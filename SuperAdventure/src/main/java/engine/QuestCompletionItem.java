/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class QuestCompletionItem
{
	private Item Details;
	private int Quantity;
	
	/**
	 * @param details
	 * @param quantity
	 */
	public QuestCompletionItem(Item details, int quantity)
	{
		Details = details;
		Quantity = quantity;
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
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return Quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		Quantity = quantity;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Details == null) ? 0 : Details.hashCode());
		result = prime * result + Quantity;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof QuestCompletionItem)) return false;
		QuestCompletionItem other = (QuestCompletionItem) obj;
		if (Details == null)
		{
			if (other.Details != null) return false;
		}
		else
			if (!Details.equals(other.Details)) return false;
		if (Quantity != other.Quantity) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("QuestCompletionItem [Details=");
		builder.append(Details);
		builder.append(", Quantity=");
		builder.append(Quantity);
		builder.append("]");
		return builder.toString();
	}
	
	
}
