package com.example.Spring_boot_Studying.Service;

import com.example.Spring_boot_Studying.Domain.Member;
import com.example.Spring_boot_Studying.Repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;
    MemberService memberService;


    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test

    void 회원가입() {
        //given//무언가가 주어졌는데
        Member member = new Member();
        member.setName("Spring");
        //when//이게 실행 됐을때
        Long saveId = memberService.join(member);

        //then//결과가 이래야 한다.
        Member findeMember = memberService.findOne(saveId).get();

        assertThat(member.getName()).isEqualTo(findeMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);

        //해석 : join(member2)를 실행할 시 IllegalStateException.class가 나와야한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //memberService.join(member2);

        //then

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}