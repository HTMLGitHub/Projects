package com.revature.Engine;

import java.util.List;
import java.util.ArrayList;

public class Quest 
{
	private int ID;
	private String Name;
	private String Description;
	private int RewardExperiencePoints;
	private int RewardGold;
	public ArrayList<QuestCompletionItem>QuestCompletionItems;
	private Item RewardItem;
	
	public Quest(int iD, String name, String description, int rewardExperiencePoints, int rewardGold) 
	{
		setID(iD);
		setName(name);
		setDescription(description);
		setRewardExperiencePoints(rewardExperiencePoints);
		setRewardGold(rewardGold);
		setQuestCompletionItems();
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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

	public List<QuestCompletionItem> getQuestCompletionItems() {
		return QuestCompletionItems;
	}

	public void setQuestCompletionItems() {
		QuestCompletionItems = new ArrayList<QuestCompletionItem>();
	}

	public Item getRewardItem() {
		return RewardItem;
	}

	public void setRewardItem(Item rewardItem) {
		RewardItem = rewardItem;
	}	
}
