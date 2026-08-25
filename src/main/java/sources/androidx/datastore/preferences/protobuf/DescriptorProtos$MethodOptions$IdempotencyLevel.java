package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$MethodOptions$IdempotencyLevel implements w.a {
    IDEMPOTENCY_UNKNOWN(0),
    NO_SIDE_EFFECTS(1),
    IDEMPOTENT(2);

    public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
    public static final int IDEMPOTENT_VALUE = 2;
    public static final int NO_SIDE_EFFECTS_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7556a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$MethodOptions$IdempotencyLevel.forNumber(i5) != null;
        }
    }

    DescriptorProtos$MethodOptions$IdempotencyLevel(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel forNumber(int i5) {
        if (i5 == 0) {
            return IDEMPOTENCY_UNKNOWN;
        }
        if (i5 == 1) {
            return NO_SIDE_EFFECTS;
        }
        if (i5 != 2) {
            return null;
        }
        return IDEMPOTENT;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7556a;
    }

    @Deprecated
    public static DescriptorProtos$MethodOptions$IdempotencyLevel valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
