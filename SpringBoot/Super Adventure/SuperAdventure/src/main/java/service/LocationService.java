/**
 * 
 */
package service;

import java.util.List;

import engine.Location;

/**
 * @author bak12
 *
 */
public interface LocationService
{
	public boolean createLocation(Location location);
	public boolean updateLocation(Location location);
	public boolean deleteLocation(Location location);
	public Location findLocation(int Id);
	public List<Location> findAllLocation();
}
