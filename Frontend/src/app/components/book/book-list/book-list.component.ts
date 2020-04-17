import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { MatButtonToggleChange } from '@angular/material/button-toggle';
import { BookListDataSource } from './book-list-datasource';
import { Book } from '../../../models/book';
import { BookStatus } from '../../../models/book';
import { BookService } from '../../../services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  dataSource: BookListDataSource;
  BOOK_STATUSES = Object.keys(BookStatus);

  constructor(
    private bookService: BookService,
  ) {
  }

  ngOnInit() {
    this.dataSource = new BookListDataSource(this.bookService);
  }

  filterChanged(event: any) {
    const filterValue = event.value;
    const f = filterValue != null ? filterValue : '';
    this.dataSource.setFilter(f);
  }

  statusChangedForBook(book: Book, e: MatButtonToggleChange) {
    e.source.buttonToggleGroup.value = book.status;
    if (book.status !== e.value) {
      (book as any).loading = true;

      const successCB = () => {
        book.status = e.value;
        e.source.buttonToggleGroup.value = e.value;
        (book as any).loading = false;
      };

      const errorCB = (error) => {
        (book as any).loading = false;

        console.error(error);
        alert("Nem sikerült megváltoztatni a könyv státuszát!");
      };

      switch (e.value) {
        case BookStatus.ELÉRHETŐ: {
          this.bookService.returnBook(book).subscribe(successCB, errorCB);
          break;
        }
        case BookStatus.KÖLCSÖNZÖTT: {
          this.bookService.rentBook(book).subscribe(successCB, errorCB);
          break;
        }
      }
    }
  }
}

