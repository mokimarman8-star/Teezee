package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final FrameLayout a;
    public final RecyclerView b;

    private b(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = recyclerView;
    }

    public static b a(View view) {
        int i = R$id.rv_list;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new b((FrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_recent_list, viewGroup, false);
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
