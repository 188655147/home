package com.tz.map.server;

@WebServlet("/position")
public class PositionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,HttpServlet){
        //获取页面传递过来的信息
        String lon = req.getParameter("lon");
        String lat = req.getParameter("lat");
        String err = req.getParameter("err");
        //保存起来
        req.getServletContext();
        if(err==null){
            context.setAttribute("lon",lon);
            context.setAttribute("lat",lat);
        } else {
            context.setAttribute("err",err);
        }
    }


}
