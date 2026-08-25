package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FeatureSet$EnumType implements w.a {
    ENUM_TYPE_UNKNOWN(0),
    OPEN(1),
    CLOSED(2);

    public static final int CLOSED_VALUE = 2;
    public static final int ENUM_TYPE_UNKNOWN_VALUE = 0;
    public static final int OPEN_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$EnumType.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7542a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FeatureSet$EnumType.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FeatureSet$EnumType(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FeatureSet$EnumType forNumber(int i5) {
        if (i5 == 0) {
            return ENUM_TYPE_UNKNOWN;
        }
        if (i5 == 1) {
            return OPEN;
        }
        if (i5 != 2) {
            return null;
        }
        return CLOSED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7542a;
    }

    @Deprecated
    public static DescriptorProtos$FeatureSet$EnumType valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
