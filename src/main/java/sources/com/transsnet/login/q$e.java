package com.transsnet.login;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class q$e implements yx.h {
    public static final q$e a = new q$e();

    q$e() {
    }

    @Override // yx.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final RequestBody apply(String it) {
        Intrinsics.h(it, "it");
        JsonObject jsonObject = new JsonObject();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String jsonElement = jsonObject.toString();
        Intrinsics.g(jsonElement, "toString(...)");
        return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
    }
}
