package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class InventoryFilterPredicate implements Serializable {
    public abstract void accept(InventoryPredicateVisitor inventoryPredicateVisitor);
}
