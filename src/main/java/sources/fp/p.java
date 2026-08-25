package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p implements f4.a {
    private final LinearLayout a;
    public final FrameLayout b;
    public final RecyclerView c;

    private p(LinearLayout linearLayout, FrameLayout frameLayout, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = recyclerView;
    }

    public static p a(View view) {
        RecyclerView a;
        int i = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R$id.recycler_view))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new p((LinearLayout) view, frameLayout, a);
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_filter_list, viewGroup, false);
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
