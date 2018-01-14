package com.wilya.shop.service.front.impl;

import com.wilya.shop.dbc.DatabaseConnection;
import com.wilya.shop.factory.DAOFactory;
import com.wilya.shop.service.front.IMemberServiceFront;
import com.wilya.shop.vo.Member;

public class MemberServiceFrontImpl implements IMemberServiceFront {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean regist(Member vo) throws Exception {
        try {
            if (DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(vo.getMid()) == null){
                return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }
}
