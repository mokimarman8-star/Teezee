package com.google.protobuf;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum DescriptorProtos$FieldOptions$JSType implements y.c {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);

    public static final int JS_NORMAL_VALUE = 0;
    public static final int JS_NUMBER_VALUE = 2;
    public static final int JS_STRING_VALUE = 1;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.protobuf.DescriptorProtos$FieldOptions$JSType.a
        @Override // com.google.protobuf.y.d
        public DescriptorProtos$FieldOptions$JSType findValueByNumber(int i) {
            return DescriptorProtos$FieldOptions$JSType.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e INSTANCE = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return DescriptorProtos$FieldOptions$JSType.forNumber(i) != null;
        }
    }

    DescriptorProtos$FieldOptions$JSType(int i) {
        this.value = i;
    }

    public static DescriptorProtos$FieldOptions$JSType forNumber(int i) {
        if (i == 0) {
            return JS_NORMAL;
        }
        if (i == 1) {
            return JS_STRING;
        }
        if (i != 2) {
            return null;
        }
        return JS_NUMBER;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.INSTANCE;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$JSType valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
