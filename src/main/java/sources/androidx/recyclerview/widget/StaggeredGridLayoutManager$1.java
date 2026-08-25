package androidx.recyclerview.widget;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class StaggeredGridLayoutManager$1 implements Runnable {
    final /* synthetic */ StaggeredGridLayoutManager this$0;

    StaggeredGridLayoutManager$1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.q();
    }
}
