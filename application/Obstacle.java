package application;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public abstract class Obstacle {
	
	private Group shape;
	private double posX;
	private double posY;
		
	public Obstacle(double x, double y)
	{
		this.posX=x;
		this.posY=y;
		
	}
	
	protected double getposX()
	{
		return posX;
	}
	
	protected double getposY()
	{
		return posY;
	}
	
	protected void setposX(double x)
	{
		this.posX=x;
	}
	
	protected void setposY(double y)
	{
		this.posY=y;
	}
	
	protected Group getshape()
	{
		return shape;
	}
	
	protected void setshape(Group s)
	{
		shape=s;
		shape.getProperties().put("alive", true);
	}
		
	abstract Group createEntity();
	

}

class ObstacleCircle extends Obstacle
{
		
	private double radius;
	
	public ObstacleCircle(double x, double y, double r)
	{
		super(x,y);
		this.radius=r;
		setshape(createEntity());
	}
	
	protected void setRadius(double r)
	{
		this.radius=r;
	}
	
	private double getRadius()
	{
		return radius;
	}

	@Override
	Group createEntity() {
		
		  Arc arc1 = new Arc(); 
          arc1.setCenterX(getposX()); 
	      arc1.setCenterY(getposY()); 
	      arc1.setRadiusX(radius); 
	      arc1.setRadiusY(radius); 
	      arc1.setStartAngle(90.0f); 
	      arc1.setLength(90.0f);  
	      arc1.setType(ArcType.OPEN);         
	      arc1.setStroke(Color.BLUE);
	      arc1.setStrokeWidth(5);
	      arc1.setFill(Color.TRANSPARENT);
	      
	      Arc arc2 = new Arc(); 
	      arc2.setCenterX(getposX());
	      arc2.setCenterY(getposY()); 
	      arc2.setRadiusX(radius); 
	      arc2.setRadiusY(radius); 
	      arc2.setStartAngle(0.0f); 
	      arc2.setLength(90.0f);  
	      arc2.setType(ArcType.OPEN);         
	      arc2.setStroke(Color.GREEN);
	      arc2.setStrokeWidth(5);
	      arc2.setFill(Color.TRANSPARENT);
	      
	      Arc arc3 = new Arc(); 
	      arc3.setCenterX(getposX()); 
	      arc3.setCenterY(getposY()); 
	      arc3.setRadiusX(radius); 
	      arc3.setRadiusY(radius); 
	      arc3.setStartAngle(180.0f); 
	      arc3.setLength(90.0f);  
	      arc3.setType(ArcType.OPEN);         
	      arc3.setStroke(Color.YELLOW);
	      arc3.setStrokeWidth(5);
	      arc3.setFill(Color.TRANSPARENT);
	      
	      Arc arc4 = new Arc();   
	      arc4.setCenterX(getposX()); 
	      arc4.setCenterY(getposY()); 
	      arc4.setRadiusX(radius); 
	      arc4.setRadiusY(radius); 
	      arc4.setStartAngle(270.0f); 
	      arc4.setLength(90.0f);       
	      arc4.setType(ArcType.OPEN);         
	      arc4.setStroke(Color.RED);
	      arc4.setStrokeWidth(5);
	      arc4.setFill(Color.TRANSPARENT);
	      
	      Group root = new Group(arc1,arc2,arc3,arc4); 
	      RotateTransition rotate = new RotateTransition();
	      rotate.setAxis(Rotate.Z_AXIS);
	      rotate.setByAngle(360);
	      rotate.setFromAngle(0);
	      rotate.setCycleCount(Animation.INDEFINITE);
	      rotate.setDuration(Duration.millis(3000));
	      rotate.setNode(root);
	      rotate.play();
	      
	      return root;
			
	}
	

}


class ObstacleSquare extends Obstacle
{
	private double length;
	
