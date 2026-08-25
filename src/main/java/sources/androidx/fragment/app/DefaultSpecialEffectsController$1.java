package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class DefaultSpecialEffectsController$1 implements Runnable {
    final /* synthetic */ DefaultSpecialEffectsController this$0;
    final /* synthetic */ List val$awaitingContainerChanges;
    final /* synthetic */ SpecialEffectsController.Operation val$operation;

    DefaultSpecialEffectsController$1(DefaultSpecialEffectsController defaultSpecialEffectsController, List list, SpecialEffectsController.Operation operation) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$awaitingContainerChanges = list;
        this.val$operation = operation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$awaitingContainerChanges.contains(this.val$operation)) {
            this.val$awaitingContainerChanges.remove(this.val$operation);
            this.this$0.s(this.val$operation);
        }
    }
}
