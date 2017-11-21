package com.home.service.Impl;

import com.home.dbconn.DatabaseConnection;
import com.home.factory.DAOFactory;
import com.home.service.IKongtiaoService;
import com.home.vo.Kongtiao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class KongtiaoServiceImpl implements IKongtiaoService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean insert(Kongtiao vo) throws Exception {
        try {
            if (DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).findById(vo.getKtid()) == null) {
                return DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).doCreate(vo);
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Kongtiao vo) throws Exception {
        try{
            return DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try{
            return DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public Kongtiao get(Integer id) throws Exception {
        try{
            return DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).findById(id);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
    }

    @Override
    public List<Kongtiao> list() throws Exception {
        try{
            return DAOFactory.getIKongtiaoDAOInstance(this.dbc.getConnection()).findAll();
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
