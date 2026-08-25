package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class k implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;

    private k(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = appCompatImageView3;
        this.e = appCompatImageView4;
        this.f = appCompatTextView;
    }

    public static k a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        int i = R$id.ivClose;
        AppCompatImageView a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.ivDance))) == null || (a2 = f4.b.a(view, (i = R$id.ivLoop))) == null || (a3 = f4.b.a(view, (i = R$id.ivShuffle))) == null || (a4 = f4.b.a(view, (i = R$id.tvTitle))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((LinearLayoutCompat) view, a5, a, a2, a3, a4);
    }

    public static k c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.view_music_detail_list_operate_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
