/**
 * 
 */
package engine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *
*/
@Entity @Getter @Setter  @ToString @EqualsAndHashCode(callSuper=true)
public class Monster extends LivingCreature
{
	private @Id int Id;
	private String Name;
	private int MaximumDamage;
	private int RewardExperiencePoints;
	private int RewardGold;
	
	private List<LootItem> LootTable;
	
	public Monster(int currentHitPoints, String name, int id, int maximumHitPoints, int maximumDamage, int rewardExperiencePoints, int rewardGold)
	{
		super(currentHitPoints, maximumHitPoints);
		this.Id = id;
		this.Name = name;
		this.MaximumDamage = maximumDamage;
		this.RewardExperiencePoints = rewardExperiencePoints;
		this.RewardGold = rewardGold;
		
		LootTable = new ArrayList<LootItem>();
	}
	
	public void setLootTable(LootItem lootTable)
	{
		LootTable.add(lootTable);
	}	
}
