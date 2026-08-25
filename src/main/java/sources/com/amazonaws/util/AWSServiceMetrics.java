package com.amazonaws.util;

import com.amazonaws.metrics.ServiceMetricType;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum AWSServiceMetrics implements ServiceMetricType {
    HttpClientGetConnectionTime("HttpClient");

    private final String serviceName;

    AWSServiceMetrics(String str) {
        this.serviceName = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
