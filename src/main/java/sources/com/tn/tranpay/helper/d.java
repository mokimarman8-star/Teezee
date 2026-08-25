package com.tn.tranpay.helper;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class d {
    public static final String a(String str) {
        Intrinsics.h(str, "<this>");
        byte[] decode = Base64.decode(str, 2);
        Intrinsics.g(decode, "decodedBytes");
        return new String(decode, Charsets.b);
    }
}
