/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class Weapon extends Item
{
	private int MinimumDamage;
	private int MaximumDamage;
	
	/**
	 * @param iD
	 * @param name
	 * @param pluralName
	 * @param minimumDamage
	 * @param maximumDamage
	 */
	public Weapon(int iD, String name, String pluralName, int minimumDamage, int maximumDamage)
	{
		super(iD, name, pluralName);
		MinimumDamage = minimumDamage;
		MaximumDamage = maximumDamage;
	}
	
	/**
	 * @return the minimumDamage
	 */
	public int getMinimumDamage()
	{
		return MinimumDamage;
	}
	/**
	 * @param minimumDamage the minimumDamage to set
	 */
	public void setMinimumDamage(int minimumDamage)
	{
		MinimumDamage = minimumDamage;
	}
	/**
	 * @return the maximumDamage
	 */
	public int getMaximumDamage()
	{
		return MaximumDamage;
	}
	/**
	 * @param maximumDamage the maximumDamage to set
	 */
	public void setMaximumDamage(int maximumDamage)
	{
		MaximumDamage = maximumDamage;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + MaximumDamage;
		result = prime * result + MinimumDamage;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof Weapon)) return false;
		Weapon other = (Weapon) obj;
		if (MaximumDamage != other.MaximumDamage) return false;
		if (MinimumDamage != other.MinimumDamage) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Weapon [MinimumDamage=");
		builder.append(MinimumDamage);
		builder.append(", MaximumDamage=");
		builder.append(MaximumDamage);
		builder.append("]");
		return builder.toString();
	}
	
	
}
