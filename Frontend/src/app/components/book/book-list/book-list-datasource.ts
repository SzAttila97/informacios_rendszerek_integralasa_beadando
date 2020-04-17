import { DataSource } from '@angular/cdk/collections';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { merge } from 'rxjs';
import { EventEmitter } from '@angular/core';
import { Book } from '../../../models/book';
import { BookService } from '../../../services/book.service';

export class BookListDataSource extends DataSource<Book> {
  data: Book[] = [];
  dataChanged: EventEmitter<Book[]> = new EventEmitter();
  status: string = '';
  setGeneralFilterChnaged: EventEmitter<string> = new EventEmitter();

  constructor(
    private bookService: BookService,
  ) {
    super();
  }

  connect(): Observable<Book[]> {
    this.init();

    const dataMutations = [
      this.dataChanged,
      this.setGeneralFilterChnaged
    ];

    return merge(...dataMutations).pipe(map(() => {
      return this.getFilteredData([...this.data]);
    }));
  }

  private init() {
    this.bookService.getAllBook().subscribe(
      (result: Book[]) => {
        this.data = result;
        this.dataChanged.emit(result);
      },
      (error) => {
        console.error(error);
        this.data = [];
        this.dataChanged.emit([]);

        alert("Nem sikerült betölteni a könyvek listáját!");
      }
    );
  }

  disconnect() { }


  public setFilter(f: string) {
    this.status = f;
    this.setGeneralFilterChnaged.emit(f);
  }

  private getFilteredData(data: Book[]) {
    return data
      .filter((book: Book) => {
        return book != null 
            && book.status != null
            && book.status.toString().toLowerCase().includes(this.status.toLowerCase());
      });
  }
}
