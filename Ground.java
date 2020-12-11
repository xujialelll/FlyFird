package game;

import org.junit.Test;

import java.awt.image.BufferedImage;


/**
 * 地面类
 */

public class Ground {
    //x坐标
    int x;

    //y坐标
    int y;

    //地面图片
    BufferedImage img;

    //地面的宽度
    int w;

    //地面的高度
    int h;

    //地面的构造器用来构建地面对象
    public Ground() {
        //初始化地面图片
        img=Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/Ground2.PNG");

        //获取图片的高度、宽度
        h=img.getHeight();
        w=img.getWidth();

        //初始化x
        x=0;
        //初始化
        y=644-h-50;
    }

    @Test
    //地面移动的方法
    public void move(){
        if(x<=-(w-432)){
            x=0;
        }
        x--;
    }
}
