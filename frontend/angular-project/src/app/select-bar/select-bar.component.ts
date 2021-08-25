import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-select-bar',
  templateUrl: './select-bar.component.html',
  styleUrls: ['./select-bar.component.css']
})


export class SelectBarComponent implements OnInit {

  
  //for the first one  
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  

  //for the second one
  foods: Food[] = [
    {value: 'year', viewValue: 'year'},
    {value: 'rate', viewValue: 'rate'}
   
  ];

  constructor() { }
  ngOnInit(): void {
  }

}

