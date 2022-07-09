package com.company.saleofspareparts.screen.positionforsale;

import com.company.saleofspareparts.app.CompareService;
import com.company.saleofspareparts.entity.Detail;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.saleofspareparts.entity.PositionForSale;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

@UiController("ComparePositionForSale.browse")
@UiDescriptor("compare-position-for-sale-browse.xml")
@LookupComponent("positionForSalesTable")
public class ComparePositionForSaleBrowse extends StandardLookup<PositionForSale> {
    Detail detailCompare = null;
    @Named("compareDL")
    private CollectionLoader<PositionForSale> compareDL;
    @Autowired
    private CompareService compareService;

    @Install(to = "compareDL", target = Target.DATA_LOADER)
    private List<PositionForSale> compareDLLoadDelegate(LoadContext<PositionForSale> loadContext) {
        return compareService.fetchPriceCompare(detailCompare);
    }

    @Subscribe("detailSelector")
    public void onDetailSelectorValueChange(HasValue.ValueChangeEvent<Detail> event) {
        detailCompare = event.getValue();
        compareDL.load();
    }
}