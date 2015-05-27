package com.example.SQLiteToDo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.SQLiteToDo.lib.DBEmpl_2;

public class MainActivity extends Activity {
	
	/** ListView UI object */
	private ListView lvMain = null;	
	
	/** Private field for store List Data */
	private StringArray ListData = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		/* Invoke parent method */
		super.onCreate(savedInstanceState);
		
		/* Setting up layout */
		setContentView(R.layout.activity_main);


		/* Create Cursor for read a data from data base */
		Cursor cr = MyApp.getDB().getReadableCursor(DBEmpl_2.TableDep.T_NAME);

		/* Create a StringBuilder object */
		StringBuilder sBuilder = new StringBuilder();

		/* Read a data from data base */
		if (cr.moveToFirst()) {

			/* Calculate indexes of columns */
			int col_id = cr.getColumnIndex(DBEmpl_2.TableDep._ID);
			int col_name = cr.getColumnIndex(DBEmpl_2.TableDep.C_NAME);
			int col_info = cr.getColumnIndex(DBEmpl_2.TableDep.C_LOCA);

			/* Read data */
			do {

				sBuilder.append( cr.getString(col_id) + " " +
						cr.getString(col_name) + " - " +  cr.getString(col_info) +"\n");

			} while (cr.moveToNext());

			/* Show data */
//			tvText.setText(sBuilder.toString());
		
		/* Create List Data */
		ListData = new StringArray(getResources(),R.array.list_items);
		
		/* Load UI components */
		lvMain = (ListView) findViewById(R.id.lvMain);
		
		/* Create custom Adapter */
		ListViewAdapter lvAdapter = new ListViewAdapter(this, ListData,ItemType.getDef());
	     	    
	    /* Setting up adapter for ListView (lvMain) */
	    lvMain.setAdapter(lvAdapter);
	    
	    /* Create OnItemClick Listener  */
	    lvMain.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				/* Get Item title */
				String iTitle = arg0.getItemAtPosition(arg2).toString();
				
				/* Build text for message */
				String iMsg = "itemClick: position = " + arg2 + ", id = " + arg3 + ", text = " + iTitle;
				
				/* Show message */
				ShowMessage(iMsg);				
				
			}
		});
	    	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
		 
		 /* Handle item selection */
		 switch (item.getItemId()) {
		 	     
		 	/* Menu "Add" */
			case R.id.menu_add_item: {
				ListData.add("Item " + String.valueOf(ListData.size() + 1) + " (new)");	
				((BaseAdapter) lvMain.getAdapter()).notifyDataSetChanged();				
				return true;
			}
				
			 /* Menu "Clear all" */						
			case R.id.menu_clear_items: {
				((ListViewAdapter) lvMain.getAdapter()).clear();
				return true;			
			}
				
			/* Menu "Change type of View" */						
			case R.id.menu_ch_type: {
				((ListViewAdapter) lvMain.getAdapter()).changeItemType();												
				return true;
			}
			
			default: return super.onOptionsItemSelected(item);
			
		 }
		 
	 }	 		 		
	
	private void ShowMessage(String Msg) {
		(Toast.makeText(this, Msg, Toast.LENGTH_SHORT)).show();		
	}	

}
