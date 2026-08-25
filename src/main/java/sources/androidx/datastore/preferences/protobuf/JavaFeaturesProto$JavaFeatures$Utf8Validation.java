package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum JavaFeaturesProto$JavaFeatures$Utf8Validation implements w.a {
    UTF8_VALIDATION_UNKNOWN(0),
    DEFAULT(1),
    VERIFY(2);

    public static final int DEFAULT_VALUE = 1;
    public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
    public static final int VERIFY_VALUE = 2;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.JavaFeaturesProto$JavaFeatures$Utf8Validation.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7564a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return JavaFeaturesProto$JavaFeatures$Utf8Validation.forNumber(i5) != null;
        }
    }

    JavaFeaturesProto$JavaFeatures$Utf8Validation(int i5) {
        this.value = i5;
    }

    public static JavaFeaturesProto$JavaFeatures$Utf8Validation forNumber(int i5) {
        if (i5 == 0) {
            return UTF8_VALIDATION_UNKNOWN;
        }
        if (i5 == 1) {
            return DEFAULT;
        }
        if (i5 != 2) {
            return null;
        }
        return VERIFY;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7564a;
    }

    @Deprecated
    public static JavaFeaturesProto$JavaFeatures$Utf8Validation valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
