package com.company.saleofspareparts.screen.purchase;

import com.company.saleofspareparts.app.PurchaseService;
import com.company.saleofspareparts.entity.PositionForSale;
import io.jmix.ui.AppUI;
import io.jmix.ui.Dialogs;
import io.jmix.ui.component.Button;

import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@UiController("Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
public class PurchaseEdit extends StandardEditor<Purchase> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PurchaseEdit.class);
    UUID idEntity;
    List <PositionForSale> positions;
    int amountPurchase;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private Dialogs dialogs;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Purchase> event) {
        idEntity = event.getEntity().getId();
    }

    @Subscribe(id = "purchaseDc", target = Target.DATA_CONTAINER)
    public void onPurchaseDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Purchase> event) {
        positions =  event.getItem().getPositionsForSale();
        amountPurchase = event.getItem().getAmount();
    }
    AppUI context;
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        //try {
            purchaseService.amountCheck(positions, amountPurchase);
       /* }catch (RuntimeException e){
            dialogs.createExceptionDialog()
                    .withCaption("Alert")
                    .withMessage("Division by zero")
                    .withThrowable(e.fillInStackTrace())
                    .show();
            event.preventCommit();
        }
        */
    }

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        purchaseService.amountReduction(idEntity);
    }

}