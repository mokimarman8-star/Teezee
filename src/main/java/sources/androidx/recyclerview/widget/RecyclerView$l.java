package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class RecyclerView$l {
    @Deprecated
    public void getItemOffsets(@NonNull Rect rect, int i5, @NonNull RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        getItemOffsets(rect, ((RecyclerView$n) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
    }

    @Deprecated
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$x recyclerView$x) {
        onDraw(canvas, recyclerView);
    }

    @Deprecated
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
    }

    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView$x recyclerView$x) {
        onDrawOver(canvas, recyclerView);
    }
}
