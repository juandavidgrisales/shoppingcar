/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.order;

import com.company.shoppingcar.orderhasproducts.OrderHasProducts;
import com.company.shoppingcar.shoppinguser.ShoppingUser;
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

/**
 *
 * @author juan.grisales
 */
@Entity
@Table(name = "shooping_order")
@NamedQueries({
    @NamedQuery(name = "ShoopingOrder.findAll", query = "SELECT s FROM ShoopingOrder s")})
public class ShoopingOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    @Column(name = "close_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closeDate;
    
    @JoinColumn(name = "shopping_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ShoppingUser shoppingUserId;
    
    @OneToMany(mappedBy = "mainOrderId")
    private Collection<ShoopingOrder> shoopingOrderCollection;
    
    @JoinColumn(name = "main_order_id", referencedColumnName = "id")
    @ManyToOne
    private ShoopingOrder mainOrderId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoopingOrder")
    private Collection<OrderHasProducts> orderHasProductsCollection;

    public ShoopingOrder() {
    }

    public ShoopingOrder(Integer id) {
        this.id = id;
    }

    public ShoopingOrder(Integer id, Date orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public ShoppingUser getShoppingUserId() {
        return shoppingUserId;
    }

    public void setShoppingUserId(ShoppingUser shoppingUserId) {
        this.shoppingUserId = shoppingUserId;
    }

    public Collection<ShoopingOrder> getShoopingOrderCollection() {
        return shoopingOrderCollection;
    }

    public void setShoopingOrderCollection(Collection<ShoopingOrder> shoopingOrderCollection) {
        this.shoopingOrderCollection = shoopingOrderCollection;
    }

    public ShoopingOrder getMainOrderId() {
        return mainOrderId;
    }

    public void setMainOrderId(ShoopingOrder mainOrderId) {
        this.mainOrderId = mainOrderId;
    }

    public Collection<OrderHasProducts> getOrderHasProductsCollection() {
        return orderHasProductsCollection;
    }

    public void setOrderHasProductsCollection(Collection<OrderHasProducts> orderHasProductsCollection) {
        this.orderHasProductsCollection = orderHasProductsCollection;
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
        if (!(object instanceof ShoopingOrder)) {
            return false;
        }
        ShoopingOrder other = (ShoopingOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.shoppingcar.ShoopingOrder[ id=" + id + " ]";
    }
    
}
