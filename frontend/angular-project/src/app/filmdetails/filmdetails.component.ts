import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Film } from '../shared/film';

@Component({
  selector: 'app-filmdetails',
  templateUrl: './filmdetails.component.html',
  styleUrls: ['./filmdetails.component.css']
})
export class FilmdetailsComponent implements OnInit {
  Films: Film[] ;
  constructor(private httpClient:HttpClient) { }

  ngOnInit() {}

}
