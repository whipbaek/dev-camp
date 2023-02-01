# ❄SmileGate Winter:// Dev.Camp 2022
- 해당 프로젝트는 SmileGate Winter Dev Camp 2022 과정의 개인프로젝트 입니다.

<br>

## 💻프로젝트 주제

- 인증시스템 구현

<br>

## 🚩목표 기능

 - 가입, 로그인 페이지
 - 유저 관리 페이지
 - 인증 서버 API
 - RDBMS DB 사용 
 - Password Encryption
 - E - Mail 인증 (Optional)

<br>

## 🎯프로젝트 목표

`해당 프로젝트를 수행함으로써 성장하고 싶은 부분`
- 가입, 로그인 페이지, 유저 관리 페이지
    - 스프링에서 관리하는 세션을 통하여 인증과 보안 프로세스에 대해 공부
- 인증서버 API
    - 스프링을 활용한 인증 시스템을 공부하고 익숙해짐
- RDBMS DB 사용
    - 백엔드와 DB연동에 익숙해지고 DB 설계 역량을 늘리고 싶음
    - JPA 사용에 익숙해지고 역량을 늘리고, 각 구조 및 기능에 대하여 공부함.
- Password Encryption
    - Spring security를 프로젝트에 적용해보고, 패스워드 보안을 위해 Password Encryption을 적용해보고, DB에 저장한다.
- 단위 테스트를 최대한 많이 작성해보고, 프로젝트 진행 과정에 있어서 테스트에 익숙해지기
- 기능별로 commit하고, convention을 최대한 지켜가며 프로젝트를 진행
- 기능별로 최대한 메소드를 나누어보고, 클래스를 나누어 보기 → 한 메소드가 하나의 일만 하도록!

<br>

## 📑기술 스택
- JAVA
- Spring Framework
- Spring Boot
- MySQL
- JPA
- Thymeleaf
- IntelliJ
- Git

