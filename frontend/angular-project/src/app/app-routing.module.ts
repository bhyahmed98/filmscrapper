import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SearchBarComponent } from './search-bar/search-bar.component';

const routes:Routes=[
  {
    path:'',
    component:HomeComponent,
    
  },
  {
    path:'search/:searchTerm',
    component:HomeComponent,
  },
  {
    path:'search',
    component:HomeComponent,
  },
]

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
