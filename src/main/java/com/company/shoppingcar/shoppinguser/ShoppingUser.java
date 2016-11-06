/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.shoppinguser;

import com.company.shoppingcar.role.Role;
import com.company.shoppingcar.order.ShoopingOrder;
import com.company.shoppingcar.company.Company;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juan.grisales
 */
@Entity
@Table(name = "shopping_user")
@NamedQueries({
    @NamedQuery(name = "ShoppingUser.findAll", query = "SELECT s FROM ShoppingUser s")})
public class ShoppingUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "identification_number")
    private String identificationNumber;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payoff")
    private String payoff;
    
    @Column(name = "payoff_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payoffDate;
    
    @JoinColumn(name = "Role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Role roleid;
    
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingUserId")
    private Collection<ShoopingOrder> shoopingOrderCollection;

    public ShoppingUser() {
    }

    public ShoppingUser(Integer id) {
        this.id = id;
    }

    public ShoppingUser(Integer id, String identificationNumber, String email, String password, String payoff) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.password = password;
        this.payoff = payoff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayoff() {
        return payoff;
    }

    public void setPayoff(String payoff) {
        this.payoff = payoff;
    }

    public Date getPayoffDate() {
        return payoffDate;
    }

    public void setPayoffDate(Date payoffDate) {
        this.payoffDate = payoffDate;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Collection<ShoopingOrder> getShoopingOrderCollection() {
        return shoopingOrderCollection;
    }

    public void setShoopingOrderCollection(Collection<ShoopingOrder> shoopingOrderCollection) {
        this.shoopingOrderCollection = shoopingOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingUser)) {
            return false;
        }
        ShoppingUser other = (ShoppingUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.shoppingcar.ShoppingUser[ id=" + id + " ]";
    }
    
}
