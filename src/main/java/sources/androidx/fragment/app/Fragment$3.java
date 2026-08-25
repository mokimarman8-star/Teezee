package androidx.fragment.app;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class Fragment$3 implements Runnable {
    final /* synthetic */ Fragment this$0;

    Fragment$3(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.callStartTransitionListener(false);
    }
}
