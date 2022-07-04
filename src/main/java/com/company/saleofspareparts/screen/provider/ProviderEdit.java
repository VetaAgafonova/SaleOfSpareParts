package com.company.saleofspareparts.screen.provider;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Provider;

@UiController("Provider.edit")
@UiDescriptor("provider-edit.xml")
@EditedEntityContainer("providerDc")
public class ProviderEdit extends StandardEditor<Provider> {
}