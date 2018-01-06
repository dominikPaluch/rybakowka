import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {
  pl: any;
  valueDate: Date;
  value: Date;

  constructor() {
  }

  ngOnInit() {
    this.pl = {
      firstDayOfWeek: 1,
      dayNames: ["poniedzialek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela"],
      dayNamesShort: ["pon", "wt", "śr", "czw", "pt", "sb", "nie"],
      dayNamesMin: ["P", "W", "Ś", "C", "P", "S", "N"],
      monthNames: ["styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"],
      monthNamesShort: ["st", "lu", "mar", "kw", "ma", "cze", "lip", "sie", "wrz", "paź", "lis", "gr"],
      today: 'Dzisiaj',
      clear: 'Czyść'
    };
  }

}
