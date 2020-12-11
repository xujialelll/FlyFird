package game;

import sun.awt.image.ToolkitImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * 游戏窗体类
 */

public class GameFrame extends JFrame {


    //构造器：用来做初始化操作
    public GameFrame() {

        //设置窗体的尺寸
        setSize(400,600);

        //设置居中显示
        setLocationRelativeTo(null);

        //设置关闭窗体的同时终止程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置标题
        setTitle("飞翔的小鸟");

        //设置Logo图标
        setIconImage(Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/BirdLogo.jpg"));

    }

}
