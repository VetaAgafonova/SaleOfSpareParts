package com.company.saleofspareparts.screen.positionforsale;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.PositionForSale;

@UiController("PositionForSale.edit")
@UiDescriptor("position-for-sale-edit.xml")
@EditedEntityContainer("positionForSaleDc")
public class PositionForSaleEdit extends StandardEditor<PositionForSale> {
}