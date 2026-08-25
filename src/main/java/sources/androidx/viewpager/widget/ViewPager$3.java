package androidx.viewpager.widget;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewPager$3 implements Runnable {
    final /* synthetic */ ViewPager this$0;

    ViewPager$3(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.setScrollState(0);
        this.this$0.populate();
    }
}
