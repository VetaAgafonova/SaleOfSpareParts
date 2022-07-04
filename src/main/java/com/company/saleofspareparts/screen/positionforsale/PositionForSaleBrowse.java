package com.company.saleofspareparts.screen.positionforsale;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.PositionForSale;

@UiController("PositionForSale.browse")
@UiDescriptor("position-for-sale-browse.xml")
@LookupComponent("positionForSalesTable")
public class PositionForSaleBrowse extends StandardLookup<PositionForSale> {
}