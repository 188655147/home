package com.home.factory;

import com.home.dao.IKongtiaoDAO;
import com.home.dao.IUserDAO;
import com.home.dao.Impl.KongtiaoDAOImpl;
import com.home.dao.Impl.UserDAOImpl;
import com.home.service.IKongtiaoService;

import java.sql.Connection;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance(Connection conn){
        return new UserDAOImpl(conn);
    }
    public static IKongtiaoDAO getIKongtiaoDAOInstance(Connection conn){
        return new KongtiaoDAOImpl(conn);
    }
}
