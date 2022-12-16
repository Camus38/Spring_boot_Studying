package com.example.Spring_boot_Studying;


import com.example.Spring_boot_Studying.Repository.MemoryMemberRepository;
import com.example.Spring_boot_Studying.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
