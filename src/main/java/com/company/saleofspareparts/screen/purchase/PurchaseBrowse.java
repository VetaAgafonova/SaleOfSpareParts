package com.company.saleofspareparts.screen.purchase;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;

@UiController("Purchase.browse")
@UiDescriptor("purchase-browse.xml")
@LookupComponent("purchasesTable")
public class PurchaseBrowse extends StandardLookup<Purchase> {
}