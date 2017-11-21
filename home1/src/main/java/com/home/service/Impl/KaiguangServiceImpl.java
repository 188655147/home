package com.home.service.Impl;

import com.home.dbconn.DatabaseConnection;
import com.home.factory.DAOFactory;
import com.home.service.IKaiguangService;
import com.home.vo.Kaiguang;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class KaiguangServiceImpl implements IKaiguangService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Kaiguang vo) throws Exception {
        try{
            if(DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).findById(vo.getKgid()) == null){
                return DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Kaiguang vo) throws Exception {
        try {
            return DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public Kaiguang get(Integer id) throws Exception {
        try {
            return DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).findById(id);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public List<Kaiguang> list() throws Exception {
        try {
            return DAOFactory.getIKaiguangDAOInstance(this.dbc.getConnection()).findAll();
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
        return null;
    }
}
