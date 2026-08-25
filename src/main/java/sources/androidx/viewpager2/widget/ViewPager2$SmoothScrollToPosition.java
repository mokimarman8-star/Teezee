package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewPager2$SmoothScrollToPosition implements Runnable {
    private final int mPosition;
    private final RecyclerView mRecyclerView;

    ViewPager2$SmoothScrollToPosition(int i5, RecyclerView recyclerView) {
        this.mPosition = i5;
        this.mRecyclerView = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mRecyclerView.smoothScrollToPosition(this.mPosition);
    }
}
