package com.hatchways.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfo {
	
	private Integer ticketId;
	private LocalDate flightDate;
	private String flightNumber;
	private String seatNumber;
	private Integer tickerCost;
	
	

}
