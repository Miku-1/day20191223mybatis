package com.mapper;

/*
 *@Date: 22:58 2019/12/23
 *@Description:
 */

import com.pojo.Member;

import java.util.List;

public interface MemberMapper {

    /*
     * 获取所有
     * */
    List<Member> getAll();

    /*
    * 添加
    * */
    Integer addMember(Member member);

    Integer updateMember(Member member);

    Integer deleteMember(Integer id);

}
