import { Quest } from "./Quest";

export interface PlayerQuest
{
        Details: Quest | null;
        IsCompleted: boolean;
}