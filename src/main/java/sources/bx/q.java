package bx;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q implements f4.a {
    private final View a;
    public final AppCompatImageView b;
    public final LinearLayoutCompat c;
    public final TnTextView d;

    private q(View view, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, TnTextView tnTextView) {
        this.a = view;
        this.b = appCompatImageView;
        this.c = linearLayoutCompat;
        this.d = tnTextView;
    }

    public static q a(View view) {
        LinearLayoutCompat a;
        TnTextView a2;
        int i = R.id.iv_icon;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.ll_download_inner))) == null || (a2 = f4.b.a(view, (i = R.id.tv_tips))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new q(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
