package com.wilya.shop.factory;

import com.wilya.shop.dao.IMemberDAO;
import com.wilya.shop.dao.impl.MemberDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static IMemberDAO getIMemberDAOInstance(Connection conn){
        return new MemberDAOImpl(conn);
    }
}
