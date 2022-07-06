package com.company.saleofspareparts.entity;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.util.UUID;

@JmixEntity
public class PriceComparison {

    @JmixId
    private UUID detailId;

    private String detailName;

    private String providersName;

    private Integer price;

    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProvidersName() {
        return providersName;
    }

    public void setProvidersName(String providersName) {
        this.providersName = providersName;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public UUID getDetailId() {
        return detailId;
    }

    //public UUID getId() {
    //    return detailId;
    //}

    public void setDetailId(UUID detailId) {
        this.detailId = detailId;
    }
}