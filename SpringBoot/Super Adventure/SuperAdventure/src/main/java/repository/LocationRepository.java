/**
 * 
 */
package repository;

import java.util.List;

import engine.Location;

/**
 * @author bak12
 *
 */
public interface LocationRepository
{
	public boolean createLocation(Location location);
	public boolean updateLocation(Location location);
	public boolean deleteLocation(Location location);
	public Location getLocationById(int Id);
	public List<Location> getAllLocations();
}
