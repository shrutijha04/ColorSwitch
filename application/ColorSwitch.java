package application;


import javafx.stage.Screen;  

import javafx.stage.Stage;

import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import java.io.Serializable;


public class ColorSwitch implements Serializable{
	
		private static final long serialVersionUID = 284456181386169120L;
		
		private HashMap<KeyCode, Boolean> keys;
		private int GameId;
		private double gameTranslateY;
		private AnimationTimer timer;
		private ScoreNode score;
		private Label scoreLabel;
		private Label HighestscoreLabel;
		private Label totalStarsLabel;
		private long highestScore;
		private Button pauseButton;
		private boolean playerAlive;
		private Scenes currentscene;
	   // private Pane appRoot;
		private Sound starcollect;
		private Sound die;
		private Sound bgmusic;
	    private Ball player;
	    private double position;
	    private Point2D playerVelocity ;
	    private boolean canJump;

	    private boolean running;
	    private boolean pauseMenu;

		public ColorSwitch()
		{
			position=700;
			keys=new HashMap<KeyCode, Boolean>();
			score=new ScoreNode();
			canJump = true;
			running = true;
		    pauseMenu=false;
		    playerAlive=true;
		    highestScore=getHighScore();
			renderGUI();
			//setSounds();
		}
		
		public ColorSwitch(DataTable d)
		{
			GameId=d.getGameID();
			gameTranslateY=d.getTranslateY();
			keys=new HashMap<KeyCode, Boolean>();
			score=new ScoreNode();
			score.setScore(d.getScore());
			score.setStars(d.getStars());
			canJump = d.getcanJump();
			running = d.getRunning();
		    pauseMenu=false;
		    playerAlive=d.getAlive();
		    position=d.getposY();
		    highestScore=getHighScore();
			renderGUI();
			//setSounds();
		}
		
		private long getHighScore()
		{
			if(Main.getDatabase().getGameRecord().size()==0)
				return 0;
			
			long max=Long.MIN_VALUE;
			for(DataTable t: Main.getDatabase().getGameRecord())
			{
				if(t.getHighScore()>max)
					max=t.getHighScore();
				
			}
			
			return max;
		}

	    private void initContent() {
		    
		   playerVelocity = new Point2D(0, 0);
		
	       player = new Ball(ColorChooserBall.getColor(),500,700,0,20);
	      
	       currentscene.addGameRoot(player.getshape());
	       currentscene.addAppRoot(scoreLabel);
	       currentscene.addAppRoot(totalStarsLabel);
	       currentscene.addAppRoot(HighestscoreLabel);
	       currentscene.addAppRoot(pauseButton);
	       
	      
	       player.getshape().translateYProperty().addListener((obs, old, newValue) -> {
	            int offset = -newValue.intValue();
	            //System.out.println(offset+" "+obs+" "+old);
	            if (offset > 400 && offset<1080) {
	            	
	                currentscene.getGameRoot().setLayoutY((offset - 350));    
	               
	            }
	            
	            if(offset>= 1100)
	            {
	            	
	            		try {
	            		
	                    initBg();
	                    initContent();
	                   
	                    currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
	                    currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
	                    
						Main.mainWindow.setScene(currentscene.getScene());
	            		
	                    
	            		}catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
					
	            	
	            }
	            
	        });
	    
	    }
	    
