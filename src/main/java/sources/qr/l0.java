package qr;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l0 implements f4.a {
    private final BLFrameLayout a;
    public final RecyclerView b;

    private l0(BLFrameLayout bLFrameLayout, RecyclerView recyclerView) {
        this.a = bLFrameLayout;
        this.b = recyclerView;
    }

    public static l0 a(View view) {
        int i = R.id.recycler_view;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new l0((BLFrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.a;
    }
}
