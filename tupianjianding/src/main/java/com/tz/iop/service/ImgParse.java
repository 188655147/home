package com.tz.iop.service;

import com.baidu.aip.imagecensor.AipImageCensor;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * 图片性质解析类
 */
@WebServlet("/parse")
public class ImgParse extends HttpServlet {
    private static final String APPID = "9389343";
    private static final String APIKEY = "9FfcAkwQ9pBWgYO4vmfdOf31";
    private static final String SECRETKEY = "XQMyp7ZYp1D99XCrzPxB7bTjPEOSGYwr";
    public static org.json.JSONObject parserImg(String imgPath){
        AipImageCensor client = new AipImageCensor(APPID,APIKEY,SECRETKEY);
        JSONObject antiPorn = client.antiPorn(imgPath);
        return antiPorn;
    }
    protected void service(HttpServletRequest req,HttpServletRequest resp) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        String psth = req.getParameter("path");
        String realPath = req.getServletContext().getRealPath(path);
        org.json.JSONObject parserImg = parserImg(realPath);
        resp.getWriter().print(pareserImg);
    }
}
