package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DefaultItemAnimator$1 implements Runnable {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ArrayList val$moves;

    DefaultItemAnimator$1(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$moves = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.val$moves.iterator();
        while (it.hasNext()) {
            DefaultItemAnimator$g defaultItemAnimator$g = (DefaultItemAnimator$g) it.next();
            this.this$0.animateMoveImpl(defaultItemAnimator$g.f12730a, defaultItemAnimator$g.f12731b, defaultItemAnimator$g.f12732c, defaultItemAnimator$g.f12733d, defaultItemAnimator$g.f12734e);
        }
        this.val$moves.clear();
        this.this$0.mMovesList.remove(this.val$moves);
    }
}
