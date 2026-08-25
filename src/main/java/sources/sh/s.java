package sh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.JsonViewer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class s implements f4.a {
    private final LinearLayout a;
    public final JsonViewer b;

    private s(LinearLayout linearLayout, JsonViewer jsonViewer) {
        this.a = linearLayout;
        this.b = jsonViewer;
    }

    public static s a(View view) {
        int i = R$id.jsonViewer;
        JsonViewer a = f4.b.a(view, i);
        if (a != null) {
            return new s((LinearLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static s c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_plan_detail_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
