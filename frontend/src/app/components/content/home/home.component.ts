import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {startHours, stopHours} from './hours-data';
import {Observable} from "rxjs/Observable";
import {Observer} from "rxjs/Observer";
import {EasingLogic} from 'ng2-page-scroll';
import {animate, state, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
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
      transition("* => active", animate("300ms ease-in")),
      transition("* => inactive", animate("300ms ease-out")),
    ])
  ]
})
export class HomeComponent implements OnInit {

  selectedObjects: string[] = [];
  public observable1: Observable<boolean>;
  public observable2: Observable<boolean>;
  public observable3: Observable<boolean>;
  private observer1: Observer<boolean>;
  private observer2: Observer<boolean>;
  private observer3: Observer<boolean>;

  @ViewChild('upScroll') upScroll: ElementRef;
  @ViewChild('add') add: ElementRef;
  @ViewChild('carousel') carousel: ElementRef;
  @ViewChild('header') header: ElementRef;
  @ViewChild('socialMedia') socialMedia: ElementRef;
  @ViewChild('whereWeAre') whereWeAre: ElementRef;
  startHours = startHours;
  stopHours = stopHours;
  numberToCounting1 = 68;
  numberToCounting2 = 140;
  numberToCounting3 = 430;
  timeOfScroll = 1500;
  timeOfScrollUp = 750;

  selectedStartHour = this.startHours[5];
  selectedStopHour = this.stopHours[5];

  myEasing: EasingLogic = {
    ease: (t: number, b: number, c: number, d: number): number => {
      if (t === 0) {
        return b;
      }
      if (t === d) {
        return b + c;
      }
      if ((t /= d / 2) < 1) {
        return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
      }
      return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
    }
  };

  scrollimateOptions: any = {
    myScrollimation1: {
      currentState: "inactive",
      states: [
        {
          method: "pxElement",
          value: 550,
          state: "active",
        },
        {
          method: "default",
          state: "inactive"
        }
      ]
    }
  };

  // @HostListener("click", ["$event"])
  // public onClick(event: any): void {
  //   event.stopPropagation();
  //   console.log("aa");
  // }

  ngOnInit() {

  }

  constructor() {
    this.observable1 = new Observable<boolean>((observer1: any) => this.observer1 = observer1).share();
    this.observable2 = new Observable<boolean>((observer2: any) => this.observer2 = observer2).share();
    this.observable3 = new Observable<boolean>((observer3: any) => this.observer3 = observer3).share();
    setTimeout(() => this.observer1.next(true), 1000);
    setTimeout(() => this.observer2.next(true), 2000);
    setTimeout(() => this.observer3.next(true), 3000);
  }

  notDisplayWhenGalleryIsDisplay(event: boolean) {
    if (event && !this.upScroll.nativeElement.classList.contains('noDisplay')) {
      this.upScroll.nativeElement.classList.add('noDisplay');
      this.add.nativeElement.classList.add('noDisplay');
      this.carousel.nativeElement.classList.add('noDisplay');
      this.header.nativeElement.classList.add('noDisplay');
      this.socialMedia.nativeElement.classList.add('noDisplay');
      this.whereWeAre.nativeElement.classList.add('noDisplay');
    } else {
      this.upScroll.nativeElement.classList.remove('noDisplay');
      this.add.nativeElement.classList.remove('noDisplay');
      this.carousel.nativeElement.classList.remove('noDisplay');
      this.header.nativeElement.classList.remove('noDisplay');
      this.socialMedia.nativeElement.classList.remove('noDisplay');
      this.whereWeAre.nativeElement.classList.remove('noDisplay');
    }
  }

  doSmthWhenGoToDescination(reachedTarget: boolean): void {
    if (reachedTarget) {
      console.log('Yeah, we reached our destination');
    } else {
      console.log('Ohoh, something interrupted us');
    }
  }

  onChangeStart(hour) {
    this.selectedStartHour = hour;
  }

  onChangeStop(hour) {
    this.selectedStopHour = hour;
  }
}
