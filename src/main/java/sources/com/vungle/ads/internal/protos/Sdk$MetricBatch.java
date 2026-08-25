package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.b1;
import com.google.protobuf.i;
import com.google.protobuf.o;
import com.google.protobuf.y;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Sdk$MetricBatch extends GeneratedMessageLite implements b {
    private static final Sdk$MetricBatch DEFAULT_INSTANCE;
    public static final int METRICS_FIELD_NUMBER = 1;
    private static volatile b1 PARSER;
    private y.j metrics_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements b {
        private a() {
            super(Sdk$MetricBatch.DEFAULT_INSTANCE);
        }

        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).addAllMetrics(iterable);
            return this;
        }

        public a addMetrics(int i, Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).addMetrics(i, (Sdk$SDKMetric) aVar.build());
            return this;
        }

        public a addMetrics(int i, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).addMetrics(i, sdk$SDKMetric);
            return this;
        }

        public a addMetrics(Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).addMetrics((Sdk$SDKMetric) aVar.build());
            return this;
        }

        public a addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).addMetrics(sdk$SDKMetric);
            return this;
        }

        public a clearMetrics() {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).clearMetrics();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.b
        public Sdk$SDKMetric getMetrics(int i) {
            return ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).getMetrics(i);
        }

        @Override // com.vungle.ads.internal.protos.b
        public int getMetricsCount() {
            return ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).getMetricsCount();
        }

        @Override // com.vungle.ads.internal.protos.b
        public List<Sdk$SDKMetric> getMetricsList() {
            return Collections.unmodifiableList(((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).getMetricsList());
        }

        public a removeMetrics(int i) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).removeMetrics(i);
            return this;
        }

        public a setMetrics(int i, Sdk$SDKMetric.a aVar) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).setMetrics(i, (Sdk$SDKMetric) aVar.build());
            return this;
        }

        public a setMetrics(int i, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) ((GeneratedMessageLite.b) this).instance).setMetrics(i, sdk$SDKMetric);
            return this;
        }
    }

    static {
        Sdk$MetricBatch sdk$MetricBatch = new Sdk$MetricBatch();
        DEFAULT_INSTANCE = sdk$MetricBatch;
        GeneratedMessageLite.registerDefaultInstance(Sdk$MetricBatch.class, sdk$MetricBatch);
    }

    private Sdk$MetricBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
        ensureMetricsIsMutable();
        com.google.protobuf.a.addAll(iterable, this.metrics_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(int i, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(i, sdk$SDKMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(sdk$SDKMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMetricsIsMutable() {
        y.j jVar = this.metrics_;
        if (jVar.isModifiable()) {
            return;
        }
        this.metrics_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sdk$MetricBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(Sdk$MetricBatch sdk$MetricBatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(sdk$MetricBatch);
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, oVar);
    }

    public static Sdk$MetricBatch parseFrom(i iVar) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar);
    }

    public static Sdk$MetricBatch parseFrom(i iVar, o oVar) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, oVar);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, oVar);
    }

    public static b1 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMetrics(int i) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(int i, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.set(i, sdk$SDKMetric);
    }

    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$MetricBatch();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"metrics_", Sdk$SDKMetric.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                GeneratedMessageLite.c cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sdk$MetricBatch.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.vungle.ads.internal.protos.b
    public Sdk$SDKMetric getMetrics(int i) {
        return (Sdk$SDKMetric) this.metrics_.get(i);
    }

    @Override // com.vungle.ads.internal.protos.b
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.vungle.ads.internal.protos.b
    public List<Sdk$SDKMetric> getMetricsList() {
        return this.metrics_;
    }

    public e getMetricsOrBuilder(int i) {
        return (e) this.metrics_.get(i);
    }

    public List<? extends e> getMetricsOrBuilderList() {
        return this.metrics_;
    }
}
