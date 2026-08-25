package com.amazonaws.metrics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {
    private final String a;
    private final String b;

    public SimpleServiceMetricType(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.a;
    }
}
