package com.home.service;

import com.home.vo.User;

/**
 * 定义user表的业务层的执行标准，此类一定要负责数据库的打开与关闭操作
 * 此类可以通过DAOFactory类取得IUserDAO接口对象
 */
public interface IUserService extends IService<Integer,User> {
}
