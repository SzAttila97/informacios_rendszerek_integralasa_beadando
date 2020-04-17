import { NgModule } from '@angular/core';
import { Routes } from '@angular/router';
import { RouterModule } from '@angular/router';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { BookAddComponent } from './components/book/book-add/book-add.component';

const routes: Routes = [
  { path: 'book/add', component: BookAddComponent },
  { path: 'book/list', component: BookListComponent },
  { path: 'book', redirectTo: 'book/list', pathMatch: 'full' },

  { path: '**', redirectTo: '/book/list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
