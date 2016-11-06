/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.shoppingcar.orderhasproducts;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juan.grisales
 */
@Embeddable
public class OrderHasProductsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "shooping_order_id")
    private int shoopingOrderId;

    public OrderHasProductsPK() {
    }

    public OrderHasProductsPK(int productId, int shoopingOrderId) {
        this.productId = productId;
        this.shoopingOrderId = shoopingOrderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShoopingOrderId() {
        return shoopingOrderId;
    }

    public void setShoopingOrderId(int shoopingOrderId) {
        this.shoopingOrderId = shoopingOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) shoopingOrderId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasProductsPK)) {
            return false;
        }
        OrderHasProductsPK other = (OrderHasProductsPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.shoopingOrderId != other.shoopingOrderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.shoppingcar.OrderHasProductsPK[ productId=" + productId + ", shoopingOrderId=" + shoopingOrderId + " ]";
    }
    
}
