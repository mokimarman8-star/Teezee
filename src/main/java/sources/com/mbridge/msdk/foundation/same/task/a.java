package com.mbridge.msdk.foundation.same.task;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a implements Runnable {

    /* renamed from: id, reason: collision with root package name */
    public static long f3id;
    public InterfaceC0088a mListener;
    public b mState = b.READY;

    /* renamed from: com.mbridge.msdk.foundation.same.task.a$a, reason: collision with other inner class name */
    public interface InterfaceC0088a {
        void a(b bVar);
    }

    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public a() {
        f3id++;
    }

    private void setState(b bVar) {
        this.mState = bVar;
        InterfaceC0088a interfaceC0088a = this.mListener;
        if (interfaceC0088a != null) {
            interfaceC0088a.a(bVar);
        }
    }

    public final void cancel() {
        b bVar = this.mState;
        b bVar2 = b.CANCEL;
        if (bVar != bVar2) {
            setState(bVar2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return f3id;
    }

    public b getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == b.READY) {
                setState(b.RUNNING);
                runTask();
                setState(b.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void runTask();

    public void setOnStateChangeListener(InterfaceC0088a interfaceC0088a) {
        this.mListener = interfaceC0088a;
    }

    public final void setPause(boolean z) {
        b bVar = this.mState;
        b bVar2 = b.PAUSE;
        if (bVar == bVar2 || bVar == b.CANCEL || bVar == b.FINISH) {
            return;
        }
        if (z) {
            setState(bVar2);
        } else {
            setState(b.RUNNING);
        }
        pauseTask(z);
    }
}
