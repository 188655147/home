package com.home.dao;

import com.home.vo.Kongtiao;

import java.util.List;

public interface IKongtiaoDAO extends IDAO<Integer, Kongtiao> {
    /**
     * 查询空调的详细信息，包括空调所对应的用户信息
     *
     * @param ktid 要查询的空调id
     * @return 所有的数据以VO对象返回，如果没有则返回null
     * @throws Exception SQL查询错误
     */
    public Kongtiao findByIdDetails(Integer ktid) throws Exception;

    /**
     * 查询空调完整信息
     *
     * @return 所有的数据对象以List集合返回，如果没有数据，集合长度为0(size() == 0)
     * @throws Exception SQL查询错误
     */
    public List<Kongtiao> findAllDetails() throws Exception;

    /**
     * 分页查询空调的完整信息
     *
     * @param currentPage 当前所在的页
     * @param lineSize    每页显示数据的行数
     * @param column      要进行模糊查询的数据列
     * @param keyWord     模糊查询的关键字
     * @return 如果表中有数据，则所有的数据会封装为VO对象而后利用List集合返回，<br>
     * 如果没有数据，那么集合的长度为0(size() == 0)
     * @throws Exception SQL执行异常
     */
    public List<Kongtiao> findAllSplitDetails(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;
}
