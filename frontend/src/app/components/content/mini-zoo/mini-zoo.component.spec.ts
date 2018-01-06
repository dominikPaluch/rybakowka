import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MiniZooComponent } from './mini-zoo.component';

describe('MiniZooComponent', () => {
  let component: MiniZooComponent;
  let fixture: ComponentFixture<MiniZooComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MiniZooComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MiniZooComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
