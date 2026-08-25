package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class w extends p {
    private Long value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Sdk$SDKMetric.SDKMetricType metricType) {
        super(metricType);
        Intrinsics.h(metricType, "metricType");
    }

    public final void addValue(long j) {
        Long l = this.value;
        this.value = Long.valueOf((l != null ? l.longValue() : 0L) + j);
    }

    @Override // com.vungle.ads.p
    public long getValue() {
        Long l = this.value;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    /* renamed from: getValue, reason: collision with other method in class */
    public final Long m135getValue() {
        return this.value;
    }

    public final void markTime() {
        this.value = Long.valueOf(System.currentTimeMillis());
    }

    public final void setValue(Long l) {
        this.value = l;
    }
}
