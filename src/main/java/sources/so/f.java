package so;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f extends RecyclerView.a0 {
    private View a;
    private ImageView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        this.a = view;
        View findViewById = view.findViewById(R$id.image);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.b = (ImageView) findViewById;
    }

    public final ImageView f() {
        return this.b;
    }

    public final View g() {
        return this.a;
    }
}
