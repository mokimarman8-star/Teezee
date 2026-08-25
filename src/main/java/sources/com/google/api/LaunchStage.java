package com.google.api;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum LaunchStage implements y.c {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);

    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int DEPRECATED_VALUE = 5;
    public static final int EARLY_ACCESS_VALUE = 1;
    public static final int GA_VALUE = 4;
    public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.api.LaunchStage.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LaunchStage findValueByNumber(int i) {
            return LaunchStage.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return LaunchStage.forNumber(i) != null;
        }
    }

    LaunchStage(int i) {
        this.value = i;
    }

    public static LaunchStage forNumber(int i) {
        if (i == 0) {
            return LAUNCH_STAGE_UNSPECIFIED;
        }
        if (i == 1) {
            return EARLY_ACCESS;
        }
        if (i == 2) {
            return ALPHA;
        }
        if (i == 3) {
            return BETA;
        }
        if (i == 4) {
            return GA;
        }
        if (i != 5) {
            return null;
        }
        return DEPRECATED;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static LaunchStage valueOf(int i) {
        return forNumber(i);
    }

    @Override // com.google.protobuf.y.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
