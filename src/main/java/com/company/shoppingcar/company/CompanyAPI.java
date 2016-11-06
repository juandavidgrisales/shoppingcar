/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.company;

import com.company.shoppingcar.utils.exceptions.BadRequestException;
import com.company.shoppingcar.utils.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan.grisales
 */
@RestController
@RequestMapping("/company")
public class CompanyAPI {
    
    @Autowired
    private CompanyService companyService;
    
    /**
     * create a new company.
     *
     * @param company en la base de datos
     * @return El company con la información de creación completa.
     */
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Company create (@RequestBody Company company) {
        return companyService.create(company);
    }
    
    /**
     * find a company by name
     *
     * @param description - company name
     * @return company found by name
     * @throws com.company.shoppingcar.utils.exceptions.BadRequestException
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     */
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Company findByDescription (@RequestParam String description) throws BadRequestException, NotFoundException {
        return companyService.findByDescription(description);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Company findById (@PathVariable Integer id) throws BadRequestException, NotFoundException {
        return companyService.findById(id);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Company> getAll (@RequestParam(value = "index", required = false) Integer index, 
                                        @RequestParam(value = "size", required = false) Integer size, 
                                        @RequestParam(value = "direccion", required = false) String direccion, 
                                        @RequestParam(value = "orden", required = false) String orden) throws NotFoundException {
        return companyService.getAll(index, size, direccion, orden);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) throws NotFoundException, BadRequestException {
        companyService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update (@RequestBody Company company) throws NotFoundException, BadRequestException {
        companyService.update(company);
    }
    
}

