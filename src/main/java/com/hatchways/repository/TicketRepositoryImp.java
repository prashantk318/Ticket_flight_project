package com.hatchways.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.hatchways.entity.TicketInfo;



@Repository
public class TicketRepositoryImp implements TicketRepository{
	
	private static List<TicketInfo> list = new ArrayList<TicketInfo>();

	private static Integer ticketCount  = 3;
	// Add three customers
	static {
		list.add(new TicketInfo(1,LocalDate.parse("2021-05-02"),"AC1","A1",1000));
		list.add(new TicketInfo(1,LocalDate.parse("2021-05-02"),"AC1","A1",1000));
		list.add(new TicketInfo(1,LocalDate.parse("2021-05-02"),"AC1","A1",1000));

	}

	
	@Override
	public List<TicketInfo> getticketInfo() {
		return list;
	}

	@Override
	public TicketInfo saveTicketInfo(TicketInfo ticketInfo) {
		
		if(ticketInfo.getTicketId()==null) {
			ticketInfo.setTicketId(++ticketCount);
		}
		 list.add(ticketInfo);
		 return ticketInfo;
	}

	@Override
	public TicketInfo getInfoById(Integer id) {
		for(TicketInfo ticket: list) {
			if(ticket.getTicketId() == id) {
				return ticket;
			}
		}
		return null;
	}

	@Override
	public TicketInfo getInfoBySeatNo(String seatNo) {
		for(TicketInfo ticket: list) {
			if(ticket.getSeatNumber() == seatNo) {
				return ticket;
			}
		}
		return null;
	}
}
