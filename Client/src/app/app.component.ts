import { Component } from '@angular/core';
import { WebSocketAPI } from './WebSocketAPI';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';


  webSocketAPI: WebSocketAPI;
  greeting: any;
  name: string;
  list:any = [];
  mylist:any = [
    "asf",
    "sdfsdf",
    "sdfsdf",
  ]
  
  
  constructor(websocket : WebSocketAPI)
  {
      this.webSocketAPI = websocket;
  }
  ngOnInit() {
    //this.webSocketAPI = new WebSocketAPI();
  }

  connect(){
    this.webSocketAPI._connect();
  }

  disconnect(){
    this.webSocketAPI._disconnect();
  }


  resolveAfter2Seconds(x) {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(x);
      }, 100);
    });
  }
  sendMessage(){
    this.webSocketAPI._send(this.name);
    this.resolveAfter2Seconds(20).then(value => {
      this.list = this.webSocketAPI.list;
      console.log("Message From me: ",this.list[0]);
      
    }) 
  }

  // handleMessage(message){
  //   this.greeting = message;
  // }
}
