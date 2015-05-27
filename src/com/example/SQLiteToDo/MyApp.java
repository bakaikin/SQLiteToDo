package com.example.SQLiteToDo;

import android.app.Application;
import android.util.Log;
import com.example.SQLiteToDo.lib.DBEmpl_2;

public class MyApp extends Application {
	
	/* Static file for store a link to the data base object */	
	private static DBEmpl_2 mDBEmpl = null;
	
	
	/* Private field for store a LOG tag */
	public static final String LOG_TAG = "MyApp";	
	
	@Override
	public void onCreate() {
		
		/* Invoke a parent method */
		super.onCreate();
		
		/* Create a data base object */		
		mDBEmpl = new DBEmpl_2(getApplicationContext());
		
		/* Write a log */
		Log.d(LOG_TAG, "Application onCreate");			
	}
	
	/** Get a link to the data base object */
	public static DBEmpl_2 getDB() { return mDBEmpl; }
	
	/** Add any string to Log */
	public static void Log(String log) {
		Log.d(LOG_TAG, log);
	}

}
