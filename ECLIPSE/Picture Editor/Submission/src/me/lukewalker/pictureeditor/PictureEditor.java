package me.lukewalker.pictureeditor;

import java.awt.Color;
import java.util.ArrayList;


public class PictureEditor {
    
    static Picture pic;
    
    public static Color color = new Color(1,1,1);
    
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
            pic.set(x, y, color);
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
    			pic.set(x3, y3, color);
    		}
    	}
    	
    	pic.show();
    }
    
    public static void drawTriangle(int x, int y, int height) {
    	for (int h = 1; h <= height; h++) {
    		for (int l = 1; l <= h; l++) {
    			pic.set(l+x, h+y, color);
    		}
    	}
    	
    	pic.show();
    }
    
    public static void reflectX() {
    	for (int x = 0; x < pic.width(); x++) {
    		ArrayList<Color> c1 = new ArrayList<Color>();
    		ArrayList<Color> c2 = new ArrayList<Color>();
    		for (int y1 = 0; y1 < pic.height()/2; y1++) {
    			c1.add(pic.get(x, y1));
    		}
    		for (int y2 = pic.height()-1; y2 > pic.height()/2; y2--) {
    			c2.add(pic.get(x, y2));
    		}
    		for (int y1 = 0; y1 < pic.height()/2-1; y1++) {
    			pic.set(x, y1, c2.get(y1));
    		}
    		int i = 0;
    		for (int y2 = pic.height()-1; y2 > pic.height()/2; y2--) {
    			pic.set(x, y2, c1.get(i));
    			i++;
    		}
    	}
    	
    	pic.show();
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
}