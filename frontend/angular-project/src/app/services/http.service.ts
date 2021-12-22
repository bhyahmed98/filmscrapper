import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { baseUrl } from '../shared/baseUrl';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ProcessHTTPMsgService } from '../process-httpmsg.service';
import { Film } from '../shared/film';
import { Category } from '../shared/category';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient,private processHTTPMsgService:ProcessHTTPMsgService) { }

  getFilms(querySearch:String,queryCategory:String,querySortBy:String):Observable<Array<Film>>{
    return this.http.post<Array<Film>>(baseUrl+'film/getall', [queryCategory,querySortBy,querySearch])
    .pipe(catchError(this.processHTTPMsgService.handleError));
  }

  getCategories():Observable<Array<Category>>{
    return this.http.get<Array<Category>>(baseUrl+'category/getall').pipe(catchError(this.processHTTPMsgService.handleError));
  }


 

}
