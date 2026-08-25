package pw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d implements f4.a {
    private final CardView a;
    public final CardView b;
    public final AppCompatTextView c;
    public final CardView d;
    public final TextView e;
    public final AppCompatImageView f;
    public final MediaView g;
    public final FrameLayout h;
    public final TextView i;

    private d(CardView cardView, CardView cardView2, AppCompatTextView appCompatTextView, CardView cardView3, TextView textView, AppCompatImageView appCompatImageView, MediaView mediaView, FrameLayout frameLayout, TextView textView2) {
        this.a = cardView;
        this.b = cardView2;
        this.c = appCompatTextView;
        this.d = cardView3;
        this.e = textView;
        this.f = appCompatImageView;
        this.g = mediaView;
        this.h = frameLayout;
        this.i = textView2;
    }

    public static d a(View view) {
        AppCompatTextView a;
        AppCompatImageView a2;
        MediaView a3;
        int i = R$id.icon_cardview;
        CardView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.native_ad_action))) != null) {
            CardView cardView = (CardView) view;
            i = R$id.native_ad_des;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a2 = f4.b.a(view, (i = R$id.native_ad_icon))) != null && (a3 = f4.b.a(view, (i = R$id.native_ad_media))) != null) {
                i = R$id.native_ad_media_container;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null) {
                    i = R$id.native_ad_title;
                    TextView textView2 = (TextView) f4.b.a(view, i);
                    if (textView2 != null) {
                        return new d(cardView, a4, a, cardView, textView, a2, a3, frameLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static d c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.search_hot_hi_native_ad_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
