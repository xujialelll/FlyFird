package game;

import org.junit.Test;

import java.awt.image.BufferedImage;

public class Bird {
    //鸟的图片
    BufferedImage img;
    //x,y坐标
    int x;
    int y;
    //鸟的宽度、高度
    int w;
    int h;
    //初速度
    double v0;
    //往上一动的时间
    double t;
    //距离
    double s;
    //重力
    double g;

    public Bird(){

        //获取鸟的图片
        img=Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/Bird.png");

        //获取鸟的宽度，高度
        w=img.getWidth()/5;
        h=img.getHeight()/5;

        x=100;
        y=200;

        //速度初始化
        v0=3;
        t=0.2;
        s=0;
        g=5;
    }

    @Test
    //小鸟的一个落体运动
    public void move(){

        //计算小鸟上抛距离
        s=v0*t;
        //得到小鸟上抛到最高时的y坐标
        y=(int)(y-s);
        //计算小鸟到达高点时的速度
        double v2=v0-g*t;
        //最高点的速度就是小鸟下落时的初速度
        v0=v2;
    }

    //小鸟上抛运动
    public void moveUp(){
        v0=10;
    }


    //小鸟与顶部、地面发生碰撞
    public boolean hit(){
        if(y<=0||y>=644-233-h){
            return true;
        }
        return false;//没碰到
    }


    //小鸟和柱子的碰撞
    public boolean hit(Column column){
        if(x>=column.x-w&&x<=column.x+column.w){
            if(y>column.h/2+column.y-column.gap/2&&y<column.h/2+column.y+column.gap/2-h){
                return false;
            }
            return true;
        }
        return false;
    }
}
