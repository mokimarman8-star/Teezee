package androidx.appcompat.widget;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ForwardingListener$TriggerLongPress implements Runnable {
    final /* synthetic */ ForwardingListener this$0;

    ForwardingListener$TriggerLongPress(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.e();
    }
}
