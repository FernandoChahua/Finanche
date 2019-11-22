import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './component/layout/layout.component';
import {HomeComponent} from './component/home/home.component';
import { LoginComponent } from './component/auth/login/login.component';
import { RegisterComponent } from './component/auth/register/register.component';
import { LettersComponent } from './component/letters/letters.component';
import { PortfoliosComponent } from './component/portfolios/portfolios.component';


const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full',
      },
      {
        path: 'home',
        component: HomeComponent,
        data: { title: 'Home'}
      },{
        path:'letters',
        component:LettersComponent,
        data:{title:'Letras'}
      },{
        path:'portfolios',
        component: PortfoliosComponent,
        data:{title: 'Cartera de Letras'}
      }
    ]
  },
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        component: LoginComponent,
        data: { title: 'Login'}
      },
      {
        path: 'register',
        component: RegisterComponent,
        data: { title: 'Register'}
      }
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
