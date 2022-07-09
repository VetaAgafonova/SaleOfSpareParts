package com.company.saleofspareparts.app;

import com.company.saleofspareparts.entity.Detail;
import com.company.saleofspareparts.entity.PositionForSale;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompareService {
    @Autowired
    private DataManager dataManager;

    public  List<PositionForSale> fetchPriceCompare(Detail det){
        List<PositionForSale> positions;
        if(det == null)
            positions = dataManager.load(PositionForSale.class).all().list();
        else
            positions = dataManager.load(PositionForSale.class )
                    .query("select c from PositionForSale c where c.details = :det")
                    .parameter("det", det)
                    .list();
        return positions;
    }
}