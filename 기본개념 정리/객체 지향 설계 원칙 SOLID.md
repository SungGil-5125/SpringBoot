# 좋은 객체 지향 설계 5가지 원칙(SOLID)

> SOLID
> : 클린코드로 유명한 로버트 마틴이 **좋은 객체 지향 설계의 5가지 원칙**을 정리<br>
> 1) SRP 단일 책임 원칙(single responsibility principle)
> 2) OCP 개방-패쇄 원칙(Open/closed principle)
> 3) LSP 리스코프 분리 원칙(Liskov substitution principle)
> 4) ISP 인터페이스 분리 원칙(Interface segregation principle)
> 5) DIP 의존관계 역전 원칙(Dependency inversion principle)

### 1) SRP 단일 책임 원칙(single responsibility principle)

- 한 클래스는 하나의 책임만 가져야 한다.
- 하나의 책임이라는것은 모호하다.
   - 책임이 클수도 있고, 작을 수도 있다.
   - 문맥과 상황에 따라 다르다.
    (이 부분에서 경험이 중요하다고 볼 수 있음)
- 중요한 기준은 변경이다.<br>
  변경이 있을때 **파급 효과가 적으면 단일 책임 원칙을 잘 따른것**<br>
  예) UI 변경, 객체의 생성과 사용의 분리

> 💡 즉, 변경이 있을때는 하나의 클래스는 하나의 지점만 고친다면, 이 원칙을 잘 따르고 있는것이다.

### 2) OCP 개방-폐쇄 원칙(open/closed principle)

❗️가장 중요한 원칙❗️

- 소프트웨어 요소는 **확장에는 열려있으나 변경에는 닫혀있어야 한다.**
  <br> -> 다형성을 활용하자!

- 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현.

> 여기서 문제점 🤚🏻<br>
> MemberService 클라이언트가 구현 클래스를 직접 선택<br>
> -> MemberRepository m = new MemoryMemberRepository(); //기존코드<br>
> -> MemberRepository m = new JdbcMemberRepository(); //변경코드<br>
> **구현 객체를 변경하려면 클라이언트 코드 (MemberService)를 변경해야 한다!**<br>
> **분명 다형성을 사용했지만, OCP 원칙이 깨진다!(=클라이언트가 기존 코드를 변경 해야만 한다.)**<br>
> 그렇다면 이 문제를 어떻게 해결할까?<br>
> 💡 객체를 생성하고 연관 관계를 맺어주는 별도의 조립을 해주는 설정자가 필요하다.<br>
> -> 이걸 해주는것이 바로 **스프링!** 소위 스프링 컨테이너가 하는 역할.<br>
> -> 이 원칙을 지키기 위해 DI도 필요하고, IOC 컨테이너도 필요한것이다.

### 3) LSP 리스코프 치환 원칙(Liskov substitution principle)

- 프로그램의 객체는 프로그램의 정확성을 깨트리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성에서 하위 클래스는 **인터페이스 규약을 다 지켜야 한다는 것**, 다형성을 지원하기 위한 원칙, 인터페이스를 구현한 구현체는 믿고 사용하려면, 이원칙이 필요하다.
- 단순히 컴파일에 성공하는것을 넘어서는 이야기 <br>
  EX) 자동차 인터페이스의 엑셀은 앞으로 가라는 기능을 가자는데 뒤로 가게 구현하면 LSP에 위반이 된다.

### 4) ISP 인터페이스 분리 법칙(Interface segregation principle)
- 특정 클라이언트를 위한 인터페이스 여러개가 범용 인터페이스 하나 보다 낫다.
- 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
- 시용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
- **분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음**
- 인터페이스가 명확해지고, 대체 가능성이 높아진다.

### 5) DIP 의존 관계 역전 원칙(Dependency   inversion prinpcile)
❗️중요한 원칙❗️

- **프로그래머는 "추상에 의존해야지, 구체화에 의존하면 안된다."** 의존성 주입은 이 원칙을 따르는 방법중 하나이다.
- 쉽게 이야기 해서 클라이언트 코드가 **구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻이다.**<br>
Ex) 클라이언트 코드(MemberService)가 구현 클래스(MemoryMemberRepository or JdbcMemberRepository)에 의존하지 말고, 인터페이스(MemberRepository Interface)에 의존하라는 뜻
- 앞에서 이야기한 **역할(Role)에 의존하게 해야 한다는 것과 같다.**<br> 
객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다.<br><br>

🙆‍♂️ 참고 자료 🙇‍♂️
<br>
https://velog.io/@sorzzzzy/Spring-Boot2-1-2.-%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%EA%B3%BC-%EC%8A%A4%ED%94%84%EB%A7%81