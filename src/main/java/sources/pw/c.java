package pw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final CardView d;
    public final AppCompatImageView e;

    private c(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, CardView cardView, AppCompatImageView appCompatImageView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = frameLayout3;
        this.d = cardView;
        this.e = appCompatImageView;
    }

    public static c a(View view) {
        CardView a;
        AppCompatImageView a2;
        int i = R$id.ad_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.ad_cover;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null && (a = f4.b.a(view, (i = R$id.cardView))) != null && (a2 = f4.b.a(view, (i = R$id.swipe_guide))) != null) {
                return new c((FrameLayout) view, frameLayout, frameLayout2, a, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.native_card_page_item, viewGroup, false);
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
