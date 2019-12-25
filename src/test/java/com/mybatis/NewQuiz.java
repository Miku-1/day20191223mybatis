package com.mybatis;

/*
 *@Date: 21:24 2019/12/24
 *@Description:
 */

import com.pojo.Member;

import java.io.IOException;
import java.util.List;

public class NewQuiz {
    public static void main(String[] args) throws IOException {
        Quiz quiz = new Quiz();
        List<Member> memberList1 = quiz.getMembers();

        for (Member mem:memberList1){
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n",mem.getId(),mem.getQq_number(),mem.getPassword(),mem.getImg_url(),mem.getNick_name(),mem.getSex());
        }

        System.out.println("-------------------");
        Member member = new Member();
        member.setQq_number("98339665");
        member.setPassword("RK87");
        member.setNick_name("逗比");
        member.setImg_url("1234");
        member.setSex("famale");
//        quiz.add(member);
//        quiz.delete(11);
        quiz.delete(13);
        quiz.update(member);
//        quiz.delete(9);

        System.out.println("-------------------");
        List<Member> memberList2 = quiz.getMembers();
        for (Member mem:memberList2){
            System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n",mem.getId(),mem.getQq_number(),mem.getPassword(),mem.getImg_url(),mem.getNick_name(),mem.getSex());
        }
    }
}
