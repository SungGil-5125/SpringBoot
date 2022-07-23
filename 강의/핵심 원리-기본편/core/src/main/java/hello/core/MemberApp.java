package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //
        // 컨테이너 생성 후 AppConfig를 전달하면 @Bean이 붙은 메서드들을 통해 정해진 절차에 따라 컨테이너에 빈들이 등록된다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 빈이 등록될때 메서드 이름으로 빈으로 등록되기 때문에 빈을 가져올려면 메소드 이름으로 써야한다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
