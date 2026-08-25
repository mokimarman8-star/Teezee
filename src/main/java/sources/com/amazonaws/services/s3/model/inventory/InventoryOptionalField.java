package com.amazonaws.services.s3.model.inventory;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum InventoryOptionalField {
    Size("Size"),
    LastModifiedDate("LastModifiedDate"),
    StorageClass("StorageClass"),
    ETag("ETag"),
    IsMultipartUploaded("IsMultipartUploaded"),
    ReplicationStatus("ReplicationStatus");

    private final String field;

    InventoryOptionalField(String str) {
        this.field = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.field;
    }
}
