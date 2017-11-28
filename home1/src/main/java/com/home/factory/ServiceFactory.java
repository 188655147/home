package com.home.factory;

import com.home.service.IKaiguangService;
import com.home.service.IKongtiaoService;
import com.home.service.IUserService;
import com.home.service.Impl.KaiguangServiceImpl;
import com.home.service.Impl.KongtiaoServiceImpl;
import com.home.service.Impl.UserServiceImpl;

public class ServiceFactory {
    public static IUserService getIUserServiceInstance() {
        return new UserServiceImpl();
    }

    public static IKongtiaoService getIKongtiaoServiceInstance() {
        return new KongtiaoServiceImpl();
    }

    public static IKaiguangService getIKaiguangServiceInstance() {
        return new KaiguangServiceImpl();
    }
}
