package com.revature.Engine;

import java.util.ArrayList;

public class Monster extends LivingCreature
{
	private int ID;
	private String Name;
	private int MaximumDamage;
	private int RewardExperiencePoints;
	private int RewardGold;
	private ArrayList<LootItem> LootTable = new ArrayList<LootItem>();
	
	
	public Monster(int currentHitPoints, int maximumHitPoints, int iD, String name, int maximumDamage,
			int rewardExperiencePoints, int rewardGold) {
		super(currentHitPoints, maximumHitPoints);
		
		setID(iD);
		setName(name);
		setMaximumDamage(maximumDamage);
		setRewardExperiencePoints(rewardExperiencePoints);
		setRewardGold(rewardGold);
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getMaximumDamage() {
		return MaximumDamage;
	}


	public void setMaximumDamage(int maximumDamage) {
		MaximumDamage = maximumDamage;
	}


	public int getRewardExperiencePoints() {
		return RewardExperiencePoints;
	}


	public void setRewardExperiencePoints(int rewardExperiencePoints) {
		RewardExperiencePoints = rewardExperiencePoints;
	}


	public int getRewardGold() {
		return RewardGold;
	}


	public void setRewardGold(int rewardGold) {
		RewardGold = rewardGold;
	}


	public ArrayList<LootItem> getLootTable() {
		
		return this.LootTable;
	}


	public void setLootTable(ArrayList<LootItem> lootTable) {
		this.LootTable = new ArrayList<LootItem>();	
	}
}
