/*

10/31 - FunctionPlotter.java

#1 Complete the gridlines for the first quadrant of a cartesian coordinate plane
(an upside-down plane, that is)

After creating the gridlines, try adding a linear functions (#2), and then a quadratic function (#3).

*/

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class FunctionPlotter extends JComponent {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		FunctionPlotter graph = new FunctionPlotter();
		window.setSize(400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("A Function Plotter");

		window.add(graph);
		window.setVisible(true);

	}

	public void paint(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		// Example: horizontal grid lines
		for (int y=0; y<=400; y+=20) {
			g.drawLine(0,y,400,y);
		}

		// #1) Draw the vertical gridlines (person A)
		for (int x=0; x<=400; x+=20) {
			g.drawLine(x,0,x,400);
		}

		// Example: plot y = 2x - 2
		g.setColor(Color.RED);
		for (int x = 0; x<400; x++) {
			int y = 2*x- 2;
			g.drawOval(x,y,1,1);
		}

		// Example: plot y = x
		g.setColor(Color.PINK);
		for (int x = 0; x < 400; x++) {
			int y = x;
			g.drawOval(x,y,1,1);
		}

		// #2) Create another linear function e.g. y = 3x+1 (person B)
		g.setColor(Color.BLUE);
		for (int x = 0; x < 400; x++) {
			int y = 3*x+1;
			g.drawLine(x,y,1,1);
		}

		// Example: plot y = (1/2)*x^2 - 4
		g.setColor(Color.CYAN);
		for (int x = 0; x < 400; x++) {
			int y1 = (int)(0.5*Math.pow(x,2) - 4);
			int y2 = (int)(0.5*Math.pow(x+1,2) - 4);
			g.drawLine(x,y1,x+1,y2);

		}

		// #3) Create a quadratic e.g. y = x^2 (person A)
		// x^2 = x*x   or  x^2 = Math.pow(x, 2)
		// 3x^2+2x+3
		g.setColor(Color.GREEN);
		for (int x = 0; x < 400; x++) {
			int y = (int)(3*Math.pow(x,2)+2*x+3);
			g.drawLine(x,y,1,1);
		}




	}

}
