package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu extends Parent implements Menu {
	
	private static boolean NightTheme=true;
	
        public MainMenu() {
		
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);
            VBox menu2 = new VBox(10);
            VBox menu3 = new VBox(10);
            VBox menu4 = new VBox(10);
            VBox choicemenu=new VBox(10);
            VBox rulesMenu=new VBox(10);
            
            menu0.setTranslateX(100);
            menu0.setTranslateY(170);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

            menu3.setTranslateX(100);
            menu3.setTranslateY(200);
            
            menu3.setTranslateX(100);
            menu3.setTranslateY(200);


            menu4.setTranslateX(100);
            menu4.setTranslateY(200);

            
            choicemenu.setTranslateX(100);
            choicemenu.setTranslateY(200);
            
            rulesMenu.setTranslateX(100);
            rulesMenu.setTranslateY(200);

            final int offset = 400;

            menu1.setTranslateX(offset);

            MenuButton btnNewGame = new MenuButton("NEW GAME");
            btnNewGame.setOnMouseClicked(event -> {

                getChildren().add(menu3);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu3);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });
            
            Text instruction=new Text();
            instruction.setTranslateX(10);
            instruction.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
            instruction.setFill(Color.WHITE);
            instruction.setWrappingWidth(500);
            instruction.setTextAlignment(TextAlignment.CENTER);
            
            String rules="GAME RULES:\n1)Press Space Key to jump.\n2) Press P to pause the game at any time.\n3)Avoid touching obstacle of different colour than the player ball and Collect stars.\n4) Atleast 10 stars are needed to resurrect after GAME OVER.";
            instruction.setText(rules);
            
            MenuButton btnBack5 = new MenuButton("BACK");
            btnBack5.setOnMouseClicked(event -> {
            	
            	getChildren().remove(rulesMenu);
                getChildren().add(menu0);

               
            });
            
            MenuButton btnLeaderBoard = new MenuButton("LEADER BOARD");
            btnLeaderBoard.setOnMouseClicked(event -> {

//                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
//                ft.setFromValue(1);
//                ft.setToValue(0);
//                ft.setOnFinished(evt -> setVisible(false));
//                ft.play();
                getChildren().add(menu4);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu4);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });
            
            MenuButton btnBacklast = new MenuButton("BACK");
            btnBacklast.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu4);
                tt.setToX(menu4.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu4.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu4);
                });
            });
            
            Text leadertext=new Text();
            leadertext.setTranslateX(10);
            leadertext.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
            leadertext.setFill(Color.WHITE);
            leadertext.setWrappingWidth(500);
            leadertext.setTextAlignment(TextAlignment.CENTER);
            
            DataTable t=getHighScore();
            
            if(t!=null) {
            	String textl="Highest Score: "+t.getScore()+"\n Date: "+t.getDate()+"\n Time: "+t.getTime();
            	leadertext.setText(textl);
            }
            
            else
            {
            	String textl="No games played yet!";
            	leadertext.setText(textl);
            }

            MenuButton btnGameRules = new MenuButton("GAME RULES");
            btnGameRules.setOnMouseClicked(event -> {
              
            		getChildren().remove(menu0);
            		getChildren().add(rulesMenu);
      
            	    
            });
            
            ComboBox<DataTable> choicebox=new ComboBox<>();
            choicebox.setMinWidth(200);
            choicebox.setMinHeight(50);
            choicebox.setTranslateX(10);
            choicebox.setStyle("-fx-font: 20px \"Verdana\";");
            choicebox.setPromptText("Select Game to Load");
            choicebox.setVisibleRowCount(7);
            for(DataTable e: Main.getDatabase().getGameRecord())
            	choicebox.getItems().add(e);

            Label noGameyet=new Label("NO GAMES SAVED YET!!");
            noGameyet.setVisible(false);
            noGameyet.setTranslateX(10);
            noGameyet.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
	    	noGameyet.setTextFill(Color.WHITE);
	    
            
            MenuButton btnBack4 = new MenuButton("BACK");
            btnBack4.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), choicemenu);
                tt.setToX(choicemenu.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu3.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(choicemenu);
                });
            });
            
                     
            MenuButton submit=new MenuButton("PLAY");
            submit.setOnMouseClicked(e-> {
            	
            	if(choicebox.getItems().size()==0)
            	{
            		noGameyet.setVisible(true);
            		
            	}
            	
            	else {
            	DataTable selected =getChoice(choicebox);
            	
            	if(selected!=null) {
            		
            	Main.getDatabase().getGameRecord().remove(selected);
            	ColorSwitch game=new ColorSwitch(selected);
                game.loadGame();
                
            	}
            	}
            	
            });
            
            noGameyet.setVisible(false);
           
            
            MenuButton btnLoadGame = new MenuButton("LOAD GAME");
            btnLoadGame.setOnMouseClicked(event -> {
                getChildren().add(choicemenu);
                
                /*TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), choicemenu);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });*/
                getChildren().remove(menu0);
    
            });

            MenuButton btnExit = new MenuButton("EXIT");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            MenuButton btnBack1 = new MenuButton("BACK");
            btnBack1.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });
            });


            MenuButton btnBack2 = new MenuButton("BACK");
            btnBack2.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu2.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu2.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu2);
                });
            });

          /*  MenuButton btnName = new MenuButton("NAME");
            btnName.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> setVisible(false));
                ft.play();
            });*/

            MenuButton btnStartGame = new MenuButton("START GAME");
            btnStartGame.setOnMouseClicked(event -> {
               /* FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> setVisible(false));
                ft.play();*/
            	ColorSwitch game=new ColorSwitch();
            	game.startGame();
            });

            MenuButton btnBack3 = new MenuButton("BACK");
            btnBack3.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu3);
                tt.setToX(menu3.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu3.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu3);
                });
            });
            
            

            MenuButton btnOptions = new MenuButton("OPTIONS");
            btnOptions.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX() - offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });


            MenuButton btnTheme = new MenuButton("THEMES");
            btnTheme.setOnMouseClicked(event -> {
                getChildren().add(menu2);

               /* TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });*/
                getChildren().remove(menu1);
            });

            MenuButton btnDarkTheme = new MenuButton("NIGHT MODE");
            btnDarkTheme.setOnMouseClicked(event -> {
                getChildren().add(menu0);
              
                NightTheme=true;
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu2);
                });
                getChildren().remove(menu2);
            });
            
            MenuButton btnLightTheme = new MenuButton("DAY MODE");
            btnLightTheme.setOnMouseClicked(event -> {
                getChildren().add(menu0);
                NightTheme=false;
                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
                tt.setToX(menu1.getTranslateX() + offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> {
                    getChildren().remove(menu2);
                });
            });

            menu0.getChildren().addAll(btnNewGame, btnLoadGame, btnGameRules, btnLeaderBoard,  btnOptions,  btnExit);
            menu1.getChildren().addAll(btnTheme,btnBack1);
            menu2.getChildren().addAll(btnDarkTheme,btnLightTheme,btnBack2);
            menu3.getChildren().addAll(btnStartGame,btnBack3);
            menu4.getChildren().addAll(leadertext,btnBacklast);
            choicemenu.getChildren().addAll(choicebox,submit,btnBack4,noGameyet);
            rulesMenu.getChildren().addAll(instruction,btnBack5);
            rulesMenu.setStyle("-fx-background-color: #DA70D6;");
            menu4.setStyle("-fx-background-color: #DA70D6;");
            
            Rectangle bg = new Rectangle(1000, 780);
            bg.setFill(Color.WHITE);
            bg.setOpacity(0.4);
            
            getChildren().addAll(bg, menu0);
        }
        
       public static boolean getNightTheme()
       {
    	   return NightTheme;
       }
       
       private DataTable getHighScore()
       {
    	   DataTable obj=null;
			if(Main.getDatabase().getGameRecord().size()==0)
				return obj;
			
			long max=Long.MIN_VALUE;
			for(DataTable t: Main.getDatabase().getGameRecord())
			{
				if(t.getScore()>max)
					{
						max=t.getScore();
						obj=t;
					}
				
			}
			
			return obj;
		}
 @Override     
 public void display()
 {
	 Pane root = new Pane(); //done
     root.setPrefSize(1000, 780); //done

     ImageView imgView = new ImageView(new Image(getClass().getResource("/images/menu.gif").toExternalForm())); //done
     imgView.setFitWidth(1000); //done
     imgView.setFitHeight(780); //done

    // MainMenu gameMenu = new MainMenu();
     this.setVisible(false);

     root.getChildren().addAll(imgView, this);

     Scene scene = new Scene(root,1000,780);
     scene.setOnKeyPressed(event -> {
         if (event.getCode() == KeyCode.SPACE) {
             if (!this.isVisible()) {
                 FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                 ft.setFromValue(0);
                 ft.setToValue(1);

                 this.setVisible(true);
                 ft.play();
             }
             else {
                 FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                 ft.setFromValue(1);
                 ft.setToValue(0);
                 ft.setOnFinished(evt -> this.setVisible(false));
                 ft.play();
             }
         }
     });
     
     Main.mainWindow.setScene(scene);
     Main.mainWindow.show(); 
     
 }
 
 private DataTable getChoice(ComboBox<DataTable> choicebox)
 {
 	DataTable record=choicebox.getValue();
 	return record;
 }
        
}



class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
            text.setFont(font);
            text.setFill(Color.WHITE);

//            Rectangle bg = new Rectangle(250, 30);
            Rectangle bg = new Rectangle(300, 40);
//            bg.setX(500);
//            System.out.println(bg.getX());
            bg.setArcHeight(10.0d);
            bg.setArcWidth(10.0d);
//            Rectangle bg1 = new Rectangle();
//            bg.setOpacity(0.6);
            bg.setOpacity(1);
            bg.setFill(Color.BLACK);
//            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
        
       
}
