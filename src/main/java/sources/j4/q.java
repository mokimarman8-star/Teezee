package j4;

import androidx.core.app.NotificationCompat;
import androidx.coroutines.C0210d;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final String f15909a;

    /* renamed from: b, reason: collision with root package name */
    private final C0210d f15910b;

    public q(String str, C0210d c0210d) {
        Intrinsics.h(str, "workSpecId");
        Intrinsics.h(c0210d, NotificationCompat.CATEGORY_PROGRESS);
        this.f15909a = str;
        this.f15910b = c0210d;
    }

    public final C0210d a() {
        return this.f15910b;
    }

    public final String b() {
        return this.f15909a;
    }
}
