package androidx.appcompat.widget;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class AbsActionBarView$1 implements Runnable {
    final /* synthetic */ AbsActionBarView this$0;

    AbsActionBarView$1(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.showOverflowMenu();
    }
}
