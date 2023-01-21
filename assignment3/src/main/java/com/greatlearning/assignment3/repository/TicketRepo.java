package com.greatlearning.assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.assignment3.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

	//Custom query
	 @Query(value = "select * from ticket t where t.title like %:keyword% or t.short_desc like %:keyword%", nativeQuery = true)
	 List<Ticket> findByKeyword(@Param("keyword") String keyword);
}
