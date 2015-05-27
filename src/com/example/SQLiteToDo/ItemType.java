package com.example.SQLiteToDo;

public enum ItemType {

	itFull, itShort;
	
	public static ItemType getDef() { return ItemType.itFull; }
	
	public static ItemType getNext(ItemType iType) {		
		int index = (iType.ordinal() + 1) % ItemType.values().length;		
		return ItemType.values()[index];		
	}
	
}
