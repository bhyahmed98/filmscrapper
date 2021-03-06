import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';

import { HttpService } from '../services/http.service';
import { Film } from '../shared/film';

import { ActivatedRoute } from '@angular/router';





@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

})
export class HomeComponent implements OnInit {
  listFilm: Array<Film>= new Array<Film>();
  
  displayedColumns: string[] = ['idFilm', 'nameFilm','currentRate'];
  dataSource: Array<Film>= new Array<Film>();
  images:String[] = [];



  querySearch:String="";
  queryCategory:String="";
  querySortBy:String="";
  queryCategories:String[];

  
  constructor(private httpService:HttpService,private route:ActivatedRoute) { 
    this.listFilm = new Array<Film>();
    
    this.route.queryParams.subscribe(data=>{
        console.log(data);
        this.querySearch=data.searchTerm;
        this.queryCategory=data.categoryTerm;
        this.querySortBy=data.sortByTerm;

        
        console.log('____________________');
        console.log('queryCategory'+this.queryCategory);
        //let queryCategories=this.queryCategory.split('');
        let queryCategories="";
        
        console.log(this.queryCategory);
       
        console.log('querySortBy'+this.querySortBy);
        console.log('____________________');
        
        
        this.Search();
    });
    
  }

  cat():void{
    console.log("entree en cat")
    if (this.queryCategory!=null){
      this.queryCategories=this.queryCategory.split(',');
      this.queryCategories.pop();
    }

    console.log(this.queryCategories);

  }

  Search():void{
    this.cat();
    console.log('search is initialized!');
    console.log('querySearch'+this.querySearch);
    console.log('queryCategory');
    console.log(this.queryCategory);
    console.log('querySortBy'+this.querySortBy);


    this.httpService.getFilms(this.querySearch,this.queryCategory,this.querySortBy)
    .subscribe(result=>{
      this.listFilm=result;
      this.dataSource = this.listFilm; 

    })
    // this.route.params.subscribe(params=>{

    //     if(this.querySearch)
    //     this.dataSource=this.listFilm.filter(film=> film.nameFilm.toLowerCase().includes(this.querySearch.toLowerCase()));
    //     else{this.dataSource=this.listFilm;}

    //   });

      
    

  }


  ngOnInit(): void {
   
    console.log('oninit is initialized!');

  }


  

}
