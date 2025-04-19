import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../web-socket.service';

@Component({
  selector: 'app-log-display',
  templateUrl: './log-display.component.html',
  styleUrls: ['./log-display.component.css']
})
export class LogDisplayComponent implements OnInit {
  logs: string[] = [];

  constructor(private webSocketService: WebSocketService) {}

  ngOnInit() {
    this.webSocketService.getLogs().subscribe((log: string) => {
      this.logs.push(log);
    });
  }
}

