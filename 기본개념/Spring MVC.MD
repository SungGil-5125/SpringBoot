## Spring MVC 구조

spring의 MVC 구조는 MVC2 패턴 방법을 따르며, 이 MVC2의 아키텍처에 맞게 설계되어 있다.

스프링에서는 유저의 요청을 받는 DispatherServlet이 핵심이다.

![image](https://user-images.githubusercontent.com/82089918/166428852-96e950aa-ad13-4562-b364-82898c88400a.png)

- spring bean으로 되어있는곳은 스프링 빈으로 등록되야하는것을 말한다.

|구성요소|설명|
|:--:|:--:|
|DispatcherServlet|클라이언트의 요청을 전달 받아 요청에 맞는 컨트롤러가 리턴한 값을 view에 전달하여 알맞은 응답을 생성|
|HandlerMapping|클라이언트의 요청 URL을 어떤 컨트롤러가 처리할지 결정|
|Controller|클라이언트의 요청을 처리한 뒤, 결과를 DispatchaerServlet에게 리턴|
|ModelAndView|컨트롤러가 처리한 결과 정보 및 뷰 선택에 필요한 정보를 담음|
|ViewResolver|컨트롤러의 처리 결과를 생성할 뷰를 결정|
|View|컨트롤러의 처리 결과 화면을 생성, JSP 또는 Velocity 템플릿 파일 등을 뷰로 사용|   


## 🎉Spring MVC의 동작과정

1. 사용자가 URL을 통하여 Request를 전송한다.
2. DispatchServlet은 Request를 처리하기 위한 Controller를 HandlerMapping 빈 객체에게 검색요청한다.
3. HandlerMapping은 Client의 URL을 이용해서 이를 처리할 Controller 빈 객체를 DispatcherServlet에게 return 한다.
4. DispatcherServlet은 Controller 객체를 처리할 수 있는 HandlerAdapter 빈에게 요청 처리를 위임한다.<br>
   
    - @Controller, Controller Interface, HttpRequestHandler Interface를 동일한 방식으로 처리하기 위해 HandlerAdapter 빈이 중간에 사용된다.
5. HandlerAdapter는 Controller에 알맞은 method를 호출한다.
6. Controller는 비지니스 로직을 실행한 후 처리 결과를 HandlerAdapter에게 return 한다.
7. HandlerAdapter는 DispatcherServlet에게 Controller의 실행결과를 ModelAndView 객체로 변환하여 return 한다.
8. DispatcherServlet은 결과를 보여줄 View를 검색하기 위해 ViewResolver 빈 객체에게 ModelAndView안의 해당 View를 검색 요청 한다.
9. ViewResover는 ModelAndView안의 View 이름에 해당하는 View 객체를 찾거나 생성해서 return 한다.
    <br>
    - JSP를 사용하는 ViewResolver는 매번 새로운 View 객체를 생성해서 DispatcherServler에게 return 한다.
10. DispatcherServlet은 ViewResolver가 return한 View 객체에게 request result 생성을 요청한다.
11. View 객체는 JSP를 사용하는 경우 JSP를 실행하여 result를 Rendering 한 후 Client에게 Rendering된 View를 응답한다.


🙆‍♂️ 참고 자료 🙇‍♂️ <br>
https://velog.io/@gillog/Spring-MVC-%EA%B5%AC%EC%A1%B0