package com.company.saleofspareparts.screen.purchase;

import com.company.saleofspareparts.app.PurchaseService;
import com.company.saleofspareparts.entity.PositionForSale;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Collapsable;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

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

    @Subscribe
    public void onInitEntity(InitEntityEvent<Purchase> event) {
        idEntity = event.getEntity().getId();
    }

    @Subscribe(id = "purchaseDc", target = Target.DATA_CONTAINER)
    public void onPurchaseDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Purchase> event) {
        positions =  event.getItem().getPositionsForSale();
        amountPurchase = event.getItem().getAmount();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        log.info("onBeforeCommitChanges");
        purchaseService.amountCheck(positions, amountPurchase);
        log.info("onBeforeCommitChanges");
    }

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        purchaseService.amountReduction(idEntity);
    }

}