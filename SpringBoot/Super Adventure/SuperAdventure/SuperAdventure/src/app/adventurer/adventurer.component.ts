import { Adventurer } from './../Engine/Adventurer';
import { Item } from './../Engine/Item';
import { PlayerLocation } from '../Engine/PlayerLocation';
import { LivingCreature } from '../Engine/LivingCreature';
import { Component, OnInit } from '@angular/core';
import { Quest } from '../Engine/Quest';
import { Monster } from '../Engine/Monster';
import { Identifiers } from '@angular/compiler';

@Component
({
  selector: 'app-adventurer',
  templateUrl: './adventurer.component.html',
  styleUrls: ['./adventurer.component.css']
})
export class AdventurerComponent implements OnInit
{
  currentPlace: PlayerLocation = 
  {
    Id: 1,
    Name: "Home",
    Description: "Your house. Looks boring!",
    ItemRequiredToEnter: null,
    QuestAvailableHere: null,
    MonsterLivingHere: null,
    LocationToNorth: null,
    LocationToSouth: null,
    LocationToEast: null,
    LocationToWest: null
  };

  player: Adventurer = 
  {
    name: 'Reed Tealeaf',
    currentHitPoints: 10,
    maximumHitPoints: 10,
    gold: 20,
    experiencePoints: 0,
    level: 1,
    CurrentLocation: this.currentPlace,
    Inventory: null,
    Quests: null    
  };

  constructor() { }

  ngOnInit(): void 
  {
    
  }

}
