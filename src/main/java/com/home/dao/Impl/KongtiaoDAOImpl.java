package com.home.dao.Impl;

import com.home.dao.IKongtiaoDAO;
import com.home.vo.Kongtiao;
import com.home.vo.User;

import java.util.List;
import java.util.Set;

public class KongtiaoDAOImpl implements IKongtiaoDAO {
    @Override
    public boolean doCreate(Kongtiao vo) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdate(Kongtiao vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        return false;
    }

    @Override
    public User findById(Integer userno) throws Exception {
        return null;
    }

    @Override
    public List<Kongtiao> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Kongtiao> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }
}
