package repository;

import java.util.List;

import engine.Monster;

public interface MonsterRepository
{
	public boolean createMonster(Monster monster);
	public boolean deleteMonster(Monster monster);
	public boolean updateMonster(Monster monster);
	public List<Monster> findAllMonsters();
	public Monster getMonsterById(int Id);
}
