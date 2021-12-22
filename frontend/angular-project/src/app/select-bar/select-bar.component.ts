import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

import { HttpService } from '../services/http.service';
import { Category } from '../shared/category';

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

  listCategories:Array<Category>=new Array<Category>();
  //for the first one  
  toppings = new FormControl();
  toppingList: String[] = [];
  sortByValue : String;

  constructor(private httpService:HttpService,private router:Router) { 
    
  }
ngOnChanges():any{

  console.log("red")
}


ngOnInit(): void {
  
  this.getCategory();

  console.log(this.sortByValue);
  this.toppings.setValue(['aukzga'])
}



getCategory():void{

  this.httpService.getCategories().subscribe(result=>{
    this.listCategories=result;
      this.listCategories.forEach(element=>{
        let ch=element.title;
        console.log(ch);
        this.toppingList.push(ch);
        console.log(this.toppings);
      
   
      });


      console.log("+++++++++++++++++");
      
      
      console.log("+++++++++++++++++");
      

  });
 
}
openedChange() {
  console.log(this.toppings.value);
  this.router.navigateByUrl('/categories?categoriesTerm='+this.toppings.value[0]);
}


  
  //for the second one
  foods: Food[] = [
    {value: 'year', viewValue: 'year'},
    {value: 'rate', viewValue: 'rate'}
   
  ];

  






}

function ch(ch: any) {
  throw new Error('Function not implemented.');
}

