package androidx.appcompat.widget;

import android.view.ViewParent;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ForwardingListener$DisallowIntercept implements Runnable {
    final /* synthetic */ ForwardingListener this$0;

    ForwardingListener$DisallowIntercept(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewParent parent = this.this$0.d.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
