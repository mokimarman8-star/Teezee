package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final LinearLayoutCompat a;
    public final FrameLayout b;
    public final LinearLayoutCompat c;

    private a(LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat2) {
        this.a = linearLayoutCompat;
        this.b = frameLayout;
        this.c = linearLayoutCompat2;
    }

    public static a a(View view) {
        int i = R$id.flComments;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
        return new a(linearLayoutCompat, frameLayout, linearLayoutCompat);
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_dev, viewGroup, false);
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
