package com.amazonaws.services.s3.model.inventory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum InventoryFrequency {
    Daily("Daily"),
    Weekly("Weekly");

    private final String frequency;

    InventoryFrequency(String str) {
        this.frequency = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.frequency;
    }
}
