package androidx.core.widget;

import android.widget.ListView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class i extends AutoScrollHelper {

    /* renamed from: s, reason: collision with root package name */
    private final ListView f7366s;

    public i(ListView listView) {
        super(listView);
        this.f7366s = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean a(int i5) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean b(int i5) {
        ListView listView = this.f7366s;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i6 = firstVisiblePosition + childCount;
        if (i5 > 0) {
            if (i6 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i5 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void j(int i5, int i6) {
        this.f7366s.scrollListBy(i6);
    }
}
