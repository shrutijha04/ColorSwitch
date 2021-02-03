package application;

import application.MenuButton;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;


public class gameEndAlert extends Parent implements Menu{
	private static Stage endgameWindow;
	
	
	public gameEndAlert(DataTable record)
	{
		
		endgameWindow=new Stage();
		
        endgameWindow.initModality(Modality.APPLICATION_MODAL);
        
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);
        VBox menu2 = new VBox(10);
        VBox menu3 = new VBox(10);
        VBox resurrectmenu=new VBox(10);
        VBox rulesMenu=new VBox(10);
        
        menu0.setTranslateX(100);
        menu0.setTranslateY(170);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        menu2.setTranslateX(100);
        menu2.setTranslateY(200);

        menu3.setTranslateX(100);
        menu3.setTranslateY(200);
        
        resurrectmenu.setTranslateX(100);
        resurrectmenu.setTranslateY(200);
        
        rulesMenu.setTranslateX(100);
        rulesMenu.setTranslateY(200);

        final int offset = 400;

        menu1.setTranslateX(offset);

        Label label = new Label("GAME OVER");
        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 60);
        label.setFont(font);
        label.setAlignment(Pos.CENTER_RIGHT);
//        label.setTranslateX(300);
        label.setTextFill(Color.DARKRED);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), label);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
      
        Label label1 = new Label("CURRENT SCORE: "+record.getScore());
        Font font1 = Font.font("Verdana", FontWeight.EXTRA_BOLD, 28);
        label1.setFont(font1);
        label1.setAlignment(Pos.CENTER);
        label1.setTranslateX(60);


        label1.setTextFill(Color.DARKBLUE);

        Label label3 = new Label("STARS: "+record.getStars());
        Font font3 = Font.font("Verdana", FontWeight.EXTRA_BOLD, 28);
        label3.setFont(font3);
        label3.setAlignment(Pos.CENTER);
        label3.setTranslateX(140);

        label3.setTextFill(Color.YELLOW);


        Label label2 = new Label("HIGHEST SCORE: "+record.getHighScore());
        Font font2 = Font.font("Verdana", FontWeight.EXTRA_BOLD, 28);
        label2.setFont(font2);
        label2.setAlignment(Pos.CENTER);
        label2.setTranslateX(65);
        label2.setTextFill(Color.AZURE);

        Label label4 = new Label("");
        Font font4 = Font.font("Verdana", FontWeight.EXTRA_BOLD, 10);
        label4.setFont(font4);

        MenuButton btnExitToMainMenu = new MenuButton("EXIT TO MAIN MENU");
        btnExitToMainMenu.setOnMouseClicked(event -> {
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

        MenuButton btnBackEXIT = new MenuButton("BACK");
        btnBackEXIT.setOnMouseClicked(event -> {
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

        MenuButton btnDontSaveExit = new MenuButton("DONT SAVE AND EXIT");
        btnDontSaveExit.setOnMouseClicked(event -> {
        	
           	MainMenu gameMenu=new MainMenu();
           	endgameWindow.close();
       		gameMenu.display();
       		
        });

        MenuButton btnSaveExitToMainMenu = new MenuButton("SAVE AND EXIT");
        btnSaveExitToMainMenu.setOnMouseClicked(event -> {
        	
        	//System.out.println("Clicked save and exit in endgame!");
    		Main.getDatabase().addGameRecord(record);
    		DatabaseManager.serialize(Main.getDatabase());
    		MainMenu gameMenu=new MainMenu();
    		endgameWindow.close();
       		gameMenu.display();
    		
        });
        
        Label resurrect=new Label("YOU DO NOT HAVE ENOUGH STARS TO RESURRECT!");
        resurrect.setTranslateX(10);
        resurrect.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 24));
        resurrect.setTextFill(Color.WHITE);
        resurrect.setMaxWidth(500);
        resurrect.setWrapText(true);
        resurrect.setTextAlignment(TextAlignment.CENTER);
        
        MenuButton btnBack4 = new MenuButton("BACK");
        btnBack4.setOnMouseClicked(event -> {
        	
        	getChildren().remove(resurrectmenu);
            getChildren().add(menu0);

           
        });
        

        MenuButton btnResurrect = new MenuButton("RESURRECT");
        btnResurrect.setOnMouseClicked(event -> {
          
        	if(record.getStars()>=10)
        	{	
        		record.setStars(record.getStars()-10);
        		record.setAlive(true);
        		endgameWindow.close();
        		ColorSwitch game=new ColorSwitch(record);
        		game.startGame();
        	}
        	
        	else
        	{
        		getChildren().remove(menu0);
        		getChildren().add(resurrectmenu);
  
        	}
        	    
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
        

        MenuButton btnGameRules = new MenuButton("GAME RULES");
        btnGameRules.setOnMouseClicked(event -> {
          
        		getChildren().remove(menu0);
        		getChildren().add(rulesMenu);
  
        	    
        });

        
        
        MenuButton btnRestartGame = new MenuButton("RESTART GAME");
        btnRestartGame.setOnMouseClicked(event -> {
            /*FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();*/
        	endgameWindow.close();
        	ColorSwitch game=new ColorSwitch();
        	game.startGame();
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


        MenuButton btnTheme = new MenuButton("THEME");
        btnTheme.setOnMouseClicked(event -> {
            getChildren().add(menu2);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
            tt.setToX(menu1.getTranslateX() + offset);

            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
            tt1.setToX(menu1.getTranslateX());

            tt.play();
            tt1.play();

            tt.setOnFinished(evt -> {
                getChildren().remove(menu1);
            });
        });

      

        menu0.getChildren().addAll( label, label1, label3, label2,label4, btnResurrect ,  btnRestartGame, btnGameRules,btnExitToMainMenu);
       
        menu3.getChildren().addAll(btnSaveExitToMainMenu,btnDontSaveExit,btnBackEXIT);
        resurrectmenu.getChildren().addAll(resurrect,btnBack4);
        rulesMenu.getChildren().addAll(instruction,btnBack5);
        rulesMenu.setStyle("-fx-background-color: #DA70D6;");
        Rectangle bg = new Rectangle(800, 720);
        bg.setFill(Color.WHITE);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
	}
	
	@Override
	public void display()
	{
		Pane root = new Pane(); //done
        root.setPrefSize(800, 720); //done

        ImageView imgView = new ImageView(new Image(getClass().getResource("/images/pauseMenu.gif").toExternalForm())); //done
        imgView.setFitWidth(800); //done
        imgView.setFitHeight(720); //done


        this.setVisible(false);

        root.getChildren().addAll(imgView, this);

        Scene scene = new Scene(root,800,720);
        
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
        ft.setFromValue(0);
        ft.setToValue(1);
        this.setVisible(true);
        ft.play();
        
        endgameWindow.setScene(scene);
		endgameWindow.show();		
	}

}

