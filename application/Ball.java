package application;

import java.io.Serializable; 

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public	class Ball implements Serializable{
	   
		private static final long serialVersionUID = 6069334306566159165L;
		private Circle shape;
	    private Color color;
	    private double posX;
	    private double posY;
	    private int velocity;
	    private double radius;
	    private Boolean alive;
	    private Boolean canJump;
	    
	    public Ball(Boolean alive, Boolean canJump){
	    	this.color=Color.BLUE;
	        this.posX=500;
	        this.posY=700;
	        this.velocity=0;
	        this.radius=20;
	        this.alive=alive;
	        this.canJump=canJump;
	        createBall(color);
	    }

	    public Ball(Color color, double posX, double posY, int velocity, double radius){
	        this.color=color;
	        this.posX=posX;
	        this.posY=posY;
	        this.velocity=velocity;
	        this.radius=radius;
	        this.alive=true;
	        this.canJump=true;
	        createBall(color);
	    }

	    public Circle getshape()
	    {
	    	return shape;
	    }
	   
	    public double getPosX() {
	        return posX;
	    }

	    public void setPosX(double posX) {
	        this.posX = posX;
	    }

	    public double getPosY() {
	        return posY;
	    }

	    public void setPosY(double posY) {
	        this.posY = posY;
	    }

	    public int getVelocity() {
	        return velocity;
	    }

	    public void setVelocity(int velocity) {
	        this.velocity = velocity;
	    }

	    public double getRadius() {
	        return radius;
	    }

	    public void setRadius(double radius) {
	        this.radius = radius;
	    }

	    public Boolean getAlive() {
	        return alive;
	    }

	    public void setAlive(Boolean alive) {
	        this.alive = alive;
	    }

	    public Boolean getCanJump() {
	        return canJump;
	    }

	    public void setCanJump(Boolean canJump) {
	        this.canJump = canJump;
	    }

	    public Color getColor() {
	        return color;
	    }

	    public void setColor(Color color) {
	        this.color = color;
	        setfill();
	    }
	    
	    public void createBall(Color color)
	    {
	    	Circle c=new Circle(posX, posY, radius);
	    	shape=c;
	    	shape.setFill(color);
	    }
	    
	    public void setfill()
	    {
	    	shape.setFill(color);
	    }
	    
	    public Rectangle2D getBoundary() {
	        return new Rectangle2D(posX, posY, 2*radius, 2*radius);
	    }

}


