package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = apc.getBean("memberService", MemberService.class);
        OrderService orderService = apc.getBean("orderService",OrderService.class);

        Long id = 1L;

        Member member = new Member(id, "은지", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(id,"치약", 2000);
        System.out.println(order);
        System.out.println(order.calPrice());
    }
}
