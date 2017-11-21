package com.home.action;


import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
    /**
     * Where the logic of the action is executed.
     *
     * @return a string representing the logical result of the execution.
     * See constants in this interface for a list of standard result values.
     * @throws Exception thrown if a system level exception occurs.
     *                   <b>Note:</b> Application level exceptions should be handled by returning
     *                   an error value, such as <code>Action.ERROR</code>.
     */
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
