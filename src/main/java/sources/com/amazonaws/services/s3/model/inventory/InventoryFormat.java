package com.amazonaws.services.s3.model.inventory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum InventoryFormat {
    CSV("CSV");

    private final String format;

    InventoryFormat(String str) {
        this.format = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.format;
    }
}
