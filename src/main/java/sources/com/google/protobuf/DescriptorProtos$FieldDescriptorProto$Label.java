package com.google.protobuf;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum DescriptorProtos$FieldDescriptorProto$Label implements y.c {
    LABEL_OPTIONAL(1),
    LABEL_REQUIRED(2),
    LABEL_REPEATED(3);

    public static final int LABEL_OPTIONAL_VALUE = 1;
    public static final int LABEL_REPEATED_VALUE = 3;
    public static final int LABEL_REQUIRED_VALUE = 2;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label.a
        @Override // com.google.protobuf.y.d
        public DescriptorProtos$FieldDescriptorProto$Label findValueByNumber(int i) {
            return DescriptorProtos$FieldDescriptorProto$Label.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e INSTANCE = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return DescriptorProtos$FieldDescriptorProto$Label.forNumber(i) != null;
        }
    }

    DescriptorProtos$FieldDescriptorProto$Label(int i) {
        this.value = i;
    }

    public static DescriptorProtos$FieldDescriptorProto$Label forNumber(int i) {
        if (i == 1) {
            return LABEL_OPTIONAL;
        }
        if (i == 2) {
            return LABEL_REQUIRED;
        }
        if (i != 3) {
            return null;
        }
        return LABEL_REPEATED;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.INSTANCE;
    }

    @Deprecated
    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
