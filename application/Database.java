package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable
{
	private static final long serialVersionUID = -858820327390071580L;
	private static Database instance;
	private ArrayList<DataTable> gameRecord;
	
	private Database()
	{
		gameRecord=new ArrayList<DataTable>();
	}
	
	public static Database getInstance()
	{
		if(instance==null)
			instance=new Database();
		//System.out.println("created instance");
		return instance;
	}
	
	public ArrayList<DataTable> getGameRecord()
    {
    	return gameRecord;
    }
    
    public void addGameRecord(DataTable s)
    {
    	gameRecord.add(s);
    }



}