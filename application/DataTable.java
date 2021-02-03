package application;

import java.io.Serializable;

public class DataTable implements Serializable {
	
	private static final long serialVersionUID = 384417937374280247L;
	private long score;
	private long stars;
	private boolean alive;
	private boolean running;
	private boolean canJump;
	private String date;
	private String time;
	private long highScore;
	private double posX;
	private double posY;
	private int GameID;
	private double translateY;
	
	public DataTable(long score, long stars, boolean alive, boolean running, boolean canJump,String date,String time, long highScore, double y, int id,double translatey)
	{
		this.score=score;
		this.stars=stars;
		this.alive=alive;
		this.running=running;
		this.canJump=canJump;
		this.date=date;
		this.time=time;
		this.highScore=highScore;
		this.posY=y;
		this.GameID=id;
		this.translateY=translatey;
	}
	
	public long getScore()
	{
		return score;
	}
	
	public int getGameID()
	{
		return GameID;
	}
	
	public double getTranslateY()
	{
		return translateY;
	}
	
	public double getposY()
	{
		return posY;
	}
	
	public long getHighScore()
	{
		return highScore;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public long getStars()
	{
		return stars;
	}
	
	public boolean getAlive()
	{
		return alive;
	}
	
	public boolean getcanJump()
	{
		return canJump;
	}
	
	public boolean getRunning()
	{
		return running;
	}
	
	public void setScore(long s)
	{
		score=s;
	}
	
	public void setHighScore(long s)
	{
		highScore=s;
	}
	
	public void setStars(long s)
	{
		stars=s;
	}
	
	public void setAlive(boolean s)
	{
		alive=s;
	}
	
	public void setcanJump(boolean s)
	{
		canJump=s;
	}
	
	public void setRunning(boolean s)
	{
		running=s;
	}
	
	public String toString()
	{
		String str=date+" "+time+" Score: "+score+" Stars: "+stars;
		if(alive!=true)
			str+=" GAME OVER";
		return str ;
	}
	
	

}
