package com.example.Spring_boot_Studying.Service;

import com.example.Spring_boot_Studying.Domain.Member;
import com.example.Spring_boot_Studying.Repository.MemberRepository;
import com.example.Spring_boot_Studying.Repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;


//@Service
@Transactional
public class MemberService {
    //꿀팁//
    //Ctrl + Shift + T 입력 시 해당 클래스 Test 자동 생성
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //Ctrl + Alt + V : 변수 추출하기 단축키 //꿀팁
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> { //ifPresent란 Null이 아닐시 동작하는 함수, Optional이기에 가능
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });*/

        //위 코드를 좀 더 효율적으로 개량
        //findByName()의 반환값이 Optional이기에 가능
        memberRepository.findByName(member.getName())
                        .ifPresent( m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
