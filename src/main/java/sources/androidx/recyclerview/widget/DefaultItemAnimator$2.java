package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DefaultItemAnimator$2 implements Runnable {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ArrayList val$changes;

    DefaultItemAnimator$2(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$changes = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.val$changes.iterator();
        while (it.hasNext()) {
            this.this$0.animateChangeImpl((DefaultItemAnimator$f) it.next());
        }
        this.val$changes.clear();
        this.this$0.mChangesList.remove(this.val$changes);
    }
}
