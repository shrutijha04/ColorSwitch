package application;

import javafx.scene.media.AudioClip;

public class Sound {
	
	
	
	    private AudioClip soundEffect;
	    
	    
	    public Sound(String filePath) {
	    
	        soundEffect = new AudioClip(getClass().getResource(filePath).toString());
	    }

	    public void playClip() {
	        soundEffect.play();
	    }
	    
	    public void stopClip()
	    {
	    	soundEffect.stop();
	    }
	    
	    public void playInf()
	    {
	    	soundEffect.setVolume(0.2);
	    	soundEffect.setCycleCount(AudioClip.INDEFINITE);
	    	soundEffect.play();
	    }
	    
	   
	

}
