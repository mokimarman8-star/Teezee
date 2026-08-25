package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final FrameLayout a;
    public final AppCompatImageView b;
    public final RecyclerView c;

    private k(FrameLayout frameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = appCompatImageView;
        this.c = recyclerView;
    }

    public static k a(View view) {
        RecyclerView a;
        int i = R$id.iv_close;
        AppCompatImageView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.recycler_view))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((FrameLayout) view, a2, a);
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_local_video_middle_ep, viewGroup, false);
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
