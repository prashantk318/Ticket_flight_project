package com.hatchways.repository;

import java.util.List;

import com.hatchways.entity.TicketInfo;


public interface TicketRepository {
List<TicketInfo>getticketInfo();
public TicketInfo saveTicketInfo(TicketInfo ticketInfo);
public TicketInfo getInfoById(Integer id);
public TicketInfo getInfoBySeatNo(String seatNo);
}
