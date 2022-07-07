package com.company.saleofspareparts.screen.purchase;

import com.company.saleofspareparts.app.PurchaseService;
import com.company.saleofspareparts.entity.PositionForSale;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Purchase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.UUID;

@UiController("Purchase.browse")
@UiDescriptor("purchase-browse.xml")
@LookupComponent("purchasesTable")
public class PurchaseBrowse extends StandardLookup<Purchase> {







}