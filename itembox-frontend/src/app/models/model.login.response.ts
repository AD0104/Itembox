export interface LoginResponseInterface {
  code: number;
  message: string;
  data: {
    accessToken: string;
    tokenType: string;
  };
}
