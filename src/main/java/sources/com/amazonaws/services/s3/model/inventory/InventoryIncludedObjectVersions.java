package com.amazonaws.services.s3.model.inventory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum InventoryIncludedObjectVersions {
    All("All"),
    Current("Current");

    private final String name;

    InventoryIncludedObjectVersions(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
