package com.home.dao.Impl;

import com.home.dao.IKongtiaoDAO;
import com.home.vo.Kongtiao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KongtiaoDAOImpl implements IKongtiaoDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    public KongtiaoDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public boolean doCreate(Kongtiao vo) throws Exception {
        String sql = "INSERT INTO kongtiao(ktid,ktname,moshi,wendu,fengli,dingshi,user_w,fengxiang," +
                "kaiguang,saofeng,shuimian,shuxian) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getKtid());
        this.pstmt.setString(2,vo.getKtname());
        this.pstmt.setString(3,vo.getMoshi());
        this.pstmt.setInt(4,vo.getWendu());
        this.pstmt.setInt(5,vo.getFengli());
        this.pstmt.setInt(6,vo.getDingshi());
        if (vo.getUserByUserW() == null) {
            this.pstmt.setNull(7, Types.NULL);
        }else {
            this.pstmt.setInt(7,vo.getUserByUserW().getId());
        }
        this.pstmt.setDouble(8,vo.getFengxiang());
        this.pstmt.setByte(9,vo.getKaiguang());
        this.pstmt.setByte(10,vo.getSaofeng());
        this.pstmt.setByte(11,vo.getShuxian());
        this.pstmt.setByte(12,vo.getShuimian());
        return this.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Kongtiao vo) throws Exception {
        String sql = "UPDATE kongtiao SET ktname=?,moshi=?,wendu=?,fengli=?,dingshi=?,user_w=?," +
                "fengxiang=?,kaiguang=?,saofeng=?,shuimian=?,shuxian=? WHERE ktid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,vo.getKtname());
        this.pstmt.setString(2,vo.getMoshi());
        this.pstmt.setInt(3,vo.getWendu());
        this.pstmt.setInt(4,vo.getFengli());
        this.pstmt.setInt(5,vo.getDingshi());
        if (vo.getUserByUserW() == null) {
            this.pstmt.setNull(6, Types.NULL);
        }else {
            this.pstmt.setInt(6,vo.getUserByUserW().getId());
        }
        this.pstmt.setDouble(7,vo.getFengxiang());
        this.pstmt.setByte(8,vo.getKaiguang());
        this.pstmt.setByte(9,vo.getSaofeng());
        this.pstmt.setByte(10,vo.getShuxian());
        this.pstmt.setByte(11,vo.getShuimian());
        this.pstmt.setInt(12,vo.getKtid());
        return this.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if(ids == null || ids.size() == 0){ //没有要删除的数据
            return false;
        }
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM kongtiao WHERE ktid IN(");
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        this.pstmt = this.conn.prepareStatement(sql.toString());
        return  this.pstmt.executeUpdate() == ids.size();
    }

    @Override
    public Kongtiao findById(Integer id) throws Exception {
        Kongtiao vo = null;
        String sql = "SELECT ktname,moshi,wendu,fengli,dingshi,user_w,fengxiang,kaiguang,saofeng," +
                "shuimian,shuxian FROM kongtiao WHERE ktid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            vo = new Kongtiao();
            vo.setKtname(rs.getString(1));
            vo.setMoshi(rs.getString(2));
            vo.setWendu(rs.getInt(3));
            vo.setFengli(rs.getInt(4));
            vo.setDingshi(rs.getInt(5));
            vo.setUserW(rs.getInt(6));
            vo.setFengxiang(rs.getDouble(7));
            vo.setKaiguang(rs.getByte(8));
            vo.setSaofeng(rs.getByte(9));
            vo.setShuimian(rs.getByte(10));
            vo.setShuxian(rs.getByte(11));
        }
        return vo;
    }

    @Override
    public List<Kongtiao> findAll() throws Exception {
        List<Kongtiao> all = new ArrayList<Kongtiao>();
        String sql = "SELECT ktid,ktname,moshi,wendu,fengli,dingshi,user_w,fengxiang,kaiguang," +
                "saofeng,shuimian,shuxian FROM kongtiao";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()){
            Kongtiao vo = new Kongtiao();
            vo.setKtid(rs.getInt(1));
            vo.setKtname(rs.getString(2));
            vo.setMoshi(rs.getString(3));
            vo.setWendu(rs.getInt(4));
            vo.setFengli(rs.getInt(5));
            vo.setDingshi(rs.getInt(6));
            vo.setUserW(rs.getInt(7));
            vo.setFengxiang(rs.getDouble(8));
            vo.setKaiguang(rs.getByte(9));
            vo.setSaofeng(rs.getByte(10));
            vo.setShuimian(rs.getByte(11));
            vo.setShuxian(rs.getByte(12));
        }
        return all;
    }

    @Override
    public List<Kongtiao> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Kongtiao findByIdDetails(Integer ktid) throws Exception {
        Kongtiao vo = null;
        String sql = "SELECT ktname,moshi,wendu,fengli,dingshi,user_w,fengxiang,kaiguang,saofeng," +
                "shuimian,shuxian FROM kongtiao WHERE ktid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,ktid);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            vo = new Kongtiao();
            vo.setKtname(rs.getString(1));
            vo.setMoshi(rs.getString(2));
            vo.setWendu(rs.getInt(3));
            vo.setFengli(rs.getInt(4));
            vo.setDingshi(rs.getInt(5));
            vo.setUserW(rs.getInt(6));
            vo.setFengxiang(rs.getDouble(7));
            vo.setKaiguang(rs.getByte(8));
            vo.setSaofeng(rs.getByte(9));
            vo.setShuimian(rs.getByte(10));
            vo.setShuxian(rs.getByte(11));
        }
        return vo;
    }

    @Override
    public List<Kongtiao> findAllDetails() throws Exception {
        return null;
    }

    @Override
    public List<Kongtiao> findAllSplitDetails(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }
}
