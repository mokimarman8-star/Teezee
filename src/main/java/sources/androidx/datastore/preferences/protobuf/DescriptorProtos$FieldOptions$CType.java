package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$FieldOptions$CType implements w.a {
    STRING(0),
    CORD(1),
    STRING_PIECE(2);

    public static final int CORD_VALUE = 1;
    public static final int STRING_PIECE_VALUE = 2;
    public static final int STRING_VALUE = 0;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$FieldOptions$CType.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7550a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$FieldOptions$CType.forNumber(i5) != null;
        }
    }

    DescriptorProtos$FieldOptions$CType(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$FieldOptions$CType forNumber(int i5) {
        if (i5 == 0) {
            return STRING;
        }
        if (i5 == 1) {
            return CORD;
        }
        if (i5 != 2) {
            return null;
        }
        return STRING_PIECE;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7550a;
    }

    @Deprecated
    public static DescriptorProtos$FieldOptions$CType valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
