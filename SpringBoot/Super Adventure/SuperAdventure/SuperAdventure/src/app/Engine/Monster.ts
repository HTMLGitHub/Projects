import { LivingCreature } from './LivingCreature';
import { LootItem } from './LootItem';

export interface Monster extends LivingCreature
{
        Id: number;
        Name: String;
        MaximumDamage: number;
        RewardExperiencePoints: number;
        RewardGold: number;

        LootTable: Array<LootItem>
}