package com.home.test;

import com.home.factory.ServiceFactory;
import com.home.vo.Kongtiao;
import com.home.vo.User;

public class TestAdd {
    public static void main(String[] args) {
        Kongtiao vo = new Kongtiao();
        vo.setKtid(1);
        try{
            System.out.println(ServiceFactory.getIKongtiaoServiceInstance().get(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
