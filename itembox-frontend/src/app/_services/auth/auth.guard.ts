import { inject } from "@angular/core";
import { CanActivateFn, Router } from "@angular/router";
import { TOKEN_NAME } from "../../shared/constants";
import { jwtDecode } from "jwt-decode";

export const authGuard: CanActivateFn = () => {
  const router = inject(Router);
  const token = localStorage.getItem(TOKEN_NAME);
  if (token != null) {
    let tokenDecoded = jwtDecode(token);
    const isTokenExpired =
      tokenDecoded && tokenDecoded.exp
        ? tokenDecoded.exp < Date.now() / 1000
        : false;
    if (!isTokenExpired) return true;
    localStorage.removeItem(TOKEN_NAME);
    router.navigateByUrl("/login");
    return false;
  } else {
    router.navigateByUrl("/login");
    return false;
  }
};
