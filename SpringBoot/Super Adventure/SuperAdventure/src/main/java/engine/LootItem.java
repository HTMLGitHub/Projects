/**
 * 
 */
package engine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *	Base Class for all objects in Super Adventure
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class LootItem 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LootItemSequence")
	@SequenceGenerator(name="LootItemSequence", sequenceName="LOOTITEM_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="Details")
	private Item Details;
	
	@Column(name="DropPercentage")
	private int DropPercentage;
	
	@Column(name="IsDefaultItem")
	private boolean IsDefaultItem;

	/**
	 * @param details
	 * @param dropPercentage
	 * @param isDefaultItem
	 */
	public LootItem(Item details, int dropPercentage, boolean isDefaultItem)
	{
		Details = details;
		DropPercentage = dropPercentage;
		IsDefaultItem = isDefaultItem;
	}
	
	
}
