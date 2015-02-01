/**
This class creates a panel that roughly approximates abstract art. It draws a different portrait every 4 seconds.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RandomArt{
	
	public static void main(String[] args){
		
		JFrame window = new JFrame("Abstract Art");
		ArtPanel content = new ArtPanel();
		window.setContentPane(content);
		window.setSize(500, 500);
		window.setResizable(false);
		window.setLocation(100, 100);
		window.setVisible(true);
		
	}
	
	static class ArtPanel extends JPanel{
		
		private ArrayList<Shape> shapes = new ArrayList<Shape>(1);
		
		public ArtPanel(){
			
			Timer timer = new Timer(4000, new ActionListener(){
				
				public void actionPerformed(ActionEvent evt){
					repaint();
				}
				
			});
			
			timer.start();
			
		}
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
			
			shapes.clear();
			int artType = (int)(Math.random() * 3);
			int i;
			switch(artType){
		
				case 0:
				for(i = 0; i < 500; i++){
					shapes.add(new Line(getWidth(), getHeight()));
				}
				break;
				
				case 1:
				for(i = 0; i < 200; i++){
					shapes.add(new Circle(getWidth(), getHeight()));
				}
				break;
				
				case 2:
				for(i = 0; i < 25; i++){
					shapes.add(new Square(getWidth(), getHeight()));
				}
		
			}
			
			for(Shape shape:shapes){
				shape.drawShape(g);
			}
			
		}
		
		static abstract class Shape{
			
			Color randColor;
			
			public Shape(){
				
				randColor = Color.getHSBColor( (float)Math.random(), 1.0F, 1.0F);
				
			}
			
			abstract void drawShape(Graphics g);
			
		}
		
		static class Line extends Shape{
			
			private int x1, y1;
			private int x2, y2;
			
			public Line(int width, int height){//width and height are taken from the container.
				
				x1 = (int)(width * Math.random());
				y1 = (int)(height * Math.random());
				x2 = (int)(width * Math.random());
				y2 = (int)(height * Math.random());
				
			}
			
			void drawShape(Graphics g){
				
				g.setColor(randColor);
				g.drawLine(x1, y1, x2, y2);
				
			}
			
		}
		
		static class Square extends Shape{
			
			private int centerX, centerY;
			private int size;
			
			public Square(int width, int height){
				
				centerX = (int)(width * Math.random());
				centerY = (int)(height * Math.random());
				size = (int)(170 * Math.random());
				
			}
			
			void drawShape(Graphics g){
				
				g.setColor(randColor);
				g.fill3DRect(centerX - size/2, centerY - size/2, size, size, true);
				
			}
			
		}
			
		static class Circle extends Shape{
			
			private int centerX, centerY;
			
			public Circle(int width, int height){
				
				centerX = (int)(width * Math.random());
				centerY = (int)(height * Math.random());
				
			}
			
			void drawShape(Graphics g){
				
				g.setColor(randColor);
				g.drawOval(centerX - 50, centerY - 50, 100, 100);
				
			}
			
		}
		
	}
	
}