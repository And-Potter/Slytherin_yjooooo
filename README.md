# 🚩4th Seminar

### 🎥실행영상

<div>
  <img height="400" src="https://user-images.githubusercontent.com/68374234/118389227-d49cde80-b663-11eb-8f0e-2d2573e649f4.gif">
</div>



### 📷Postman Test

<div>
  SignUp👉
  <img height="400" src="https://user-images.githubusercontent.com/68374234/118389234-dbc3ec80-b663-11eb-8169-cf8d168e3c19.png">
  SignIn👉
  <img height="400" src="https://user-images.githubusercontent.com/68374234/118389232-db2b5600-b663-11eb-91e6-b4738611e361.png">
</div>



### ✔️과제 현황

- Step1 - 로그인/회원가입 통신 구현하기

  - RetrofitBuilder : Retrofit Interface 구현체

    ```kotlin
    object RetrofitBuilder {
        private const val BASE_URL = "http://cherishserver.com"
    
        private val loginRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    
        val loginService: LoginService = loginRetrofit.create(LoginService::class.java)
    }
    ```

  - LoginService : 회원가입, 로그인 서버 요청 동작 정의
    => 다음 함수를 viewModelScope 내에서 사용하기 위해 suspend modifier 사용.

    ```kotlin
    interface LoginService {
        @POST("/login/signin")
        suspend fun postSignIn(
            @Body requestSignIn: RequestSignIn
        ): ResponseSignIn
    
        @POST("/login/signup")
        suspend fun postSignUp(
            @Body requestSignUp: RequestSignUp
        ): ResponseSignUp
    }
    ```

  - SignUpViewModel 에서 이름, 아이디, 비밀번호를 모두 입력했을 시(databinding과 observe통해서 null체크) 서버통신요청
    => Dispatchers를 IO로 설정할 경우, livedata의 값 설정은 postValue을 이용하여 설정.

    ```kotlin
    fun requestSignUp() = viewModelScope.launch {
        try {
            RetrofitBuilder.loginService.postSignUp(
                RequestSignUp(
                    birth = "none",
                    email = email.value!!,
                    nickname = nickname.value!!,
                    password = password.value!!,
                    phone = "none",
                    sex = "none"
                )
            )
            _isSignUp.postValue(true)
        } catch (e: HttpException) {
            _isSignUp.postValue(false)
        }
    }
    ```

  - SignInViewModel 에서 아이디, 비밀번호를 모두 입력했을 시(databinding과 observe통해서 null체크) 서버통신요청
    => Dispatchers를 IO로 설정할 경우, livedata의 값 설정은 postValue을 이용하여 설정.

    ```kotlin
    fun requestSignIn() = viewModelScope.launch {
        try {
            val responseSignIn = RetrofitBuilder.loginService.postSignIn(
                RequestSignIn(
                    email = email.value!!,
                    password = password.value!!
                )
            )
            _nickname.postValue(responseSignIn.data.userNickname)
            _isSignIn.postValue(true)
        } catch (e: HttpException) {
            _isSignIn.postValue(false)
        }
    }
    ```



# 🚩2nd Seminar


### 🎥실행영상

<div>
  <img height="400" src="https://user-images.githubusercontent.com/68374234/115982289-daf3e980-a5d4-11eb-8788-ab7f2593c57a.gif">
</div>





### ✔️과제 현황

- Step1

  - Repo RecyclerView 구현

    ```kotlin
    private fun setRepoRcvAdapter() {
        binding.homeRcvRepository.adapter = RepoRcvAdapter()
    }
    
    private fun setRepoListObserver() {
        homeViewModel.repoList.observe(this) { repoList ->
            repoList.let {
                if (binding.homeRcvRepository.adapter != null) with(binding.homeRcvRepository.adapter as RepoRcvAdapter) {
                    submitList(repoList)
                }
            }
        }
    }
    ```

  - RecyclerView 아이템 내부 repo name, repo info 긴 경우에 ... 나오도록 처리

    ```xml
    android:ellipsize="end"
    android:maxLines="1"
    ```

- Step2

  - GridLayout을 적용한 RecyclerView 구현(아직x)
  - 여러 ViewHolder 만들어 RecyclerView 안에 2가지이상의 뷰 보여주기(아직x)
  - RecyclerView Item 기능 구현하기(아직 x)

- Step3

  - notifyDataSetChanged가 하는 일(아직 x)



# 🚩1st Seminar


### 🎥실행영상

<div>
  Login👉
  <img height="400" src="https://user-images.githubusercontent.com/68374234/114338500-25657700-9b8e-11eb-997d-0d8a2c03121c.gif">  
  SignUp👉
  <img height="400" src="https://user-images.githubusercontent.com/68374234/114338507-28606780-9b8e-11eb-928c-e41f87f5902a.gif">
  Bonus👉
  <img height="400" src="https://user-images.githubusercontent.com/68374234/114338513-2ac2c180-9b8e-11eb-8554-adf2f80ff6c2.gif">
