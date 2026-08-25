package com.facebook.biddingkit.http.util;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public enum HttpStatusCode {
    SUCCESS(200),
    NO_BID(204),
    BAD_REQUEST(400),
    TIMEOUT(504),
    UNKNOWN(-1);

    private int mStatusCode;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HttpStatusCode.values().length];
            a = iArr;
            try {
                iArr[HttpStatusCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HttpStatusCode.NO_BID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HttpStatusCode.BAD_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HttpStatusCode.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HttpStatusCode(int i) {
        this.mStatusCode = i;
    }

    public static HttpStatusCode getValue(int i) {
        for (HttpStatusCode httpStatusCode : values()) {
            if (httpStatusCode.mStatusCode == i) {
                return httpStatusCode;
            }
        }
        return UNKNOWN;
    }

    public String getErrorMessage() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown error" : "Server timeout" : "Invalid request" : "No bid" : "";
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
