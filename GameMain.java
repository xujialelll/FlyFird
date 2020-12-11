package game;

import org.junit.Test;

public class GameMain {
    //主程序
    public static void main(String[] args) {
        //创建窗体对象
        GameFrame gameFrame=new GameFrame();

        //创建一个画板对象
        GamePanel gamePanel=new GamePanel();

        //向窗体内添加一块画板
        gameFrame.add(gamePanel);

        //显示窗体
        gameFrame.setVisible(true);
    }

}
