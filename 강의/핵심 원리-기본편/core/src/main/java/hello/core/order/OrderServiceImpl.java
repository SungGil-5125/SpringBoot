package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    SRP : 한 클래스는 하나의 책임만 가져야 한다.
    원래 기존에는 OrderServiceImpl이 구현 객체의 생성과 연결도 같이 했지만, AppConfig의 등장으로 객체의 생성과 연결을 하지 않아도 된다.
    그래서 OrderServiceImpl은 실행하는 책임만 가진다.

    구현객체 : DiscountPolicy discountPolicy = new FixDiscountPolicy;
     */

    /*
    DIP : 추상화에 의존을 해야지 구체화에 의존하면 안된다.
    보시다 싶이 클라이언트 코드가 AppConfig(공연 기획자) 덕분에 추상화에 의존 하기 때문에 DIP에 위배되지 않는다.
    사용영역(orderServiceImpl, DiscountPolicy)를 바꾸지 않고, 구정영역(AppConfig)만 바꿔도 사용할수있다.
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
