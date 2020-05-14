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
  libroSelezionato: Libro;

  constructor(
    private libriService: LibriService
  ) { }

  ngOnInit(): void {
    this.ricaricaLibri();
  }

  clickLibro(libro: Libro) {
    console.log('click!', libro);
    this.libroSelezionato = libro;
  }

  salvaLibro() {
    console.log('salvataggio del libro', this.libroSelezionato);
    this.libriService.save(this.libroSelezionato).subscribe((esito) => {
      if (esito) {
        this.libroSelezionato = undefined;
        this.ricaricaLibri();
      }
    });
  }

  private ricaricaLibri() {
    this.libriService.getLibri().subscribe((libri) => {
      this.libri = libri;
    });
  }

}
