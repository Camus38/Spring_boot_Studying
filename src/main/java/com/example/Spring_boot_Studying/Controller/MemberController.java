package com.example.Spring_boot_Studying.Controller;

import com.example.Spring_boot_Studying.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //서비스와 컨트롤러 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
