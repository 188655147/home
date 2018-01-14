package com.wilya.shop.factory;

import com.wilya.shop.service.front.IMemberServiceFront;
import com.wilya.shop.service.front.impl.MemberServiceFrontImpl;

public class ServiceFrontFactory {
    public static IMemberServiceFront getIMemberServiceFrontInstance(){
        return new MemberServiceFrontImpl();
    }
}
