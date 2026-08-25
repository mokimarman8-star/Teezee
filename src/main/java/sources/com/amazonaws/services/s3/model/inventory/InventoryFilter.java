package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class InventoryFilter implements Serializable {
    private InventoryFilterPredicate predicate;

    public InventoryFilter() {
    }

    public InventoryFilter(InventoryFilterPredicate inventoryFilterPredicate) {
        this.predicate = inventoryFilterPredicate;
    }

    public InventoryFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(InventoryFilterPredicate inventoryFilterPredicate) {
        this.predicate = inventoryFilterPredicate;
    }

    public InventoryFilter withPredicate(InventoryFilterPredicate inventoryFilterPredicate) {
        setPredicate(inventoryFilterPredicate);
        return this;
    }
}
