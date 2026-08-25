package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum DescriptorProtos$ExtensionRangeOptions$VerificationState implements w.a {
    DECLARATION(0),
    UNVERIFIED(1);

    public static final int DECLARATION_VALUE = 0;
    public static final int UNVERIFIED_VALUE = 1;
    private static final w.b internalValueMap = new w.b() { // from class: androidx.datastore.preferences.protobuf.DescriptorProtos$ExtensionRangeOptions$VerificationState.a
    };
    private final int value;

    private static final class b implements w.c {

        /* renamed from: a, reason: collision with root package name */
        static final w.c f7541a = new b();

        private b() {
        }

        @Override // androidx.datastore.preferences.protobuf.w.c
        public boolean isInRange(int i5) {
            return DescriptorProtos$ExtensionRangeOptions$VerificationState.forNumber(i5) != null;
        }
    }

    DescriptorProtos$ExtensionRangeOptions$VerificationState(int i5) {
        this.value = i5;
    }

    public static DescriptorProtos$ExtensionRangeOptions$VerificationState forNumber(int i5) {
        if (i5 == 0) {
            return DECLARATION;
        }
        if (i5 != 1) {
            return null;
        }
        return UNVERIFIED;
    }

    public static w.b internalGetValueMap() {
        return internalValueMap;
    }

    public static w.c internalGetVerifier() {
        return b.f7541a;
    }

    @Deprecated
    public static DescriptorProtos$ExtensionRangeOptions$VerificationState valueOf(int i5) {
        return forNumber(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.w.a
    public final int getNumber() {
        return this.value;
    }
}
