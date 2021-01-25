package com.revature.Engine;

public class LivingCreature 
{
	private int MaximumHitPoints;
	private int CurrentHitPoints;
	
	public LivingCreature(int currentHitPoints, int maximumHitPoints)
	{
		setCurrentHitPoints(currentHitPoints);
		setMaximumHitPoints(maximumHitPoints);
	}

	public int getMaximumHitPoints() {
		return MaximumHitPoints;
	}

	public void setMaximumHitPoints(int maximunHitPoints) {
		this.MaximumHitPoints = maximunHitPoints;
	}

	public int getCurrentHitPoints() {
		return CurrentHitPoints;
	}

	public void setCurrentHitPoints(int currentHitPoints) {
		this.CurrentHitPoints = currentHitPoints;
	}
	
	
}
