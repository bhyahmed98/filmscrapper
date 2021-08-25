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
  queryCategory:String="";
  querySortBy:String="";
  filmName : any;
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
    this.router.navigateByUrl('/search?searchTerm='+this.searchTerm);

  }
  test(){
    
    this.httpService.getFilms(this.querySearch,this.queryCategory,this.querySortBy)
    .subscribe(result=>{
      console.log("azldakzdlkaz"+result) ;  


    // this.route.params.subscribe(params=>{
      
 

    //     if(this.querySearch)
    //     this.dataSource=this.listFilm.filter(film=> film.nameFilm.toLowerCase().includes(this.querySearch.toLowerCase()));
    //     else{this.dataSource=this.listFilm;}



    //   });

      
    })

  }

}
