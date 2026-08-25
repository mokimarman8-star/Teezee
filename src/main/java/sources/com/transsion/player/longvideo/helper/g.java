package com.transsion.player.longvideo.helper;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import kn.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends d {
    private boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g gVar, mn.j jVar, View view) {
        gVar.d = true;
        FrameLayout frameLayout = jVar.o.g;
        Intrinsics.g(frameLayout, "gameContainer");
        uf.c.g(frameLayout);
        AppCompatImageView appCompatImageView = jVar.o.j;
        Intrinsics.g(appCompatImageView, "ivGameClose");
        uf.c.g(appCompatImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(g gVar) {
        mn.k kVar;
        AppCompatImageView appCompatImageView;
        mn.j b = gVar.b();
        if (b == null || (kVar = b.o) == null || (appCompatImageView = kVar.j) == null) {
            return;
        }
        uf.c.k(appCompatImageView);
    }

    @Override // com.transsion.player.longvideo.helper.d
    public void c(String str, final mn.j jVar) {
        Intrinsics.h(jVar, "viewBinding");
        super.c(str, jVar);
        jVar.o.j.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.helper.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.g(g.this, jVar, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(LongVodUiType longVodUiType) {
        a.b a;
        View e;
        mn.k kVar;
        FrameLayout frameLayout;
        mn.k kVar2;
        FrameLayout frameLayout2;
        mn.k kVar3;
        FrameLayout frameLayout3;
        mn.k kVar4;
        AppCompatImageView appCompatImageView;
        mn.k kVar5;
        FrameLayout frameLayout4;
        Intrinsics.h(longVodUiType, "uiType");
        a.b a2 = a();
        if (a2 != null) {
            a2.d(longVodUiType);
        }
        if (longVodUiType == LongVodUiType.MIDDLE || this.d || (a = a()) == null || (e = a.e()) == 0) {
            return;
        }
        ViewParent parent = e.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(e);
        }
        wj.c cVar = e instanceof wj.c ? (wj.c) e : null;
        if (cVar != null) {
            cVar.setPageStyle("fullscreen");
        }
        mn.j b = b();
        if (b != null && (kVar5 = b.o) != null && (frameLayout4 = kVar5.g) != null) {
            uf.c.k(frameLayout4);
        }
        mn.j b2 = b();
        if (b2 != null && (kVar4 = b2.o) != null && (appCompatImageView = kVar4.j) != null) {
            uf.c.g(appCompatImageView);
        }
        mn.j b3 = b();
        if (b3 != null && (kVar3 = b3.o) != null && (frameLayout3 = kVar3.g) != null) {
            frameLayout3.postDelayed(new Runnable() { // from class: com.transsion.player.longvideo.helper.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.i(g.this);
                }
            }, 3000L);
        }
        mn.j b4 = b();
        if (b4 != null && (kVar2 = b4.o) != null && (frameLayout2 = kVar2.g) != null) {
            frameLayout2.removeAllViews();
        }
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        mn.j b5 = b();
        if (b5 == null || (kVar = b5.o) == null || (frameLayout = kVar.g) == null) {
            return;
        }
        frameLayout.addView(e, layoutParams);
    }
}
