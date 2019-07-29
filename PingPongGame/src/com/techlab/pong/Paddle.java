package com.techlab.pong;

import apcs.Window;

public class Paddle {
	
	String color;
	public int x,y;
	int dy;
	int length;
	public static int width=20;
	char up;
	char down;
	boolean notCollide;
	
	public Paddle(int x, int y, char up,char down) {
		this.x=x;
		this.y=y;
		this.up=up;
		this.down=down;
		length=150;
		color="orange";
		dy=10;
		notCollide=true;
		
	}
	
	public void draw() {
		Window.out.color(color);
		Window.out.rectangle(x, y, width, length);
	}
	
	public void move() {
		if(Window.key.pressed(up)) {
			y-=dy;
			if(y-length/2 <= 0) {
				y=length/2;
			}
		}
		if(Window.key.pressed(down)) {
			y+=dy;
			if(y+length/2 >= Window.height()) {
				y=Window.height()-length/2;
			}
		}
	}
	

}
