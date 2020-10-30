package com.lambdaschool.javacountries.controllers;

import com.lambdaschool.javacountries.models.Countries;
import com.lambdaschool.javacountries.repositories.countryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class countrycontroller {
    @Autowired
    countryrepository contrepo;

    @GetMapping(value = "/countries/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries()
    {
        List<Countries> myList = new ArrayList<String>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/countries/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountriesName()
    {
        List<Countries> myList = new ArrayList<>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        Collections.sort(myList);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/countries/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> findByname(PathVariable char letter)
    {
        List<Countries> myList = new ArrayList<>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        List<Countries> rtnList = findCountries(myList, c->c.getname().charAt(0)==letter)
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/countries/population/total/", produces = {"application/json"})
    public ResponseEntity<?> findByname(PathVariable char letter)
    {
        List<Countries> myList = new ArrayList<>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        List<Countries> rtnList = findCountries(myList, c->c.getname().charAt(0)==letter)
        return new ResponseEntity<>(myList, HttpStatus.OK);
}
