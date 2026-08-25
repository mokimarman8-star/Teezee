package com.tn.tranpay.helper;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RequestBody a(Object obj) {
            Intrinsics.h(obj, "req");
            try {
                if (obj instanceof String) {
                    return RequestBody.Companion.create((String) obj, MediaType.Companion.parse("application/json"));
                }
                return RequestBody.Companion.create(com.alibaba.fastjson.a.toJSON(obj).toString(), MediaType.Companion.parse("application/json"));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
