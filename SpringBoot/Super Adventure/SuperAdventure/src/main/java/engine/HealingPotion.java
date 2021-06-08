/**
 * 
 */
package engine;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** 
 * Heals Player for @param AmountToHeal
 * 
 * @author bak12
 *
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode(callSuper=true)
public class HealingPotion extends Item
{
	private int amountToHeal;
	
	public HealingPotion(int Id, String Name, String PluralName, int amountToHeal)
	{
		super(Id, Name, PluralName);
		this.amountToHeal = amountToHeal;
	}

	
}
