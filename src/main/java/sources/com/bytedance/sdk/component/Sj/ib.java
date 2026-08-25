package com.bytedance.sdk.component.Sj;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum ib {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
