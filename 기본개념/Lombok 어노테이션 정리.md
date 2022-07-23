# Lombok 어노테이션 정리

## 생성자 어노테이션

```java
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성해준다
@AllArgsConstructor
@RequiredArgsConstructor

public Member() { // NoArgsConstructor // 기본 생성자

    }

public Member(String email, String password) { // AllArgsConstructor 가지고 있는 모든 필드 전체 값들을 매개변수 로 받는다.

    }

public Member(String phone, String address) { // RequiredArgsConstructor final 키워드와 @NonNull 어노테이션이 붙은 필드만 매개변수로 받는다.

    }
```

## @ToString

toString() 메소드를 자동으로 생성해주는 어노테이션이다.
exclude 속성을 사용하면, 특정 필드를 toString()에서 제외할 수 있다.

```java
@ToString(exclude = "pw")
public class User {
    private Long id;
    private String pw;
}
```

## equals, hashCode

자바 빈을 만들때 equals와 hashCode 메소드를 자주 오버라이딩을 하는데 @EqualsAndHashCode 어노테이션을 사용하면 자동으로 이 메서드를 만들수 있다.

```java
@EqualsAndHashCode(callSuper = true)
public class User extends Domain {
  private String username;
  private String password;
}
```


callSuper 속성을 통해 equals와 hashCode 메소드 자동 생성시 부모 클래스의 필드까지 감안할지 안할지에 대해서 설정할 수 있다.

즉, callSuper = true로 설정하면 부모 클래스 필드 값들도 동일한지 체크하며, callSuper = false로 설정(기본값)하면 자신 클래스의 필드 값들만 고려합니다.

```java
User user1 = new User();
user1.setId(1L);
user1.setUsername("user");
user1.setPassword("pass");

User user2 = new User();
user1.setId(2L); // 부모 클래스의 필드가 다름
user2.setUsername("user");
user2.setPassword("pass");

user1.equals(user2);
// callSuper = true 이면 false, callSuper = false 이면 true
```

## @Data

@Data는 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한꺼번에 생성해주는 어노테이션이다.

```java
@Data

```
를 쓰면 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고, final 또는 @NotNull 필드 값을 매개변수로 받는 생성자를 만들어 주고, toString, equals, hashCode 메소드가 자동으로 만들어진다.

출처 : https://www.daleseo.com/lombok-popular-annotations/