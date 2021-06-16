package engine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Quest
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="QuestSequence")
	@SequenceGenerator(name="QuestSequence", sequenceName="QUEST_SEQ", allocationSize=1)
	private int Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="RewardExperiencePoints")
	private int RewardExperiencePoints;
	
	@Column(name="RewardGold")
	private int RewardGold;
	
	@Column(name="RewardItem")
	private Item RewardItem;
	
	@Column(name="QuestCompletionItems")
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
