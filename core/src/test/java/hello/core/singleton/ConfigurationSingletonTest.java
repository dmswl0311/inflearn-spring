package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("configurationTest")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        System.out.println("memberServiceImpl memberRepository="+memberServiceImpl.getMemberRepository());
        System.out.println("orderServiceImpl memberRepository="+orderServiceImpl.getMemberRepository());
        System.out.println("memberRepository="+memberRepository);
        //같다?
        Assertions.assertThat(memberServiceImpl.getMemberRepository()).isSameAs(orderServiceImpl.getMemberRepository());
    }

    @Test
    @DisplayName("configurationDeepTest")
    void configurationDeepTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean="+bean.getClass()); //bean=class hello.core.AppConfig$$SpringCGLIB$$0
    }
}
