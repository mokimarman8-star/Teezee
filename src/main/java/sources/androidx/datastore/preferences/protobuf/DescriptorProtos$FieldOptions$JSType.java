package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FieldOptions$JSType implements w.a {
    JS_NORMAL(0),
    JS_STRING(1),
    JS_NUMBER(2);

    public static final int JS_NORMAL_VALUE = 0;
    public static final int JS_NUMBER_VALUE = 2;
    public static final int JS_STRING_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$JSType.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7551a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FieldOptions$JSType.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FieldOptions$JSType(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FieldOptions$JSType forNumber(int i5) {
        if (i5 == 0) {
            return JS_NORMAL;
        }
        if (i5 == 1) {
            return JS_STRING;
        }
        if (i5 != 2) {
            return null;
        }
        return JS_NUMBER;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7551a;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$JSType valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
