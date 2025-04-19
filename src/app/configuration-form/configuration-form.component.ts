import { Component } from '@angular/core';

@Component({
  selector: 'app-configuration-form',
  templateUrl: './configuration-form.component.html',
  styleUrls: ['./configuration-form.component.css']
})
export class ConfigurationFormComponent {
  config = {
    totalTickets: 0,
    ticketReleaseRate: 0,
    customerRetrievalRate: 0,
    maxTicketCapacity: 0
  };

  onSubmit() {
    console.log('Configuration submitted:', this.config);
    // Add logic to send this configuration to the backend
  }
}
