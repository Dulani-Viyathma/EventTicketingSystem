
import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../web-socket.service';

@Component({
  selector: 'app-ticket-display',
  templateUrl: './ticket-display.component.html',
  styleUrls: ['./ticket-display.component.css']
})
export class TicketDisplayComponent implements OnInit {
  tickets: any[] = [];

  constructor(private webSocketService: WebSocketService) {}

  ngOnInit() {
    this.webSocketService.connect();
    this.webSocketService.getTickets().subscribe((ticket: any) => {
      console.log('Received ticket: ', ticket); // Debugging line
      this.tickets.push(ticket);
    });
  }
}
