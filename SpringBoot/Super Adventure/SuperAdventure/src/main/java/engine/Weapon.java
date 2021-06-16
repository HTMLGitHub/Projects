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

@Entity
@Getter @Setter @ToString @EqualsAndHashCode(callSuper=true)
public class Weapon extends Item
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LivingCreatureSequence")
	@SequenceGenerator(name="LivingCreatureSequence", sequenceName="LIVINGCREATURE_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="MinimumDamage")
	private int MinimumDamage;
	
	@Column(name="MaximumDamage")
	private int MaximumDamage;

	/**
	 * @param Id
	 * @param Name
	 * @param PluralName
	 * @param minimumDamage
	 * @param maximumDamage
	 */
	public Weapon(int Id, String Name, String PluralName, int minimumDamage, int maximumDamage)
	{
		super(Id, Name, PluralName);
		MinimumDamage = minimumDamage;
		MaximumDamage = maximumDamage;
	}
}
