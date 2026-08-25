package com.google.api;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum Property$PropertyType implements y.c {
    UNSPECIFIED(0),
    INT64(1),
    BOOL(2),
    STRING(3),
    DOUBLE(4),
    UNRECOGNIZED(-1);

    public static final int BOOL_VALUE = 2;
    public static final int DOUBLE_VALUE = 4;
    public static final int INT64_VALUE = 1;
    public static final int STRING_VALUE = 3;
    public static final int UNSPECIFIED_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.api.Property$PropertyType.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Property$PropertyType findValueByNumber(int i) {
            return Property$PropertyType.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return Property$PropertyType.forNumber(i) != null;
        }
    }

    Property$PropertyType(int i) {
        this.value = i;
    }

    public static Property$PropertyType forNumber(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return INT64;
        }
        if (i == 2) {
            return BOOL;
        }
        if (i == 3) {
            return STRING;
        }
        if (i != 4) {
            return null;
        }
        return DOUBLE;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static Property$PropertyType valueOf(int i) {
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
