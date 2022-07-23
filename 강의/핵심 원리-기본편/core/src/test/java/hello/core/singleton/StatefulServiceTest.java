package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {

        //지역변수로 변경

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB : B 사용자 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //ThreadA : A 사용자 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); // 같은 인스턴스라 마지막꺼가 나옴

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

     static class TestConfig {

        @Bean
         public StatefulService statefulService() {
            return new StatefulService();
        }
     }
}