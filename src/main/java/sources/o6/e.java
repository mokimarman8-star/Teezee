package o6;

import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;
import t6.f;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class e implements j {
    private final BaseQuickAdapter a;

    public e(BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(baseQuickAdapter, "mAdapter");
        this.a = baseQuickAdapter;
    }

    public void onChanged(int i, int i2, Object obj) {
        BaseQuickAdapter baseQuickAdapter = this.a;
        baseQuickAdapter.notifyItemRangeChanged(i + baseQuickAdapter.a0(), i2, obj);
    }

    public void onInserted(int i, int i2) {
        BaseQuickAdapter baseQuickAdapter = this.a;
        baseQuickAdapter.notifyItemRangeInserted(i + baseQuickAdapter.a0(), i2);
    }

    public void onMoved(int i, int i2) {
        BaseQuickAdapter baseQuickAdapter = this.a;
        baseQuickAdapter.notifyItemMoved(i + baseQuickAdapter.a0(), i2 + this.a.a0());
    }

    public void onRemoved(int i, int i2) {
        f i0 = this.a.i0();
        if (i0 != null && i0.m() && this.a.getItemCount() == 0) {
            BaseQuickAdapter baseQuickAdapter = this.a;
            baseQuickAdapter.notifyItemRangeRemoved(i + baseQuickAdapter.a0(), i2 + 1);
        } else {
            BaseQuickAdapter baseQuickAdapter2 = this.a;
            baseQuickAdapter2.notifyItemRangeRemoved(i + baseQuickAdapter2.a0(), i2);
        }
    }
}
