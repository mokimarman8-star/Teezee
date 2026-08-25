package com.transsion.player.longvideo.helper;

import android.util.Log;
import android.view.ViewGroup;
import com.transsion.player.longvideo.ui.LongVodUiType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    public static final a e = new a(null);
    private final mn.j a;
    private int b;
    private int c;
    private int d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(mn.j jVar) {
        Intrinsics.h(jVar, "viewBinding");
        this.a = jVar;
        this.b = com.blankj.utilcode.util.y.c();
        int e2 = com.blankj.utilcode.util.y.e();
        this.c = e2;
        int i = this.b;
        if (e2 < i) {
            this.c = i;
            this.b = e2;
        }
        int a2 = com.blankj.utilcode.util.d.a();
        if (a2 > 10) {
            this.c -= a2;
        }
    }

    public final int a() {
        return this.d;
    }

    public final void b(int i, int i2) {
        com.blankj.utilcode.util.d.c();
    }

    public final void c() {
        this.d = 0;
    }

    public final void d(LongVodUiType longVodUiType, int i) {
        Intrinsics.h(longVodUiType, "uiType");
        if (this.d == 0) {
            this.d = com.blankj.utilcode.util.d.c();
        }
        LongVodUiType longVodUiType2 = LongVodUiType.LAND;
        int i2 = 0;
        int i3 = (longVodUiType == longVodUiType2 && i == 1) ? this.d : 0;
        if (longVodUiType == longVodUiType2 && i == 3) {
            i2 = this.d;
        }
        Log.e("LongVodLandSpace", "setSpace  uiType:" + longVodUiType + "  rotation:" + i + "  spaceLeft:" + i3 + "  spaceRight:" + i2);
        ViewGroup.LayoutParams layoutParams = this.a.q.h.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.a.o.C.getLayoutParams();
        layoutParams.width = i3;
        layoutParams2.width = i3;
        this.a.q.h.setLayoutParams(layoutParams);
        this.a.o.C.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.a.q.g.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = this.a.o.B.getLayoutParams();
        layoutParams3.width = i2;
        layoutParams4.width = i2;
        this.a.q.g.setLayoutParams(layoutParams3);
        this.a.o.B.setLayoutParams(layoutParams4);
    }
}
