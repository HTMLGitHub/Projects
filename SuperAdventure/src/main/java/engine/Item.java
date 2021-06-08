/**
 * 
 */
package engine;

/**
 * @author bak12
 *
 */
public class Item
{
	private int ID;
	private String Name;
	private String PluralName;
	
	
	/**
	 * @param iD
	 * @param name
	 * @param pluralName
	 */
	public Item(int iD, String name, String pluralName)
	{
		ID = iD;
		Name = name;
		PluralName = pluralName;
	}
	
	/**
	 * @return the iD
	 */
	public int getID()
	{
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD)
	{
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		Name = name;
	}
	/**
	 * @return the pluralName
	 */
	public String getPluralName()
	{
		return PluralName;
	}
	/**
	 * @param pluralName the pluralName to set
	 */
	public void setPluralName(String pluralName)
	{
		PluralName = pluralName;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((PluralName == null) ? 0 : PluralName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Item)) return false;
		Item other = (Item) obj;
		if (ID != other.ID) return false;
		if (Name == null)
		{
			if (other.Name != null) return false;
		}
		else
			if (!Name.equals(other.Name)) return false;
		if (PluralName == null)
		{
			if (other.PluralName != null) return false;
		}
		else
			if (!PluralName.equals(other.PluralName)) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Item [ID=");
		builder.append(ID);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", PluralName=");
		builder.append(PluralName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
