package androidx.viewpager.widget;

import android.database.DataSetObserver;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewPager$j extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager f13751a;

    ViewPager$j(ViewPager viewPager) {
        this.f13751a = viewPager;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f13751a.dataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f13751a.dataSetChanged();
    }
}
