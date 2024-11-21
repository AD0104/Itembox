import { Component, OnDestroy } from "@angular/core";
import { MatInputModule } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatIconModule } from "@angular/material/icon";
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from "@angular/forms";
import { LoginInterface } from "../../models/model.login";
import { AuthManagementService } from "../../_services/auth/auth.management.service";

@Component({
  selector: "app-login",
  standalone: true,
  imports: [
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  templateUrl: "./login.component.html",
  styleUrl: "./login.component.scss",
})
export class LoginComponent implements OnDestroy {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authManager: AuthManagementService,
  ) {
    this.loginForm = this.fb.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", Validators.required],
    });
  }

  onSubmit() {
    const loginData: LoginInterface = this.loginForm.value;
    this.authManager.doLogin(loginData);
  }

  ngOnDestroy(): void {}
}
