/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class LootItem
{
	private Item Details;
	private int DropPercentage;
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

	/**
	 * @return the details
	 */
	public Item getDetails()
	{
		return Details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(Item details)
	{
		Details = details;
	}

	/**
	 * @return the dropPercentage
	 */
	public int getDropPercentage()
	{
		return DropPercentage;
	}

	/**
	 * @param dropPercentage the dropPercentage to set
	 */
	public void setDropPercentage(int dropPercentage)
	{
		DropPercentage = dropPercentage;
	}

	/**
	 * @return the isDefaultItem
	 */
	public boolean isIsDefaultItem()
	{
		return IsDefaultItem;
	}

	/**
	 * @param isDefaultItem the isDefaultItem to set
	 */
	public void setIsDefaultItem(boolean isDefaultItem)
	{
		IsDefaultItem = isDefaultItem;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("LootItem [Details=");
		builder.append(Details);
		builder.append(", DropPercentage=");
		builder.append(DropPercentage);
		builder.append(", IsDefaultItem=");
		builder.append(IsDefaultItem);
		builder.append("]");
		return builder.toString();
	}
	
	
}
