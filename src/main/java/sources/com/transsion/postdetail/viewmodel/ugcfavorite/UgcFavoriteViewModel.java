package com.transsion.postdetail.viewmodel.ugcfavorite;

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

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UgcFavoriteViewModel extends b {
    public static final a h = new a(null);
    private static int i = 10;
    private final b0 b;
    private final b0 c;
    private final np.a d;
    private String e;
    private String f;
    private boolean g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcFavoriteViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = new b0();
        this.c = new b0();
        this.d = (np.a) c.e.a().h(np.a.class);
    }

    public final b0 e() {
        return this.b;
    }

    public final void f(String str, String str2) {
        Intrinsics.h(str, "page");
        Intrinsics.h(str2, "userId");
        this.e = str;
        this.f = str2;
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new UgcFavoriteViewModel$getUgcVideoFavoriteList$1(this, str, str2, null), 2, (Object) null);
    }

    public final boolean g() {
        return this.g;
    }

    public final void h(String str) {
        this.g = false;
        if (str == null || str.length() == 0) {
            wf.a.a.w("UgcFavoriteViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.b.n((Object) null);
            return;
        }
        wf.a.a.c("UgcFavoriteViewModel", "loadMore: load nextPage=" + str, true);
        f(str.toString(), String.valueOf(this.f));
    }

    public final void i() {
        wf.a.a.c("UgcFavoriteViewModel", "refresh: reset page to 1 and load first page", true);
        this.e = MsgStyle.CUSTOM_LEFT_PIC;
        this.g = true;
        f(String.valueOf(MsgStyle.CUSTOM_LEFT_PIC), String.valueOf(this.f));
    }
}
