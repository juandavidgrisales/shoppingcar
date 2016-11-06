/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.company;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan.grisales
 */
@Transactional
public interface ICompanyRepository extends CrudRepository<Company, Integer> {
    
    /**
     *
     * @param description
     * @return Company by name
     */
    public Company findByDescription (String description);
    
    /**
     *
     * @param page
     * @return Page of companies
     */
    public Page<Company> findAll (Pageable page);
    
}
