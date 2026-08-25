package com.cloud.hisavana.protocol.okhttptransport;

import com.cloud.hisavana.protocol.okhttptransport.UploadBodyDataBroker;
import com.cloud.hisavana.protocol.okhttptransport.e;
import com.google.common.base.s;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.t;
import com.google.common.util.concurrent.z;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class e implements d {
    private final b a;
    private final c b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UploadBodyDataBroker.ReadResult.values().length];
            a = iArr;
            try {
                iArr[UploadBodyDataBroker.ReadResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UploadBodyDataBroker.ReadResult.END_OF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static final class b implements d {

        class a extends UploadDataProvider {
            private volatile boolean a = false;
            private final Buffer b = new Buffer();
            final /* synthetic */ long c;
            final /* synthetic */ RequestBody d;

            a(long j, RequestBody requestBody) {
                this.c = j;
                this.d = requestBody;
            }

            public long getLength() {
                return this.c;
            }

            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                if (!this.a) {
                    this.d.writeTo(this.b);
                    this.b.flush();
                    this.a = true;
                    long length = getLength();
                    long size = this.b.size();
                    if (size != length) {
                        throw new IOException("Expected " + length + " bytes but got " + size);
                    }
                }
                if (this.b.read(byteBuffer) == -1) {
                    throw new IllegalStateException("The source has been exhausted but we expected more!");
                }
                uploadDataSink.onReadSucceeded(false);
            }

            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException());
            }
        }

        b() {
        }

        @Override // com.cloud.hisavana.protocol.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i) {
            long contentLength = requestBody.contentLength();
            if (contentLength >= 0 && contentLength <= 1048576) {
                return new a(contentLength, requestBody);
            }
            throw new IOException("Expected definite length less than 1048576but got " + contentLength);
        }
    }

    static final class c implements d {
        private final ExecutorService a;

        /* JADX INFO: Access modifiers changed from: private */
        static class a extends UploadDataProvider {
            private final RequestBody a;
            private final UploadBodyDataBroker b;
            private final t c;
            private final long d;
            private r e;
            private long f;

            /* renamed from: com.cloud.hisavana.protocol.okhttptransport.e$c$a$a, reason: collision with other inner class name */
            class C0121a implements m {
                C0121a() {
                }

                public void onFailure(Throwable th) {
                    a.this.b.j(th);
                }

                public void onSuccess(Object obj) {
                }
            }

            private a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j) {
                this.a = requestBody;
                this.b = uploadBodyDataBroker;
                if (executorService instanceof t) {
                    this.c = (t) executorService;
                } else {
                    this.c = MoreExecutors.b(executorService);
                }
                this.d = j == 0 ? 2147483647L : j;
            }

            /* synthetic */ a(RequestBody requestBody, UploadBodyDataBroker uploadBodyDataBroker, ExecutorService executorService, long j, a aVar) {
                this(requestBody, uploadBodyDataBroker, executorService, j);
            }

            private void h() {
                if (this.e == null) {
                    r submit = this.c.submit(new Callable() { // from class: com.cloud.hisavana.protocol.okhttptransport.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Void k;
                            k = e.c.a.this.k();
                            return k;
                        }
                    });
                    this.e = submit;
                    Futures.a(submit, new C0121a(), MoreExecutors.a());
                }
            }

            private void j(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                byteBuffer.position(0);
                if (!m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY)) {
                    throw l(getLength(), this.f);
                }
                s.a(byteBuffer.position() == 0, "END_OF_BODY reads shouldn't write anything to the buffer", new Object[0]);
                byteBuffer.position(position);
                uploadDataSink.onReadSucceeded(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Void k() {
                BufferedSink buffer = Okio.buffer(this.b);
                this.a.writeTo(buffer);
                buffer.flush();
                this.b.h();
                return null;
            }

            private static IOException l(long j, long j2) {
                return new IOException("Expected " + j + " bytes but got at least " + j2);
            }

            private UploadBodyDataBroker.ReadResult m(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                UploadBodyDataBroker.ReadResult readResult = (UploadBodyDataBroker.ReadResult) z.b(this.b.b(byteBuffer), this.d, TimeUnit.MILLISECONDS);
                this.f += byteBuffer.position() - position;
                return readResult;
            }

            private void n(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    UploadBodyDataBroker.ReadResult m = m(byteBuffer);
                    if (this.f > getLength()) {
                        throw l(getLength(), this.f);
                    }
                    if (this.f >= getLength()) {
                        j(uploadDataSink, byteBuffer);
                        return;
                    }
                    int i = a.a[m.ordinal()];
                    if (i == 1) {
                        uploadDataSink.onReadSucceeded(false);
                    } else if (i == 2) {
                        throw new IOException("The source has been exhausted but we expected more data!");
                    }
                } catch (ExecutionException e) {
                    e = e;
                    this.e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                } catch (TimeoutException e2) {
                    e = e2;
                    this.e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            private void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                try {
                    uploadDataSink.onReadSucceeded(m(byteBuffer).equals(UploadBodyDataBroker.ReadResult.END_OF_BODY));
                } catch (ExecutionException | TimeoutException e) {
                    this.e.cancel(true);
                    uploadDataSink.onReadError(new IOException(e));
                }
            }

            public long getLength() {
                return this.a.contentLength();
            }

            public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
                h();
                if (getLength() == -1) {
                    o(uploadDataSink, byteBuffer);
                } else {
                    n(uploadDataSink, byteBuffer);
                }
            }

            public void rewind(UploadDataSink uploadDataSink) {
                uploadDataSink.onRewindError(new UnsupportedOperationException("Rewind is not supported!"));
            }
        }

        c(ExecutorService executorService) {
            this.a = executorService;
        }

        @Override // com.cloud.hisavana.protocol.okhttptransport.d
        public UploadDataProvider a(RequestBody requestBody, int i) {
            return new a(requestBody, new UploadBodyDataBroker(), this.a, i, null);
        }
    }

    e(b bVar, c cVar) {
        this.a = bVar;
        this.b = cVar;
    }

    static e b(ExecutorService executorService) {
        return new e(new b(), new c(executorService));
    }

    @Override // com.cloud.hisavana.protocol.okhttptransport.d
    public UploadDataProvider a(RequestBody requestBody, int i) {
        long contentLength = requestBody.contentLength();
        return (contentLength == -1 || contentLength > 1048576) ? this.b.a(requestBody, i) : this.a.a(requestBody, i);
    }
}
