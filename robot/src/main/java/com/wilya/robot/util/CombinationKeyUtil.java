package com.wilya.robot.util;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ClassName: CombinationKeyUtil
 * @deprecated: 快捷键封装
 * @author: yinghan
 * @date: 2017年12月12日21:42:12
 * @version: 1.0
 */
public class CombinationKeyUtil {
    //shift组合键
    public static void keyPressWithShift(Robot robot,int key){
        //创建机器人
        //Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(key);

        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(key);
        //等待
        robot.delay(100);
    }
    //Ctrl组合键
    public static void keyPressWithCtrl(Robot robot,int key){
        //创建机器人
        //Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(key);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(key);
        //等待
        robot.delay(100);
    }
    //Ctrl+Shift
    public static void keyPressCtrlShift(Robot robot,int key){
        //创建机器人
        //Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(key);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(key);
        //等待
        robot.delay(100);
    }
    //Ctrl+Alt
    public static void keyPressCtrlAlt(Robot robot,int key){
        //创建机器人
        //Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(key);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(key);
        //等待
        robot.delay(100);
    }

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            keyPressCtrlAlt(robot,KeyEvent.VK_A);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
