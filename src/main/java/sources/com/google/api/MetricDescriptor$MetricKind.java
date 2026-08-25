package com.google.api;

import com.google.protobuf.y;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum MetricDescriptor$MetricKind implements y.c {
    METRIC_KIND_UNSPECIFIED(0),
    GAUGE(1),
    DELTA(2),
    CUMULATIVE(3),
    UNRECOGNIZED(-1);

    public static final int CUMULATIVE_VALUE = 3;
    public static final int DELTA_VALUE = 2;
    public static final int GAUGE_VALUE = 1;
    public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
    private static final y.d internalValueMap = new y.d() { // from class: com.google.api.MetricDescriptor$MetricKind.a
        @Override // com.google.protobuf.y.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MetricDescriptor$MetricKind findValueByNumber(int i) {
            return MetricDescriptor$MetricKind.forNumber(i);
        }
    };
    private final int value;

    private static final class b implements y.e {
        static final y.e a = new b();

        private b() {
        }

        @Override // com.google.protobuf.y.e
        public boolean isInRange(int i) {
            return MetricDescriptor$MetricKind.forNumber(i) != null;
        }
    }

    MetricDescriptor$MetricKind(int i) {
        this.value = i;
    }

    public static MetricDescriptor$MetricKind forNumber(int i) {
        if (i == 0) {
            return METRIC_KIND_UNSPECIFIED;
        }
        if (i == 1) {
            return GAUGE;
        }
        if (i == 2) {
            return DELTA;
        }
        if (i != 3) {
            return null;
        }
        return CUMULATIVE;
    }

    public static y.d internalGetValueMap() {
        return internalValueMap;
    }

    public static y.e internalGetVerifier() {
        return b.a;
    }

    @Deprecated
    public static MetricDescriptor$MetricKind valueOf(int i) {
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
