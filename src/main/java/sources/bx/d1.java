package bx;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d1 implements f4.a {
    private final BLFrameLayout a;
    public final RecyclerView b;

    private d1(BLFrameLayout bLFrameLayout, RecyclerView recyclerView) {
        this.a = bLFrameLayout;
        this.b = recyclerView;
    }

    public static d1 a(View view) {
        int i = R.id.recyclerView;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new d1((BLFrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.a;
    }
}
