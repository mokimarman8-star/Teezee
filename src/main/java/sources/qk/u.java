package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u implements f4.a {
    private final LinearLayout a;
    public final FrameLayout b;
    public final View c;
    public final ConstraintLayout d;

    private u(LinearLayout linearLayout, FrameLayout frameLayout, View view, ConstraintLayout constraintLayout) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = view;
        this.d = constraintLayout;
    }

    public static u a(View view) {
        View a;
        ConstraintLayout a2;
        int i = R.id.fl_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R.id.sub_room_header_bg))) == null || (a2 = f4.b.a(view, (i = R.id.sub_room_title_layout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new u((LinearLayout) view, frameLayout, a, a2);
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_room, viewGroup, false);
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
