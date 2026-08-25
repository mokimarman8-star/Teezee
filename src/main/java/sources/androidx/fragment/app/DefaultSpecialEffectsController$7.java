package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DefaultSpecialEffectsController$7 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ FragmentTransitionImpl val$impl;
    final /* synthetic */ Rect val$lastInEpicenterRect;
    final /* synthetic */ View val$lastInEpicenterView;

    DefaultSpecialEffectsController$7(DefaultSpecialEffectsController defaultSpecialEffectsController, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$impl = fragmentTransitionImpl;
        this.val$lastInEpicenterView = view;
        this.val$lastInEpicenterRect = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$impl.h(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
    }
}
