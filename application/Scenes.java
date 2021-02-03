package application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Scenes {
	
	private Scene scene;
	private Pane gameRoot;
	private Pane appRoot;
	private ArrayList<Obstacle> obstacleList; 
	//private HashMap<Integer,String> obstacleMap;
	private ArrayList<Star> starList;
	private ArrayList<ColorChooserBall> ColorChooserBallList;
	
	public Scenes(String ans)
	{
		gameRoot=new Pane();
		appRoot=new Pane();
		obstacleList=new ArrayList<Obstacle>();
		//obstacleMap=new HashMap<Integer,String>();
		starList=new ArrayList<Star>();
		ColorChooserBallList=new ArrayList<ColorChooserBall>();
		createScene(ans);
		
	}
	
	protected Scene getScene()
	{
		return scene;
	}
	
	protected void setScene(Scene s)
	{
		scene=s;
	}
	
	protected ArrayList<Star> getstarList()
	{
		return starList;
	}
	
	protected ArrayList<Obstacle> getobstacleList()
	{
		return obstacleList;
	}

	protected ArrayList<ColorChooserBall> getColorChooserBallList()
	{
		return ColorChooserBallList;
	}
	
	protected Pane getGameRoot()
	{
		return gameRoot;
	}
	
	protected void addGameRoot(Node s)
	{
		gameRoot.getChildren().add(s);
	}
	
	protected Pane getAppRoot()
	{
		return appRoot;
	}
	
	protected void addAppRoot(Node s)
	{
		//s.setTranslateX(x);
		//s.setTranslateY(y);
		appRoot.getChildren().add(s);
		
	}
	
	
	protected abstract void createScene(String ans);
	
	protected abstract void createObstacles(String ans);
	

}

class ScenesEasy extends Scenes {


	public ScenesEasy(String ans) {
		super(ans);
	}

	@Override
	public void createScene(String ans) {

		createObstacles(ans);
		//create
		Scene s1 = new Scene(getAppRoot(), 1000, 780);
		s1.setFill(Color.BLACK);
		setScene(s1);
	}

