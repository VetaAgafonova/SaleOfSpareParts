package com.company.saleofspareparts.app;

import com.company.saleofspareparts.entity.PriceComparison;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompareService {
    @Autowired
    private DataManager dataManager;

    //public List<PriceComparison> fetchPriceComparison(){

    //}
}