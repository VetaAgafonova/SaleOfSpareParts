package com.company.saleofspareparts.screen.provider;

import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.Provider;

@UiController("Provider.browse")
@UiDescriptor("provider-browse.xml")
@LookupComponent("providersTable")
public class ProviderBrowse extends StandardLookup<Provider> {
}