![architecture](https://user-images.githubusercontent.com/75191916/209574601-3e946936-77c2-4975-987f-b7b6e07b3cea.png)

<br>

## 📌구현 기능
- [x] 회원가입
  - [x] 이메일 인증
  - [x] 비밀번호 암호화
- [x] 로그인
- [x] 회원 정보 수정
- [x] 검증 기능
- [x] 세션 기능 (로그인 유지)

## 📌구현 기능 상세 정보

![1](https://user-images.githubusercontent.com/75191916/209467242-0853d29e-323b-4d20-92ae-661ace50c67c.png)

- 회원가입 기능
  - 이메일(ID), 비밀번호, 이름을 입력받아 회원가입
  - 이메일을 중복되는값을 허용허지 않음 (이미 가입된 이메일)
  - 비밀번호는 6자이상, 이름은 2자 이상이여야 함
  <br>
![2](https://user-images.githubusercontent.com/75191916/209467250-b39cf290-9972-47a6-acf1-ad231b0b25a5.png)



- 이메일 인증
  - 회원가입에서 기본정보를 입력하면, 이메일 인증이 진행됨
  - 이메일로 보낸 코드까지 입력되면 회원가입이 완료됨
  - 스프링 메일 라이브러리와, 구글 SMTP를 활용하여 구현
  <br>
![3](https://user-images.githubusercontent.com/75191916/209467252-e7c0b453-2b7c-437e-a3ef-e58a58a04a5e.png)
![4](https://user-images.githubusercontent.com/75191916/209467253-e9ad6bf2-e910-44a3-b181-ed123dfc97df.png)



- 비밀번호 암호화
  - DB에 저장되는 비밀번호는 모두 암호화 되어서 저장됨
  - SpringSecurity를 활용하여 구현체로 BCryptPasswordEncoder() 를 사용 <br>
![db](https://user-images.githubusercontent.com/75191916/209467255-e8d79def-d5da-4376-b7cb-19c0f4dc84ec.png)


- 로그인 기능
  - 이메일과, 비밀번호를 입력받아 진행됨
  - DB에 저장된 정보와 맞다면 로그인 완료됨 <br>
![login](https://user-images.githubusercontent.com/75191916/209467262-a6e418c3-42ad-4ba0-b1b7-3ef04329a5d6.png)

  

- 로그인 유지
  - 로그인 상태를 유지하기 위해서는 Session을 사용하였음
  - Http Session에 정보를 넣어주고, 사용자가 로그인 되어있는지를 검사하였음
  - Session이 있다면 로그인된 화면을 보여주고, 없다면 기본화면을 요청하는 방식 <br>
![5](https://user-images.githubusercontent.com/75191916/209467267-e92cdaa0-c6e8-4cc6-a1ca-694be2546eb2.png)
![6](https://user-images.githubusercontent.com/75191916/209467284-f5a2f732-0da7-4d6a-b211-65f9708dd5ce.png)



- 필터 기능
  - 로그인되어야 진입 가능한 사이트에 대해서 필터 기능을 추가.
  - 권한이 없는 사이트에 진입시 로그인화면으로 redirect 시켜줌
  - 로그인이되면 기존에 요청한 페이지로 이동
  - 스프링 인터셉터 기능을 활용



- 검증 기능
  - 이메일이 중복되거나, 가입시 패스워드가 6자미만, 로그인 정보가 틀릴때, 필드가 비어있을 때 등 여러 검증시에 사용
  - Spring에서 에러를 담아주는 객체 BindingResult를 활용하여 구현함. <br>
![7](https://user-images.githubusercontent.com/75191916/209467288-3fa1350b-8467-491a-b7b9-dab858e71120.png)
![8](https://user-images.githubusercontent.com/75191916/209467289-ec60e120-51e1-412c-8cf6-ce2ce3c678b2.png)
![9](https://user-images.githubusercontent.com/75191916/209467290-b030ccaf-4ea0-4341-ae4a-6e855fb9fb8c.png)



- 회원정보 수정
  - 로그인 되어있는 상태라면 회원 정보를 수정할 수 있음
  - 이메일은 변경할 수 없으며, 비밀번호와 이름을 변경할 수 있다. <br>
![10](https://user-images.githubusercontent.com/75191916/209467293-7f1ce360-7ae9-40cb-af43-47c20d1b6bc7.png)



## ✔코드 중 확인받고 싶은 부분
- 컨트롤러나 서비스를 어느정도로 나뉘어야하는에 대한 의문.
  - MemberService에 로그인 기능과 회원가입 기능은 넣으면 안되는지? 등..
  - 따로 로그인서비스와 회원가입 서비스에 대한 객체를 만들어야하는건지..?
- 비슷한 이유로 dto에 대해서도 어느정도로 나뉘어야하는지
  - register와, login 등 ..
- Primary Key로 어떤 필드를 사용하면 좋은지?
- 세션을 활용하여 로그인을 검증할때, 보통 세션에 대한 정보로 어떤것을 사용해야하는지?
  - 현재는 Member entity를 서비스단에서 받아와서 넣는데 이게 맞는가.. 
- 이메일 인증이 끝나고 가입을 처리하기위해 미리 받아둔 정보를 controller단에 저장하는데 이게 괜찮은 방법인가?


## ❓개발관련 궁굼했던 점들
- 해당 프로젝트 구조 or 기능에 있어서 추가적으로 공부하면 좋을 부분? (추가적인 기술스택 등..)
- 여러 서버를 다른 언어로 구성할 거 같은데 API Gateway 라는것으로 구성하면 되는것인지? 다중서버로는 처음 개발예정!
- 다중서버를 사용할때 DB는 한개만 사용해서 각자 접근하면 되는지, ORM을 사용해도 괜찮은지? (JPA)
- 프론트를 React로 할 시, 서버단에서는 JSON만 보내주면 되는지?
  - 검증에 있어서 만약 오류 메세지를 출력해야한다면 메세지 자체를 서버에서 보내줘야하는지, 또는 true false 값만 보내줘야하는지?
  - 아니면 error code를 보내줘야 하는지..? 


