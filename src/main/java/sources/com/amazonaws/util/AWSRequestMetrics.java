package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class AWSRequestMetrics {
    protected final TimingInfo a;

    public enum Field implements MetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.a = TimingInfo.m();
    }

    protected AWSRequestMetrics(TimingInfo timingInfo) {
        this.a = timingInfo;
    }

    public void a(MetricType metricType, Object obj) {
    }

    public void b(MetricType metricType) {
    }

    public final TimingInfo c() {
        return this.a;
    }

    public void d(MetricType metricType) {
    }

    public void e() {
    }

    public void f(MetricType metricType, long j) {
    }

    public void g(MetricType metricType) {
    }
}
