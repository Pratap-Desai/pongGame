package com.techlab.pong;

import apcs.Window;

public class Ball {

	int x,dx;
	int y,dy;
	int radius;
	String color;
	final int speed=10;
	int varyspeed;

	public Ball() {
		x=Window.width()/2;
		y=Window.height()/2;
		varyspeed=speed;
		dx=varyspeed;
		dy=varyspeed;
		randomize();
		radius=25;
		color="yellow";
	}

	public void increaseSpeed() {
		varyspeed=varyspeed+2;
	}
	private void randomize() {
		int check=Window.rollDice(4);
		switch(check) {
		case 1: {
			dx=varyspeed;
			dy=varyspeed;
			break;
		}
		case 2: {
			dx=varyspeed;
			dy=-varyspeed;
			break;
		}
		case 3: {
			dx=-varyspeed;
			dy=varyspeed;
			break;
		}
		case 4: {
			dx=-varyspeed;
			dy=-varyspeed;
			break;
		}
		}
		
	}
	public void draw() {
	
		Window.out.color(color);
		Window.out.circle(x, y, radius);
	}
	
	public void move() {
		x+=dx;
		y+=dy;
		//checks if the ball is touching the top or bottom of the screen
		if(y-radius<=0 && dy<0) {
			dy=-dy;
		}
		else if(y+radius>=Window.height() && dy>0) {
			dy=-dy;
		}
	}
	
	public void reflect(Paddle p) {
		//compares the x of the ball to the x of the paddle
		if(x + radius >= p.x - p.width/2  && x - radius <= p.x + p.width/2 ) {
			//compares the y of the ball to the y of the paddle
			if(y + radius >= p.y - p.length/2  && y - radius <= p.y + p.length/2) {
				//reflects off the x
				if(p.notCollide) {
				dx = -dx;
				p.notCollide=false;
				}
				
			}
		}	else {
			p.notCollide=true;
		}
	}
	
	private void resetValues() {
		x=Window.width()/2;
		y=Window.height()/2;
		varyspeed=speed;
		randomize();
	}
	public void reset() {
		if(x- radius > Window.width()- Game.paddleX+Paddle.width/2) {
			Game.leftScore++;
			resetValues();
		}else if(x+radius < Game.paddleX-Paddle.width/2) {
			Game.rightScore++;
			resetValues();
		}
	}
	
}
