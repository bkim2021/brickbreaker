package brickbreaker;

import java.awt.Color;
import processing.core.PApplet;

public class Rectangle {
	PApplet p;
	float classX;
	float classY;
	float classWidth;
	float classHeight;
	Color innerColor;
	
	//Constructor
	public Rectangle(float x, float y, float width, float height, PApplet app) {
		classX = x;
		classY = y;
		classWidth = width;
		classHeight = height;
		p = app;
		innerColor = new Color(0, 0, 0);
	}
	
	public void paint() {
		p.stroke(0, 255, 0);
		p.strokeWeight(4);
		p.fill(innerColor.getRed(), innerColor.getGreen(), innerColor.getBlue());
		p.rect(classX, classY, classWidth, classHeight);
	}
	
	public void move() {
		classX = classX + 1;
	}
	
	//A whole list of setters and getters.
	
	public float getX() {
		return classX;
	}
	
	public void setX(float newX) {
		classX = newX;
	}
	
	public float getY() {
		return classY;
	}
	
	public void setY(float newY) {
		classY = newY;
	}
	
	public float getWidth() {
		return classWidth;
	}
	
	public void setWidth(float newWidth) {
		classWidth = newWidth;
	}
	
	public float getHeight() {
		return classHeight;
	}
	
	public void setHeight(float newHeight) {
		classHeight = newHeight;
	}
	
	public Color getColor() {
		return innerColor;
	}
	
	public void setColor(Color newColor) {
		innerColor = newColor;
	}
	
	public void setLocation(float newX, float newY) {
		classX = newX;
		classY = newY;
	}
}
