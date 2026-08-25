package com.google.api;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum LabelDescriptor$ValueType implements y.c {
    STRING(0),
    BOOL(1),
    INT64(2),
    UNRECOGNIZED(-1);

    public static final int BOOL_VALUE = 1;
    public static final int INT64_VALUE = 2;
    public static final int STRING_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.api.LabelDescriptor$ValueType.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LabelDescriptor$ValueType findValueByNumber(int i) {
            return LabelDescriptor$ValueType.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return LabelDescriptor$ValueType.forNumber(i) != null;
        }
    }

    LabelDescriptor$ValueType(int i) {
        this.value = i;
    }

    public static LabelDescriptor$ValueType forNumber(int i) {
        if (i == 0) {
            return STRING;
        }
        if (i == 1) {
            return BOOL;
        }
        if (i != 2) {
            return null;
        }
        return INT64;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static LabelDescriptor$ValueType valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
