package com.transsion.push.utils;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationUtil$d implements RequestListener {
    NotificationUtil$d() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
        Intrinsics.h(drawable, "resource");
        Intrinsics.h(obj, "model");
        Intrinsics.h(dataSource, "dataSource");
        a.a.f(wf.a.a, "NotificationUtil", obj + " 预加载成功", false, 4, (Object) null);
        return true;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
        Intrinsics.h(target, "target");
        a.a.f(wf.a.a, "NotificationUtil", obj + " 预加载失败", false, 4, (Object) null);
        return true;
    }
}
