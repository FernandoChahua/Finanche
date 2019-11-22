import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LayoutComponent} from './component/layout/layout.component';


const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [

    ]
  },
  {
    path: 'auth',
    children: [

    ]
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