	    private void loadContent() {
	        
	    
		   playerVelocity = new Point2D(0, 0);
		
		   player = new Ball(ColorChooserBall.getColor(),500,position,0,20);
	     
	       currentscene.addGameRoot(player.getshape());
	       currentscene.addAppRoot(scoreLabel);
	       currentscene.addAppRoot(totalStarsLabel);
	       currentscene.addAppRoot(HighestscoreLabel);
	       currentscene.addAppRoot(pauseButton);
	       currentscene.getGameRoot().setLayoutY(gameTranslateY);
	       
	       
	       if(position>=500)
	       {
	    	   player.getshape().translateYProperty().addListener((obs, old, newValue) -> {
		            int offset = -newValue.intValue();
		            //System.out.println(offset);
		            if (offset > 400 && offset<900) {
		                currentscene.getGameRoot().setLayoutY(offset-380);    
		                
		            }
		            
		            if(offset>= 1030)
		            {
		            	
		            		try {
		            		
		                    initBg();
		                    initContent();
		                  
		                    currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
		                    currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
		                    
							Main.mainWindow.setScene(currentscene.getScene());
		            		
		                    
		            		}catch (Exception e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
						
		            	
		            }
		            
		        });
	    	   
	       }
	    	
	       else if(position>200 && position<500)
	       {
	    	   player.getshape().translateYProperty().addListener((obs, old, newValue) -> {
		            int offset = -newValue.intValue();
		            //System.out.println(offset);
		            if (offset > 0 && offset<360) {
		                currentscene.getGameRoot().setLayoutY(300+offset);    
		                
		            }
		            
		            if(offset>= 740)
		            {
		            	
		            		try {
		            		
		                    initBg();
		                    initContent();
		                   
		                    currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
		                    currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
		                    
							Main.mainWindow.setScene(currentscene.getScene());
		            		
		                    
		            		}catch (Exception e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
						
		            	
		            }
		            
		        });
	    	   
	       }
	    	   
	       else { 
	       player.getshape().translateYProperty().addListener((obs, old, newValue) -> {
	            int offset = -newValue.intValue();
	           // System.out.println(offset);
	            if (offset > 0 && offset<280) {
	                currentscene.getGameRoot().setLayoutY(400+offset);    
	                
	            }
	            
	            if(offset>= 280)
	            {
	            	
	            		try {
	            		
	                    initBg();
	                    initContent();
	                  
	                    currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
	                    currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
	                    
						Main.mainWindow.setScene(currentscene.getScene());
	            		
	                    
	            		}catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
					
	            	
	            }
	            
	        });
	       }
	       
	    }
	    
	   private void initBg()
	   {
		   if(score.getScore()<=7)
		   {
			   Random rn = new Random();
			   int answer = rn.nextInt(25);
			   String combo=LevelData.LEVEL1[answer];
			 
			   currentscene=sceneFactory.getScene(1, combo);
			   GameId=answer;
		   }
		   else if(score.getScore()>7 && score.getScore()<=14)
		   {
			   Random rn = new Random();
			   int answer = rn.nextInt(25);
			   String combo=LevelData.LEVEL2[answer];
			  
			   currentscene=sceneFactory.getScene(2, combo);
			   GameId=answer;
		   }
		   else
		   {
			   Random rn = new Random();
			   int answer = rn.nextInt(24);
			   String combo=LevelData.LEVEL3[answer];
			  
			   currentscene=sceneFactory.getScene(3, combo);
			   GameId=answer;
		   }
		   
		   
	   }
	   
	   private void loadBg()
	   {
		   if(score.getScore()<=7)
		   {
			   String combo=LevelData.LEVEL1[GameId];
			  
			   currentscene=sceneFactory.getScene(1, combo);
			  
		   }
		   else if(score.getScore()>7 && score.getScore()<=14)
		   {
			
			   String combo=LevelData.LEVEL2[GameId];
			 
			   currentscene=sceneFactory.getScene(2, combo);
			 
		   }
		   else
		   {
			 
			   String combo=LevelData.LEVEL3[GameId];
			  
			   currentscene=sceneFactory.getScene(3, combo);
			   
		   }
		   
	   }  
	   
	    
	   private void renderGUI()
	   {
		    scoreLabel=new Label("Score: "+score.getScore());
	    	scoreLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
	    	scoreLabel.setTextFill(Color.WHITE);
	    	scoreLabel.setTranslateX(850);
	    	scoreLabel.setTranslateY(30);
	    	
	    	HighestscoreLabel=new Label("Highest Score: "+highestScore);
	    	HighestscoreLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
	    	HighestscoreLabel.setTextFill(Color.WHITE);
	    	HighestscoreLabel.setTranslateX(10);
	    	HighestscoreLabel.setTranslateY(30);
	    	
	    	totalStarsLabel=new Label("Stars: "+score.getStars());
	    	totalStarsLabel.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
	    	totalStarsLabel.setTextFill(Color.WHITE);
	    	totalStarsLabel.setTranslateX(850);
	    	totalStarsLabel.setTranslateY(65);
	    	
	    	pauseButton = new Button("Click Or Press P to PAUSE");
	    	pauseButton.setWrapText(true);
	    	pauseButton.setStyle("-fx-background-color: #00ff00; -fx-border-color: rgb(49, 89, 23);-fx-border-radius: 5;-fx-padding: 3 6 6 6;");
	    	pauseButton.setMaxWidth(140);
	    	pauseButton.setTextFill(Color.BLACK);
	    	pauseButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
	    	pauseButton.setTextAlignment(TextAlignment.CENTER);;
	    	pauseButton.setMinHeight(90);
	    	pauseButton.setTranslateX(10);
	    	pauseButton.setTranslateY(90);
	    	pauseButton.setFocusTraversable(false);
	    	
	    	pauseButton.setOnAction(e->{
	    			//canJump=false;
	    			running=false;
	    			pauseMenu=true;
	    	});
	    	
	    	setSounds();
	   }
	   
	  private void setSounds()
	   {
		    this.starcollect = new Sound("/sounds/star.wav");
	       
	        this.die = new Sound("/sounds/die.wav");
	        
	        this.bgmusic=new Sound("/sounds/bgmusic.wav");
	   }

	    private void update() {
	    	
	    	
	        if (isPressed(KeyCode.SPACE)) {
	            jumpPlayer();
	            running=true;
	        }

	        if(!isPressed(KeyCode.SPACE) && running)
	        {
	        	player.getshape().setTranslateY(player.getshape().getTranslateY() + 1);
	        	player.setPosY(player.getPosY()+1);
	        }
	       
	       if(isPressed(KeyCode.P))
	       {
	    	  // running=false;
	    	   pauseButton.fire();
	    	   //canJump=false;
	       }

	        if (playerVelocity.getY() < 10) {
	            playerVelocity = playerVelocity.add(0, 1);
	        }

	        
	       
	       for (Star star : currentscene.getstarList()) {
	           if (player.getshape().getBoundsInParent().intersects(star.getImage().getBoundsInParent())) 
	    	   {
	                star.getImage().getProperties().put("alive", false);
	                score.addScore(1);
	                score.addStars(1);
	               // System.out.println(score.getScore()+" "+score.getStars());
	                starcollect.playClip();
	           }
	        }

	      
	       starIterator(currentscene.getstarList());
	       
	       scoreLabel.setText("Score: "+score.getScore());
	       totalStarsLabel.setText("Stars: "+score.getStars());
	       
	       if(score.getScore()>highestScore)
	    	   highestScore=score.getScore();
	       
	       HighestscoreLabel.setText("Highest Score: "+highestScore);
	       
	       if(player.getPosY()>795)
	       {
	    	   	  running=false;
				  player.setAlive(false);
				  playerAlive=false;
				  System.out.println("YOU LOSE");
				  die.playClip();
				
	       }
	       
	     	for(Obstacle o : currentscene.getobstacleList()) {
	           if (player.getshape().getBoundsInParent().intersects(o.getshape().getBoundsInParent())) 
	    	   {
	        	  for(Node s: o.getshape().getChildren())
	        	  {
	        		 // o.getshape().getChildren().removeIf(node -> ((Arc)node).getFill() == Color.BLACK);
	        		  if(((Path)Shape.intersect(player.getshape(), (Shape)s)).getElements().size() > 0) {
	        		  
	        			  if(((Shape)s).getStroke()!=player.getColor())
	        			  {
	        				  running=false;
	        				  player.setAlive(false);
	        				  playerAlive=false;
	        				  System.out.println("YOU LOSE");
	        				  die.playClip();
	        				  break;
	        			  }
	        		  }
	        	  }
	        	      
	    	   }
	        }
	     	
	     	
	     	for (ColorChooserBall c : currentscene.getColorChooserBallList()) {
		           if (player.getshape().getBoundsInParent().intersects(c.getshape().getBoundsInParent())) 
		    	   {
		                player.setColor(c.getrandomColor());
		                break;
		           }
		        }
	     
	         
	     
} 

	    public void starIterator(ArrayList<Star> collection)
	    {
	    	for (Iterator<Star> it = collection.iterator(); it.hasNext(); ) {
	            Star star = it.next();
	            if (!(Boolean)star.getImage().getProperties().get("alive")) {
	                it.remove();
	                currentscene.getGameRoot().getChildren().remove(star.getImage());
	            }
	        }
	    }
	    


	    private void jumpPlayer() {
	        if (canJump) {
	           //playerVelocity = playerVelocity.add(0, -30);
	           player.getshape().setTranslateY(player.getshape().getTranslateY() - 4);
	           player.setPosY(player.getPosY()-4);
	          
	        }
	    }

	   
	    private boolean isPressed(KeyCode key) {
	    	
	    		return keys.getOrDefault(key, false);
	  
	    }
	    

	   
	    public void startGame(){
	    	   	
	    	bgmusic.playInf();
	    	
	    	initBg();
	        initContent();	 
	        
	        currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
	        currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
	        Main.mainWindow.setScene(currentscene.getScene());
	        Main.mainWindow.show();
	          

	         timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	               if (playerAlive) {
	                    update();
	                }
	               
	               else
	               {
	            	   endGame();
	               }
	            	
	               if(pauseMenu && player.getAlive())
	               {
	            	   pauseMenu = false;
	            	   pauseGame();
	               }
	   	    		
	            }
	            
	        };
	        timer.start();
	       
	       
	    }
	    
	    
	    public void loadGame(){
    	   	
	    	bgmusic.playInf();
	    	
	    	loadBg();
	        loadContent();
	       
	        currentscene.getScene().setOnKeyPressed(event -> keys.put(event.getCode(), true));
	        currentscene.getScene().setOnKeyReleased(event -> keys.put(event.getCode(), false));
	        Main.mainWindow.setScene(currentscene.getScene());
	        Main.mainWindow.show();
	          

	         timer = new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	               if (playerAlive) {
	                    update();
	                }
	               
	               else
	               {
	            	   endGame();
	               }
	            	
	               if(pauseMenu && player.getAlive())
	               {
	            	   pauseMenu = false;
	            	   pauseGame();
	               }
	   	    		
	            }
	            
	        };
	        timer.start();
	       
	       
	    }
	    
	    public void endGame()
	    {
	    	timer.stop();
	    	bgmusic.stopClip();
	    	DataTable record=new DataTable(score.getScore(),score.getStars(),playerAlive,running,canJump,score.getDate(),score.getTime(),highestScore,player.getPosY(),GameId,currentscene.getGameRoot().getLayoutY());
	   	  	gameEndAlert alertbox=new gameEndAlert(record);
	   	  	alertbox.display();
	   	  	
	    }
	    
	    public void pauseGame()
	    {
     	    keys.keySet().forEach(key -> keys.put(key, false));
     	    DataTable record=new DataTable(score.getScore(),score.getStars(),playerAlive,running,canJump,score.getDate(),score.getTime(),highestScore,player.getPosY(),GameId,currentscene.getGameRoot().getLayoutY());
     	   	pauseButtonMenu pmenu=new pauseButtonMenu(record,this);
     	    pmenu.display();
     	    
	    }
	    
	    public void destroyGame()
	    {
	    	timer.stop();
	    	bgmusic.stopClip();
	    }
	   	
	    

}
