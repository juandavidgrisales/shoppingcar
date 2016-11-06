/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.company;

import com.company.shoppingcar.utils.exceptions.BadRequestException;
import com.company.shoppingcar.utils.exceptions.NotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan.grisales
 */
@Service
@Transactional
public class CompanyService {
    
    @Autowired
    private ICompanyRepository companyRepository;
    
    /**
     * Create a new company.
     *
     * @param company en la base de datos
     * @return El company con la información de creación completa.
     */
    
    public Company create (Company company) {
        return companyRepository.save(company);
    }
    
    /**
     * Find a company by name
     *
     * @param description of company
     * @return the company found by name
     * 
     * @throws com.company.shoppingcar.utils.exceptions.BadRequestException
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     */
    
    public Company findByDescription (String description)  throws BadRequestException, NotFoundException {
        Company company;

        try {
            company = companyRepository.findByDescription(description);
        } catch (NumberFormatException e) { 
            throw new BadRequestException();
        }

        if (company != null) {
            return company;
        } else {
            throw new NotFoundException();
        }
    }
    
    /**
     * Find a company by identification number
     *
     * @param id company identification number
     * @return the company found by identification number
     * 
     * @throws com.company.shoppingcar.utils.exceptions.BadRequestException
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     */
    
    public Company findById (Integer id)  throws BadRequestException, NotFoundException {
        Company company;

        try {
            company = companyRepository.findOne(id);
        } catch (NumberFormatException exception) {
            throw new BadRequestException();
        }

        if (company != null) {
            return company;
        } else {
            throw new NotFoundException();
        }
    }
    
    /**
     * ver todos los companys en la base de datos
     *
     * @param index
     * @param size
     * @param direccion
     * @param orden
     * 
     * @return todos los company en base de datos
     * 
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     */
    
    public Iterable<Company> getAll (Integer index, Integer size, String direccion, String orden) throws NotFoundException {
        
        if(index != null && size != null){
            
            PageRequest page;
            
            if(("ASC".equals(direccion) || "DESC".equals(direccion)) && orden != null && !"".equals(orden) ){
                Sort sort = new Sort(Sort.Direction.valueOf(direccion), orden);
                page = new PageRequest(index, size, sort); 
                return companyRepository.findAll(page);
            }else{                
                page = new PageRequest(index, size); 
                return companyRepository.findAll(page);              
            }
        }else{
            return companyRepository.findAll();    
        }
    }
    
    /**
     * delete a company if this exist
     *
     * @param id identification number of company to be deleted
     * 
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     * @throws com.company.shoppingcar.utils.exceptions.BadRequestException
     */
    
    public void delete (Integer id) throws NotFoundException, BadRequestException {

        Company company;

        try {
            company = companyRepository.findOne(id);
        } catch (NumberFormatException e) {
            throw new BadRequestException();
        }

        if (company != null) {
            companyRepository.delete(company);
        } else {
            throw new NotFoundException();
        }
    }
    
    /**
     * update the company
     *
     * @param company object which must to have its identification number
     * 
     * @throws com.company.shoppingcar.utils.exceptions.NotFoundException
     * @throws com.company.shoppingcar.utils.exceptions.BadRequestException
     */
    
    public void update (Company company) throws NotFoundException, BadRequestException {
        Company companyTemp;

        try {
            companyTemp = companyRepository.findOne(company.getId());
            if (companyTemp == null) {
                throw new NotFoundException();
            }
        } catch (NumberFormatException e) {
            throw new NotFoundException();
        }

            companyRepository.save(company);
    }
    
}
