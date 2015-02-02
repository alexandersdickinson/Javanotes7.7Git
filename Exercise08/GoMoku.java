/**
This program allows the user to play a game of Go Moku. It is similar to tic tac toe, but with a large board, and with the requirement that 5 pieces be lined
up in order to achieve victory.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GoMoku extends JPanel{
	
	Boolean[][] pieces = new Boolean[15][15];//Two dimensions represent rows and columns. Boolean value represents color, where black is true.
	private final int SIZE = 450;
	private int turn = 1;
	private boolean victory = false;
	
	public static void main(String[] args){
		
		JFrame window = new JFrame("Go Moku");
		window.setResizable(false);
		GoMoku content = new GoMoku();
		window.setContentPane(content);
		window.pack();
		window.setVisible(true);
		
	}
	
	public GoMoku(){
		
		setLayout(new BorderLayout());
		add(new Board(), BorderLayout.CENTER);
		add(new Buttons(), BorderLayout.SOUTH);
		
	}
	
	private class Board extends JPanel{
		
		private int lineStartX, lineStartY;//keeps track of where lineups are.
		private int lineEndX, lineEndY;
				
		public Board(){
			
			setPreferredSize(new Dimension(SIZE, SIZE));
			setBackground(new Color(255, 63, 211));
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			addMouseListener(new MouseAdapter(){
				
				public void mousePressed(MouseEvent evt){
					
					int lineUp;//counter to determine how many pieces are lined up in a row.
					int x, y;
					x = evt.getX() / (SIZE/15);
					y = evt.getY() / (SIZE/15);
					if(pieces[x][y] == null){
						
						pieces[x][y] = turn % 2 == 0 ? false:true;
						turn++;
						
					}
					
					if(turn >= 10){//check for five in a row. Before 10 turns, having five pieces in a row is impossible.
						
						for(int col = 0; col < pieces.length; col++){
							
							for(int row = 0; row < pieces[col].length; row++){
								
								if(pieces[col][row] != null){
									
									lineStartX = col;
									lineStartY = row;
									
									lineUp = 1;
									while(col + lineUp < pieces.length && row - lineUp >= 0 &&
									pieces[col + lineUp][row - lineUp] != null && pieces[col + lineUp][row - lineUp] == pieces[col][row]){
									
										lineUp++;
									}//above right and below left
									
									lineEndX = col + lineUp;
									lineEndY = row - lineUp;
									
									if(lineUp < 5){
										lineUp = 1;
										while(col + lineUp < pieces.length && pieces[col + lineUp][row] != null && pieces[col + lineUp][row] == pieces[col][row]){
											lineUp++;
										}//right and left
										
										lineEndX = col + lineUp;
										lineEndY = row;
										
									}
									if(lineUp < 5){
										lineUp = 1;
										while(col + lineUp < pieces.length && row + lineUp < pieces.length &&
										pieces[col + lineUp][row + lineUp] != null && pieces[col + lineUp][row + lineUp] == pieces[col][row]){
											
											lineUp++;
										}//below right and above left
										
										lineEndX = col + lineUp;
										lineEndY = row + lineUp;
										
									}
									if(lineUp < 5){
										lineUp = 1;
										while(row + lineUp < pieces.length && pieces[col][row + lineUp] != null && pieces[col][row + lineUp] == pieces[col][row]){
											lineUp++;
										}//below and above
										
										lineEndX = col;
										lineEndY = row + lineUp;
										
									}
									
									if(lineUp >= 5)
										victory = true;
									
								}
								
							}
							
						}
						
					}
					
					repaint();
					
				}
				
			});
			
		}
		
		public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//draw horizontal lines.
			g.setColor(Color.BLACK);
			for(int row = 1; row < SIZE/15; row++){
				g.drawLine(0, SIZE/15 * row, getWidth() - 1, SIZE/15 * row);
			}
			
			//draw vertical lines
			for(int col = 1; col < SIZE/15; col++){
				g.drawLine(SIZE/15 * col, 0, SIZE/15 * col, getHeight() - 1);
			}
			
			//draw pieces
			for(int col = 0; col < pieces.length; col++){
				
				for(int row = 0; row < pieces[col].length; row++){
					
					if(pieces[col][row] != null){
						
						if(pieces[col][row])
							g.setColor(Color.BLACK);
						else
							g.setColor(Color.WHITE);
						g.fillOval((SIZE/15) * col + 2, (SIZE/15) * row + 2, 26, 26);
						
					}
					
				}
				
			}
			
			if(victory){
				g.setColor(Color.RED);
				g.drawLine(lineStartX * (SIZE/15), lineStartY * (SIZE/15), lineEndX * (SIZE/15), lineEndY * (SIZE/15));
			}
						
		}
		
	}
	
	private class Buttons extends JPanel{
		
		public Buttons(){
			
			JButton newGame = new JButton("New Game");
			add(newGame);
			JButton resign = new JButton("Resign");
			add(resign);
			setBorder(BorderFactory.createEtchedBorder());
			
		}
		
	}
	
}