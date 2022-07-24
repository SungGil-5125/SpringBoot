package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 수동으로 넣어주는 Appconfig는 제외한다.
        // default : 설정 정보 클래스의 패키지가 시작위치가 된다. ex) hello.core 전체
)
public class AutoAppConfig {
}
