package engine;

public class LivingCreature
{
	private int CurrentHitPoints;
	private int MaximumHitPoints;
	
	/**
	 * @param currentHitPoints
	 * @param maximumHitPoints
	 */
	public LivingCreature(int currentHitPoints, int maximumHitPoints)
	{
		CurrentHitPoints = currentHitPoints;
		MaximumHitPoints = maximumHitPoints;
	}
	
	/**
	 * @return the currentHitPoints
	 */
	public int getCurrentHitPoints()
	{
		return CurrentHitPoints;
	}
	/**
	 * @param currentHitPoints the currentHitPoints to set
	 */
	public void setCurrentHitPoints(int currentHitPoints)
	{
		CurrentHitPoints = currentHitPoints;
	}
	/**
	 * @return the maximumHitPoints
	 */
	public int getMaximumHitPoints()
	{
		return MaximumHitPoints;
	}
	/**
	 * @param maximumHitPoints the maximumHitPoints to set
	 */
	public void setMaximumHitPoints(int maximumHitPoints)
	{
		MaximumHitPoints = maximumHitPoints;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + CurrentHitPoints;
		result = prime * result + MaximumHitPoints;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof LivingCreature)) return false;
		LivingCreature other = (LivingCreature) obj;
		if (CurrentHitPoints != other.CurrentHitPoints) return false;
		if (MaximumHitPoints != other.MaximumHitPoints) return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("LivingCreature [CurrentHitPoints=");
		builder.append(CurrentHitPoints);
		builder.append(", MaximumHitPoints=");
		builder.append(MaximumHitPoints);
		builder.append("]");
		return builder.toString();
	}
	
}
