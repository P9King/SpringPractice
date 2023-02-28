package com.study.assignment.repository;

import com.study.assignment.entitiy.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {




    // 로그인
    @Query(value = "select count(*) from users where email =:#{#me.email} and password =:#{#me.password}", nativeQuery = true)
    int findMemberEntityByEmailAndPassword(@Param("me") MemberEntity memberEntity);




    /*movie 관련 JPA*/

}
