package com.amazonaws.services.s3.metrics;

import com.amazonaws.metrics.ServiceMetricType;
import com.amazonaws.metrics.SimpleMetricType;
import com.amazonaws.metrics.ThroughputMetricType;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class S3ServiceMetric extends SimpleMetricType implements ServiceMetricType {
    public static final S3ThroughputMetric b;
    public static final S3ServiceMetric c;
    public static final S3ThroughputMetric d;
    public static final S3ServiceMetric e;
    private static final S3ServiceMetric[] f;
    private final String a;

    /* JADX INFO: Access modifiers changed from: private */
    public static abstract class S3ThroughputMetric extends S3ServiceMetric implements ThroughputMetricType {
        private S3ThroughputMetric(String str) {
            super(str);
        }
    }

    static {
        S3ThroughputMetric s3ThroughputMetric = new S3ThroughputMetric(a("DownloadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.1
        };
        b = s3ThroughputMetric;
        S3ServiceMetric s3ServiceMetric = new S3ServiceMetric(a("DownloadByteCount"));
        c = s3ServiceMetric;
        S3ThroughputMetric s3ThroughputMetric2 = new S3ThroughputMetric(a("UploadThroughput")) { // from class: com.amazonaws.services.s3.metrics.S3ServiceMetric.2
        };
        d = s3ThroughputMetric2;
        S3ServiceMetric s3ServiceMetric2 = new S3ServiceMetric(a("UploadByteCount"));
        e = s3ServiceMetric2;
        f = new S3ServiceMetric[]{s3ThroughputMetric, s3ServiceMetric, s3ThroughputMetric2, s3ServiceMetric2};
    }

    private S3ServiceMetric(String str) {
        this.a = str;
    }

    private static final String a(String str) {
        return "S3" + str;
    }

    public static S3ServiceMetric[] b() {
        return (S3ServiceMetric[]) f.clone();
    }

    @Override // com.amazonaws.metrics.SimpleMetricType, com.amazonaws.metrics.MetricType
    public String name() {
        return this.a;
    }
}
