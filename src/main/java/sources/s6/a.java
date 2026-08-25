package s6;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {

    /* renamed from: s6.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0152a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            try {
                iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadMoreStatus.End.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    private final void a(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    public void convert(BaseViewHolder baseViewHolder, int i, LoadMoreStatus loadMoreStatus) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(loadMoreStatus, "loadMoreStatus");
        int i2 = C0152a.a[loadMoreStatus.ordinal()];
        if (i2 == 1) {
            a(getLoadingView(baseViewHolder), false);
            a(getLoadComplete(baseViewHolder), true);
            a(getLoadFailView(baseViewHolder), false);
            a(getLoadEndView(baseViewHolder), false);
            return;
        }
        if (i2 == 2) {
            a(getLoadingView(baseViewHolder), true);
            a(getLoadComplete(baseViewHolder), false);
            a(getLoadFailView(baseViewHolder), false);
            a(getLoadEndView(baseViewHolder), false);
            return;
        }
        if (i2 == 3) {
            a(getLoadingView(baseViewHolder), false);
            a(getLoadComplete(baseViewHolder), false);
            a(getLoadFailView(baseViewHolder), true);
            a(getLoadEndView(baseViewHolder), false);
            return;
        }
        if (i2 != 4) {
            return;
        }
        a(getLoadingView(baseViewHolder), false);
        a(getLoadComplete(baseViewHolder), false);
        a(getLoadFailView(baseViewHolder), false);
        a(getLoadEndView(baseViewHolder), true);
    }

    public abstract View getLoadComplete(BaseViewHolder baseViewHolder);

    public abstract View getLoadEndView(BaseViewHolder baseViewHolder);

    public abstract View getLoadFailView(BaseViewHolder baseViewHolder);

    public abstract View getLoadingView(BaseViewHolder baseViewHolder);

    public abstract View getRootView(ViewGroup viewGroup);
}
