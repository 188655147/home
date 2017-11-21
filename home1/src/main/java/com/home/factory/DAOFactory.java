package com.home.factory;

import com.home.dao.IKaiguangDAO;
import com.home.dao.IKongtiaoDAO;
import com.home.dao.IUserDAO;
import com.home.dao.Impl.KaiguangDAOImpl;
import com.home.dao.Impl.KongtiaoDAOImpl;
import com.home.dao.Impl.UserDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance(Connection conn){
        return new UserDAOImpl(conn);
    }
    public static IKongtiaoDAO getIKongtiaoDAOInstance(Connection conn){
        return new KongtiaoDAOImpl(conn);
    }
    public static IKaiguangDAO getIKaiguangDAOInstance(Connection conn){
        return new KaiguangDAOImpl(conn);
    }
}
