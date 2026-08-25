package com.transsion.room.sub.viewmodel.likes;

import android.app.Application;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.transsion.push.bean.MsgStyle;
import kg.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcLikesViewModel extends b {
    public static final a i = new a(null);
    private static int j = 8;
    private final b0 b;
    private final b0 c;
    private final op.a d;
    private String e;
    private String f;
    private String g;
    private boolean h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcLikesViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = (op.a) c.e.a().h(op.a.class);
    }

    public final b0 e() {
        return this.b;
    }

    public final b0 f() {
        return this.c;
    }

    public final void g(String str, String str2) {
        Intrinsics.h(str, "page");
        Intrinsics.h(str2, "userId");
        this.f = str;
        this.g = str2;
        a.a.f(wf.a.a, "UgcLikesViewModel", "Likes getUgcVideoLikesBean", false, 4, (Object) null);
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UgcLikesViewModel$getUgcVideoLikesBean$1(str, str2, this, null), 2, (Object) null);
    }

    public final boolean h() {
        return this.h;
    }

    public final void i(String str) {
        this.h = false;
        if (str == null || str.length() == 0) {
            wf.a.a.w("UgcLikesViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.c.n((Object) null);
            return;
        }
        wf.a.a.c("UgcLikesViewModel", "loadMore: load nextPage=" + str, true);
        g(str.toString(), String.valueOf(this.g));
    }

    public final void j(String str, boolean z) {
        Intrinsics.h(str, "ugcVideoId");
        this.e = str;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UgcLikesViewModel$postLikeUgcVideo$1(str, z, this, null), 2, (Object) null);
    }

    public final void k() {
        wf.a.a.c("UgcLikesViewModel", "refresh: reset page to 1 and load first page", true);
        this.f = MsgStyle.CUSTOM_LEFT_PIC;
        this.h = true;
        g(String.valueOf(MsgStyle.CUSTOM_LEFT_PIC), String.valueOf(this.g));
    }
}
