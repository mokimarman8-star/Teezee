package com.google.protobuf;

import com.google.protobuf.WireFormat;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class m {
    public abstract Object getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract s0 getMessageDefaultInstance();

    public abstract int getNumber();

    boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
