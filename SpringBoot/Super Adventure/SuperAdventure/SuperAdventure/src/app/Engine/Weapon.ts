import { Item } from './Item';

export interface Weapon extends Item
{
        MinimumDamage: number;
        MaximumDamage: number;
}