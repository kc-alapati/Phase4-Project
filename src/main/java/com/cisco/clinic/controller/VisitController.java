package com.cisco.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cisco.clinic.model.Visit;
import com.cisco.clinic.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<Void> addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Visit>> getAllVisits() {
        List<Visit> visits = visitService.getAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable int id) {
        Visit visit = visitService.getVisitById(id);
        if (visit != null) {
            return new ResponseEntity<>(visit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitById(@PathVariable int id) {
        Visit existingVisit = visitService.getVisitById(id);
        if (existingVisit != null) {
            visitService.deleteVisitById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
