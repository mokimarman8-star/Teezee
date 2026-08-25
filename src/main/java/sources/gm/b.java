package gm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final LinearLayoutCompat a;
    public final FrameLayout b;
    public final j c;
    public final AppCompatTextView d;

    private b(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, j jVar, AppCompatTextView appCompatTextView) {
        this.a = linearLayoutCompat;
        this.b = frameLayout;
        this.c = jVar;
        this.d = appCompatTextView;
    }

    public static b a(View view) {
        View a;
        int i = R$id.container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.titleLayout))) != null) {
            j a2 = j.a(a);
            int i2 = R$id.tvTotalCoin;
            AppCompatTextView a3 = f4.b.a(view, i2);
            if (a3 != null) {
                return new b((LinearLayoutCompat) view, frameLayout, a2, a3);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_points_history_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
