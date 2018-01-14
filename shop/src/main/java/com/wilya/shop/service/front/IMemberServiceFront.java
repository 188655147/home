package com.wilya.shop.service.front;

import com.wilya.shop.vo.Member;

public interface IMemberServiceFront {
    /**
     * 实现用户的注册操作，注册时要提供有mid、password、regdate、code、status;<br>
     *     本程序将调用如下操作：<br>
     *         调用IMemberDAO.findById()方法判断注册mid是否存在。
     *         调用IMemberDAO.doCreate()方法保存基本信息。
     * @param vo 包含有注册信息的vo类对象
     * @return 注册成功返回true，否则返回false
     * @throws Exception
     */
    public boolean regist(Member vo) throws Exception;
}
