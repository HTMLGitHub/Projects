package com.revature.Engine;

public class Item 
{
	private int ID;
	private String Name;
	private String NamePlural;
	
	public Item(int ID, String Name, String NamePlural)
	{
		setID(ID);
		setName(Name);
		setNamePlural(NamePlural);
	}

	public int getID() {
		return ID;
	}

	private void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	private void setName(String name) {
		Name = name;
	}

	public String getNamePlural() {
		return NamePlural;
	}

	private void setNamePlural(String namePlural) {
		NamePlural = namePlural;
	}
}
