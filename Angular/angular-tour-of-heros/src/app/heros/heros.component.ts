import { MessageService } from './../message.service';
import { HeroService } from './../hero.service';
import { Hero } from './../hero';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-heros',
  templateUrl: './heros.component.html',
  styleUrls: ['./heros.component.css']
})
export class HerosComponent implements OnInit {

  heros: Hero[] = [];
  
  getHeros():void
  {
    this.heroService.getHeros().subscribe(heros=>this.heros = heros);
  }

  constructor(private heroService: HeroService) { }

  ngOnInit(): void 
  {
    this.getHeros();
  }

}
