import { NgModule } from '@angular/core';
import { APP_INITIALIZER } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { RootComponent } from './components/root/root.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BookAddComponent } from './components/book/book-add/book-add.component';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { ConfigLoader } from './services/config.loader';
import { initConfig } from './services/config.loader';
import { BookService } from './services/book.service';
import { AppRoutingModule } from './app-routing.module';
import { AppMaterialModule } from './app-material.module';

@NgModule({
  declarations: [
    RootComponent,
    NavbarComponent,
    BookAddComponent,
    BookListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppMaterialModule,
  ],
  providers: [
    ConfigLoader,
    {
      provide: APP_INITIALIZER,
      useFactory: initConfig,
      deps: [ConfigLoader],
      multi: true
    },
    BookService
  ],
  bootstrap: [RootComponent]
})
export class AppModule { }
