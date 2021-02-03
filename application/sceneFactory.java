package application;

import java.util.ArrayList;

public class sceneFactory {
	
	
	public static Scenes getScene(int option, String combo)
	{
		switch(option)
		{
			case 1: return new ScenesEasy(combo);
					
					
			case 2: return new ScenesMedium(combo);
					
					
			case 3: return new ScenesDifficult(combo);
					
			default: return new ScenesEasy(combo);
			
		}
	}
}
