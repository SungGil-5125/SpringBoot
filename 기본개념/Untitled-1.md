# Spring이란?

### 📌 스프링이란 뭘까?

> 스프링이라는 단어는 문맥에 따라 다르게 사용된다.

- 스프링 DI 컨테이너 기술(핵심 중 핵심인 스프링 빈을 관리하는 기술)
- 스프링 프레임 워크
- 스프링 부트, 스프링 프레임 워크 등을 포함한 스프링 생태계

### 🛠 스프링은 왜 만들었을까?

> 모든 기술은 **핵심 개념과 핵심 컨셉을 이해**하고, 그 이후로 사용하면서 내 것으로 만드는게 중요하다.

- 웹 애플리케이션을 만들고, DB 접근을 편리하게 해주는 기술인가?
- 전자정부 프레임 워크에서 사용하는 기술인가?
- 웹 서버도 자동으로 띄워주는 건가?
- 클라우드, 마이크로 서비스에서 쓴다는건가?

모두 ❌❌ 이것은 최종 결과물에 불과하다.

### 🚳 스프링의 진짜 핵심

- 스프링은 자바 언어 기반의 프레임 워크이다.
- 자바 언어의 가장 큰 특징 - **객체 지향 언어!**
- 스프링은 **객체 지향 언어**가 가진 **강력한 특징**을 살려내는 프레임 워크이다.
- 정리하자면, 스프링은 **좋은 객체 지향** 애플리케이션을 개발할 수 있게 도와주는 프레임 워크이다.

---

### 🐧 좋은 객체 지향 프로그래밍이란?

✨객체 지향의 특징✨

- 추상화
- 캡슐화 
- 상속
- 다형성(제일 중요!)

### 🔗 객체 지향 프로그래밍

- 객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어 목록으로 보는 시각에서 벗어나 여러개의 독립된 단위, 즉 **"객체"들의 모임** 으로 파악하고자 하는 것이다.
- 각각의 객체는 메세지를 주고 받고, 데이터를 처리 할 수 있다.(협력)
- 객체 지향 프로그래밍은 프로그램을 **유연하고 변경이 용이하게 만들기 때문에** 대규모 스프트웨어 개발에 많이 사용된다.

> 💡 여기서 핵심 키워드 : 객체들의 모임, 유연하고 변경이 용이

### 🍩 유연하고 변경이 용이하다?

- 레고 블럭 조립하듯이
- 키보드, 마우스 갈아 끼우듯이
- 컴퓨터 부품 갈아 끼우듯이
- 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있는 방법

### 📌 다형성 

자바 언어에서 다형성을 활용하면 인터페이스를 이용한 역할(기능)과 인터페이스를 상속받은 구현 객체를 이용해 역활과 구현을 분리해 다형성의 본질을 찾을 수 있다.

> 객체를 설계할때는 역할 부분인 인터페이스를 먼저 설계하고, 그 역할을 수행하는 구현 객체 클래스를 만들자.

💡 다형성의 실제 비유(Texi)

![image](https://user-images.githubusercontent.com/82089918/167990756-b9c0c579-f1e2-41ac-b632-c04e2c4366ea.png)

- 역할과 구현으로 구분한다.
- 역할(기능)은 인터페이스가 되고 구현은 구현할 클래스가 된다.
- 역할은 Texi가 되며, 구현은 아반떼, 소나타, 그랜저이다.
- Texi는 Texi의 차가 아반떼이던, 소나타, 그랜저 차량의 종류와 상관없이 업무를 수행할 수 있다.
- Texi 운전자는 대상의 역할(Texi 인터페이스)만 알면됨.
- Texi는 구현대상 (아반떼, 소나타, 그랜저)의 내부를 알 필요가 없다.
- Texi 드라이버는 구현대상의 내부 구조가 변경되어도 영향을 받지 않는다.
- Texi 드라이버는 구현대상 자체를 변경하여도 영향을 받지 않음.   