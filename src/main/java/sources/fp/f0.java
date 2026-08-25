package fp;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 implements f4.a {
    private final View a;
    public final RecyclerView b;

    private f0(View view, RecyclerView recyclerView) {
        this.a = view;
        this.b = recyclerView;
    }

    public static f0 a(View view) {
        int i = R$id.recyclerView;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            return new f0(view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