	public ObstacleSquare(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {
		
		Line line1 = new Line(); 
        line1.setStartX(10.0f); 
        line1.setStartY(10.0f); 
        line1.setEndX(length); 
        line1.setEndY(10.0f);   
        line1.setStroke(Color.BLUE);
        line1.setStrokeWidth(5);
        
        Line line2 = new Line(); 
        line2.setStartX(10.0f); 
        line2.setStartY(10.0f); 
        line2.setEndX(10.0f); 
        line2.setEndY(length);  
        line2.setStroke(Color.GREEN);
        line2.setStrokeWidth(5);

        Line line3 = new Line();
        line3.setStartX(length-30);
        line3.setStartY(10.0f);
        line3.setEndX(length-30);
        line3.setEndY(length);
        line3.setStroke(Color.RED);
        line3.setStrokeWidth(5);

        Line line4 = new Line();
        line4.setStartX(10.0f);
        line4.setStartY(length-30);
        line4.setEndX(length);
        line4.setEndY(length-30);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(5);
   
        Group group = new Group(line1,line2,line3,line4);
 
        line1.setTranslateX(getposX()); 
        line1.setTranslateY(getposY());
        
        line2.setTranslateX(getposX()); 
        line2.setTranslateY(getposY());
        
        line3.setTranslateX(getposX()+30);
        line3.setTranslateY(getposY());
        
        line4.setTranslateX(getposX()); 
        line4.setTranslateY(getposY()+30);

        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setFromAngle(0);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.millis(3000));

        //rotate.setAutoReverse(true);
        rotate.setNode(group);
        rotate.play();
//
        return group;
	}

}

class ObstacleRectangle extends Obstacle
{
	private double length;

	public ObstacleRectangle(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {

		Line line1 = new Line();
		line1.setStartX(10.0f);
		line1.setStartY(10.0f);
		line1.setEndX(length);
		line1.setEndY(10.0f);
		line1.setStroke(Color.BLUE);
		line1.setStrokeWidth(5);

		Line line2 = new Line();
		line2.setStartX(10.0f);
		line2.setStartY(10.0f);
		line2.setEndX(10.0f);
		line2.setEndY(length);
		line2.setStroke(Color.GREEN);
		line2.setStrokeWidth(5);

		Line line3 = new Line();
		line3.setStartX(length-30);
		line3.setStartY(10.0f);
		line3.setEndX(length-30);
		line3.setEndY(length);
		line3.setStroke(Color.RED);
		line3.setStrokeWidth(5);

		Line line4 = new Line();
		line4.setStartX(10.0f);
		line4.setStartY(length-30);
		line4.setEndX(length);
		line4.setEndY(length-30);
		line4.setStroke(Color.YELLOW);
		line4.setStrokeWidth(5);

		Group group = new Group(line1,line2,line3,line4);

		line1.setTranslateX(getposX());
		line1.setTranslateY(getposY());

		line2.setTranslateX(getposX());
		line2.setTranslateY(getposY());

		line3.setTranslateX(getposX()+30);
		line3.setTranslateY(getposY());

		line4.setTranslateX(getposX());
		line4.setTranslateY(getposY()+30);

		RotateTransition rotate = new RotateTransition();
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.setByAngle(360);
		rotate.setFromAngle(0);
		rotate.setCycleCount(Animation.INDEFINITE);
		rotate.setDuration(Duration.millis(3000));

		//rotate.setAutoReverse(true);
		rotate.setNode(group);
		rotate.play();
//
		return group;
	}

}


class ObstacleParallelLines extends Obstacle
{
	private double length;

