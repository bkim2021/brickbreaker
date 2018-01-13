package brickbreaker;

import java.awt.Color;

import processing.core.PApplet;

public class Ball {
	private PApplet p;
	private float classX;
	private float classY;
	private float classXVelocity;
	private float classYVelocity;
	private float classSize;
	Color c;
	
	public Ball(PApplet app, float x, float y, float size, Color clr) {
		p = app;
		classX = x;
		classY = y;
		classSize = size;
		c = clr;
		classXVelocity = 3;
		classYVelocity = 3;
	}
	
	public void move() {
		classX = classX + classXVelocity;
		classY = classY + classYVelocity;
		
		if(classX > p.width || classX < 0) {
			classXVelocity = -classXVelocity;
		}
		
		if(classY < 0) {
			classYVelocity = -classYVelocity;
		}
	}
	
	public void paint() {
		p.noStroke();
		p.fill(c.getRed(), c.getGreen(), c.getBlue());
		p.ellipse(classX, classY, classSize, classSize);
	}
	
	public float getY() {
		return classY;
	}
	
	public float getX() {
		return classX;
	}
	
	public float getXVelocity() {
		return classXVelocity;
	}
	
	public float getYVelocity() {
		return classYVelocity;
	}
	
	public float getSize() {
		return classSize;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setY(float newY) {
		classY = newY;
	}
	
	public void setX(float newX) {
		classX = newX;
	}
	
	public void setXVelocity(float newXVelocity) {
		classXVelocity = newXVelocity;
	}
	
	public void setYVelocity(float newYVelocity) {
		classYVelocity = newYVelocity;
	}
	
	public void setVelocity(float newXVelocity, float newYVelocity) {
		classXVelocity = newXVelocity;
		classYVelocity = newYVelocity;
	}
	
	public void setSize(float newSize) {
		classSize = newSize;
	}
	
	public void setColor(Color newColor) {
		c = newColor;
	}
	
	public void setLocation(float newX, float newY) {
		classX = newX;
		classY = newY;
	}
}
