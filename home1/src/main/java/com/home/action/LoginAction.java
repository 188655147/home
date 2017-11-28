package com.home.action;

import com.home.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LoginAction extends ActionSupport {

    /*    private String userno;
        private String password;
        public String getUserno() {
            return userno;
        }
        public void setUserno(String userno) {
            this.userno = userno;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }*/
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        if (user.getUserno().equals("admin") && user.getPassword().equals("123")) {
            //调用servlet提供的api接口，实现将数据存到session里
            //首先获取action的上下文对象
            ActionContext actionContext = ActionContext.getContext();
            //获取session的对象，而这个对象是存储了所有的session数据的集合
            Map<String,Object> sessionMap = actionContext.getSession();
            sessionMap.put("username",user.getUserno());
            return SUCCESS;
        } else {
            return "relogin";
        }
    }
}
