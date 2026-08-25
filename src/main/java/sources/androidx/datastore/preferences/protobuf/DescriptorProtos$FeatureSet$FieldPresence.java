package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FeatureSet$FieldPresence implements w.a {
    FIELD_PRESENCE_UNKNOWN(0),
    EXPLICIT(1),
    IMPLICIT(2),
    LEGACY_REQUIRED(3);

    public static final int EXPLICIT_VALUE = 1;
    public static final int FIELD_PRESENCE_UNKNOWN_VALUE = 0;
    public static final int IMPLICIT_VALUE = 2;
    public static final int LEGACY_REQUIRED_VALUE = 3;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$FieldPresence.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7543a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FeatureSet$FieldPresence.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FeatureSet$FieldPresence(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FeatureSet$FieldPresence forNumber(int i5) {
        if (i5 == 0) {
            return FIELD_PRESENCE_UNKNOWN;
        }
        if (i5 == 1) {
            return EXPLICIT;
        }
        if (i5 == 2) {
            return IMPLICIT;
        }
        if (i5 != 3) {
            return null;
        }
        return LEGACY_REQUIRED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7543a;
    }

    @Deprecated
    public static DescriptorProtos$FeatureSet$FieldPresence valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
