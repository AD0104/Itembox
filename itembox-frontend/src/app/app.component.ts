import { Component } from "@angular/core";
import { RouterOutlet } from "@angular/router";
import { LoginComponent } from "./views/login/login.component";
import { ReactiveFormsModule } from "@angular/forms";
import { MatDialogModule } from "@angular/material/dialog";
import { MatToolbarModule } from "@angular/material/toolbar";
import { NavComponent } from "./views/nav/nav.component";

@Component({
  selector: "app-root",
  standalone: true,
  imports: [
    LoginComponent,
    NavComponent,
    RouterOutlet,
    ReactiveFormsModule,
    MatDialogModule,
    MatToolbarModule,
  ],
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.scss",
})
export class AppComponent {
  title = "itembox-frontend";
}
