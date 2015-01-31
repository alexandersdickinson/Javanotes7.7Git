/**
This class creates a panel upon which rectangles and ovals can be drawn. Right click creates an oval. Shift clicking clears the panel.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ArrayStamper{
	
	public static void main(String[] args){
		
		JFrame window = new JFrame("Stamp Squares!");
		StampPanel content = new StampPanel();
		window.setContentPane(content);
		window.setSize(300, 300);
		window.setVisible(true);
		
	}
	
	private static class StampPanel extends JPanel implements MouseListener, MouseMotionListener{
		
		private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>(1);
		private ArrayList<Oval> ovals = new ArrayList<Oval>(1);
		private boolean dragging;
		
		public StampPanel(){
			
			addMouseListener(this);
			addMouseMotionListener(this);
			
		}
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
			
			//print all elements of rectangles and ovals arrays.
			if(rectangles != null){
				g.setColor(Color.RED);
				for(Rectangle rect:rectangles){
					g.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
				}
			}
			
			if(ovals != null){
				g.setColor(Color.BLUE);
				for(Oval oval:ovals){
					g.fillOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());
				}
			}
			
		}
		
		public void mousePressed(MouseEvent evt){
			
	        if ( evt.isShiftDown() ) {
	                // The user was holding down the Shift key.  Just repaint the panel.
	                // Since this class does not define a paintComponent() method, the 
	                // method from the superclass, JPanel, is called.  That method simply
	                // fills the panel with its background color, which is black.  The 
	                // effect is to clear the panel.
				rectangles.clear();
				ovals.clear();
	            repaint();
				dragging = false;
	            return;
	        }
		
			dragging = true;
			
			if(evt.isMetaDown()){
				
				ovals.add(new Oval(evt.getX(), evt.getY()));
				
			}
			else{
				
				rectangles.add(new Rectangle(evt.getX(), evt.getY()));
				
			}
			
			repaint();
		
		}
		
		public void mouseReleased(MouseEvent evt){
			
			dragging = false;
			
		}
		public void mouseClicked(MouseEvent evt){}
		public void mouseEntered(MouseEvent evt){}
		public void mouseExited(MouseEvent evt){}
		public void mouseMoved(MouseEvent evt){}
		public void mouseDragged(MouseEvent evt){
			
			if(!dragging)
				return;
			
	        if ( evt.isShiftDown() ) {
	                // The user was holding down the Shift key.  Just repaint the panel.
	                // Since this class does not define a paintComponent() method, the 
	                // method from the superclass, JPanel, is called.  That method simply
	                // fills the panel with its background color, which is black.  The 
	                // effect is to clear the panel.
				rectangles.clear();
				ovals.clear();
	            repaint();
	            return;
	        }
			
			if(evt.isMetaDown()){
				
				ovals.add(new Oval(evt.getX(), evt.getY()));
				
			}
			else{
				
				rectangles.add(new Rectangle(evt.getX(), evt.getY()));
				
			}
			
			repaint();
			
		}
			
		private class Rectangle{
			
			private int width, height;
			private int x, y;
			
			public Rectangle(int xCoord, int yCoord){
				
				width = 40;
				height = 20;
				x = xCoord;
				y = yCoord;
				
			}
			
			public int getWidth(){
				return width;
			}
			
			public int getHeight(){
				return height;
			}
			
			public int getX(){
				return x;
			}
			
			public int getY(){
				return y;
			}
			
			public void setX(int xCoord){
				x = xCoord;
			}
			
			public void setY(int yCoord){
				y = yCoord;
			}
			
		}
		
		private class Oval{
			
			private int width, height;
			private int x, y;
			
			public Oval(int xCoord, int yCoord){
				
				width = 40;
				height = 20;
				x = xCoord;
				y = yCoord;
				
			}
			
			public int getWidth(){
				return width;
			}
			
			public int getHeight(){
				return height;
			}
			
			public int getX(){
				return x;
			}
			
			public int getY(){
				return y;
			}
			
			public void setX(int xCoord){
				x = xCoord;
			}
			
			public void setY(int yCoord){
				y = yCoord;
			}
			
		}
		
	}
	
}