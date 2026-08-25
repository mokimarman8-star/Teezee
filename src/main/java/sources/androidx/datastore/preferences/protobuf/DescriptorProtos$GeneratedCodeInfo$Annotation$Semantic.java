package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic implements w.a {
    NONE(0),
    SET(1),
    ALIAS(2);

    public static final int ALIAS_VALUE = 2;
    public static final int NONE_VALUE = 0;
    public static final int SET_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7555a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic.forNumber(i5) != null;
        }
    }

    DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic forNumber(int i5) {
        if (i5 == 0) {
            return NONE;
        }
        if (i5 == 1) {
            return SET;
        }
        if (i5 != 2) {
            return null;
        }
        return ALIAS;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7555a;
    }

    @Deprecated
    public static DescriptorProtos$GeneratedCodeInfo$Annotation$Semantic valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
