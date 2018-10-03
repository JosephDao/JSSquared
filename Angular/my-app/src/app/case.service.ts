import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Case } from './case';
import { UrlService } from './url.service';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class CaseService {
  
  private casesUrl = this.url.getUrl()+'admin';

  constructor(private http: HttpClient, private url:UrlService, private auth:AuthService) { 
  }

  getCases (): Observable<Case[]> {

    if(+this.auth.getIsAdmin() == 0)
      return this.http.get<Case[]>(this.casesUrl+ '/' + this.auth.getId());

    return this.http.get<Case[]>(this.casesUrl);
  }

}
