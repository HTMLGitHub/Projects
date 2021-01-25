package com.revature.Engine;

public class Player extends LivingCreature
{
	private String Name;
	private int level;
	private int gold;
	private int experiencePoints;
		
	public Player(int currentHitPoints, int maximumHitPoints, String Name, int level, int gold, int experiencePoints) 
	{
		super(currentHitPoints, maximumHitPoints);
		
		setName(Name);
		setLevel(level);
		setGold(gold);
		setExperiencePoints(experiencePoints);
	}

	public int getLevel() {
		this.level = ((getExperiencePoints()/100)+1); 
		return  this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return Name;
	}

	private void setName(String name) {
		Name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}	
}
