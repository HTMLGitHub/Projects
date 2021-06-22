/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Item;
import engine.Weapon;
import repository.WeaponRepository;

/**
 * @author bak12
 *
 */
@Service("WeaponService")
public class WeaponServiceImpl implements WeaponService
{
	@Autowired
	public WeaponRepository weaponRepo;
	private ItemService itemRepo;
	
	@Override
	public boolean createWeapon(Weapon weapon)
	{
		return weaponRepo.createWeapon(weapon);
	}

	@Override
	public boolean updateWeapon(Weapon weapon)
	{
		return weaponRepo.updateWeapon(weapon);
	}

	@Override
	public boolean deleteWeapon(Weapon weapon)
	{
		return weaponRepo.deleteWeapon(weapon);
	}

	@Override
	public Weapon findWeaponById(int Id)
	{
		Weapon weapon = weaponRepo.getWeaponById(Id);
		
		if(weapon!=null)
		{
			Item item = itemRepo.findItemById(weapon.getId());
			
			weapon.setName(item.getName());
			weapon.setPluralName(item.getPluralName());
			return weapon;
		}
		return null;
	}

	@Override
	public List<Weapon> findAllWeapons()
	{
		List<Item> items = itemRepo.findAllItems();
		List<Weapon> weapons = weaponRepo.getAllWeapons();
		if(!items.isEmpty()&&!weapons.isEmpty())
		{
			for(Item i: items)for(Weapon w: weapons)
			{
				if(i.getId()==w.getId())
				{
					w.setName(i.getName());
					w.setPluralName(i.getPluralName());
				}
			}
			return weapons;
		}
		return null;
	}
}