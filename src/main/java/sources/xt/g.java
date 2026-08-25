package xt;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.transfer.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;

    private g(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatTextView;
        this.e = appCompatTextView2;
    }

    public static g a(View view) {
        AppCompatImageView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.ivClose;
        AppCompatImageView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.ivLoading))) == null || (a2 = f4.b.a(view, (i = R$id.tvDevicesName))) == null || (a3 = f4.b.a(view, (i = R$id.tvWifiSsid))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g((FrameLayout) view, a4, a, a2, a3);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
