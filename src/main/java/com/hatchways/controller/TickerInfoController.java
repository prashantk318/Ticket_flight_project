package com.hatchways.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hatchways.entity.TicketInfo;
import com.hatchways.exception.TicketNotFoundException;
import com.hatchways.repository.TicketRepository;
import com.hatchways.response.ResponseHandler;




@RestController
@RequestMapping("/api")
public class TickerInfoController {

	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping("/tickets")
	public List<TicketInfo>getTickets(){
		return ticketRepository.getticketInfo();
	}
	
	@GetMapping("/tickets/{theId}")
	public TicketInfo retriveTicket(@PathVariable Integer theId){
		TicketInfo ticket = ticketRepository.getInfoById(theId);
		
		if(ticket==null) {
			throw new TicketNotFoundException("Id -" + theId);
		}
		return ticket;
	}
	
	@PostMapping("/tickets")
	public ResponseEntity<Map<String, String>> saveTicketInfo(@RequestBody TicketInfo saveTicket) {
		
		TicketInfo savedticket = ticketRepository.saveTicketInfo(saveTicket);
		
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedticket.getTicketId())
				 .toUri();
		 ResponseEntity<TicketInfo> response = ResponseEntity.created(location).build();
		
		 Map<String, String> map = new HashMap<>();
		 if(response !=null)
			 map.put("status", "success");
			 return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		 
		 
	}
	
	@PutMapping("/tickets/{theId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, String>> updateTicket(@PathVariable Integer theId, @RequestBody TicketInfo ticket) {
        TicketInfo savedticket = ticketRepository.getInfoById(theId);
        //TicketInfo savedtickets = ticketRepository.getInfoBySeatNo(seatNo);
        
        savedticket.setTicketId(theId);
        savedticket.setFlightDate(ticket.getFlightDate());
        savedticket.setFlightNumber(ticket.getFlightNumber());
        savedticket.setTickerCost(ticket.getTickerCost());
        savedticket.setSeatNumber(ticket.getSeatNumber());
        Integer id = ticket.getTicketId();
       // String seat = ticket.getSeatNumber();
        if(id == theId) {
        	return ResponseHandler.generateResponse("failed", "ticketId already Exist");
        }
       
     return null;
        
    }
}
