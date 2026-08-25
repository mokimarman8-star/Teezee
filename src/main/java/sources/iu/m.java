package iu;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class m implements f4.a {
    private final FrameLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final BLTextView d;

    private m(FrameLayout frameLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView) {
        this.a = frameLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = bLTextView;
    }

    public static m a(View view) {
        AppCompatTextView a;
        BLTextView a2;
        int i = R$id.tvUGCImmDownloading;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tvUGCImmDownloadingPercent))) == null || (a2 = f4.b.a(view, (i = R$id.tvUGCImmDownloadingView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new m((FrameLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
