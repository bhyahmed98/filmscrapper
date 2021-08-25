import { Actor } from "./actor";
import { Category } from "./category";
import { Language } from "./language";
import { Feedback } from "./feedback";
import { Favourite } from "./favourite";



export class Film{
    
    idFilm: number;
    nameFilm: String;
    linkPapystreaming: String;
    linkChill: String;
    linkMoviestars: String;
    linkPrimeware:String;
    year:String;
    numberRate:String;
    currentRate:String;
    img:String;
    actors: Array<Actor>;
    categories: Array<Category>;
    languages: Array<Language>;
    favourites: Array<Favourite>;
    feedbacks: Array<Feedback>;


    


}