import { Item } from './Item';

export interface LootItem
{
        Details: Item;
        DropPercentage: number;
        IsDefaultItem: boolean;
}