package com.example.SQLiteToDo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	
	/* Private field for store type of items */
	private ItemType FItemType = ItemType.getDef();	
	
	/* Private field for store List Data */
	private StringArray FListData = null;
	
	/* Private field for store inflater */
	private LayoutInflater ItemInflater = null;
	
	/** Constructor */
	public ListViewAdapter(Context AContext, StringArray AListData, ItemType AItemType) {
		super();
		FListData = AListData;
		ItemInflater = (LayoutInflater) AContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
		
	/**
	 * Get current type of items
	 * */
	public ItemType getItemType() { return FItemType; }
	
	/**
	 * Set new value for type of items
	 * */
	public void setItemType(ItemType value) {
		if (!FItemType.equals(value)) {
			FItemType = value;
			notifyDataSetInvalidated();
		}
	}
	
	/**
	 * Change type of items
	 * */
	public void changeItemType() {
		setItemType(ItemType.getNext(FItemType));
	}
	
	/**
	 * Clear all items 
	 * */
	public void clear() {
		FListData.clear();
		this.notifyDataSetChanged();
	}
	
	@Override
	public int getCount() { return FListData.size(); }

	@Override
	public Object getItem(int arg0) { return FListData.get(arg0); }

	@Override
	public long getItemId(int arg0) { return arg0; }

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {

		/* Create a View */		
		View ItemView = null;
		
		if (getItemType() == ItemType.itFull)
			ItemView = ItemInflater.inflate(R.layout.list_item_old, arg2, false);
		else
			ItemView = ItemInflater.inflate(R.layout.list_item_short, arg2, false);				
					
		/* Load UI components */		
		TextView iNumber = (TextView) ItemView.findViewById(R.id.iNumber);
		TextView iTitle = (TextView) ItemView.findViewById(R.id.iTitle);
		
		/* Fill UI components */
		iNumber.setText(String.valueOf(arg0 + 1));
		iTitle.setText(FListData.get(arg0));

		
		if (getItemType() == ItemType.itFull) {
			TextView iShort = (TextView) ItemView.findViewById(R.id.iShort);
			iShort.setText("This is element " + String.valueOf(arg0 + 1));
		}
				
		/* Return View (as Item) */
		return ItemView;
		
	}

}
