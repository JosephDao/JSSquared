import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { UrlService } from '../url.service';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {
  private headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
  constructor(private http: HttpClient,private url: UrlService) { }

  submitForm(firstname, lastname, birthdate, rating, socialw, placement){
    const body = `firstname=${firstname}&lastname=${lastname}&birthdate=${birthdate}&rating=${rating}&socialId=${socialw}&placementId=${placement}`;
    return this.http.post(this.url.getUrl()+'createcase', body, {headers: this.headers})
  }

  updateForm(newcase:Object){
    
    return this.http.put(this.url.getUrl()+'createcase',newcase);
  }
}


