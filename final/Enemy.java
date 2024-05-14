import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private double MOVE_AMT = 1;
    private BufferedImage enemy;
    private double xCoord;
    private double yCoord;
    public Enemy(String image) {
        yCoord = 475;
        xCoord = 800;
        try {
            enemy = ImageIO.read(new File(image));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getMOVE_AMT() {
        return MOVE_AMT;
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }

    public BufferedImage getEnemyImage() {
        return enemy;
    }
    public void moveRight() {
        if (xCoord + MOVE_AMT <= 920) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 435) {
            yCoord += MOVE_AMT;
        }
    }
    public void setMOVE_AMT(double amount) {
        MOVE_AMT += amount;
    }
    public Rectangle enemyRect() {
        int imageHeight = getEnemyImage().getHeight();
        int imageWidth = getEnemyImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
