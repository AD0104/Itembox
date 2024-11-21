import { Component, OnInit } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatToolbarModule } from "@angular/material/toolbar";
import { Router } from "@angular/router";
import { CommonModule } from "@angular/common";
import { AuthManagementService } from "../../_services/auth/auth.management.service";

@Component({
  selector: "app-nav",
  standalone: true,
  imports: [MatToolbarModule, MatIconModule, MatButtonModule, CommonModule],
  templateUrl: "./nav.component.html",
  styleUrl: "./nav.component.scss",
})
export class NavComponent implements OnInit {
  isUserLoggedIn: boolean = false;
  logoPath: string = "assets/images/itembox_logo.png";
  constructor(
    private router: Router,
    private authManager: AuthManagementService,
  ) {}
  goToUrl(url: string) {
    this.router.navigateByUrl(url);
  }
  doLogout() {
    this.authManager.doLogout();
  }
  ngOnInit(): void {
    this.isUserLoggedIn = this.authManager.getUserLoggedIn();
    this.authManager.isUserLoggedInStatus.subscribe((result) => {
      console.log("isUserLoggedIn changed the current value: ", result);
      this.isUserLoggedIn = result;
    });
  }
}
