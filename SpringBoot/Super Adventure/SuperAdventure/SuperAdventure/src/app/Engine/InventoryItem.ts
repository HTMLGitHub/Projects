import { Item } from "./Item";

export interface InventoryItem
{
        Details: Item | null;
        Quantity: number;
}