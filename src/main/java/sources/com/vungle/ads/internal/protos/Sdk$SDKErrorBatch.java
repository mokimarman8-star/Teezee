package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.b1;
import com.google.protobuf.i;
import com.google.protobuf.o;
import com.google.protobuf.y;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class Sdk$SDKErrorBatch extends GeneratedMessageLite implements c {
    private static final Sdk$SDKErrorBatch DEFAULT_INSTANCE;
    public static final int ERRORS_FIELD_NUMBER = 1;
    private static volatile b1 PARSER;
    private y.j errors_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements c {
        private a() {
            super(Sdk$SDKErrorBatch.DEFAULT_INSTANCE);
        }

        /* synthetic */ a(com.vungle.ads.internal.protos.a aVar) {
            this();
        }

        public a addAllErrors(Iterable<? extends Sdk$SDKError> iterable) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).addAllErrors(iterable);
            return this;
        }

        public a addErrors(int i, Sdk$SDKError.a aVar) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).addErrors(i, (Sdk$SDKError) aVar.build());
            return this;
        }

        public a addErrors(int i, Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).addErrors(i, sdk$SDKError);
            return this;
        }

        public a addErrors(Sdk$SDKError.a aVar) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).addErrors((Sdk$SDKError) aVar.build());
            return this;
        }

        public a addErrors(Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).addErrors(sdk$SDKError);
            return this;
        }

        public a clearErrors() {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).clearErrors();
            return this;
        }

        @Override // com.vungle.ads.internal.protos.c
        public Sdk$SDKError getErrors(int i) {
            return ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).getErrors(i);
        }

        @Override // com.vungle.ads.internal.protos.c
        public int getErrorsCount() {
            return ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).getErrorsCount();
        }

        @Override // com.vungle.ads.internal.protos.c
        public List<Sdk$SDKError> getErrorsList() {
            return Collections.unmodifiableList(((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).getErrorsList());
        }

        public a removeErrors(int i) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).removeErrors(i);
            return this;
        }

        public a setErrors(int i, Sdk$SDKError.a aVar) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).setErrors(i, (Sdk$SDKError) aVar.build());
            return this;
        }

        public a setErrors(int i, Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) ((GeneratedMessageLite.b) this).instance).setErrors(i, sdk$SDKError);
            return this;
        }
    }

    static {
        Sdk$SDKErrorBatch sdk$SDKErrorBatch = new Sdk$SDKErrorBatch();
        DEFAULT_INSTANCE = sdk$SDKErrorBatch;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKErrorBatch.class, sdk$SDKErrorBatch);
    }

    private Sdk$SDKErrorBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllErrors(Iterable<? extends Sdk$SDKError> iterable) {
        ensureErrorsIsMutable();
        com.google.protobuf.a.addAll(iterable, this.errors_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addErrors(int i, Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.add(i, sdk$SDKError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addErrors(Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.add(sdk$SDKError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearErrors() {
        this.errors_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureErrorsIsMutable() {
        y.j jVar = this.errors_;
        if (jVar.isModifiable()) {
            return;
        }
        this.errors_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sdk$SDKErrorBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(Sdk$SDKErrorBatch sdk$SDKErrorBatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(sdk$SDKErrorBatch);
    }

    public static Sdk$SDKErrorBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKErrorBatch parseDelimitedFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, oVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(i iVar) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(i iVar, o oVar) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, iVar, oVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKErrorBatch parseFrom(InputStream inputStream, o oVar) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, oVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, oVar);
    }

    public static Sdk$SDKErrorBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKErrorBatch parseFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, oVar);
    }

    public static b1 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeErrors(int i) {
        ensureErrorsIsMutable();
        this.errors_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrors(int i, Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.set(i, sdk$SDKError);
    }

    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.vungle.ads.internal.protos.a aVar = null;
        switch (com.vungle.ads.internal.protos.a.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKErrorBatch();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"errors_", Sdk$SDKError.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                GeneratedMessageLite.c cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sdk$SDKErrorBatch.class) {
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

    @Override // com.vungle.ads.internal.protos.c
    public Sdk$SDKError getErrors(int i) {
        return (Sdk$SDKError) this.errors_.get(i);
    }

    @Override // com.vungle.ads.internal.protos.c
    public int getErrorsCount() {
        return this.errors_.size();
    }

    @Override // com.vungle.ads.internal.protos.c
    public List<Sdk$SDKError> getErrorsList() {
        return this.errors_;
    }

    public d getErrorsOrBuilder(int i) {
        return (d) this.errors_.get(i);
    }

    public List<? extends d> getErrorsOrBuilderList() {
        return this.errors_;
    }
}