	public ObstacleParallelLines(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {

		Line line1 = new Line();
		line1.setStartX(10.0f);
		line1.setStartY(10.0f);
		line1.setEndX(length);
		line1.setEndY(10.0f);
		line1.setStroke(Color.RED);
		line1.setStrokeWidth(5);

		Line line2 = new Line();
		line2.setStartX(10.0f+length+length-30);
		line2.setStartY(10.0f);
		line2.setEndX(length);
		line2.setEndY(10.0f);
		line2.setStroke(Color.BLUE);
		line2.setStrokeWidth(5);
//
		Line line3 = new Line();
		line3.setStartX(50.0f+(length+length-60-10));
		line3.setStartY(10.0f);
		line3.setEndX(length);
		line3.setEndY(10.0f);
		line3.setStroke(Color.YELLOW);
		line3.setStrokeWidth(5);

		Line line4 = new Line();
		line4.setStartX(10.0f+(length+length-10));
		line4.setStartY(10.0f);
		line4.setEndX(length);
		line4.setEndY(10.0f);
		line4.setStroke(Color.GREEN);
		line4.setStrokeWidth(5);

		Group group = new Group(line1,line2,line3 , line4);

//		Group group = new Group(line1,line2);

		line1.setTranslateX(getposX());
		line1.setTranslateY(getposY());

		line2.setTranslateX(getposX());
		line2.setTranslateY(getposY());

		line3.setTranslateX(getposX()+length-10-10);
		line3.setTranslateY(getposY());


		line4.setTranslateX(getposX()-length-length+10);
		line4.setTranslateY(getposY());

		TranslateTransition translate = new TranslateTransition();
		translate.setFromX(-600);
		translate.setToX(600);
		translate.setByX(-1000);
		translate.setCycleCount(Animation.INDEFINITE);
		translate.setDuration(Duration.millis(4000));
		translate.setAutoReverse(true);

		//rotate.setAutoReverse(true);
		translate.setNode(group);
		translate.play();

		return group;
	}



}

class ObstacleStraightParallelLines extends Obstacle
{
	private double length;

	public ObstacleStraightParallelLines(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {

		Line line1 = new Line();
		line1.setStartX(length - 60);
		line1.setStartY(10.0f);
//		line1.setEndX(10.0f);
		line1.setEndX(length-60);
		line1.setEndY(length);
		line1.setStroke(Color.BLUE);
		line1.setStrokeWidth(7);

		Line line2 = new Line();
		line2.setStartX(10.0f);
		line2.setStartY(10.0f);
		line2.setEndX(10.0f);
		line2.setEndY(length);
		line2.setStroke(Color.GREEN);
		line2.setStrokeWidth(7);


		Line line3 = new Line();
		line3.setStartX(length-60);
		line3.setStartY(10.0f);
		line3.setEndX(length-60);
		line3.setEndY(length);
		line3.setStroke(Color.RED);
		line3.setStrokeWidth(7);

		Line line4 = new Line();
		line4.setStartX(length-125);
		line4.setStartY(10.0f-30);
		line4.setEndX(length-125);
		line4.setEndY(length-30);
		line4.setStroke(Color.YELLOW);
		line4.setStrokeWidth(7);

		Group group = new Group(line1,line2,line3,line4);

		line1.setTranslateX(getposX()-20);
		line1.setTranslateY(getposY());

		line2.setTranslateX(getposX());
		line2.setTranslateY(getposY());

		line3.setTranslateX(getposX()+30);
		line3.setTranslateY(getposY());

		line4.setTranslateX(getposX()-50);
		line4.setTranslateY(getposY()+30);
//
		TranslateTransition translate = new TranslateTransition();
		translate.setByX(-300);
//		translate.setByX(200);
		translate.setCycleCount(Animation.INDEFINITE);
		translate.setDuration(Duration.millis(6000));
		translate.setAutoReverse(true);

		//rotate.setAutoReverse(true);
		translate.setNode(group);
		translate.play();

		return group;
	 }
}
class ObstaclePlusSign extends Obstacle
{
	private double length;

