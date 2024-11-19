import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./views/login/login.component";
import { MenuComponent } from "./views/menu/menu.component";
import { NgModule } from "@angular/core";
import { authGuard } from "./_services/auth/auth.guard";

export const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  { path: "menu", component: MenuComponent, canActivate: [authGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: "reload" })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
