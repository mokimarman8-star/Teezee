package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final ProgressBar c;

    private a(FrameLayout frameLayout, FrameLayout frameLayout2, ProgressBar progressBar) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = progressBar;
    }

    public static a a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R$id.ugcPbLoading;
        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
        if (progressBar != null) {
            return new a(frameLayout, frameLayout, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_ugc_video_detail, viewGroup, false);
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
