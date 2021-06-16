package engine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Quest
{
	private @Id int Id;
	private String Name;
	private String Description;
	private int RewardExperiencePoints;
	private int RewardGold;
	
	private Item RewardItem;
	private List<QuestCompletionItem> QuestCompletionItems;
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param rewardExperiencePoints
	 * @param rewardGold
	 */
	public Quest(int id, String name, String description, int rewardExperiencePoints, int rewardGold)
	{
		super();
		Id = id;
		Name = name;
		Description = description;
		RewardExperiencePoints = rewardExperiencePoints;
		RewardGold = rewardGold;
		this.QuestCompletionItems = new ArrayList<QuestCompletionItem>();
	}
	
	public void setQuestCompletionItems(QuestCompletionItem questCompletionItem)
	{
		QuestCompletionItems.add(questCompletionItem);
	}
}
