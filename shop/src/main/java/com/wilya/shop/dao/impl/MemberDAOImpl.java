package com.wilya.shop.dao.impl;

import com.wilya.shop.dao.IMemberDAO;
import com.wilya.shop.util.dao.AbstractDAOImpl;
import com.wilya.shop.vo.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class MemberDAOImpl extends AbstractDAOImpl implements IMemberDAO {
    public MemberDAOImpl(Connection conn) {
        super(conn);
    }

    /**
     * 实现数据的增加操作
     *
     * @param vo 包含了要增加数据的VO对象
     * @return 数据保存成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    @Override
    public boolean doCreate(Member vo) throws Exception {
        String sql = "INSERT INTO member(mid,password,code,regdate,status) VALUES (?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMid());
        super.pstmt.setString(2,vo.getPassword());
        super.pstmt.setString(3,vo.getCode());
        super.pstmt.setTimestamp(4,new Timestamp(vo.getRegdate().getTime()));
        super.pstmt.setInt(5,vo.getStatus());
        return super.pstmt.executeUpdate() > 0;
    }

    /**
     * 实现数据的修改操作，本次修改时根据id进行全部字段数据的修改
     *
     * @param vo 包含了要修改数据的信息，一定要提供有ID内容
     * @return 数据修改成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    @Override
    public boolean doUpdate(Member vo) throws Exception {
        return false;
    }

    /**
     * 执行数据的批量删除操作，所有要删除的数据以Set集合的形式保存
     *
     * @param ids 包含了所有要删除的数据ID，不包含有重复内容
     * @return 删除成功返回true（删除的数据个数与要删除的数据个数相同），否则返回false
     * @throws Exception SQL执行异常
     */
    @Override
    public boolean doRemoveBatch(Set<String> ids) throws Exception {
        return false;
    }

    /**
     * 根据用户账号查询指定的雇员信息
     *
     * @param id 要查询的用户账号
     * @return 如果雇员信息存在，则将数据以VO类对象的形式返回，如果雇员数据不存在，则返回null
     * @throws Exception SQL执行异常
     */
    @Override
    public Member findById(String id) throws Exception {
        Member vo = null;
        String sql = "SELECT mid,password,name,phone,address,code,status,regdate,photo FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCode(rs.getString(6));
            vo.setStatus(rs.getInt(7));
            vo.setRegdate(rs.getTimestamp(8));
            vo.setPhoto(rs.getString(9));
        }
        return vo;
    }

    /**
     * 查询指定数据表的全部记录，并且以集合的形式返回
     *
     * @return 如果表中有数据，则所有的数据会封装为VO对象而后利用List集合返回<br>
     * 如果没有数据，那么集合的长度为0（size() == 0,不是null）
     * @throws Exception Sql执行异常
     */
    @Override
    public List<Member> findAll() throws Exception {
        return null;
    }

    /**
     * 分页进行数据的模糊查询，查询结果以集合的形式返回
     *
     * @param currentPage 当前所在的页
     * @param lineSize    每一页显示的数据行数
     * @param column      要进行模糊查询的数据列
     * @param keyWord     模糊查询的关键字
     * @return 如果表中有数据，则所有的数据会封装为VO对象而后利用List集合返回，<br>
     * 如果没有数据，那么集合的长度为0（Size() == 0,不是null）
     * @throws Exception Sql执行异常
     */
    @Override
    public List<Member> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    /**
     * 进行模糊查询数据量的统计，如果表中没有记录统计的结构就是0
     *
     * @param column  要进行模糊查询的数据列
     * @param keyWord 模糊查询的关键字
     * @return 返回表中的数据量，如果没有数据返回0
     * @throws Exception SQL执行异常
     */
    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }
}
