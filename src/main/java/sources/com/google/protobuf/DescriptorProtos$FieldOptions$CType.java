package com.google.protobuf;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum DescriptorProtos$FieldOptions$CType implements y.c {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    public static final int STRING_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.protobuf.DescriptorProtos$FieldOptions$CType.a
        @Override // com.google.protobuf.y.d
        public DescriptorProtos$FieldOptions$CType findValueByNumber(int i) {
            return DescriptorProtos$FieldOptions$CType.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e INSTANCE = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return DescriptorProtos$FieldOptions$CType.forNumber(i) != null;
        }
    }

    DescriptorProtos$FieldOptions$CType(int i) {
        this.value = i;
    }

    public static DescriptorProtos$FieldOptions$CType forNumber(int i) {
        if (i == 0) {
            return STRING;
        }
        if (i == 1) {
            return CORD;
        }
        if (i != 2) {
            return null;
        }
        return STRING_PIECE;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.INSTANCE;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$CType valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
