package com.neuedu.text;

import com.neuedu.dao.LoginDao;
import com.neuedu.mybatisImplDao.LoginMybatis;
import org.junit.Test;

public class usertext {

    @Test
   public  void textLoginDao(){
        LoginDao dao=new LoginMybatis();
        dao.LogonLogic("admin","21232f297a57a5a743894a0e4a801fc3");


   }


}
