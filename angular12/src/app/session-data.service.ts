import { Injectable } from '@angular/core';
import {SessionModel} from './session/sessionModel'
@Injectable({
  providedIn: 'root'
})
export class SessionDataService {
  maxId:number=2;
  sessionList:SessionModel[]=[
    {
      id:1,
      name:"Javascript",
      trainer:"anushree ",
      date:"11-Jan-2021"

    },
    {
      id:2,
      name:"Angular",
      trainer:"sharanya mahesheka ",
      date:"13-Jan-2021"

    },

  ];

  constructor() {

   }
   getSessionList(){
    return this.sessionList;
  }
  getSessionDetails(id){
    for (let index = 0; index < SessionModel.length; index++) {
      if(SessionModel[index].id==id)
      return SessionModel[index];
    }
    return null;
  }
  add(){

  }
  deleteSession(){

  }
  editSession(){

  }
}
