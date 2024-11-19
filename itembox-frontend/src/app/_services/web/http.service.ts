import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { LoginInterface } from "../../models/model.login";
import { API_URL_BASE, API_AUTH_BASE } from "../../shared/constants";

@Injectable({
  providedIn: "root",
})
export class HttpService {
  httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  postGenerateJwtToken(loginCredentials: LoginInterface) {
    const url: string = API_URL_BASE + API_AUTH_BASE + "/login";
    return this.httpClient.post<any>(url, loginCredentials);
  }
}
