package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        memberService.join(new Member(1L,"a", Grade.VIP));
        Member findMem = memberService.findMember( 1L);

        System.out.println("findMem ==> "+ findMem.getName());
    }
}

