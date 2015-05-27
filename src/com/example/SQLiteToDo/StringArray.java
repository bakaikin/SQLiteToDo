/**
 * Mikhail Malakhov
 *  
 * */

package com.example.SQLiteToDo;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

/**
 * StringArray - Class for works with array of string 
 * 
 * */

public class StringArray extends ArrayList<String> {

	/** Private Constant from superclass */
	private static final long serialVersionUID = 1L;
		
	/** Constructor without any parameters */
	public StringArray() { super(); }	
	
	/** Constructor with parameter (read from Resources) */
	public StringArray(Resources AppResources, int ResourceID) {
		super();
		this.LoadFromResource(AppResources, ResourceID, false);
	}
					
	/** Load Data from Resources */
	public int LoadFromResource(Resources AppResources, int ResourceID, boolean ClearBefore) {
		
		/* Clear array before reading, if needed */
		if (ClearBefore) this.clear();
		
		/* Get array of string from application resource */
		String[] Values = AppResources.getStringArray(ResourceID);
		
		/* Load data from array */
		for (int i = 0; i< Values.length; i++) this.add(Values[i]);
		
		/* Return number of element that added  */
		return Values.length;
		
	}
	
	/** Load Data from Resources */
	public int LoadFromResource(Resources AppResources, int ResourceID) {
		return this.LoadFromResource(AppResources, ResourceID, true);
	}
	
	/** Load Data from Resources */
	public int LoadFromResource(Context AContext, int ResourceID, boolean ClearBefore) {
		return this.LoadFromResource(AContext.getResources(), ResourceID, ClearBefore);
	}		
	
	/** Load Data from Resources */
	public int LoadFromResource(Context AContext, int ResourceID) {
		return this.LoadFromResource(AContext.getResources(), ResourceID, true);
	}				
			
	/** Convert data to string */	
	public String toString() {
		
		/* Create a StringBuilder Object */
		StringBuilder SBuilder = new StringBuilder();
		
		/* Fill a StringBuilder Object */
		for (int i = 0; i < this.size(); i++) SBuilder.append(this.get(i));
		
		/* Return a Value */
		return SBuilder.toString();		
		
	}	

}
