package com.google.api;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum FieldBehavior implements y.c {
    FIELD_BEHAVIOR_UNSPECIFIED(0),
    OPTIONAL(1),
    REQUIRED(2),
    OUTPUT_ONLY(3),
    INPUT_ONLY(4),
    IMMUTABLE(5),
    UNRECOGNIZED(-1);

    public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
    public static final int IMMUTABLE_VALUE = 5;
    public static final int INPUT_ONLY_VALUE = 4;
    public static final int OPTIONAL_VALUE = 1;
    public static final int OUTPUT_ONLY_VALUE = 3;
    public static final int REQUIRED_VALUE = 2;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.api.FieldBehavior.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FieldBehavior findValueByNumber(int i) {
            return FieldBehavior.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return FieldBehavior.forNumber(i) != null;
        }
    }

    FieldBehavior(int i) {
        this.value = i;
    }

    public static FieldBehavior forNumber(int i) {
        if (i == 0) {
            return FIELD_BEHAVIOR_UNSPECIFIED;
        }
        if (i == 1) {
            return OPTIONAL;
        }
        if (i == 2) {
            return REQUIRED;
        }
        if (i == 3) {
            return OUTPUT_ONLY;
        }
        if (i == 4) {
            return INPUT_ONLY;
        }
        if (i != 5) {
            return null;
        }
        return IMMUTABLE;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static FieldBehavior valueOf(int i) {
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
