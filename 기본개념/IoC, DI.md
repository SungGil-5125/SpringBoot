## IoC (Inversion of Control, 제어의 역전)

일반적으로는 객체 생성, 사용, 제거 등 모든 제어권은 개발자들이 관리한다.
하지만 이 모든 제어권을 스프링 컨테이너에게 주는 것을 IoC라고 한다.

아래 코드를 보면 BestBike 생성자에서 bike 클래스와의 의존 관계를 개발자가 접 수동으로 설정하고 있다.

```java
public class BestBike {

    private Bike bike;

    public BestBike()
        bike = new Bike();
        // BestBike 생성자에서 Bike 클래스와의 의존관계를 수동으로 직접 설정하고 있다.
    }
```
그런데 스프링이 제공하는 **@Autowired** 어노테이션을 사용하면 개발자가 직접 의존 관계를 설정해주는 코드가 사라지고 컨테이너에게 제어권을 맡긴것이다.

```java
public class BestBike {

    @Autowired
    private Bike bike;

}
```

> 💡  IoC가 필요한 이유? -> 객체 지향 원칙을 잘 지키기 위해서!

## 의존성 주입 (Dependency injection)

> 어떤 객체에 스프링 컨테이너가 또 다른 객체와 의존성을 맺어주는 행위!

의존 관계 주입 방법으로는 3가지가 있다.

### 생성자 주입

```java

@Service
public class UserServiceImpl implements UserService {

     private UserRepository userRepository;
     private MemberService memberService; 
     
    @Autowired
     public UserServiceImpl(UserRepository userRepository, MemberService memberService) { 
         this.userRepository = userRepository; 
         this.memberService = memberService; }
     }


```

생성자 주입은 생성자 호출 시점에 1회 호출 되는것이 보장된다. 그렇기 때문에 주입 받은 객체가 변하지 않거나, 반드시 객체의 주입이 필요한 경우에 강제하기 위해 사용될 수 있다. 또한 Spring 프레임워크에서는 생성자 주입을 적극 지원 하고 있기 때문에, 생성자가 1개만 있을 경우에 @Autowired를 생략해도 주입이 가능하도록 편의성을 제공하고 있다.

```java

@Service
public class UserServiceImpl implements UserService {

     private UserRepository userRepository;
     private MemberService memberService; 
     
     public UserServiceImpl(UserRepository userRepository, MemberService memberService) { 
         this.userRepository = userRepository; 
         this.memberService = memberService; }
     }


```

### 수정자 주입

수정자 주입(Setter 주입)은 필드 값을 변경하는 Setter를 통해서 의존관계를 주입하는 방법이다. Setter 주입은 생성자 주입과는 다르게 **주입 받는 객체가 변경 될 가능성이 있는 경우**에 사용된다. (실제로 변경될 가능성은 극히 드물다.)

```java

@Service
public class UserServiceImpl implements UserService {

     private UserRepository userRepository;
     private MemberService memberService; 
     
     @Autowired 
     public void setUserRepository(UserRepository userRepository) { 
         this.userRepository = userRepository; 
         }

      @Autowired 
      public void setUserRepository(MemberService memberSerive) { 
         this.memberService = memberService; 
         }

```

@Autowired로 주입할 대상이 없을 경우에는 오류가 발생한다. 위의 예제는 XXX bean이 존재하지 않을 경우에 오류가 발생하는 것이다. 주입할 대상이 없어도 동작하도록 할려면 @Autowired(required = false)를 통해 설정할 수 있다.

### 필드 주입

필드 주입은 필드에 바로 의존관계를 주입하는 방법이다. 인텔리제이에서 필드 인젝션을 사용하면 Field injection is not recommended이라는 경고 문구가 나온다.

```java

@Service
public class UserServiceImpl implements UserService {

     @Autowired
     private UserRepository userRepository;

     @Autowired
     private MemberService memberService; 

}
```

필드 인젝션을 이용하면 코드가 간결해져서 과거에 상당히 많이 이용되었던 주입 방법이였다. 하지만 필드 주입은 **외부에서 접근이 불가능 하다는 단점**이 존재했는데, 테스트 코드의 중요성이 부각됨에 따라 필드의 객체를 수정할 수 없는 필드 주입은 거의 사용하지 않게 되었다. 또한 **필드 주입은 반드시 DI 프레임 워크가 존재**해야 하므로 반드시 사용을 지양해야 한다. 그렇기에 애플리케이션 실제 코드와 무관한 테스트 코드나 설정을 위해 불가피 한 경우에만 이용하자.

## 생성자 주입을 사용해야 하는 이유

추후에 업로드 예정. 개졸림


