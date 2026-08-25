package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i0 implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TnTextView c;
    public final TnTextView d;
    public final View e;

    private i0(ConstraintLayout constraintLayout, RecyclerView recyclerView, TnTextView tnTextView, TnTextView tnTextView2, View view) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = tnTextView;
        this.d = tnTextView2;
        this.e = view;
    }

    public static i0 a(View view) {
        TnTextView a;
        TnTextView a2;
        View a3;
        int i = R.id.historyRv;
        RecyclerView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.tvAll))) == null || (a2 = f4.b.a(view, (i = R.id.tvTitle))) == null || (a3 = f4.b.a(view, (i = R.id.vLine))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i0((ConstraintLayout) view, a4, a, a2, a3);
    }

    public static i0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_history_play_record_layout, viewGroup, false);
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
