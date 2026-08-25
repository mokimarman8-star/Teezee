package com.transsion.shorttv.order;

import com.transsion.shorttv.order.bean.GetPaynicornOrderStatusRespEntity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public static final class a {
        public static void a(b bVar, String str, String str2) {
            Intrinsics.h(str, "errorCode");
            Intrinsics.h(str2, "errorMsg");
        }

        public static void b(b bVar, GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity) {
        }
    }

    void a(String str, String str2);

    void b(GetPaynicornOrderStatusRespEntity getPaynicornOrderStatusRespEntity);
}
