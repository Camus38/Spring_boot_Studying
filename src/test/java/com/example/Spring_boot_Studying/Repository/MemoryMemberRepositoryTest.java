package com.example.Spring_boot_Studying.Repository;

import com.example.Spring_boot_Studying.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test //Junit 프레임워크의 기능
    public void save(){
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result); //꿀팁

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member(); //Shift + F6 // 관련 변수 전체 Rename
        member2.setName("Spring2");
        repository.save(member2);

        //repository.findByName("Spring1");

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);


        Member member3 = new Member();
        member3.setName("Spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(3);
    }
}
