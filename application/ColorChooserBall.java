package application;

import java.util.*;

import java.util.HashMap;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;

class ColorChooserBall extends Obstacle
{

	private double radius;
	private static Color color=Color.BLUE;
	private static HashMap<Integer,Color> colorHashMap = new HashMap<Integer, Color>() {{
        put(1,Color.BLUE);
        put(2,Color.GREEN);
        put(3,Color.RED);
        put(4,Color.YELLOW);
    }};

	public ColorChooserBall(double x, double y, double r)
	{
		super(x,y);
		this.radius=r;
		setshape(createEntity());
	}

	public void setRadius(double r)
	{
		this.radius=r;
	}

	public double getRadius()
	{
		return radius;
	}
	
	public static Color getColor()
	{
		return color;
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
//		arc1.setType(ArcType.OPEN);
//		arc1.setStroke(Color.BLUE);
		arc1.setStrokeWidth(5);
		arc1.setFill(Color.TRANSPARENT);
		arc1.setFill(Color.BLUE);
		arc1.setType(ArcType.ROUND);

		Arc arc2 = new Arc();
		arc2.setCenterX(getposX());
		arc2.setCenterY(getposY());
		arc2.setRadiusX(radius);
		arc2.setRadiusY(radius);
		arc2.setStartAngle(0.0f);
		arc2.setLength(90.0f);
//		arc2.setType(ArcType.OPEN);
//		arc2.setStroke(Color.GREEN);
		arc2.setStrokeWidth(5);
		arc2.setFill(Color.TRANSPARENT);
		arc2.setFill(Color.GREEN);
		arc2.setType(ArcType.ROUND);

		Arc arc3 = new Arc();
		arc3.setCenterX(getposX());
		arc3.setCenterY(getposY());
		arc3.setRadiusX(radius);
		arc3.setRadiusY(radius);
		arc3.setStartAngle(180.0f);
		arc3.setLength(90.0f);
//		arc3.setType(ArcType.OPEN);
//		arc3.setStroke(Color.YELLOW);
		arc3.setStrokeWidth(5);
		arc3.setFill(Color.TRANSPARENT);
		arc3.setFill(Color.YELLOW);
		arc3.setType(ArcType.ROUND);

		Arc arc4 = new Arc();
		arc4.setCenterX(getposX());
		arc4.setCenterY(getposY());
		arc4.setRadiusX(radius);
		arc4.setRadiusY(radius);
		arc4.setStartAngle(270.0f);
		arc4.setLength(90.0f);
//		arc4.setType(ArcType.OPEN);
//		arc4.setStroke(Color.RED);
		arc4.setStrokeWidth(5);
		arc4.setFill(Color.TRANSPARENT);
		arc4.setFill(Color.RED);
		arc4.setType(ArcType.ROUND);

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
	
	public Color getrandomColor() {
        Random random = new Random();
       // int randomColorInt = random.nextInt(max - min) + min;
        int randomColorInt=random.nextInt(4)+1;
        color= colorHashMap.get(randomColorInt);
        return color;
    }
}





