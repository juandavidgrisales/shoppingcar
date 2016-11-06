/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.orderhasproducts;

import com.company.shoppingcar.order.ShoopingOrder;
import com.company.shoppingcar.product.Product;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author juan.grisales
 */
@Entity
@Table(name = "order_has_products")
@NamedQueries({
    @NamedQuery(name = "OrderHasProducts.findAll", query = "SELECT o FROM OrderHasProducts o")})
public class OrderHasProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected OrderHasProductsPK orderHasProductsPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "amount")
    private String amount;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "specifications")
    private String specifications;
    
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    
    @JoinColumn(name = "shooping_order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ShoopingOrder shoopingOrder;

    public OrderHasProducts() {
    }

    public OrderHasProducts(OrderHasProductsPK orderHasProductsPK) {
        this.orderHasProductsPK = orderHasProductsPK;
    }

    public OrderHasProducts(OrderHasProductsPK orderHasProductsPK, String amount, String specifications) {
        this.orderHasProductsPK = orderHasProductsPK;
        this.amount = amount;
        this.specifications = specifications;
    }

    public OrderHasProducts(int productId, int shoopingOrderId) {
        this.orderHasProductsPK = new OrderHasProductsPK(productId, shoopingOrderId);
    }

    public OrderHasProductsPK getOrderHasProductsPK() {
        return orderHasProductsPK;
    }

    public void setOrderHasProductsPK(OrderHasProductsPK orderHasProductsPK) {
        this.orderHasProductsPK = orderHasProductsPK;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoopingOrder getShoopingOrder() {
        return shoopingOrder;
    }

    public void setShoopingOrder(ShoopingOrder shoopingOrder) {
        this.shoopingOrder = shoopingOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHasProductsPK != null ? orderHasProductsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasProducts)) {
            return false;
        }
        OrderHasProducts other = (OrderHasProducts) object;
        if ((this.orderHasProductsPK == null && other.orderHasProductsPK != null) || (this.orderHasProductsPK != null && !this.orderHasProductsPK.equals(other.orderHasProductsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.shoppingcar.OrderHasProducts[ orderHasProductsPK=" + orderHasProductsPK + " ]";
    }
    
}
