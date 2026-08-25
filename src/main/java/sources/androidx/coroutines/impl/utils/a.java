package androidx.coroutines.impl.utils;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14092a = new a();

    private a() {
    }

    public final String a() {
        String processName = Application.getProcessName();
        Intrinsics.g(processName, "getProcessName()");
        return processName;
    }
}
