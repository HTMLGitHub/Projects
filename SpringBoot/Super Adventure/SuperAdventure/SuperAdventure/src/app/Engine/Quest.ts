import { Item } from './Item';
import { QuestCompletionItem } from './QuestCompletionItem';
export interface Quest
{
        Id: number;
        Name: String;
        Description: String;
        RewardExperiencePoints: number;
        RewardGold: number;
        RewardItem: Item;
        QuestCompletionItems: Array<QuestCompletionItem>
}