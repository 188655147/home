package com.home.test;

import com.home.factory.ServiceFactory;
import com.home.vo.User;

public class TestAdd {
    public static void main(String[] args) {
        User vo = new User();
        vo.setUserno("11112236");
        vo.setPassword("123123123");
        vo.setName("王者");
        vo.setId(26);
        try{
            System.out.println(ServiceFactory.getIUserServiceInstance().insert(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
