/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.GUI;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import gymer.entities.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.util.List;
import gymer.entities.*;
import java.awt.Font;
import java.awt.RenderingHints;
/**
 *
 * @author luyen
 */
public class Graph {
    private JFrame fr;
    private graphGraphics gp;
    
    public Graph(List input, int in) {
        this.fr = new JFrame();
        this.gp =  new graphGraphics(input, in);
        fr.add(gp);
        fr.setSize(1750, 900);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.setTitle("Biểu đồ báo cáo");  
    }   
    
    public void destroy () {
        this.fr.dispose();
    }
}


class Point {
    int x , y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}


class graphGraphics extends Canvas {

    private List<RPDetails> data;
    private Point[] p;
    private int chooser;
    
    public graphGraphics(List input, int in) {
        this.data = input;
        this.chooser = in;
        this.p = new Point[input.size()];
    }

    private void drawCoordinate (Graphics g) {
        Point[] PosY = dividePositionY();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setBackground(Color.WHITE);
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.drawLine(100, 50, 100, 800);
        g2d.drawLine(100, 800, 1550, 800);
        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        if (chooser == 1){
                g2d.drawString("Doanh số", 65, 40);
                g2d.drawString("Số lượng", 1560, 810);
            }
        else if (chooser ==2) {
            g2d.drawString("Lượt ra vào", 65, 40);
            g2d.drawString("Ngày", 1560, 810);
        }   
        else if (chooser ==3 ) {
            g2d.drawString("Lượt ra vào", 65, 40);
            g2d.drawString("Tháng", 1560, 810);
        }
        int number = this.data.size();
        int offset = (int)(1450 / number);
        int offsetY = (int)(750 / number);
        int i = 1;
        int count = 0;
        // x,y coordinate
        for (RPDetails rp : data) {
            g2d.setStroke(new BasicStroke(2.5f));
            // X
            g2d.setColor(Color.BLUE);
            g2d.drawLine( i * offset , 790, i * offset , 810);  
            if (chooser == 1){
                g2d.drawString(rp.getTenDV() + " bán được " + rp.getSoLuongDichVu() , (i * offset) - 80, 830);
            }
            else {g2d.drawString(rp.getTenDV(), (i * offset) - 80, 830);}
            // Y
            g2d.drawLine(90, PosY[i-1].getY(), 110, PosY[i-1].getY());
            g2d.drawString(rp.getTongTien() + "" , 20, PosY[i-1].getY());
            this.p[count] = new Point(i*offset , PosY[i-1].getY());
            // horizon line 
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(0.5f));
            g2d.drawLine(115, PosY[i-1].getY(), 1550, PosY[i-1].getY());
            count++;
            i++;
        }
    }
    
    
    private Point[] dividePositionY () {
        float ratio = 0.0f;
        int posY;
        int max = data.get(0).getTongTien();
        Point[] result = new Point[this.data.size()];
        for (RPDetails rp : data) {
            if (rp.getTongTien() > max) {
                max = rp.getTongTien();
            }
        }
        int i = 0;
        for (RPDetails rp : data) {
            ratio = (float)rp.getTongTien() / (float)max;        
            posY = (int)(750f - (750f * (float)ratio));
            if (posY <= 100) {
                posY = 100;
            }
            result[i] = new Point(0,posY);
            i++;
        }

        return result;
    }
    
    private void drawLINE (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2.5f));
        for (int i = 0 ; i < data.size() ; i++) {
            g2d.setColor(Color.RED);
            if (i == (data.size() - 1)) {
                g2d.drawString(data.get(i).getTongTien()+ "", this.p[i].getX() - 30, this.p[i].getY() + 30);
                g2d.fillRect(p[i].getX()-5, this.p[i].getY() - 5, 10, 10);
                return;
            }
            g2d.drawLine(this.p[i].getX(), this.p[i].getY(), this.p[i+1].getX(), this.p[i+1].getY());
            g2d.drawString(data.get(i).getTongTien()+ "", this.p[i].getX() - 30, this.p[i].getY() + 30);
            g2d.fillRect(p[i].getX()-5, this.p[i].getY() - 5, 10, 10);
        }
    }
    
    public void paint(Graphics g) {
        drawCoordinate(g);
        drawLINE(g);
    }
}