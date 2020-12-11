package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 工具类
 */

public class Tools {
    /**
     * 根据给定的图片路径获取图片的方法
     * @param path 所给定的图片路径
     * @return
     */
    public static BufferedImage getImg(String path){
        //声明一张图片
        BufferedImage img=null;
        try {
            img=ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
}
