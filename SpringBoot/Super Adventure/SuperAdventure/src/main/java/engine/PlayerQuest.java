package engine;

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

/**
 * @author bak12
 *	Class for the Player's Quests
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class PlayerQuest
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="InventoryItemSequence")
	@SequenceGenerator(name="InventoryItemSequence", sequenceName="INVENTORYITEM_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="Details")
	private Quest Details;
	
	@Column(name="IsCompleted")
	private boolean IsCompleted;
	
	public PlayerQuest(Quest details)
	{
		this.Details = details;
		this.IsCompleted = false;
	}
}
