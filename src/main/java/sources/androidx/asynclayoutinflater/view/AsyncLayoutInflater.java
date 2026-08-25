package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.h;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class AsyncLayoutInflater {

    /* renamed from: a, reason: collision with root package name */
    LayoutInflater f1139a;

    /* renamed from: d, reason: collision with root package name */
    private Handler.Callback f1142d = new a();

    /* renamed from: b, reason: collision with root package name */
    Handler f1140b = new Handler(this.f1142d);

    /* renamed from: c, reason: collision with root package name */
    InflateThread f1141c = InflateThread.getInstance();

    private static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<c> mQueue = new ArrayBlockingQueue<>(10);
        private h mRequestPool = new h(10);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(c cVar) {
            try {
                this.mQueue.put(cVar);
            } catch (InterruptedException e5) {
                throw new RuntimeException("Failed to enqueue async inflate request", e5);
            }
        }

        public c obtainRequest() {
            c cVar = (c) this.mRequestPool.acquire();
            return cVar == null ? new c() : cVar;
        }

        public void releaseRequest(c cVar) {
            cVar.f1149e = null;
            cVar.f1145a = null;
            cVar.f1146b = null;
            cVar.f1147c = 0;
            cVar.f1148d = null;
            this.mRequestPool.release(cVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                c take = this.mQueue.take();
                try {
                    take.f1148d = take.f1145a.f1139a.inflate(take.f1147c, take.f1146b, false);
                } catch (RuntimeException e5) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e5);
                }
                Message.obtain(take.f1145a.f1140b, 0, take).sendToTarget();
            } catch (InterruptedException e6) {
                Log.w("AsyncLayoutInflater", e6);
            }
        }
    }

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f1148d == null) {
                cVar.f1148d = AsyncLayoutInflater.this.f1139a.inflate(cVar.f1147c, cVar.f1146b, false);
            }
            cVar.f1149e.a(cVar.f1148d, cVar.f1147c, cVar.f1146b);
            AsyncLayoutInflater.this.f1141c.releaseRequest(cVar);
            return true;
        }
    }

    private static class b extends LayoutInflater {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f1144a = {"android.widget.", "android.webkit.", "android.app."};

        b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String str, AttributeSet attributeSet) {
            View createView;
            for (String str2 : f1144a) {
                try {
                    createView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (createView != null) {
                    return createView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        AsyncLayoutInflater f1145a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f1146b;

        /* renamed from: c, reason: collision with root package name */
        int f1147c;

        /* renamed from: d, reason: collision with root package name */
        View f1148d;

        /* renamed from: e, reason: collision with root package name */
        d f1149e;

        c() {
        }
    }

    public interface d {
        void a(View view, int i5, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(Context context) {
        this.f1139a = new b(context);
    }

    public void a(int i5, ViewGroup viewGroup, d dVar) {
        if (dVar == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        c obtainRequest = this.f1141c.obtainRequest();
        obtainRequest.f1145a = this;
        obtainRequest.f1147c = i5;
        obtainRequest.f1146b = viewGroup;
        obtainRequest.f1149e = dVar;
        this.f1141c.enqueue(obtainRequest);
    }
}
