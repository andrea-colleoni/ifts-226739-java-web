import { Component, OnInit } from '@angular/core';
import { Libro } from '../model/libro';
import { LibriService } from '../services/libri.service';

@Component({
  selector: 'app-elenco-libri',
  templateUrl: './elenco-libri.component.html',
  styleUrls: ['./elenco-libri.component.css']
})
export class ElencoLibriComponent implements OnInit {

  libri: Libro[];

  constructor(
    private libriService: LibriService
  ) { }

  ngOnInit(): void {
    this.libriService.getLibri().subscribe((libri) => {
      this.libri = libri;
    });
  }

}
