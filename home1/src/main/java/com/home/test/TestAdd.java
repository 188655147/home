package com.home.test;

import com.home.factory.ServiceFactory;
import com.home.vo.Kongtiao;

public class TestAdd {
    public static void main(String[] args) {
        Kongtiao vo = new Kongtiao();
        vo.setKtid(1);
        try{
            System.out.println(ServiceFactory.getIKongtiaoServiceInstance().list().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
