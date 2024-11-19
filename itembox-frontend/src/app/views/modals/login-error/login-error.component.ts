import { Component } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule } from "@angular/material/dialog";

@Component({
  selector: "app-login-error",
  standalone: true,
  imports: [MatDialogModule, MatButtonModule],
  templateUrl: "./login-error.component.html",
  styleUrl: "./login-error.component.scss",
})
export class LoginErrorComponent {}
