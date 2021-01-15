import { Component, OnInit } from '@angular/core';
import { ApiDataService } from '../api-data.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})

export class TodoComponent implements OnInit {
  
  constructor(public data:ApiDataService ) { 
    
  }

  ngOnInit(): void {
    this.getApiValue();
  }
  apidata:Object=null;
  apidatafor:Object = new Object();
 
  getApiValue(){
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
  }
}
