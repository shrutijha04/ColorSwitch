package application;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.io.Serializable;

public class Star implements Serializable{

	private static final long serialVersionUID = -4159310297505386047L;
	private ImageView image;
    private double positionX;
    private double positionY;
    private double width;
    private double height;
  
    public Star(double x, double y, double w, double h)
    {
    	positionX=x;
    	positionY=y;
    	width=w;
    	height=h;
    	setImage();
    	
    }
    public void setImage() {
    	
    	/*FileInputStream input = null;
		try {
			input = new FileInputStream("images/star.jpg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        Image i= new Image(input);*/
    	
        ImageView imageView = new ImageView(new Image(getClass().getResource("/images/star.png").toExternalForm()));
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setX(positionX);
        imageView.setY(positionY);
        image=imageView;
        image.getProperties().put("alive", true);
 
        
    }
    
    public void setPositionXY(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getWidth() {
        return width;
    }
    
    public ImageView getImage()
    {
    	return image;
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }
    
    

}
