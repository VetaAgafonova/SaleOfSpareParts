package com.company.saleofspareparts.app;

import com.company.saleofspareparts.entity.PositionForSale;
import com.company.saleofspareparts.entity.Purchase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    public boolean amountCheck(Purchase purchase){
        int purchaseAmount = purchase.getAmount();

        List <PositionForSale> positions = purchase.getPositionsForSale();
        for(PositionForSale element : positions)
            if(element.getAmount() < purchaseAmount)
                return false;

        for(PositionForSale element : positions)
            element.setAmount(element.getAmount() - purchaseAmount);
        return true;
    }

}