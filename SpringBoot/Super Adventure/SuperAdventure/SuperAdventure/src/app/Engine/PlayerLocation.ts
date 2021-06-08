import { Item } from "./Item";
import { Monster } from "./Monster";
import { Quest } from "./Quest";

export interface PlayerLocation
{
        Id: number;
        Name: String;
        Description: String;
        ItemRequiredToEnter: Item | null;
        QuestAvailableHere: Quest | null;
        MonsterLivingHere: Monster | null;
        LocationToNorth: PlayerLocation | null;
        LocationToSouth: PlayerLocation | null;
        LocationToEast: PlayerLocation | null;
        LocationToWest: PlayerLocation | null;
}