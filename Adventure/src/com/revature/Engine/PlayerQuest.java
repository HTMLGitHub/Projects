package com.revature.Engine;

public class PlayerQuest 
{
	private Quest Details;
	private boolean isCompleted;
	
	public PlayerQuest(Quest Details)
	{
		setDetails(Details);
		isCompleted = false;
	}
	public Quest getDetails() {
		return Details;
	}

	public void setDetails(Quest details) {
		Details = details;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	
	
}
