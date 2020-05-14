import { Injectable } from '@angular/core';
import { Libro } from '../model/libro';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibriService {

  // utilizziamo la dependency ijection di angular per ottenere un'istanza di servizio http
  // da utilizzare nel nostro servizio
  constructor(
      private http: HttpClient,
  ) { }

  getLibri(): Observable<Libro[]> {
    return this.http.get<Libro[]>('http://localhost:8080/api/libri');
  }
}
