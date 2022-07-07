package com.company.saleofspareparts.app;

import com.company.saleofspareparts.entity.PositionForSale;
import com.company.saleofspareparts.entity.Purchase;
import com.company.saleofspareparts.screen.purchase.PurchaseEdit;
import io.jmix.core.DataManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {
    @Autowired
    private DataManager dataManager;
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PurchaseEdit.class);

    public void amountCheck(List <PositionForSale> positions, int amountForSale){
        for(PositionForSale element : positions) {
            log.info("PurchaseServiceFor");
            if(element.getAmount()<amountForSale){
                throw new RuntimeException("Amount error");
            }
        }

    }

    Purchase loadById(UUID purchaseId) {
        return dataManager.load(Purchase.class)
                .id(purchaseId)
                .one();
    }
    PositionForSale savePositionForSale(PositionForSale entity) {
        return dataManager.save(entity);
    }

    public void amountReduction(UUID purchaseId){
        //log.info("PurchaseService");
        Purchase purchase = loadById(purchaseId);

        int a = purchase.getAmount();
        int newAmount;
        List <PositionForSale> positions = purchase.getPositionsForSale();

        for(PositionForSale element : positions) {
            //log.info("PurchaseServiceFor");
            newAmount = element.getAmount() - a;
            element.setAmount(newAmount);
            savePositionForSale(element);
        }

    }
}