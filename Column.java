package game;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * 柱子类
 */

public class Column {

    //柱子图片
    BufferedImage img;

    //x,y坐标
    int x;
    int y;

    //柱子的宽度、高度
    int w;
    int h;

    //柱子间的距离
    int distance;

    //声明随机数对象
    Random random=new Random();

    //安全间隙
    int gap;

    //构造器初始化柱子对象
    public Column(int i) {
        //初始化柱子图片
        img=Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/Zhuzi5.png");

        //获取图片的宽度、高度
        w=img.getWidth();
        h=img.getHeight();

        //初始化柱子间距
        distance=245;

        //设置x,y坐标
        x=200+270*(i-1);

        y=-random.nextInt(100);
        //y=-30;

        //初始化安全间隙
        gap=75;
    }

    //柱子移动
    public void move(){
        x--;
        if(x<=-w){
            x=350+distance;
        }
    }
}
