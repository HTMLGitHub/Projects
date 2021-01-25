package com.revature.Engine;

public class QuestCompletionItem 
{
	private Item Details;
	private int Quantity;
	
	public QuestCompletionItem(Item Details, int Quantity)
	{
		setDetails(Details);
		setQuantity(Quantity);
	}
	
	public Item getDetails()
	{
		return Details;
	}
	
	public void setDetails(Item details) 
	{
		Details = details;
	}
	
	public int getQuantity() 
	{
		return Quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		Quantity = quantity;
	}
	
	
}
