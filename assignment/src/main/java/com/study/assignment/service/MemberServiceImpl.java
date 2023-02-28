package com.study.assignment.service;

import com.study.assignment.entitiy.MemberEntity;
import com.study.assignment.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memeberRepository;

    @Override
    public MemberEntity updateMember(MemberEntity memberEntity) {
        return null;
    }
}
