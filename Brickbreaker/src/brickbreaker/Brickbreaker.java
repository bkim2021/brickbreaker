package brickbreaker;

import java.util.ArrayList;
import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;


public class Brickbreaker extends PApplet {

	//Variables
	
	public ArrayList<Rectangle> bricks = new ArrayList<Rectangle>();
	public Ball ball;
	public Rectangle paddle;
	boolean lost;
	boolean won;
	public int score = 0;
	public int level = 0;
	
	
	public void setup() {
		size(400, 600);
		background(0);
		addBricks();
		
		ball = new Ball(this, 200, 300, 20, Color.WHITE);
		paddle = new Rectangle(200, 550, 60, 20, this);
		lost = false;
	}

	//Draws 
	public void draw() {
		fill(0, 0, 0, 15);
		rect(0, 0, width, height);
		drawBricks();
		ball.move();
		ball.paint();
		movePaddle();
		PFont font;
		font = createFont("Courier", 20);
		textFont(font);
		fill(255, 255, 255);
		text("Score:  ", 10, 20);
		text(score, 90, 20);
		text("Made by Brett K.", 200, 20);
		textSize(20);
		updateGame();
	}
	
	//Drawing our bricks
	public void drawBricks() {
		for(int i=0; i < bricks.size(); i++) {
			bricks.get(i).paint();
		}
	}
	
	//Adding the bricks to the screen
	public void addBricks() {
		bricks = new ArrayList<Rectangle>();
		for(int i=0; i<10; i++) {
			for(int j = 0; j < 10; j++) {
				//Puts the bricks on the screen
				bricks.add(new Rectangle(40*i,30+15*j, 40, 15, this));
			}
		}
	}
	
	//Moves the paddle (setX changes based on the x position of your paddle based on your mouse
	public void movePaddle() {
		paddle.setX(mouseX-30);
		paddle.paint();
	}
	
	public void updateGame() {
			/*
			 * Checks if the ball hits the paddle
			 * Finds the x position of the paddle and compares it to the x position
			 * of the ball
			 * Looks for the y position of the ball and compare it to the paddle
			 * Resets the velocity.
			 */
		
			// Check if the ball hits the paddle.
			if(ball.getX() > paddle.getX() && ball.getX() < paddle.getX() + 60 && ball.getY() + ball.getSize()/2 > paddle.getY()) {
				ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
			}
			
			/*Checks if the ball hits a brick
			 * Loops through the ArrayList of bricks made
			 * Creates a variables b to store the bricks
			 * Resets the velocity so it bounces down
			 * Removes a brick if hit
			 */
			for(int i=0; i<bricks.size(); i++) {
				Rectangle b = bricks.get(i);
				if(ball.getX() + (ball.getSize()/2) > b.getX() && (ball.getX() + (ball.getSize()/2) < b.getX() + b.getWidth() && ball.getY() - (ball.getSize() / 2) < (b.getY() + b.getHeight()))) {
					ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
					bricks.remove(b);
					score++;
				}
			}
			
			/* Check to see if you lost
			 * If the y position of the ball is greater than the height
			 * Reset the background, set lost to true
			 * Reset to ball velocity and show text on the screen
			 * Create a background rectangle for the text of PLAY AGAIN
			 */
			if(bricks.size() == 0) {
				background(0);
				if(!won) level++;
				won = true;
				fill(0, 0, 0);
				color(255, 255, 255);
				rect(75, 265, 255, 50);
				PFont font2;
				font2 = createFont("Courier", 18);
				textFont(font2);
				fill(0, 255, 0);
				//text(text + variable, x_position, y_position)
				PFont font3;
				font3 = createFont("Courier", 32);
				textFont(font3);
				text("YOU WIN!", 120, height/2);
				fill(255);
				text("FINAL SCORE: " + score, 75, height/3);
				text("LEVEL " + level, 110, height/2+80);		
			}
			else if(ball.getY() > height - 10) {
				background(0);
				fill(0, 0, 0);
				lost = true;
				color(255, 255, 255);
				rect(75, 265, 255, 50);
				PFont font2;
				font2 = createFont("Courier", 18);
				textFont(font2);
				fill(0, 255, 0);
				//text(text + variable, x_position, y_position)
				PFont font3;
				font3 = createFont("Courier", 32);
				textFont(font3);
				text("YOU LOST!", 120, height/2);
				fill(255);
				text("PLAY AGAIN", 110, height/2+80);
				text("FINAL SCORE: " + score, 75, height/3);
				
//				for(int l=0; l < bricks.size(); l++) {
//					bricks.remove(l);
//				}				
			}
			
			/*
			 * Resets the game
			 * Basically draw() but when you click the button
			 */
			
			if(won == true) {
				if(mousePressed && mouseX > 103 && mouseX < 283 && mouseY > 345 && mouseY <395) {
					won = false;
					background(0);
					addBricks();
					drawBricks();
					ball.setLocation(width/2, height/2);
					ball.setVelocity(ball.getXVelocity()+1, ball.getYVelocity()+1);
					ball.move();
					ball.paint();
					movePaddle();
					updateGame();
				}
			}
			else if(lost == true) {
				if(mousePressed && mouseX > 103 && mouseX < 283 && mouseY > 345 && mouseY <395) {
					lost = false;
					background(0);
					addBricks();
					drawBricks();
					ball.setLocation(width/2, height/2);
					ball.setVelocity(3, 3);
					ball.move();
					ball.paint();
					movePaddle();
					updateGame();
					score = 0;
				}
			}
	}
}