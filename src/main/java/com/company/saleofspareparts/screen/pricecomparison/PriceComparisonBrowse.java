package com.company.saleofspareparts.screen.pricecomparison;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.PriceComparison;

@UiController("PriceComparison.browse")
@UiDescriptor("price-comparison-browse.xml")
@LookupComponent("priceComparisonsTable")
public class PriceComparisonBrowse extends StandardLookup<PriceComparison> {
}