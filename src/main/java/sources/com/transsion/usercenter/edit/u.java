package com.transsion.usercenter.edit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class u {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.usercenter.edit.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            u b2;
            b2 = u.b();
            return b2;
        }
    });
    private Bitmap a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u a() {
            return (u) u.c.getValue();
        }
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u b() {
        return new u();
    }

    public final Bitmap d() {
        return this.a;
    }

    public final void e(Bitmap bitmap) {
        this.a = bitmap;
    }

    public final void f(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Intrinsics.g(createBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            this.a = createBitmap;
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
