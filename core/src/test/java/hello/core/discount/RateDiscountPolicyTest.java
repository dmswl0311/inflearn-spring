package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    private final RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void vip_o(){
        //give
        Member member = new Member(1L,"은지", Grade.VIP);

        //when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //give
        Member member = new Member(1L,"은지", Grade.BASIC);

        //when
        int discountPrice = rateDiscountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discountPrice).isEqualTo(0);
    }

}