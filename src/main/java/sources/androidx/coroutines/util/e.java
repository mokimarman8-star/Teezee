package androidx.coroutines.util;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class e implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private final int f13303a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13304b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13305c;

    /* renamed from: d, reason: collision with root package name */
    private final String f13306d;

    public e(int i5, int i6, String str, String str2) {
        Intrinsics.h(str, "from");
        Intrinsics.h(str2, "to");
        this.f13303a = i5;
        this.f13304b = i6;
        this.f13305c = str;
        this.f13306d = str2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        Intrinsics.h(eVar, "other");
        int i5 = this.f13303a - eVar.f13303a;
        return i5 == 0 ? this.f13304b - eVar.f13304b : i5;
    }

    public final String b() {
        return this.f13305c;
    }

    public final int d() {
        return this.f13303a;
    }

    public final String e() {
        return this.f13306d;
    }
}