	public ObstaclePlusSign(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {

		Line line1 = new Line();
		line1.setStartX(10.0f);
		line1.setStartY(10.0f);
		line1.setEndX(length);
		line1.setEndY(10.0f);
		line1.setStroke(Color.BLUE);
		line1.setStrokeWidth(10);

		Line line2 = new Line();
		line2.setStartX(10.0f);
		line2.setStartY(10.0f);
		line2.setEndX(10.0f);
		line2.setEndY(length+10);
		line2.setStroke(Color.GREEN);
		line2.setStrokeWidth(10);

		Line line3 = new Line();
		line3.setStartX(10.0f);
		line3.setStartY(10.0f);
		line3.setEndX(10.0f);
		line3.setEndY(length+5);
		line3.setStroke(Color.RED);
		line3.setStrokeWidth(10);
		line3.setEndX(line2.getEndX());
		line2.setEndX(line3.getEndX());

		Line line4 = new Line();
		line4.setStartX(10.0f);
		line4.setStartY(10.0f);
		line4.setEndX(length);
		line4.setEndY(10.0f);
		line4.setStroke(Color.YELLOW);
		line4.setStrokeWidth(10);
//		line4.setEndX(line2.getEndX());

		Group group = new Group(line1,line2,line3,line4);

		line1.setTranslateX(getposX());
		line1.setTranslateY(getposY());

		line2.setTranslateX(getposX());
		line2.setTranslateY(getposY());

		line3.setTranslateX(getposX());
		line3.setTranslateY(getposY()-length);


		line4.setTranslateX(getposX()-length);
		line4.setTranslateY(getposY());

		RotateTransition rotate = new RotateTransition();
		rotate.setAxis(Rotate.Z_AXIS);
//		rotate.setAxis(Rotate.Y_AXIS);
		rotate.setByAngle(360);
//		rotate.setByAngle(360);
		rotate.setFromAngle(0);
		rotate.setCycleCount(Animation.INDEFINITE);
		rotate.setDuration(Duration.millis(3000));

//		rotate.setAutoReverse(true);
		rotate.setNode(group);
		rotate.play();

		return group;
	}



}

class ObstacleRhombus extends Obstacle{
	private double length;

	public ObstacleRhombus(double x, double y, double l)
	{
		super(x,y);
		this.length=l;
		setshape(createEntity());
	}

	@Override
	Group createEntity() {

		Line line1 = new Line();
		line1.setStartX(10.0f+30);
		line1.setStartY(10.0f);
		line1.setEndX(length+30);
		line1.setEndY(10.0f);
		line1.setStroke(Color.BLUE);
		line1.setStrokeWidth(5);

		Line line2 = new Line();
		line2.setStartX(10.0f+30);
		line2.setStartY(10.0f);
		line2.setEndX(10.0f);
		line2.setEndY(length);
		line2.setStroke(Color.GREEN);
		line2.setStrokeWidth(5);

		Line line3 = new Line();
		line3.setStartX(length-30+30);
		line3.setStartY(10.0f);
		line3.setEndX(length-30);
		line3.setEndY(length);
		line3.setStroke(Color.RED);
		line3.setStrokeWidth(5);

		Line line4 = new Line();
		line4.setStartX(10.0f);
		line4.setStartY(length-30);
		line4.setEndX(length);
		line4.setEndY(length-30);
		line4.setStroke(Color.YELLOW);
		line4.setStrokeWidth(5);

		Group group = new Group(line1,line2,line3,line4);

		line1.setTranslateX(getposX());
		line1.setTranslateY(getposY());

		line2.setTranslateX(getposX());
		line2.setTranslateY(getposY());

		line3.setTranslateX(getposX()+30);
		line3.setTranslateY(getposY());

		line4.setTranslateX(getposX());
		line4.setTranslateY(getposY()+30);

		RotateTransition rotate = new RotateTransition();
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.setByAngle(360);
		rotate.setFromAngle(0);
		rotate.setCycleCount(Animation.INDEFINITE);
		rotate.setDuration(Duration.millis(3000));

		//rotate.setAutoReverse(true);
		rotate.setNode(group);
		rotate.play();

		return group;
	}



}
