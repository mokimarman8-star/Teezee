package com.transsion.gslb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class NetResponse<T> {
    public static final String EMPTY_RESPONSE = "{}";
    public int code;
    public T data;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResponseCode {
        public static final int ERROR = -1;
        public static final int NOT_MODIFIED = 1;
        public static final int OK = 0;
        public static final int SDK_ERROR = 2;
    }

    public NetResponse(int i, T t) {
        this.code = i;
        this.data = t;
    }
}
