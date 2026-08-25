package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final ResourcesRequestView e;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ResourcesRequestView resourcesRequestView) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = resourcesRequestView;
    }

    public static k a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.innerIcon;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R$id.innerTvInfo))) != null && (a2 = f4.b.a(view, (i = R$id.innerTvTitle))) != null) {
            i = R$id.iv_resources;
            ResourcesRequestView resourcesRequestView = (ResourcesRequestView) f4.b.a(view, i);
            if (resourcesRequestView != null) {
                return new k((ConstraintLayout) view, a3, a, a2, resourcesRequestView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_resource_detector_empty_layout, viewGroup, false);
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
