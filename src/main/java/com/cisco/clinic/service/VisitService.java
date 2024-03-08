package com.cisco.clinic.service;

import java.util.List;

import com.cisco.clinic.model.Visit;

public interface VisitService {

	List<Visit> getAllVisits();
	Visit getVisitById(int id);
	void addVisit(Visit visit);
	void deleteVisitById(int id);
}
