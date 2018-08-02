package com.neuedu.mybatisImplDao;

import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatis implements LoginDao{


    @Override
    public Account LogonLogic(String name, String password) {

        //读取配置文件
        //生成SqlSessionFactor 为SqlSession的工厂，用于建立与数据库的会话
        //建立SqlSession用于执行sql语句
        //调用MyBatis提供的api
        //查询MAP配置
        //返回结果
        //关闭SqlSession

        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();
        //map集合存的用户名和密码
        Map<String,String> map = new HashMap<String, String>();
        map.put("username",name);
        map.put("password",password);
        /*
         * 1.namespace+id
         * */
        Account account = session.selectOne("com.neuedu.entity.Account.findByUsernameAndPassword", map);
        System.out.println(account);
        session.close();



        return account;

    }

    @Override
    public void addToken(Account acc, String token) {

    }

    @Override
    public String findTokenByAccountId(int accountid) {
        return null;
    }
}
