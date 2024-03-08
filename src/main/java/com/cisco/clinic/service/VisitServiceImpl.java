package com.cisco.clinic.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.clinic.model.Visit;
import com.cisco.clinic.repo.VisitRepository;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public Visit getVisitById(int id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    @Override
    public void deleteVisitById(int id) {
        visitRepository.deleteById(id);
    }
}
