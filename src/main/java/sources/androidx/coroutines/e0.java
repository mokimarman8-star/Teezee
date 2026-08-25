package androidx.coroutines;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f13196a = new e0();

    private e0() {
    }

    public static final String a(String str) {
        Intrinsics.h(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
