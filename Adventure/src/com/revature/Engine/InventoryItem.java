package com.revature.Engine;

public class InventoryItem
{
	private Item Details;
	private int Quantity;
	
	public InventoryItem(Item Details, int Quantity)
	{
		setDetails(Details);
		setQuantity(Quantity);
	}

	public Item getDetails() {
		return Details;
	}

	private void setDetails(Item details) {
		Details = details;
	}

	public int getQuantity() {
		return Quantity;
	}

	private void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
