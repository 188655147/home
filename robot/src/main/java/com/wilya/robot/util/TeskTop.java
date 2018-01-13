package com.wilya.robot.util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * @ClassName:TeskTop
 * @Description:自动化机器人核心类
 * @authur yinghan
 * @date 2017年12月12日20:42:12
 */
public class TeskTop {
    public static void openBrowse(String uri){
        //获取权限  允许Java应用程序启动已经在电脑上面安装的程序
        try {
            Desktop desktop = Desktop.getDesktop();
            //desktop.open(new File("F:\\HTML\\40+22\\index.html"));
            desktop.browse(new URI(uri));

            //开始输入文字  创建一个机器人
            Robot robot = new Robot();
            robot.delay(5000);
            //按下键盘Java
            robot.keyPress(KeyEvent.VK_J);//按下
            robot.keyRelease(KeyEvent.VK_J);//弹起
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_A);//按下
            robot.keyRelease(KeyEvent.VK_A);//弹起
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_V);//按下
            robot.keyRelease(KeyEvent.VK_V);//弹起
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_A);//按下
            robot.keyRelease(KeyEvent.VK_A);//弹起
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_ENTER);//按下
            robot.keyRelease(KeyEvent.VK_ENTER);//弹起
            robot.delay(300);

            robot.keyPress(KeyEvent.VK_ENTER);//按下
            robot.keyRelease(KeyEvent.VK_ENTER);//弹起
            robot.delay(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //游戏辅助 分辨率 设置成XX 画质XXX 坐标XXX
    }
    public static void main(String[] args) {
        openBrowse("http://www.baidu.com");
    }
}
