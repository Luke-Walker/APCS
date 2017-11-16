package me.lukewalker.pictureeditor;

import java.awt.Color;
import java.util.HashMap;


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

    public static void drawDarkerLine(int y, int width) {
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
    
    public static void drawTriangle(int x, int y, int width, int height) {
    	if (width % 2 == 1) width++;
    	
    	for (int l = x;  l < width/2+x; l++) {
    		for (int h = 1; h < height+y; h++) {
    			pic.set(l, h, new Color(1,1,1));
    		}
    	}
    	for (int l = width/2; l < width+x; l++) {
    		for (int h = height; h > 0; h--) {
    			pic.set(l, h, new Color(1,1,1));
    		}
    	}
    	
    	pic.show();
    }
    
    public static void reflectX() {
    }
    
    public static void reflectY() {
    }
    
    public static void inverseColors() {
    	for (int y = 0; y < pic.height(); y++) {
    		for (int x = 0; x < pic.width(); x++) {
    			pic.set(x, y, new Color(255-pic.get(x, y).getRed(), 255-pic.get(x, y).getGreen(), 255-pic.get(x, y).getBlue()));
    		}
    	}
    	
    	pic.show();
    }
    
    public static void grayscale() {
    	for (int y = 0; y < pic.height(); y++) {
    		for (int x = 0; x < pic.width(); x++) {
    			int red = (int)(pic.get(x, y).getRed()*.299);
    			int green = (int)(pic.get(x, y).getGreen()*.587);
    			int blue = (int)(pic.get(x, y).getBlue()*.114);
    			int rgb = red + green + blue;
    			pic.set(x, y, new Color(rgb, rgb, rgb));	
    		}
    	}
    	
    	pic.show();
    }
    
    public static void drawCenteredSquare() {
        
    }
    
    public static void drawTriangleTop() {
        
    }
    
}