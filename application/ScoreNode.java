package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

public class ScoreNode implements Serializable{

	private static final long serialVersionUID = 1890202865092001177L;
	private long Score;
    private long Stars;
    private String date;
    private String time;

   
    public ScoreNode(){
    	
        this.Score = 0;
        this.Stars = 0;
        
        Date d=new Date();
        DateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
    	String time = dateFormat.format(d).toString();
    	this.time=time;
    	
    	DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
    	String date = dateFormat2.format(d).toString();
    	this.date=date;
        
    }

    public long getScore() {
        return Score;
    }

    public void setScore(long score) {
        Score = score;
    }

    public long getStars() {
        return Stars;
    }

    public void setStars(long stars) {
        Stars = stars;
    }

    public String getDate() {
        return date;
    }
    
    public void addStars(long s) {
        Stars += s;
    }
    
    public void addScore(long s) {
        Score += s;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}