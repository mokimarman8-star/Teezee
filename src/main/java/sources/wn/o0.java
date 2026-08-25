package wn;

import android.view.View;
import android.widget.ProgressBar;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o0 implements f4.a {
    private final View a;
    public final BLImageView b;
    public final ProgressBar c;
    public final BLTextView d;
    public final View e;

    private o0(View view, BLImageView bLImageView, ProgressBar progressBar, BLTextView bLTextView, View view2) {
        this.a = view;
        this.b = bLImageView;
        this.c = progressBar;
        this.d = bLTextView;
        this.e = view2;
    }

    public static o0 a(View view) {
        BLTextView a;
        View a2;
        int i = R$id.ivMute;
        BLImageView a3 = f4.b.a(view, i);
        if (a3 != null) {
            i = R$id.playerProgress;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a = f4.b.a(view, (i = R$id.tvVideoDuration))) != null && (a2 = f4.b.a(view, (i = R$id.vMuteHotZone))) != null) {
                return new o0(view, a3, progressBar, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
