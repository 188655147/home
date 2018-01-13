package com.tz.iop.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/**
 * 文件上传类
 */
@WebServlet("/")
public class Upload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletRequest resp) throws UnsupportedEncodingException {
        String name = "";
        //处理的字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //判断文件上传的类型
        boolean bol = ServletFileUpload.isMultipartContent();
        if(bol){
            //创建文件上传工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //获取文件文件迭代器
            try {
                Iterator<FileItem> items = upload.parseRequest(req).iterator();
                while(items.hasNext()){
                    FileItem item = items.next();
                    //获取上传过来的文件名
                    name = item.getName();
                    //定义文件保存路径
                    String realPath = req.getServletContext().getRealPath("upload");
                    //如果文件夹不存在
                    File file = new File(realPath);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    new File(realPath+"/"+name);
                    item.write(file);
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        resp.getWriter().print(name);
    }
}
