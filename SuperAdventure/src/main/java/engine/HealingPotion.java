/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class HealingPotion extends Item
{
	private int AmountToHeal;
	
	public HealingPotion(int iD, String name, String pluralName, int amountToHeal)
	{
		super(iD, name, pluralName);
		AmountToHeal = amountToHeal;
	}

	/**
	 * @return the amountToHeal
	 */
	public int getAmountToHeal()
	{
		return AmountToHeal;
	}

	/**
	 * @param amountToHeal the amountToHeal to set
	 */
	public void setAmountToHeal(int amountToHeal)
	{
		AmountToHeal = amountToHeal;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + AmountToHeal;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (!(obj instanceof HealingPotion)) return false;
		HealingPotion other = (HealingPotion) obj;
		if (AmountToHeal != other.AmountToHeal) return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("HealingPotion [AmountToHeal=");
		builder.append(AmountToHeal);
		builder.append("]");
		return builder.toString();
	}
		
}
