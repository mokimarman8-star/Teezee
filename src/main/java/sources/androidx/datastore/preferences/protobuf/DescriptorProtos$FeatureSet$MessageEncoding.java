package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FeatureSet$MessageEncoding implements w.a {
    MESSAGE_ENCODING_UNKNOWN(0),
    LENGTH_PREFIXED(1),
    DELIMITED(2);

    public static final int DELIMITED_VALUE = 2;
    public static final int LENGTH_PREFIXED_VALUE = 1;
    public static final int MESSAGE_ENCODING_UNKNOWN_VALUE = 0;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FeatureSet$MessageEncoding.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7545a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FeatureSet$MessageEncoding.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FeatureSet$MessageEncoding(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FeatureSet$MessageEncoding forNumber(int i5) {
        if (i5 == 0) {
            return MESSAGE_ENCODING_UNKNOWN;
        }
        if (i5 == 1) {
            return LENGTH_PREFIXED;
        }
        if (i5 != 2) {
            return null;
        }
        return DELIMITED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7545a;
    }

    @Deprecated
    public static DescriptorProtos$FeatureSet$MessageEncoding valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
