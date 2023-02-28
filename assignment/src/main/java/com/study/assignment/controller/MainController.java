package com.study.assignment.controller;

import com.study.assignment.entitiy.MemberEntity;
import com.study.assignment.entitiy.MovieEntity;
import com.study.assignment.repository.MemberRepository;
import com.study.assignment.repository.MovieRepository;
import com.study.assignment.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MemberService memberServiceImpl;


    @GetMapping("/")
    public String GetMain() {
        return "main";
    }

    @GetMapping("/member/join")
    public String GetJoin(MemberEntity memberEntity) {
        System.out.println(memberEntity);
        return "join";
    }

    @PostMapping("/member/join")
    public String PostJoin(MemberEntity memberEntity){
        System.out.println(memberEntity);
        memberRepository.save(memberEntity);
        return "join";
    }


    @GetMapping("/member/updateMember")
    public String GetUpdateMember(){
        return "updateMember";
    }


    @PostMapping("/member/updateMember")
    public String PostUpdateMember(MemberEntity memberEntity){
        memberServiceImpl.updateMember(memberEntity);
        return "updateMember";
    }


    @PostMapping("/member/login")
    public String login(MemberEntity memberEntity, HttpSession session){
       int loginResult = memberRepository.findMemberEntityByEmailAndPassword(memberEntity);
        System.out.println("/memeber/login 페이지에 있는 멤버 객체다 이말이야 "+memberEntity);
        System.out.println("로그인시 나오는 로그인 값은???::"+loginResult);
        if(loginResult == 1){
            session.setAttribute("loginId",memberEntity.getEmail());

            return "afterLogin";
        }
        return "main";
    }


    @GetMapping("/afterLogin")
    public String GetAfterLogin(MovieEntity movieEntity){
        System.out.println("getMovieEntity" + movieEntity);
        return "afterLogin";
    }

    @PostMapping("/afterLogin")
    public String PostAfterLogin(MovieEntity movieEntity, Model model){

        //영화 insert
        movieRepository.save(movieEntity);

        //영화 모든 정보 서비스에서 받기
        List<MovieEntity> movieEntityList = movieRepository.findAll();


        movieEntityList.stream().forEach(n -> System.out.println(n));

        model.addAttribute("movieList", movieEntityList);
        return "afterLogin";

    }
}
