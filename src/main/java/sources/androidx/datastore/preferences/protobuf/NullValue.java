package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum NullValue implements w.a {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);

    public static final int NULL_VALUE_VALUE = 0;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.NullValue.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7565a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return NullValue.forNumber(i5) != null;
        }
    }

    NullValue(int i5) {
        this.value = i5;
    }

    public static NullValue forNumber(int i5) {
        if (i5 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7565a;
    }

    @Deprecated
    public static NullValue valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
