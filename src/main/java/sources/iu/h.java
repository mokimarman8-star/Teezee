package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final FrameLayout a;
    public final RecyclerView b;

    private h(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = recyclerView;
    }

    public static h a(View view) {
        int i = R$id.rvLanguage;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new h((FrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_imm_video_setting_subtitle, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
