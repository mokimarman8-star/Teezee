package com.vungle.ads.internal.downloader;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: com.vungle.ads.internal.downloader.a$a, reason: collision with other inner class name */
    public static final class C0033a {
        public static final C0034a Companion = new C0034a(null);
        public static final int DEFAULT_SERVER_CODE = -1;
        private final Throwable cause;

        @b
        private final int reason;
        private final int serverCode;

        /* renamed from: com.vungle.ads.internal.downloader.a$a$a, reason: collision with other inner class name */
        public static final class C0034a {
            private C0034a() {
            }

            public /* synthetic */ C0034a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Retention(RetentionPolicy.RUNTIME)
        /* renamed from: com.vungle.ads.internal.downloader.a$a$b */
        public @interface b {
            public static final C0035a Companion = C0035a.$$INSTANCE;

            /* renamed from: com.vungle.ads.internal.downloader.a$a$b$a, reason: collision with other inner class name */
            public static final class C0035a {
                private static int CONNECTION_ERROR;
                static final /* synthetic */ C0035a $$INSTANCE = new C0035a();
                private static int REQUEST_ERROR = 1;
                private static int DISK_ERROR = 2;
                private static int FILE_NOT_FOUND_ERROR = 3;
                private static int INTERNAL_ERROR = 4;

                private C0035a() {
                }

                public final int getCONNECTION_ERROR() {
                    return CONNECTION_ERROR;
                }

                public final int getDISK_ERROR() {
                    return DISK_ERROR;
                }

                public final int getFILE_NOT_FOUND_ERROR() {
                    return FILE_NOT_FOUND_ERROR;
                }

                public final int getINTERNAL_ERROR() {
                    return INTERNAL_ERROR;
                }

                public final int getREQUEST_ERROR() {
                    return REQUEST_ERROR;
                }

                public final void setCONNECTION_ERROR(int i) {
                    CONNECTION_ERROR = i;
                }

                public final void setDISK_ERROR(int i) {
                    DISK_ERROR = i;
                }

                public final void setFILE_NOT_FOUND_ERROR(int i) {
                    FILE_NOT_FOUND_ERROR = i;
                }

                public final void setINTERNAL_ERROR(int i) {
                    INTERNAL_ERROR = i;
                }

                public final void setREQUEST_ERROR(int i) {
                    REQUEST_ERROR = i;
                }
            }
        }

        public C0033a(int i, Throwable cause, int i2) {
            Intrinsics.h(cause, "cause");
            this.serverCode = i;
            this.cause = cause;
            this.reason = i2;
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final int getReason() {
            return this.reason;
        }

        public final int getServerCode() {
            return this.serverCode;
        }
    }

    public static final class b {
        public static final C0036a Companion = new C0036a(null);
        private int progressPercent;
        private long sizeBytes;
        private long startBytes;
        private int status;
        private long timestampDownloadStart;

        /* renamed from: com.vungle.ads.internal.downloader.a$b$a, reason: collision with other inner class name */
        public static final class C0036a {
            private C0036a() {
            }

            public /* synthetic */ C0036a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b copy(b progress) {
                Intrinsics.h(progress, "progress");
                b bVar = new b();
                bVar.setStatus(progress.getStatus());
                bVar.setProgressPercent(progress.getProgressPercent());
                bVar.setTimestampDownloadStart(progress.getTimestampDownloadStart());
                bVar.setSizeBytes(progress.getSizeBytes());
                bVar.setStartBytes(progress.getStartBytes());
                return bVar;
            }
        }

        @Retention(RetentionPolicy.RUNTIME)
        /* renamed from: com.vungle.ads.internal.downloader.a$b$b, reason: collision with other inner class name */
        public @interface InterfaceC0037b {
            public static final C0038a Companion = C0038a.$$INSTANCE;

            /* renamed from: com.vungle.ads.internal.downloader.a$b$b$a, reason: collision with other inner class name */
            public static final class C0038a {
                private static int STARTED;
                static final /* synthetic */ C0038a $$INSTANCE = new C0038a();
                private static int IN_PROGRESS = 1;
                private static int PAUSED = 2;
                private static int CANCELLED = 3;
                private static int DONE = 4;
                private static int LOST_CONNECTION = 5;
                private static int STATE_CHANGED = 6;
                private static int ERROR = 7;

                private C0038a() {
                }

                public final int getCANCELLED() {
                    return CANCELLED;
                }

                public final int getDONE() {
                    return DONE;
                }

                public final int getERROR() {
                    return ERROR;
                }

                public final int getIN_PROGRESS() {
                    return IN_PROGRESS;
                }

                public final int getLOST_CONNECTION() {
                    return LOST_CONNECTION;
                }

                public final int getPAUSED() {
                    return PAUSED;
                }

                public final int getSTARTED() {
                    return STARTED;
                }

                public final int getSTATE_CHANGED() {
                    return STATE_CHANGED;
                }

                public final void setCANCELLED(int i) {
                    CANCELLED = i;
                }

                public final void setDONE(int i) {
                    DONE = i;
                }

                public final void setERROR(int i) {
                    ERROR = i;
                }

                public final void setIN_PROGRESS(int i) {
                    IN_PROGRESS = i;
                }

                public final void setLOST_CONNECTION(int i) {
                    LOST_CONNECTION = i;
                }

                public final void setPAUSED(int i) {
                    PAUSED = i;
                }

                public final void setSTARTED(int i) {
                    STARTED = i;
                }

                public final void setSTATE_CHANGED(int i) {
                    STATE_CHANGED = i;
                }
            }
        }

        @InterfaceC0037b
        public static /* synthetic */ void getStatus$annotations() {
        }

        public final int getProgressPercent() {
            return this.progressPercent;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final long getStartBytes() {
            return this.startBytes;
        }

        public final int getStatus() {
            return this.status;
        }

        public final long getTimestampDownloadStart() {
            return this.timestampDownloadStart;
        }

        public final void setProgressPercent(int i) {
            this.progressPercent = i;
        }

        public final void setSizeBytes(long j) {
            this.sizeBytes = j;
        }

        public final void setStartBytes(long j) {
            this.startBytes = j;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final void setTimestampDownloadStart(long j) {
            this.timestampDownloadStart = j;
        }
    }

    void onError(C0033a c0033a, DownloadRequest downloadRequest);

    void onSuccess(File file, DownloadRequest downloadRequest);
}
