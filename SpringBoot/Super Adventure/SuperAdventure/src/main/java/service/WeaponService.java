/**
 * 
 */
package service;

import java.util.List;

import engine.Weapon;

/**
 * @author bak12
 *
 */
public interface WeaponService
{
	public boolean createWeapon(Weapon weapon);
	public boolean updateWeapon(Weapon weapon);
	public boolean deleteWeapon(Weapon weapon);
	public Weapon findWeaponById(int Id);
	public List<Weapon> findAllWeapons();
}
