import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { HomeComponent } from '../home/home.component';
import { HttpService } from '../services/http.service';
import { ActivatedRoute ,Router} from '@angular/router';


@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})



export class SearchBarComponent implements OnInit {
  
  searchTerm : String = "";
  querySearch:String="";
  queryCategory:String[]=["action","drama"];
  querySortBy:String="year";
  filmName : any;
  ch:String="";
  ngOnInit(): void {
    this.route.params.subscribe(param=>{
      this.searchTerm=param.searchTerm;
      if (this.searchTerm==undefined)this.searchTerm="";
      
    })
    
  }
  
  constructor(private route:ActivatedRoute,private router:Router,private httpService:HttpService) { 
   
  }

  Search():void{
    console.log('search works!!');
    if(this.searchTerm){}
    else {this.searchTerm=''}
    let ch : string ="";
    for(let i =0;i<this.queryCategory.length;i++){
      ch+=this.queryCategory[i]+',';
    }

    
    this.router.navigateByUrl('/search?searchTerm='+this.searchTerm+'&categoryTerm='+ch+'&sortByTerm='+this.querySortBy);

  }


  test(){
    
    this.httpService.getFilms(this.querySearch,this.ch,this.querySortBy)
    .subscribe(result=>{
       


    // this.route.params.subscribe(params=>{
      
 

    //     if(this.querySearch)
    //     this.dataSource=this.listFilm.filter(film=> film.nameFilm.toLowerCase().includes(this.querySearch.toLowerCase()));
    //     else{this.dataSource=this.listFilm;}



    //   });

      
    })

  }

}
