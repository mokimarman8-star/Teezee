package com.transsion.push.utils;

import com.transsion.push.bean.ShowOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public /* synthetic */ class NotificationUtil$a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ShowOrder.values().length];
        try {
            iArr[ShowOrder.LAST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ShowOrder.NEXT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        a = iArr;
    }
}
