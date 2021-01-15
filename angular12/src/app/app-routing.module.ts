import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SessionComponent } from './session/session.component';
import { TodoComponent } from './todo/todo.component';

const routes: Routes = [
  { path: '',   redirectTo: '/sessions', pathMatch: 'full' },
  { path: 'sessions', component: SessionComponent },
  { path: 'todos', component:  TodoComponent},
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
