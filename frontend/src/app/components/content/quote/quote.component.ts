import {Component, OnInit} from '@angular/core';

import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-quote',
  templateUrl: './quote.component.html',
  styleUrls: ['./quote.component.scss'],
  animations: [
    trigger("elementState", [
      state("inactive", style({
        opacity: 0,
        visibility: "hidden",
      })),
      state("active", style({
        opacity: 1,
        visibility: "visible",
      })),
      transition("* => active", animate("200ms ease-in")),
      transition("* => inactive", animate("200ms ease-out")),
    ])
  ]
})
export class QuoteComponent implements OnInit {


  scrollimateOptions: any = {
    myScrollimation1: {
      currentState: "inactive", //currentState is required
      states: [
        {
          method: "pxElement", //this will be true when a total of 85% of the page has been scrolled
          value: 150, // percentTotal
          state: "active",
        },
        {
          method: "default",
          state: "inactive"
        }
      ]
    },
    myScrollimation2: {
      currentState: "inactive", //currentState is required
      states: [
        {
          method: "pxElement", //this will be true when a total of 85% of the page has been scrolled
          value: 250, // percentTotal
          state: "active",
        },
        {
          method: "default",
          state: "inactive"
        }
      ]
    },
    myScrollimation3: {
      currentState: "inactive", //currentState is required
      states: [
        {
          method: "pxElement", //this will be true when a total of 85% of the page has been scrolled
          value: 350, // percentTotal
          state: "active",
        },
        {
          method: "default",
          state: "inactive"
        }
      ]
    },
  };

  constructor() {

  }

  ngOnInit() {
  }

}
