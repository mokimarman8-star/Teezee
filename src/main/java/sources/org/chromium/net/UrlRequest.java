package org.chromium.net;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import org.chromium.net.RequestFinishedInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class UrlRequest {

    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        public abstract Builder addHeader(String str, String str2);

        public Builder addRequestAnnotation(Object obj) {
            return this;
        }

        public abstract Builder allowDirectExecutor();

        public Builder bindToNetwork(long j) {
            return this;
        }

        public abstract UrlRequest build();

        public abstract Builder disableCache();

        public abstract Builder setHttpMethod(String str);

        public abstract Builder setPriority(int i);

        public Builder setRequestFinishedListener(RequestFinishedInfo.Listener listener) {
            return this;
        }

        public Builder setTrafficStatsTag(int i) {
            return this;
        }

        public Builder setTrafficStatsUid(int i) {
            return this;
        }

        public abstract Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);
    }

    public static abstract class Callback {
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public abstract void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException);

        public abstract void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);
    }

    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract void getStatus(StatusListener statusListener);

    public abstract boolean isDone();

    public abstract void read(ByteBuffer byteBuffer);

    public abstract void start();
}
