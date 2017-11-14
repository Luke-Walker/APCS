package me.lukewalker.pictureeditor;

import java.awt.Color;


public class PictureEditor {
    
    static Picture pic;
    
    public static void main(String[] args) {
        
        args = new String[1];
        args[0] = "javapic.jpg";
        
        pic = new Picture(args[0]);
        //System.out.println(pic.width() + "w x " + pic.height()+"h");
        
        //printPixelColors();
        //drawDarkerLine();
        //drawSquare();

        pic.show();
            
    }
    
    
    public static void printPixelColors(int x, int y) {
        Color pixelColor = pic.get(x, y);
        int red = pixelColor.getRed();
        int green = pixelColor.getGreen();
        int blue = pixelColor.getBlue();
        System.out.println("red:"+red+",green:"+green+",blue:"+blue);
    }

    public static void drawDarkerLine(int y) {
        int width = 200;
        for (int x = 0; x < width; x++) {
            int red = 10;
            int blue = 10;
            int green = 10;
            Color pixelColor = new Color(red, green, blue);
            pic.set(x, y, pixelColor);
            pic.show();
        }
    }


    public static void drawSquare(int x, int y, int width, int height) {
    	int x1 = x;
    	int x2 = x+width;
    	int y1 = y;
    	int y2 = y+height;
    	
    	for (int y3 = y1; y3 < y2; y3++) {
    		for (int x3 = x1; x3 < x2; x3++) {
    			pic.set(x3, y3, new Color(1,1,1));
    		}
    	}
    	
    	pic.show();
    }
    
    public static void drawCenteredSquare() {
        
    }
    
    public static void drawTriangleTop() {
        
    }
    
}