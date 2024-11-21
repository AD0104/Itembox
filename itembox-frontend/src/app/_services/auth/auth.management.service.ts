import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";
import { LoginInterface } from "../../models/model.login";
import { HttpService } from "../web/http.service";
import { LoginResponseInterface } from "../../models/model.login.response";
import { Router } from "@angular/router";
import { MatDialog } from "@angular/material/dialog";
import { TOKEN_NAME } from "../../shared/constants";
import { LoginErrorComponent } from "../../views/modals/login-error/login-error.component";

@Injectable({
  providedIn: "root",
})
export class AuthManagementService {
  private isUserLoggedIn = new BehaviorSubject<boolean>(false);

  public isUserLoggedInStatus = this.isUserLoggedIn.asObservable();

  constructor(
    private httpService: HttpService,
    private router: Router,
    private dialog: MatDialog,
  ) {}

  doLogin(loginCredentials: LoginInterface) {
    this.httpService
      .postGenerateJwtToken(loginCredentials)
      .subscribe((response: LoginResponseInterface) => {
        if (response.code != 200) {
          const dialogRef = this.dialog.open(LoginErrorComponent, {
            width: "750px",
          });
          dialogRef.afterClosed().subscribe(() => {});
          return;
        }
        localStorage.setItem(TOKEN_NAME, response.data.accessToken);
        this.isUserLoggedIn.next(true);
        this.router.navigateByUrl("/menu");
      });
  }

  doLogout() {
    localStorage.removeItem(TOKEN_NAME);
    this.isUserLoggedIn.next(false);
    this.router.navigateByUrl("");
  }

  getUserLoggedIn(): boolean {
    this.isUserLoggedIn.next(!!localStorage.getItem(TOKEN_NAME));
    return !!localStorage.getItem(TOKEN_NAME);
  }
}
