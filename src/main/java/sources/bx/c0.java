package bx;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c0 implements f4.a {
    private final FrameLayout a;
    public final z0 b;
    public final ViewStub c;

    private c0(FrameLayout frameLayout, z0 z0Var, ViewStub viewStub) {
        this.a = frameLayout;
        this.b = z0Var;
        this.c = viewStub;
    }

    public static c0 a(View view) {
        int i = R.id.included_content;
        View a = f4.b.a(view, i);
        if (a != null) {
            z0 a2 = z0.a(a);
            int i2 = R.id.vs_allow_access;
            ViewStub viewStub = (ViewStub) f4.b.a(view, i2);
            if (viewStub != null) {
                return new c0((FrameLayout) view, a2, viewStub);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
