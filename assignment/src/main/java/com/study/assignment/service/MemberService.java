package com.study.assignment.service;

import com.study.assignment.entitiy.MemberEntity;
import org.springframework.stereotype.Service;


public interface MemberService {

    MemberEntity updateMember(MemberEntity memberEntity);
}
