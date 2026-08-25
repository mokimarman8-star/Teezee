package com.google.firebase.perf.v1;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum TransportInfo$DispatchDestination implements y.c {
    SOURCE_UNKNOWN(0),
    FL_LEGACY_V1(1);

    public static final int FL_LEGACY_V1_VALUE = 1;
    public static final int SOURCE_UNKNOWN_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.firebase.perf.v1.TransportInfo$DispatchDestination.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransportInfo$DispatchDestination findValueByNumber(int i) {
            return TransportInfo$DispatchDestination.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return TransportInfo$DispatchDestination.forNumber(i) != null;
        }
    }

    TransportInfo$DispatchDestination(int i) {
        this.value = i;
    }

    public static TransportInfo$DispatchDestination forNumber(int i) {
        if (i == 0) {
            return SOURCE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return FL_LEGACY_V1;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static TransportInfo$DispatchDestination valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        return this.value;
    }
}
