import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {ReservationsComponent} from './components/data-tables/reservations/reservations.component';
import {UserService} from './services/user.service';
import {HttpModule} from '@angular/http';
import {AppRoutingModule} from './routes/app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PushService} from './services/push.service';
import {HomeComponent} from './components/content/home/home.component';
import {HaveAccessGuard} from './guards/have-access.guard';
import {DataTablesModule} from 'angular-datatables';
import {Ng2OdometerModule} from 'ng2-odometer';
import {Ng2ScrollimateModule} from 'ng2-scrollimate';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AgmCoreModule} from '@agm/core';
import {AgmSnazzyInfoWindowModule} from '@agm/snazzy-info-window';
import {
  CalendarModule,
  CarouselModule,
  CheckboxModule,
  DataTableModule,
  DialogModule,
  DropdownModule,
  GrowlModule,
  InputTextModule,
  MultiSelectModule,
  SharedModule,
  SliderModule,
  TooltipModule,
  PasswordModule
} from 'primeng/primeng';
import {CalendarComponent} from './components/content/calendar/calendar.component';
import {CarouselComponent} from './components/content/carousel/carousel.component';
import {HeaderComponent} from './components/header/header.component';
import {MapComponent} from './components/content/map/map.component';
import {DataTableComponent} from './components/data-tables/data-table/data-table.component';
import {QuoteComponent} from './components/content/quote/quote.component';
import {EmployeeComponent} from './components/employee/employee.component';
import {MyAccountComponent} from './components/my-account/my-account.component';
import {TypesComponent} from './components/data-tables/types/types.component';
import {TypeService} from "./services/type.service";
import {UsersComponent} from './components/data-tables/users/users.component';
import {EquipmentsComponent} from './components/data-tables/equipments/equipments.component';
import {EquipmentService} from "./services/equipment.service";
import {FooterComponent} from './components/footer/footer.component';
import {Ng2PageScrollModule} from 'ng2-page-scroll';
import {MiniZooComponent} from './components/content/mini-zoo/mini-zoo.component';
import {Angular2ImageGalleryModule} from "angular2-image-gallery";
import { RegulationsComponent } from './components/regulations/regulations.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    ReservationsComponent,
    HomeComponent,
    CalendarComponent,
    CarouselComponent,
    HeaderComponent,
    MapComponent,
    DataTableComponent,
    QuoteComponent,
    EmployeeComponent,
    MyAccountComponent,
    TypesComponent,
    UsersComponent,
    EquipmentsComponent,
    FooterComponent,
    MiniZooComponent,
    RegulationsComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    DataTablesModule,
    Ng2OdometerModule.forRoot(),
    Ng2ScrollimateModule,
    BrowserAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDLHDTuibT_U4P15XvfzQ32Xys0tY3KLn8'
    }),
    AgmSnazzyInfoWindowModule,
    CheckboxModule,
    CalendarModule,
    DataTableModule,
    SharedModule,
    DropdownModule,
    MultiSelectModule,
    SliderModule,
    DialogModule,
    GrowlModule,
    Ng2PageScrollModule,
    CarouselModule,
    Angular2ImageGalleryModule,
    TooltipModule,
    InputTextModule,
    PasswordModule
  ],
  providers: [
    UserService,
    PushService,
    HaveAccessGuard,
    TypeService,
    EquipmentService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
