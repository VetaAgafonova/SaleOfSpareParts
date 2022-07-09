package com.company.saleofspareparts.screen.purchase;

import com.company.saleofspareparts.app.PurchaseService;
import io.jmix.ui.Dialogs;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;


@UiController("Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
public class PurchaseEdit extends StandardEditor<Purchase> {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private MessageBundle messageBundle;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Purchase purchase = getEditedEntity();
        if(!purchaseService.amountCheck(purchase)){
            event.preventCommit();
            dialogs.createMessageDialog().withCaption(messageBundle.getMessage("Error")).withMessage(messageBundle.getMessage("Change")).show();
        }
        
    }
}