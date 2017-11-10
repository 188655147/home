package com.home.dao.Impl;

import com.home.dao.IKaiguangDAO;
import com.home.vo.Kaiguang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KaiguangDAOImpl implements IKaiguangDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    public KaiguangDAOImpl(Connection conn){this.conn = conn;}
    @Override
    public boolean doCreate(Kaiguang vo) throws Exception {
        String sql = "INSERT INTO kaiguang(kgid,deng,jiaodu,wendu,shidu,nongdu,qiangdu,user_w) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getKgid());
        this.pstmt.setByte(2,vo.getDeng());
        this.pstmt.setDouble(3,vo.getJiaodu());
        this.pstmt.setDouble(4,vo.getWendu());
        this.pstmt.setDouble(5,vo.getShidu());
        this.pstmt.setDouble(6,vo.getNongdu());
        this.pstmt.setDouble(7,vo.getQiangdu());
        if (vo.getUserByUserW() == null) {
            this.pstmt.setNull(8, Types.NULL);
        }else{
            this.pstmt.setInt(8,vo.getUserByUserW().getId());
        }
        return this.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Kaiguang vo) throws Exception {
        String sql = "UPDATE kaiguang SET deng=?,jiaodu=?,wendu=?,shidu=?,nongdu=?,qiangdu=?,user_w=? WHERE kgid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setByte(1,vo.getDeng());
        this.pstmt.setDouble(2,vo.getJiaodu());
        this.pstmt.setDouble(3,vo.getWendu());
        this.pstmt.setDouble(4,vo.getShidu());
        this.pstmt.setDouble(5,vo.getNongdu());
        this.pstmt.setDouble(6,vo.getQiangdu());
        if (vo.getUserByUserW() == null) {
            this.pstmt.setNull(7,Types.NULL);
        }else {
            this.pstmt.setInt(7,vo.getUserByUserW().getId());
        }
        this.pstmt.setInt(8,vo.getKgid());
        return this.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if(ids == null || ids.size() == 0){
            return false;
        }
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM kaiguang WHERE kgid IN(");
        Iterator<Integer> iter = ids.iterator();
        while(iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        this.pstmt = this.conn.prepareStatement(sql.toString());
        return this.pstmt.executeUpdate() == ids.size();
    }

    @Override
    public Kaiguang findById(Integer id) throws Exception {
        Kaiguang vo = null;
        String sql = "SELECT deng,jiaodu,wendu,shidu,nongdu,qiangdu,user_w FROM kaiguang WHERE kgid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            vo = new Kaiguang();
            vo.setDeng(rs.getByte(1));
            vo.setJiaodu(rs.getDouble(2));
            vo.setWendu(rs.getDouble(3));
            vo.setShidu(rs.getDouble(4));
            vo.setNongdu(rs.getDouble(5));
            vo.setQiangdu(rs.getDouble(6));
            vo.setUserW(rs.getInt(7));
        }
        return vo;
    }

    @Override
    public List<Kaiguang> findAll() throws Exception {
        List<Kaiguang> all = new ArrayList<Kaiguang>();
        String sql = "SELECT ktid,ktname,moshi,wendu,fengli,dingshi,user_w,fengxiang,kaiguang," +
                "saofeng,shuimian,shuxian FROM kongtiao";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            Kaiguang vo = new Kaiguang();
            vo.setKgid(rs.getInt(1));
            vo.setDeng(rs.getByte(2));
            vo.setJiaodu(rs.getDouble(3));
            vo.setWendu(rs.getDouble(4));
            vo.setShidu(rs.getDouble(5));
            vo.setNongdu(rs.getDouble(6));
            vo.setQiangdu(rs.getDouble(7));
            vo.setUserW(rs.getInt(8));
        }
        return all;
    }

    @Override
    public List<Kaiguang> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }
}
