import { Component, OnInit } from '@angular/core';
import {SessionModel} from './sessionModel';
import {SessionDataService} from '../session-data.service';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.scss']
})

export class SessionComponent implements OnInit {
  selectedSession :SessionModel =null;
  auSessions:SessionModel[];
  EditorSession:SessionModel= null;


  constructor(private service:SessionDataService) { 
    this.auSessions=this.service.getSessionList();
  }
  

  ngOnInit(): void {
  }

  showDetails(selectedSesion:SessionModel){
    this.selectedSession = selectedSesion;
  }

  editSession(EditorSession:SessionModel){
    this.EditorSession=EditorSession;
  }
  AddingSession:SessionModel=null;
  addSession(){
    this.AddingSession = new SessionModel();
    this.DeletingSession=null;
  }

  EditSessionInfo(event:any){
    this.EditorSession.name=event.target.EditorSessionName.value;
    this.EditorSession.trainer=event.target.EditorSessionTrainer.value;
    this.EditorSession.date=event.target.EditorSessionDate.value;
    this.EditorSession=null;
    console.log(this.auSessions);
  }
  addSessionInfo(event:any){
    this.AddingSession.id=this.auSessions.length+1;
    this.AddingSession.name=event.target.AddSessionName.value;
    this.AddingSession.trainer=event.target.AddSessionTrainer.value;
    this.AddingSession.date=event.target.AddSessionDate.value;
    this.auSessions.push(this.AddingSession);
    console.log(this.auSessions);
    this.AddingSession=null;
  }
  DeletingSession:SessionModel;
  DeleteSession(){
    this.DeletingSession=new SessionModel();
    this.AddingSession=null;
  }
  deleteSessionInfo(session:SessionModel){
    this.auSessions.splice(this.auSessions.indexOf(session),1);
    this.DeletingSession=null;

  }
  /*getApiValue(){
    this.data.getData().subscribe((item)=>{
    console.log(item);
    this.apidata=item;
    
  });
  }
  getApiValueFor(a:string){
    this.data.getDataFor(a).subscribe((item)=>{
      console.log(item);
      this.apidatafor=item;
      
    });
  }*/

}
