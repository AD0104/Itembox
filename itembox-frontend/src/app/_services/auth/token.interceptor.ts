import { HttpInterceptorFn } from "@angular/common/http";
import { inject } from "@angular/core";
import { Router } from "@angular/router";
import { jwtDecode } from "jwt-decode";
import { TOKEN_NAME } from "../../shared/constants";

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  console.log("Request Intercepted");
  const token = localStorage.getItem(TOKEN_NAME);
  let router = inject(Router);
  if (token) {
    let tokenDecoded = jwtDecode(token);
    const isExpired =
      tokenDecoded && tokenDecoded.exp
        ? tokenDecoded.exp < Date.now() / 1000
        : false;
    if (isExpired) {
      console.log("User Token Is Expired");
      localStorage.removeItem(TOKEN_NAME);
      router.navigateByUrl("/login");
    } else {
      console.log("User Token Available");
    }
  } else {
    console.log("No Token Found");
    router.navigateByUrl("/login");
  }
  return next(req);
};
