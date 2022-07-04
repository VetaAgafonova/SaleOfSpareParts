package com.company.saleofspareparts.screen.purchase;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;

@UiController("Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
public class PurchaseEdit extends StandardEditor<Purchase> {
}