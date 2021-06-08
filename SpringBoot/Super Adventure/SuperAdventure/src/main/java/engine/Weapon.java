package engine;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode(callSuper=true)
public class Weapon extends Item
{
	private int MinimumDamage, MaximumDamage;

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
