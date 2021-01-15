import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiDataService {

  constructor(private http:HttpClient) { 
    

  }
  getData() {
    const url = 'https://jsonplaceholder.typicode.com/todos';
    return this.http.get(url);
  }
  getDataFor(a:string) {
    const url = 'https://jsonplaceholder.typicode.com/todos'+'/'+a;
    return this.http.get(url);
  }
}
