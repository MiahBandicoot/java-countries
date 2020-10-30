package com.lambdaschool.javacountries.controllers;

import com.lambdaschool.javacountries.models.Countries;
import com.lambdaschool.javacountries.repositories.countryrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class countrycontroller {
    @Autowired
    countryrepository contrepo;

    private List<Countries>  findCountries(List<Countries> myList, CheckCountry tester)
    {
        List<Countries> tempList = new ArrayList<>();
        return tempList;
    }


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

    @GetMapping(value = "/countries/population/min/", produces = {"application/json"})
    public ResponseEntity<?> findByMin() {
        List<Countries> myList = new ArrayList<>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((countries1,countries2)->(int)(countries1.getPopulation()-countries2.getPopulation()))
        List<Countries> rtnList = myList.get(0)
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    @GetMapping(value = "/countries/population/total/", produces = {"application/json"})
    List<Countries> myList = new ArrayList<Long>(Arrays.asList(1, 2));
    Long total = Long.valueOf(0);
    for (countries c: myList)
    {
        total = total + c.population();
    }
    return new ResponseEntity<>();

    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> findMaxPopulation()
    {
        LIst<countries> myList=  new ArrayList<>();
        contrepo.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((countries1,countries2)->(int)(countries2.getPopulation()-countries1.getPopulation()))
        List<Countries> rtnList = myList.get(0)
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
}
