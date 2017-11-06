package com.home.service.Impl;

import com.home.dao.Impl.KongtiaoDAOImpl;
import com.home.service.IKongtiaoService;
import com.home.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KongtiaoServiceImpl implements IKongtiaoService {
    private Connection conn;
    private PreparedStatement pstmt;
    public KongtiaoDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public boolean insert(User vo) throws Exception {
        return false;
    }

    @Override
    public boolean update(User vo) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        return false;
    }

    @Override
    public User get(String userno) throws Exception {
        return null;
    }

    @Override
    public List<User> list() throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> list(int currentPage, int lineSize, String column, String keyWord) throws Exception {
        return null;
    }
}
