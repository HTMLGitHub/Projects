package com.revature.Engine;

public class LootItem
{
	private Item Details;
	private int DropPercentage;
	private boolean IsDefaultItem;
	
	public LootItem(Item details, int dropPercentage, boolean isDefaultItem)
	{
		setDetails(details);
		setDropPercentage(dropPercentage);
		setIsDefaultItem(isDefaultItem);
	}

	public Item getDetails() {
		return Details;
	}

	public void setDetails(Item details) {
		Details = details;
	}

	public int getDropPercentage() {
		return DropPercentage;
	}

	public void setDropPercentage(int dropPercentage) {
		DropPercentage = dropPercentage;
	}

	public boolean isIsDefaultItem() {
		return IsDefaultItem;
	}

	public void setIsDefaultItem(boolean isDefaultItem) {
		IsDefaultItem = isDefaultItem;
	}
}
