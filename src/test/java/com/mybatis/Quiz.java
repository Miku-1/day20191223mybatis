package com.mybatis;

/*
 *@Date: 20:00 2019/12/24
 *@Description:
 */

import com.mapper.MemberMapper;
import com.pojo.Member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Quiz {

    public List<Member> getMembers() throws IOException {
        /*
         * 读取配置文件
         * */
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /*
         * 创建工厂
         * */
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        /*
         * 生产SqlSession对象
         * */
        SqlSession session = factory.openSession();
        /*
         *创建代理对象
         * */
        MemberMapper memberMapper = session.getMapper(MemberMapper.class);
        /*
         * 使用代理对象执行方法
         * */
        List<Member> members = memberMapper.getAll();
//        for (Member member : members) {
//            System.out.println(member.toString());
//        }

        /*
         * 释放资源
         * */
        session.close();
        in.close();
        return members;
    }

    public void add(Member member) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        MemberMapper memberMapper = session.getMapper(MemberMapper.class);
        memberMapper.addMember(member);
        session.commit();
        session.close();
        in.close();
    }


    public void delete(Integer id) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession sqlSession = factory.openSession();

        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

        memberMapper.deleteMember(id);
        sqlSession.commit();
        sqlSession.close();
        in.close();

    }

    public void update(Member member) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        MemberMapper memberMapper = session.getMapper(MemberMapper.class);

        memberMapper.updateMember(member);
        session.commit();
        session.close();
        in.close();
    }

}
