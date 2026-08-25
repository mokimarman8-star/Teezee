package bx;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class v0 implements f4.a {
    private final View a;
    public final RecyclerView b;

    private v0(View view, RecyclerView recyclerView) {
        this.a = view;
        this.b = recyclerView;
    }

    public static v0 a(View view) {
        int i = R.id.recycler_view;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new v0(view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
