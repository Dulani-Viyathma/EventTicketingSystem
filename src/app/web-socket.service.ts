import { Injectable } from '@angular/core';
import { StompService } from '@stomp/ng2-stompjs';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private StompClient: any;

  constructor(private stompService: StompService) {}

  connect(): void {
    try {
      this.StompClient = this.stompService.configure({
        brokerURL: 'http://localhost:8080/websocket',
        connectHeaders: {},
        heartbeatIncoming: 0,
        heartbeatOutgoing: 200,
        reconnectDelay: 5000,
      });
      this.stompService.activate();
      console.log('WebSocket Connected');
    } catch (error) {
      console.log('Error:', error);
    }
  }

  getTickets(): Observable<any> {
    return new Observable(observer => {
      this.stompService.subscribe('/topic/tickets').subscribe(message => {
        observer.next(JSON.parse(message.body));
      });
    });
  }

  getLogs(): Observable<string> {
    return new Observable(observer => {
      this.stompService.subscribe('/topic/logs').subscribe(message => {
        observer.next(message.body);
      });
    });
  }
}
