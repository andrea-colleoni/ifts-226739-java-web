import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  nome = 'Andrea';
  numero = 1;

  constructor() { }

  ngOnInit(): void {
    setInterval(() => this.numero++, 1000);
  }

}
