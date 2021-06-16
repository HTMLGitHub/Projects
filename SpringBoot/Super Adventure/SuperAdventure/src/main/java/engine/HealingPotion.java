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
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HealingPotionSequence")
	@SequenceGenerator(name="HealingPotionSequence", sequenceName="HEALINGPOTION_SEQ", allocationSize=1)
	private int Id;
	
	@Column(name="amountToHeal")
	private int amountToHeal;
	
	public HealingPotion(int Id, String Name, String PluralName, int amountToHeal)
	{
		super(Id, Name, PluralName);
		this.amountToHeal = amountToHeal;
	}

	
}
