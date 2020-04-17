import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Book } from '../../../models/book';
import { BookService } from '../../../services/book.service';

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent {
  constructor(
    private formBuilder: FormBuilder,
    private bookService: BookService,
  ) { }

  form = this.formBuilder.group({
    recordIdentifier: [null, Validators.compose([Validators.required, Validators.minLength(1), Validators.maxLength(100)])],
    title: [null, Validators.compose([Validators.required, Validators.minLength(1), Validators.maxLength(500)])],
    author: [null, Validators.compose([Validators.required, Validators.minLength(1), Validators.maxLength(500)])],
    releaseDate: [null, Validators.required]
  });

  onSubmit() {
    this.form.updateValueAndValidity();
    if (this.form.valid) {
      const formData = this.form.getRawValue();
      const newBook: Book = {
        id: null,
        recordIdentifier: formData.recordIdentifier,
        title: formData.title,
        author: formData.author,
        releaseDate: formData.releaseDate,
        status: null
      };

      this.bookService.addBook(newBook).subscribe(
        (response) => {
          alert('Könyv hozzáadva.');
        },
        (error) => {
          console.error(error);
          alert('Nem sikerült hozzáadni a.');
        }
      );
    }
  }
}
