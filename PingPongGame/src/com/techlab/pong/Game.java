package com.techlab.pong;

import apcs.Window;

public class Game {

	public static int paddleX=100;
	public static int leftScore=0;
	public static int rightScore=0;
	public final static int winScore=6;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Window.size(1000, 600);
		Ball ball=new Ball();
		
		Paddle paddleLeft=new Paddle(paddleX, Window.height()/2, 'w', 's');
		Paddle paddleRight=new Paddle(Window.width()-paddleX, Window.height()/2, 'i', 'k');
		int scoreFont=50;
		startScreen();
		while(true) {
			Window.out.background("light blue");
			ball.move();
			paddleLeft.move();
			paddleRight.move();
			ball.reflect(paddleLeft);
			ball.reflect(paddleRight);
			ball.reset();
			ball.draw();
			paddleLeft.draw();
			paddleRight.draw();
			Window.out.color("black");
			Window.out.fontSize(scoreFont);
			Window.out.print("Score   "+ leftScore + "  :  "+ rightScore, Window.width()/2-2*scoreFont, Window.height()/5);
			

			if(leftScore>=winScore/2 && rightScore>=winScore/2) {
				ball.increaseSpeed();
			}
			if(leftScore==winScore || rightScore==winScore) {
				restart();
				ball.reset();
				paddleLeft.reset(paddleX,Window.height()/2);
				paddleRight.reset(Window.width()-paddleX, Window.height()/2);
			}
			Window.frame();
		}
		
	}
	
	private static void restart() {
		boolean enterKey=false;
		while(!enterKey) {
			if(Window.key.pressed("space")) {
				enterKey=true;
				leftScore=0;
				rightScore=0;
			}
			Window.out.background("black");
			Window.out.color("red");
			Window.out.fontSize(50);
			Window.out.print("Press space If you wish to play Again   ", paddleX, Window.height()/2);
			Window.frame();
			
		}
	}

	private static void startScreen() {
		int counter=3;
		int fontchar=20;
		while(counter>0) {
		Window.out.background(125, 150, 175);
		Window.out.color("red");
		Window.out.fontSize(fontchar*2);
		Window.out.print("Get Ready The Game starts in " + counter, Window.width()/4, Window.height()/6);
		Window.out.fontSize(fontchar*8);
		Window.out.print(counter, Window.width()/2-2*fontchar, Window.height()/2);
		Window.out.color("green");
		Window.out.fontSize(fontchar);
		Window.out.print("Left Paddle", Game.paddleX, Window.height()/2- 2*fontchar);
		Window.out.print("up=W down= S", Game.paddleX, Window.height()/2);
		Window.out.print("Right Paddle", Window.width()-2*Game.paddleX, Window.height()/2-2*fontchar);
		Window.out.print("up=I down= K", Window.width()-2*Game.paddleX, Window.height()/2);
		Window.out.color("red");
		Window.out.fontSize(fontchar*3);
		Window.out.print("Ping Pong", Window.width()/2-fontchar*6, 5*Window.height()/6);
		counter--;
		Window.wait(1);
		}
	}

}
