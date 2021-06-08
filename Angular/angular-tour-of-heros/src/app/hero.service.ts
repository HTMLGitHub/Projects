import { MessageService } from './message.service';
import { Hero } from './hero';
import { Injectable } from '@angular/core';
import { HEROS } from './mock-heros';
import{Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroService 
{

  getHeros(): Observable<Hero[]>
  {
    const heros = of(HEROS);
    this.messageService.add('HeroService: fetched heros');
    return heros;
  }

  getHero(id: number):Observable<Hero>
  {
    //for now, assume that a hero with the specified 'id' always exists
    //Error handling will be added in teh next step of the tutorial
    
    const hero = HEROS.find(h=>h.id===id) as Hero;
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(hero);
  }

  constructor(private messageService: MessageService) { }
}
