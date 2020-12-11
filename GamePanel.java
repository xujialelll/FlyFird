package game;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


/**
 * 画板类
 */
public class GamePanel extends JPanel {

    //声明一个用于存放图片的变量（盒子）
    BufferedImage bg;

    //声明一个用于存放地面的变量
    Ground ground;

    //声明一个用于存放柱子的变量
    Column column1;

    //声明一个用于存放第二个柱子的变量
    Column column2;

    //声明一个鸟的对象
    Bird bird;

    //声明分数对象
    int score;

    //游戏准备状态
    boolean start;

    //游戏结束状态
    boolean gameOver;

    //构造器
    public GamePanel(){

        //设置背景色
        setBackground(Color.blue);

        //设置背景图片
        bg=Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/Air2.jpg");

        //初始化地面对象
        ground=new Ground();

        //初始化柱子对象
        column1=new Column(1);

        //初始化第二个柱子对象
        column2=new Column(2);

        //初始化鸟的对象
        bird=new Bird();

        //初始化游戏状态（没有开始，为准备状态，true为运行状态）
        start=false;

        //初始化游戏结束状态
        gameOver=false;

        //初始化分数
        score=0;


        //初始化鼠标监听器
        MouseAdapter adapter=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(start==false){
                    start=true;
                    System.out.println("游戏开始运行");
                    //启动游戏
                    start();
                }
                else if(gameOver){
                    //游戏回到准备状态
                    start=false;
                    gameOver=false;
                    //重置游戏中的所有对象
                    //初始化地面对象
                    ground=new Ground();

                    //初始化柱子对象
                    column1=new Column(1);

                    //初始化第二个柱子对象
                    column2=new Column(2);

                    //初始化鸟的对象
                    bird=new Bird();

                    //初始化分数
                    score=0;

                    //刷新
                    repaint();
                }
                else {
                    //小鸟上抛
                    bird.moveUp();
                    System.out.println("游戏已经运行");
                }
            }
        };
        this.addMouseListener(adapter);
    }

    @Test
    //游戏开始的方法
    public void start(){

        //启动游运行的线程
        MyThread myThread=new MyThread();

        //将线程所有执行的任务装入到线程对象中
        Thread thread=new Thread(myThread);

        //将线程纳入线程调度
        thread.start();
    }

    //用来向画板上绘制内容的方法 g相当于画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //绘制背景图片(需要绘制的图片，x坐标，y坐标，null)
        g.drawImage(bg,0,0,null);

        //绘制柱子图片
        g.drawImage(column1.img,column1.x,column1.y,column1.w,column1.h,null);
        g.drawImage(column2.img,column2.x,column2.y,column2.w,column2.h,null);

        //绘制地面图片
        g.drawImage(ground.img,ground.x,ground.y,ground.w,ground.h,null);

        //绘制鸟的图片
        g.drawImage(bird.img,bird.x,bird.y,bird.w,bird.h,null);

       //画准备状态的图片
        if(start==false){
            g.drawImage(Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/GamePlay.png"),-50,0,500,600,null);
        }

        //绘制游戏结束的图片
        if(gameOver){
            g.drawImage(Tools.getImg("D:/Developer_Code/java/FlyBird/src/img/GameOver.png"),-5,0,395,500,null);
        }

        //画分数

        //创建一个字体对象
        Font font=new Font("宋体",Font.BOLD,30);
        //将字体设置到画笔上
        g.setFont(font);
        //给画笔设置颜色
        g.setColor(Color.red);
        //绘制字符串
        g.drawString("分数:"+score,30,50);
    }


    //游戏运行的线程
    class MyThread implements Runnable{
        @Override
        public void run() {

            while (true){

                //让地面移动起来
                ground.move();

                //柱子移动
                column1.move();
                column2.move();

                //小鸟下落
                bird.move();

                //检查小鸟是否与顶部发生碰撞
                boolean boo1=bird.hit();

                //检测小鸟是否与柱子1发生了碰撞
                boolean boo2=bird.hit(column1);

                //检测小鸟是否与柱子2发生了碰撞
                boolean boo3=bird.hit(column2);

                //若发生碰撞则游戏结束
                if(boo1||boo2 ||boo3){
                    //更改游戏状态
                    gameOver=true;
                    //框体内的对象全部停止
                    break;
                }

                //计算分数
                if(bird.x==column1.x+column1.w||bird.x==column2.x+column2.w){
                    score++;
                }

                try {
                    //每移动一次休息1秒
                    Thread.sleep(50);
                    //刷新
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
