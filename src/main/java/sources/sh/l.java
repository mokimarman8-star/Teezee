package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.native_ad.BiddingFloatingIrregularAnimationView;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class l implements f4.a {
    private final FrameLayout a;
    public final BiddingFloatingIrregularAnimationView b;
    public final RecyclerView c;

    private l(FrameLayout frameLayout, BiddingFloatingIrregularAnimationView biddingFloatingIrregularAnimationView, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = biddingFloatingIrregularAnimationView;
        this.c = recyclerView;
    }

    public static l a(View view) {
        RecyclerView a;
        int i = R$id.irregularView;
        BiddingFloatingIrregularAnimationView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.rv))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new l((FrameLayout) view, a2, a);
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_irregular_layout, viewGroup, false);
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
