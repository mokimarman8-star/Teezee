package pw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f implements f4.a {
    private final ConstraintLayout a;
    public final CardView b;
    public final CardView c;
    public final NativeWrapperAdView d;

    private f(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, NativeWrapperAdView nativeWrapperAdView) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = cardView2;
        this.d = nativeWrapperAdView;
    }

    public static f a(View view) {
        CardView a;
        NativeWrapperAdView a2;
        int i = R$id.ad_detail_arrow;
        CardView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.ad_detail_btn))) == null || (a2 = f4.b.a(view, (i = R$id.adView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f((ConstraintLayout) view, a3, a, a2);
    }

    public static f c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.second_floor_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
