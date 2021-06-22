/**
 * 
 */
package repository;

import java.util.List;

import engine.Weapon;

/**
 * @author bak12
 *
 */
public interface WeaponRepository
{
	public boolean createWeapon(Weapon weapon);
	public boolean updateWeapon(Weapon weapon);
	public boolean deleteWeapon(Weapon weapon);
	public List<Weapon> getAllWeapons();
	public Weapon getWeaponById(int Id);
}
