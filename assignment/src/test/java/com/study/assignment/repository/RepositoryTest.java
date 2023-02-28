package com.study.assignment.repository;

import com.study.assignment.entitiy.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class RepositoryTest {

    @Autowired
    MemberRepository repository;
    @Test
    public void testInsert(){

        IntStream.rangeClosed(1,10).forEach(i -> {

            MemberEntity memberEntity = MemberEntity.builder()
                    .email("dycjh@example.com"+i)
                    .password("password"+i)
                    .name("test"+i)
                    .nickname("mickname"+i)
                    .build();
                repository.save(memberEntity);
        });

    }

    @Test
    public void selectNoExist() {
        MemberEntity memberEntity = repository.findById(0L).orElseThrow();
        System.out.println(memberEntity);

    }
}