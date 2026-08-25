package j4;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f15871a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15872b;

    public a(String str, String str2) {
        Intrinsics.h(str, "workSpecId");
        Intrinsics.h(str2, "prerequisiteId");
        this.f15871a = str;
        this.f15872b = str2;
    }

    public final String a() {
        return this.f15872b;
    }

    public final String b() {
        return this.f15871a;
    }
}
