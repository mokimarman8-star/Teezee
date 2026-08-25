package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class GridLayoutManager$b extends RecyclerView$n {

    /* renamed from: a, reason: collision with root package name */
    int f12799a;

    /* renamed from: b, reason: collision with root package name */
    int f12800b;

    public GridLayoutManager$b(int i5, int i6) {
        super(i5, i6);
        this.f12799a = -1;
        this.f12800b = 0;
    }

    public GridLayoutManager$b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12799a = -1;
        this.f12800b = 0;
    }

    public GridLayoutManager$b(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f12799a = -1;
        this.f12800b = 0;
    }

    public GridLayoutManager$b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f12799a = -1;
        this.f12800b = 0;
    }

    public int a() {
        return this.f12799a;
    }

    public int b() {
        return this.f12800b;
    }
}
