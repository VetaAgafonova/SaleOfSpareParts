package com.company.saleofspareparts.screen.detail;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Detail;

@UiController("Detail.edit")
@UiDescriptor("detail-edit.xml")
@EditedEntityContainer("detailDc")
public class DetailEdit extends StandardEditor<Detail> {
}