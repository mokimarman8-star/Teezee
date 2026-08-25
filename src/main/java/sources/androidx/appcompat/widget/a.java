package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f957a;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    private static class C0004a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public a(ActionBarContainer actionBarContainer) {
        this.f957a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f957a;
        if (actionBarContainer.h) {
            Drawable drawable = actionBarContainer.g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f957a;
        Drawable drawable3 = actionBarContainer2.f;
        if (drawable3 == null || !actionBarContainer2.i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f957a;
        if (actionBarContainer.h) {
            if (actionBarContainer.g != null) {
                C0004a.a(actionBarContainer.e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.e;
            if (drawable != null) {
                C0004a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
