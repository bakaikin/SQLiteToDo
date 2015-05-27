package com.example.SQLiteToDo.lib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBEmpl_1 extends DBSQLite {
	
	/* Public constant that store a name of data base */
	public static final String DB_NAME = "DBEmpl.db";
	
	/* Public constant that store a version of data base */
	public static final int DB_VERSION = 1;	

	/** 
	 * Constructor with one parameter that describe a link 
	 * to the Context object.
	 * 	@param context	The context object.
	 * */
	public DBEmpl_1(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}		
	
	/**
	 * Called when the database is created for the first time. This is 
	 * where the creation of tables and the initial population of the 
	 * tables should happen.
	 * 	@param db	The database.
	 * */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub	
	}
	
	/** 
	 * Called when the database needs to be upgraded. The implementation 
	 * should use this method to drop tables, add tables, or do anything 
	 * else it needs to upgrade to the new schema version.
	 * @param db	The database.
	 * @param oldVersion	The old database version.
	 * @param newVersion	The new database version. 
	 * */		
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
