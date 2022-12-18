package com.example.Spring_boot_Studying.Domain;


import javax.persistence.*;

@Entity //JPA가 관리하는 Entity임을 선언
public class Member {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 데이터베이스에 위임하는 전략
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
