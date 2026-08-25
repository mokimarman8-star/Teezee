package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;", "Landroidx/activity/ComponentActivity$e;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Ljava/lang/Runnable;", "<init>", "(Landroidx/activity/ComponentActivity;)V", "Landroid/view/View;", "view", "", "viewCreated", "(Landroid/view/View;)V", "activityDestroyed", "()V", "runnable", "execute", "(Ljava/lang/Runnable;)V", "onDraw", "run", "", "endWatchTimeMillis", "J", "getEndWatchTimeMillis", "()J", "currentRunnable", "Ljava/lang/Runnable;", "getCurrentRunnable", "()Ljava/lang/Runnable;", "setCurrentRunnable", "", "onDrawScheduled", "Z", "getOnDrawScheduled", "()Z", "setOnDrawScheduled", "(Z)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ComponentActivity$ReportFullyDrawnExecutorImpl implements ComponentActivity$e, ViewTreeObserver.OnDrawListener, Runnable {
    private Runnable currentRunnable;
    private final long endWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
    private boolean onDrawScheduled;
    final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$ReportFullyDrawnExecutorImpl(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$0(ComponentActivity$ReportFullyDrawnExecutorImpl componentActivity$ReportFullyDrawnExecutorImpl) {
        Runnable runnable = componentActivity$ReportFullyDrawnExecutorImpl.currentRunnable;
        if (runnable != null) {
            Intrinsics.e(runnable);
            runnable.run();
            componentActivity$ReportFullyDrawnExecutorImpl.currentRunnable = null;
        }
    }

    @Override // androidx.activity.ComponentActivity$e
    public void activityDestroyed() {
        this.this$0.getWindow().getDecorView().removeCallbacks(this);
        this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Intrinsics.h(runnable, "runnable");
        this.currentRunnable = runnable;
        View decorView = this.this$0.getWindow().getDecorView();
        Intrinsics.g(decorView, "window.decorView");
        if (!this.onDrawScheduled) {
            decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.j
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$ReportFullyDrawnExecutorImpl.execute$lambda$0(ComponentActivity$ReportFullyDrawnExecutorImpl.this);
                }
            });
        } else if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    public final Runnable getCurrentRunnable() {
        return this.currentRunnable;
    }

    public final long getEndWatchTimeMillis() {
        return this.endWatchTimeMillis;
    }

    public final boolean getOnDrawScheduled() {
        return this.onDrawScheduled;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        Runnable runnable = this.currentRunnable;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.endWatchTimeMillis) {
                this.onDrawScheduled = false;
                this.this$0.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.currentRunnable = null;
        if (this.this$0.getFullyDrawnReporter().c()) {
            this.onDrawScheduled = false;
            this.this$0.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }

    public final void setCurrentRunnable(Runnable runnable) {
        this.currentRunnable = runnable;
    }

    public final void setOnDrawScheduled(boolean z5) {
        this.onDrawScheduled = z5;
    }

    @Override // androidx.activity.ComponentActivity$e
    public void viewCreated(View view) {
        Intrinsics.h(view, "view");
        if (this.onDrawScheduled) {
            return;
        }
        this.onDrawScheduled = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }
}
