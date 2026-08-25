package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FeatureSet$RepeatedFieldEncoding implements w.a {
    REPEATED_FIELD_ENCODING_UNKNOWN(0),
    PACKED(1),
    EXPANDED(2);

    public static final int EXPANDED_VALUE = 2;
    public static final int PACKED_VALUE = 1;
    public static final int REPEATED_FIELD_ENCODING_UNKNOWN_VALUE = 0;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$RepeatedFieldEncoding.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7546a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FeatureSet$RepeatedFieldEncoding.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FeatureSet$RepeatedFieldEncoding(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FeatureSet$RepeatedFieldEncoding forNumber(int i5) {
        if (i5 == 0) {
            return REPEATED_FIELD_ENCODING_UNKNOWN;
        }
        if (i5 == 1) {
            return PACKED;
        }
        if (i5 != 2) {
            return null;
        }
        return EXPANDED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7546a;
    }

    @Deprecated
    public static DescriptorProtos$FeatureSet$RepeatedFieldEncoding valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