</div>



### ✔️과제 현황

- Step1
  - 화면 전환(o)
  - 액티비티 간 데이터 전달(o)
- Step2
  - 변수이름체크(o)
  - chain사용(o)
- Step3
  - ViewBinding 이름의 뜻이뭘까요?   
  - 객체지향 어느정도 다뤄보셨나요?  
  - 아키텍쳐라고 들어보셨나요?  




### 🍭strartActivityForResult(), registerForActivityResult()

- <a href = "https://developer.android.com/training/basics/intents/result?hl=ko"> 공식 문서 보러가기</a>

- startActivity()와 startActivityForResult() 모두 화면 전환에 사용되는데 차이점은?

  - startActivity() : 자식 액티비티에서의 결과를 부모 액티비티에서 처리하지 않아도 될 때 사용.
  - startActivityForResult() : 자식 액티비티에서의 결과를 부모 액티비티에서 처리할 때 사용.

- onActivityResult()에서 startActivityForResult()를 통해 받아온 값들을 처리해줬었는데 이제 사라진다고 함...

- 그래서 registerForActivityResult()에서 처리.

  - 기존에 startActivityForResult()를 사용하려면 Request Code와 Result Code가 필요했음.
  각 액티비티마다 RequestCode를 부여해줬어야했고 onActivityResult에서 조건을 확인해서 처리해야했음 => 코드 지저분해짐...
    - Request Code : 각 액티비티에 부여해준 값.<br>
      ▶ 각 액티비티마다 다르게 지정 가능. 이 값에 따라 처리할 것을 달리할 수 있음.
    - Result Code : 액티비티가 정상적으로 왔는지 확인해주는 값.<br>
      ▶ 자식 액티비티에서 setResult()를 통해 값 지정 가능.
  - registerForActivityResult()에서 처리하게되면 RequestCode가 필요 없음.
    - registerForActivityResult()는 ActivityResultContract 및 ActivityResultCallback을 가져와서 다른 활동을 실행하는데 사용할 ActivityResultLauncher를 반환함.
    - ActivityResultContract : 결과를 생성하는데 필요한 입력 유형과 결과의 출력 유형을 정의함.
    - ActivityResultCallback : ActivityResultContract에 정의된 출력 유형의 객체를 가져오는 onActivityResult()가 포함된 단일 메소드 인터페이스
    - 입력이 있으면 ActivityResultLauncher는 ActivityResultContract 유형과 일치하는 입력을 가져옴.
      - lanuch()를 호출하면 결과를 생성하는 프로세스가 시작됨. 사용자가 후속 활동을 완료하고 반환하면 ActivityResultCallback의 onActivityResult()가 실행됨.
      - 아래의 코드처럼 내가 결과값을 받아오고 싶은 Activity별로 Launcher를 생성하고 각각 launch()를 호출함 => 각각의 Launcher에서 어떤 Activity로 실행하는지 알고있기때문에 onActivityResult()에서 처리해줬을때와 달리 request code가 필요없음.
    - StartActivityForResult를 사용 => Intent를 입력으로 가져오고, ActivityResult를 반환 => resultCode와 Intent를 콜백의 일부로 추출할 수 있음.

- ```kotlin
  private val signUpActivityLauncher = registerForActivityResult(
      ActivityResultContracts.StartActivityForResult()
  ) {
    // 여기서 it은 ActivityResult
      setIdPwAfterSignUp(it)
  }
  
  private fun setIdPwAfterSignUp(activityResult: ActivityResult) {
          if (activityResult.resultCode == RESULT_OK) {
              signInBinding.signInEdtId.setText(activityResult.data!!.getStringExtra("id"))
              signInBinding.signInEdtPw.setText(activityResult.data!!.getStringExtra("pw"))
            // 여기서 data는 ActivityResult 클래스에서의 getData()로 받아온 mdata인데 intent임.
          }
      }
  
  private fun setOnSignUpBtnClick() {
          signInBinding.signInBtnSignUp.setOnClickListener {
              signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))
          }
      }
  ```

<div>
  <img width="430" alt="스크린샷 2021-04-11 오후 5 54 10" src="https://user-images.githubusercontent.com/68374234/114298095-9f92ee80-9aef-11eb-9000-cc46b0f4b48a.png">
  <img width="271" alt="스크린샷 2021-04-11 오후 5 53 48" src="https://user-images.githubusercontent.com/68374234/114298106-af123780-9aef-11eb-8349-fd8b502b5672.png">
</div>



### 🍭생명주기 Log

<img width="648" alt="스크린샷 2021-04-12 오전 1 10 21" src="https://user-images.githubusercontent.com/68374234/114311962-de469a00-9b2b-11eb-98c0-d7fa926909d1.png">

