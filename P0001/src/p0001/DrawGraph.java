/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author tuans
 */
public class DrawGraph extends Canvas{
    final Canvas canvas;
    Graph graph;
    public DrawGraph() {
        this.setSize(300, 300);
        canvas = this;
    }
    public DrawGraph(Graph graph){
        this.setSize(300,300);
        this.graph=graph;
        canvas=this;
    }
    public Canvas getCanvas(){
        return canvas;
    }
//    public void paint(Graphics g){
//        Graphics2D g2=(Graphics2D) g;
//        g2.setBackground(Color.WHITE);
//        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
//        g2.setColor(Color.red);
//        String text="RED";
//        FontMetrics fm=g2.getFontMetrics();
//        int w=fm.stringWidth(text);
//        int h=fm.getAscent();
//        g2.drawOval(160, 160, w*2, h*4);     
//        g2.drawString(text, 160+(w/2), 160+(h*2));
//        
//        
//    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        Iterator it=graph.nameVertice.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry) it.next();
            String name=(String) pair.getKey();
            Vector propertise=graph.propertiseVertice.get(name);
            String label=(String) propertise.get(0);
            String color=(String) propertise.get(1);
            int x=getRanNum(0,200);
            int y=getRanNum(0,200);
            drawVertice(g2,name,label,color,x,y);
            
            it.remove();
        }
    }

    private void drawVertice(Graphics2D g2, String name, String label, String color,int x,int y) {
        Color colorBorder;
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            colorBorder = (Color)field.get(null);
        } catch (Exception e) {
            colorBorder = null; // Not defined
        }
        g2.setColor(colorBorder);
        
        
        String text=label;
        FontMetrics fm=g2.getFontMetrics();
        int w=fm.stringWidth(text);
        int h=fm.getAscent();
        g2.drawOval(x, y, w*2, h*4);
        g2.setColor(Color.BLACK);
        g2.drawString(text, x+(w/2), y+(h*2));
    }

    private int getRanNum(int min, int max) {
        int number = new Random().nextInt(max - min) +min;
        return number;
    }
}
