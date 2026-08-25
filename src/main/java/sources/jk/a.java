package jk;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class a {

    /* renamed from: jk.a$a, reason: collision with other inner class name */
    public static final class C0078a extends ViewOutlineProvider {
        final /* synthetic */ float a;

        C0078a(float f) {
            this.a = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.h(view, "view");
            Intrinsics.h(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
        }
    }

    public static final void a(View view, float f) {
        Intrinsics.h(view, "<this>");
        view.setOutlineProvider(new C0078a(f));
        view.setClipToOutline(true);
    }
}
