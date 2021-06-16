CREATE TYPE Item as (Item_Id int, Name VARCHAR, PluarlName VARCHAR);
CREATE TYPE LivingCreature(livingCreature_Id int, currentHitPoints int, maximumHitPoints int);
CREATE TYPE LootItem as (Details Item, DropPercentage int, IsDefaultItem boolean);
CREATE TYPE QuestCompletionItem as (Details Item, Quantity int);
CREATE TYPE QUEST as (Quest_Id int, Name VARCHAR, PluralName VARCHAR, RewardExperiencePoints INT, RewardGold INT, RewardItem Item, QuestCompletionItems QuestCompletionItem[]);
CREATE TYPE Monster as (Monster_Id int, Name VARCHAR, MaximumDamage INT, RewardExperiencePoints INT, RewardGold INT, LootTable LootItem[]);
CREATE TYPE Location as (Location_Id int, Name VARCHAR, Description TEXT, ItemRequiredToEnter Item, QuestAvailableHere Quest, MonsterLivingHere Monster);
CREATE TYPE Locals as (Location_Id int, Name VARCHAR, Description TEXT, ItemRequiredToEnter Item, QuestAvailableHere Quest, MonsterLivingHere Monster, LocationToNorth Location, LocationToSouth Location, LocationToEast Location, LocationToWest Location);

DROP TABLE IF EXISTS LivingCreatures CASCADE;
CREATE TABLE LivingCreatures
(
	LivingCreature_Id SERIAL PRIMARY KEY,
	currentHitPoints NUMERIC,
	maximumHitPoints NUMERIC
);

DROP TABLE IF EXISTS Items CASCADE;
CREATE TABLE Items
(
	Id SERIAL PRIMARY KEY,
	Name VARCHAR,
	PluralName VARCHAR
);

DROP TABLE IF EXISTS HealingPotion CASCADE;
CREATE TABLE HealingPotion
(
	HealingPotion_Id INT,
	amountToHeal INT,
	PRIMARY KEY(HealingPotion_Id),
	
	CONSTRAINT HealingPotion_Item FOREIGN KEY(HealingPotion_Id) REFERENCES Items(Id)
);

DROP TABLE IF EXISTS InventoryItem CASCADE;
CREATE TABLE InventoryItem
(
	Details Item,
	Quantity NUMERIC
);

DROP TABLE IF EXISTS LootItems CASCADE;
CREATE TABLE LootItems
(
	Details Item,
	DropPercentage int,
	IsDefaultItem boolean
);

DROP TABLE IF EXISTS Monsters CASCADE;
CREATE TABLE Monsters
(
	Monster_Id INT,
	Name VARCHAR,
	MaximumDamage INT,
	RewardExperiencePoints INT,
	RewardGold INT,
	LootTable LootItem[],
	PRIMARY KEY(Monster_Id),
	
	CONSTRAINT fk_LivingCreature FOREIGN KEY(Monster_Id) REFERENCES LivingCreatures(LivingCreature_Id)
);

DROP TABLE IF EXISTS QuestCompletionItems CASCADE;
CREATE TABLE QuestCompletionItems
(
	Details Item,
	Quantity int
);

DROP TABLE IF EXISTS Weapon CASCADE;
CREATE TABLE Weapon
(
	Weapon_Id INT,
	MinimumDamage INT,
	MaximumDamage INT,
	PRIMARY KEY(Weapon_Id),
	
	CONSTRAINT fk_Item FOREIGN KEY(Weapon_Id) REFERENCES Items(Id)
);

DROP TABLE IF EXISTS Quests CASCADE;
CREATE TABLE Quests
(
	Quest_Id SERIAL PRIMARY KEY,
	Name VARCHAR,
	Description TEXT,
	RewardExperiencePoints INT,
	RewardGold INT,
	RewardItem Item,
	QuestCompletionItems QuestCompletionItem[]
);

DROP TABLE IF EXISTS PlayerQuest CASCADE;
CREATE TABLE PlayerQuest
(
	Details Quest,
	IsCompleted BOOLEAN
);

DROP TABLE IF EXISTS Locations CASCADE;
CREATE TABLE Locations
(
	Location_Id SERIAL PRIMARY KEY,
	Name VARCHAR,
	Description TEXT,
	ItemRequiredToEnter Item,
	QuestAvailableHere Quest,
	MonsterLivingHere Monster,
	LocationToNorth Location,
	LocationToSouth Location,
	LocationToEast Location,
	LocationToWest Location
);

DROP TABLE IF EXISTS Player CASCADE;
CREATE TABLE Player
(
	Player_Id INT,
	Gold INT,
	ExperiencePoints INT,
	Level INT,
	CurrentLocation Location,
	Inventory InventoryItem[],
	Quests PlayerQuest[],
	PRIMARY KEY(Player_Id),
	
	CONSTRAINT fk_LivingCreature FOREIGN KEY(Player_Id) REFERENCES LivingCreatures(LivingCreature_Id)
); 