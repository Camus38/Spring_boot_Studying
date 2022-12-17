package com.example.Spring_boot_Studying.Controller;

import com.example.Spring_boot_Studying.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //1.DI 중 필드 주입 //그리 좋은 방법은 아니다.
    //@Autowired private MemberService memberService;

    private  MemberService memberService;


    //2.DI 중 Setter 주입
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //3.DI 중 생성자 주입 방법 //생성자 주입이 가장 좋다.
    @Autowired //서비스와 컨트롤러 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
