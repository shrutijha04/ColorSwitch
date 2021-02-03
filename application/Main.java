package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.io.Serializable;

public class Main extends Application{
    
    public static Stage mainWindow;
    private static Database mainObj;
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	mainWindow=primaryStage;
    	mainObj=DatabaseManager.deserialize();
    	
    	if(mainObj==null)
    		mainObj=Database.getInstance();
    	
    	MainMenu gameMenu=new MainMenu();
    	gameMenu.display();
       
    }
    
    public static Database getDatabase()
    {
    	return mainObj;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}



