package pw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.transsion.ad.view.AdTagView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final AdChoicesView b;
    public final AdTagView c;
    public final AppCompatTextView d;
    public final MediaView e;
    public final FrameLayout f;

    private b(ConstraintLayout constraintLayout, AdChoicesView adChoicesView, AdTagView adTagView, AppCompatTextView appCompatTextView, MediaView mediaView, FrameLayout frameLayout) {
        this.a = constraintLayout;
        this.b = adChoicesView;
        this.c = adTagView;
        this.d = appCompatTextView;
        this.e = mediaView;
        this.f = frameLayout;
    }

    public static b a(View view) {
        AdTagView a;
        AppCompatTextView a2;
        MediaView a3;
        int i = R$id.adChoicesView;
        AdChoicesView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.adTag))) != null && (a2 = f4.b.a(view, (i = R$id.native_ad_action))) != null && (a3 = f4.b.a(view, (i = R$id.native_ad_media))) != null) {
            i = R$id.native_ad_media_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                return new b((ConstraintLayout) view, a4, a, a2, a3, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.media_content_ssp_native_ad_layout, viewGroup, false);
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
