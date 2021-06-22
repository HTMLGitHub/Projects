/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Location;
import repository.LocationRepository;

/**
 * @author bak12
 *
 */
@Service("LocationService")
public class LocationServiceImpl implements LocationService
{
	@Autowired
	public LocationRepository locationRepo;

	@Override
	public boolean createLocation(Location location)
	{
		return locationRepo.createLocation(location);
	}

	@Override
	public boolean updateLocation(Location location)
	{
		return locationRepo.updateLocation(location);
	}

	@Override
	public boolean deleteLocation(Location location)
	{
		return locationRepo.deleteLocation(location);
	}

	@Override
	public Location findLocation(int Id)
	{
		return locationRepo.getLocationById(Id);
	}

	@Override
	public List<Location> findAllLocation()
	{
		return locationRepo.getAllLocations();
	}

}
