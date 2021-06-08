import { InventoryItem } from './InventoryItem';
import { LivingCreature } from './LivingCreature';
import { PlayerLocation } from './PlayerLocation';
import { PlayerQuest } from './PlayerQuest';

export interface Adventurer extends LivingCreature
{
        name: string;
        gold: number;
        experiencePoints: number;
        level: number;

        CurrentLocation: PlayerLocation | null;
        Inventory: Array<InventoryItem> | null;
        Quests: Array<PlayerQuest> | null;
}