	@Override
	protected void createObstacles(String ans) {
		

		//'0' is circle 1
		//'1' is square 1
		//'2' parallel lines 1
		//'3' is rhombus 1
		//'4' straight parallel lines 1
		//'5' plus sign 1
		//'6' colorchooserball

		int randomY1 = 470;

		String level=ans;
		if (level.charAt(0) == '0' || level.charAt(0) == '1')
			randomY1 = 350;

		if (level.charAt(0) == '4')
			randomY1 = 350;


		if(level.charAt(0) == '3'){
			randomY1 = 400;
		}
		for (int j = 0; j < level.length(); j++) {
			char a = level.charAt(j);

			if (a == '0') {
				Obstacle circle = new ObstacleCircle(500, randomY1, 100);
				Star star = new Star(475, randomY1, 40, 40);
				getobstacleList().add(circle);
				getstarList().add(star);
				getGameRoot().getChildren().add(circle.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 450;
				else
					randomY1 = randomY1 - 390;

			}
            else if ( a == '1' ){
                Obstacle square = new ObstacleSquare(420, randomY1, 180);
                Star star = new Star(500, randomY1+60, 40, 40);
                getobstacleList().add(square);
                getstarList().add(star);
                getGameRoot().getChildren().add(square.getshape());
                getGameRoot().getChildren().add(star.getImage());

               if(j!=level.length()-1 && level.charAt(j+1)=='1')
                	randomY1 = randomY1 - 390;

               else if(j!=level.length()-1 && level.charAt(j+1)=='3')
					randomY1 = randomY1 - 400;
               else
                	randomY1 = randomY1 - 310;

            }
			else if(a == '2'){
				Obstacle parallelLines = new ObstacleParallelLines(420, randomY1 + 10, 180);
//				Obstacle square2 = new ObstacleSquare(410, randomY1 , 200);
				Star star = new Star(500, randomY1 - 20  , 40, 40);
				getobstacleList().add(parallelLines);
				getstarList().add(star);
				getGameRoot().getChildren().add(parallelLines.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
			else if ( a== '3'){
				Obstacle rhombus1 = new ObstacleRhombus(420, randomY1 + 10 , 150);
//				Obstacle rhombus2 = new ObstacleRhombus(410, randomY1  , 200);
				Star star = new Star(500, randomY1 + 60, 40, 40);
				getobstacleList().add(rhombus1);
//				getobstacleList().add(rhombus2);
				getstarList().add(star);
				getGameRoot().getChildren().add(rhombus1.getshape());
//				getGameRoot().getChildren().add(rhombus2.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
			else if ( a == '4') {
				Obstacle stprllel = new ObstacleStraightParallelLines(420, randomY1 + 10, 140);
				Obstacle stprllel1 = new ObstacleStraightParallelLines(620, randomY1 + 10, 140);
				Star star = new Star(500, randomY1, 40, 40);
				getobstacleList().add(stprllel);
				getobstacleList().add(stprllel1);
				getstarList().add(star);
				getGameRoot().getChildren().add(stprllel1.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
			else if( a == '5' ){
				Obstacle plusSign = new ObstaclePlusSign(540, randomY1 + 10, 80);
				Star star = new Star(500, randomY1 + 60, 40, 40);
				getobstacleList().add(plusSign);
//				getstarList().add(star);
				getGameRoot().getChildren().add(plusSign.getshape());
//				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '3')
					randomY1 = randomY1 - 430;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
			else{
				ColorChooserBall colorBall = new ColorChooserBall(500, randomY1 + 10, 30);
				getColorChooserBallList().add(colorBall);
//				getobstacleList().add(colorBall);
				getGameRoot().getChildren().add(colorBall.getshape());
				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
		}
		ImageView imgView=null;
		//System.out.println(MainMenu.getNightTheme());
		if(MainMenu.getNightTheme()==false) 
			imgView = new ImageView(new Image(getClass().getResource("/images/daybg.jpg").toExternalForm())); 
		
		else
			imgView = new ImageView(new Image(getClass().getResource("/images/nightbg.jpg").toExternalForm())); 
			
        imgView.setFitWidth(1000); //done
        imgView.setFitHeight(780);
        
		getAppRoot().getChildren().addAll(imgView,getGameRoot());
		getAppRoot().setBackground(Background.EMPTY);
	}
}
class ScenesMedium extends Scenes {


	public ScenesMedium(String ans) {
		super(ans);
	}

	@Override
	public void createScene(String ans) {

		createObstacles(ans);
		//create
		Scene s1 = new Scene(getAppRoot(), 1000, 780);
		s1.setFill(Color.BLACK);
		setScene(s1);
	}

	@Override
	protected void createObstacles(String ans) {

		//'0' is concentric circle two
		//'1' is concentric square two
		//'2' is concentric rhombus two
		//'3' straight parallel lines ( same speed )
		//'4'

		int randomY1 = 370;

		String level=ans;
		if (level.charAt(0) == '1' || level.charAt(0) == '3')
			randomY1 = 320;

		if (level.charAt(0) == '2')
			randomY1 = 500;

		for (int j = 0; j < level.length(); j++) {
			char a = level.charAt(j);

			if (a == '0') {
				Obstacle circle1 = new ObstacleCircle(500, randomY1, 100);
				Obstacle circle2 = new ObstacleCircle(500, randomY1, 125);
//					Obstacle circle3=new ObstacleCircle(500,randomY1,150);
				Star star = new Star(475, randomY1, 40, 40);
				getobstacleList().add(circle1);
				getobstacleList().add(circle2);
//					getobstacleList().add(circle3);
				getstarList().add(star);
//					getGameRoot().getChildren().add(circle1.getshape());
				getGameRoot().getChildren().addAll(circle1.getshape(), circle2.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 540;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '3' )
					randomY1 = randomY1 - 490;
				else if(j != level.length() - 1 && (level.charAt(j + 1) == '2' || level.charAt(j + 1) == '5' ))
					randomY1 = randomY1 - 380;
				else
					randomY1 = randomY1 - 430;
			}
			else if( a == '1'){
				Obstacle square1 = new ObstacleSquare(447, randomY1 + 22 , 150);
				Obstacle square2 = new ObstacleSquare(420, randomY1, 200);
				Star star = new Star(500, randomY1 + 64, 40, 40);
				getobstacleList().add(square1);
				getobstacleList().add(square2);
				getstarList().add(star);
				getGameRoot().getChildren().add(square1.getshape());
				getGameRoot().getChildren().add(square2.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '3')
					randomY1 = randomY1 - 420;
				else
					randomY1 = randomY1 - 310;
			}

			else if ( a == '3'){ //2
				Obstacle rhombus1 = new ObstacleRhombus(420, randomY1 + 10 , 180);
				Obstacle rhombus2 = new ObstacleRhombus(410, randomY1  , 200);
				Star star = new Star(500, randomY1 + 60, 40, 40);
				getobstacleList().add(rhombus1);
				getobstacleList().add(rhombus2);
				getstarList().add(star);
				getGameRoot().getChildren().add(rhombus1.getshape());
				getGameRoot().getChildren().add(rhombus2.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 420;
				else
					randomY1 = randomY1 - 310;
			}
			else if(a == '2'){
				Obstacle parallelLines = new ObstacleParallelLines(420, randomY1 + 10, 180);
//				Obstacle square2 = new ObstacleSquare(410, randomY1 , 200);
				Star star = new Star(500, randomY1 - 20  , 40, 40);
				getobstacleList().add(parallelLines);
				getstarList().add(star);
				getGameRoot().getChildren().add(parallelLines.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '6')
					randomY1 = randomY1 - 340;
				else
					randomY1 = randomY1 - 310;
			}
			else if ( a == '4') {
				Obstacle stprllel = new ObstacleStraightParallelLines(420, randomY1 + 10, 140);
				Obstacle stprllel1 = new ObstacleStraightParallelLines(620, randomY1 + 10, 140);
				Star star = new Star(500, randomY1, 40, 40);
				getobstacleList().add(stprllel);
				getobstacleList().add(stprllel1);
				getstarList().add(star);
				getGameRoot().getChildren().add(stprllel1.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
			else if( a == '5' ){
				Obstacle plusSign = new ObstaclePlusSign(540, randomY1 + 10, 80);
				Star star = new Star(500, randomY1 + 60, 40, 40);
				getobstacleList().add(plusSign);
//				getstarList().add(star);
				getGameRoot().getChildren().add(plusSign.getshape());
//				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '3')
					randomY1 = randomY1 - 470;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 470;
				else
					randomY1 = randomY1 - 310;
			}
			else{
				ColorChooserBall colorBall = new ColorChooserBall(500, randomY1 + 10, 30);
//				getobstacleList().add(colorBall);
				getColorChooserBallList().add(colorBall);
				getGameRoot().getChildren().add(colorBall.getshape());
				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
		}
		ImageView imgView=null;
		//System.out.println(MainMenu.getNightTheme());
		if(MainMenu.getNightTheme()==false) 
			imgView = new ImageView(new Image(getClass().getResource("/images/daybg.jpg").toExternalForm())); 
		
		else
			imgView = new ImageView(new Image(getClass().getResource("/images/nightbg.jpg").toExternalForm())); 
			
        imgView.setFitWidth(1000); //done
        imgView.setFitHeight(780);
        
		getAppRoot().getChildren().addAll(imgView,getGameRoot());
		getAppRoot().setBackground(Background.EMPTY);
	}
}

class ScenesDifficult extends Scenes {


	public ScenesDifficult(String ans) {
		super(ans);
	}

	@Override
	public void createScene(String ans) {

		createObstacles(ans);
		//create
		Scene s1 = new Scene(getAppRoot(), 1000, 780);
		//s1.setFill(Color.BLACK);
		setScene(s1);
	}

	@Override
	protected void createObstacles(String ans) {

		//'0' is concentric circle two
		//'1' is concentric square two
		//'2' is concentric rhobus two
		//'3' parallel lines ( same speed )
		//'4' 

		int randomY1 = 370;

		String level=ans;
		if (level.charAt(0) == '1')
			randomY1 = 280;

		if (level.charAt(0) == '2')
			randomY1 = 450;

		if (level.charAt(0) == '5')
			randomY1 = 500;

		for (int j = 0; j < level.length(); j++) {
			char a = level.charAt(j);

			if (a == '0') {
				Obstacle circle1 = new ObstacleCircle(500, randomY1, 100);
				Obstacle circle2 = new ObstacleCircle(500, randomY1, 125);
				Obstacle circle3=new ObstacleCircle(500,randomY1,150);
				Star star = new Star(475, randomY1, 40, 40);
				getobstacleList().add(circle1);
				getobstacleList().add(circle2);
				getobstacleList().add(circle3);
				getstarList().add(star);
//					getGameRoot().getChildren().add(circle1.getshape());
				getGameRoot().getChildren().addAll(circle1.getshape(), circle2.getshape(),circle3.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 590;
				else if(j != level.length() - 1 && (level.charAt(j + 1) == '2' || level.charAt(j + 1) == '5' ))
					randomY1 = randomY1 - 380;
				else
					randomY1 = randomY1 - 430;
			}
			else if( a == '1'){
				Obstacle square1 = new ObstacleSquare(447, randomY1 + 44 , 150);
				Obstacle square2 = new ObstacleSquare(420, randomY1+22, 200);
				Obstacle square3 = new ObstacleSquare(393, randomY1, 250);
				Star star = new Star(500, randomY1 + 84, 40, 40);
				getobstacleList().add(square1);
				getobstacleList().add(square2);
				getstarList().add(star);
				getGameRoot().getChildren().add(square1.getshape());
				getGameRoot().getChildren().add(square2.getshape());
				getGameRoot().getChildren().add(square3.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '0')
					randomY1 = randomY1 - 420;
				else
					randomY1 = randomY1 - 290;
			}
			else if(a == '2'){
				Obstacle parallelLines = new ObstacleParallelLines(420, randomY1 + 10, 180);
				Obstacle parallelLines1 = new ObstacleParallelLines(420, randomY1 + 50, 180);
				Star star = new Star(500, randomY1 - 20  , 40, 40);
				Star star2 = new Star(500, randomY1 + 40 - 20  , 40, 40);
				getobstacleList().add(parallelLines);
				getobstacleList().add(parallelLines1);
				getstarList().add(star);
				getstarList().add(star2);
				getGameRoot().getChildren().add(parallelLines.getshape());
				getGameRoot().getChildren().add(parallelLines1.getshape());
				getGameRoot().getChildren().add(star.getImage());
				getGameRoot().getChildren().add(star2.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 440;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '6')
					randomY1 = randomY1 - 210 ;
				else
					randomY1 = randomY1 - 310;
			}
			else if ( a == '4') {
				Obstacle stprllel = new ObstacleStraightParallelLines(420, randomY1 + 10, 140);
				Obstacle stprllel1 = new ObstacleStraightParallelLines(620, randomY1 + 10, 140);
				Star star = new Star(500, randomY1, 40, 40);
				getobstacleList().add(stprllel);
				getobstacleList().add(stprllel1);
				getstarList().add(star);
				getGameRoot().getChildren().add(stprllel1.getshape());
				getGameRoot().getChildren().add(star.getImage());

				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 420;
				else
					randomY1 = randomY1 - 310;
			}
			else if( a == '5' ){
				Obstacle plusSign = new ObstaclePlusSign(540, randomY1 + 10, 80);
				Star star = new Star(500, randomY1 + 60, 40, 40);
				getobstacleList().add(plusSign);
				getGameRoot().getChildren().add(plusSign.getshape());

				if(j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 530;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '0')
					randomY1 = randomY1 - 400;
				else if(j != level.length() - 1 && level.charAt(j + 1) == '4')
					randomY1 = randomY1 - 370;
				else
					randomY1 = randomY1 - 310;
			}
			else{
				ColorChooserBall colorBall = new ColorChooserBall(500, randomY1 + 10, 30);
//				getobstacleList().add(colorBall);
				getColorChooserBallList().add(colorBall);
				getGameRoot().getChildren().add(colorBall.getshape());
				if (j != level.length() - 1 && level.charAt(j + 1) == '1')
					randomY1 = randomY1 - 390;
				else
					randomY1 = randomY1 - 310;
			}
		}
		
		ImageView imgView=null;
		//System.out.println(MainMenu.getNightTheme());
		if(MainMenu.getNightTheme()==false) 
			imgView = new ImageView(new Image(getClass().getResource("/images/daybg.jpg").toExternalForm())); 
		
		else
			imgView = new ImageView(new Image(getClass().getResource("/images/nightbg.jpg").toExternalForm())); 
			
        imgView.setFitWidth(1000); //done
        imgView.setFitHeight(780);
        
		getAppRoot().getChildren().addAll(imgView,getGameRoot());
		getAppRoot().setBackground(Background.EMPTY);
	}
}