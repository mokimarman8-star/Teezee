package fw;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import fw.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private boolean a;
    private final Handler b;
    private final ScaleGestureDetector c;
    private final GestureDetector d;

    /* renamed from: fw.a$a, reason: collision with other inner class name */
    public static final class C0058a extends GestureDetector.SimpleOnGestureListener {
        private float a;
        private float b;
        final /* synthetic */ c d;

        C0058a(c cVar) {
            this.d = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            Intrinsics.h(e, "e");
            this.a = e.getRawX();
            this.b = e.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent e2, float f, float f2) {
            Intrinsics.h(e2, "e2");
            if (a.this.a) {
                return false;
            }
            this.d.b(e2.getRawX() - this.a, e2.getRawY() - this.b);
            this.a = e2.getRawX();
            this.b = e2.getRawY();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Intrinsics.h(e, "e");
            this.d.a();
            return false;
        }
    }

    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {
        final /* synthetic */ c a;
        final /* synthetic */ a b;

        b(c cVar, a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a aVar) {
            aVar.a = false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.a.onScale(detector);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.b.a = true;
            this.b.b.removeCallbacksAndMessages(null);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            Intrinsics.h(detector, "detector");
            this.b.b.removeCallbacksAndMessages(null);
            Handler handler = this.b.b;
            final a aVar = this.b;
            handler.postDelayed(new Runnable() { // from class: fw.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(a.this);
                }
            }, 700L);
        }
    }

    public a(Context context, c videoFloatGestureListener) {
        Intrinsics.h(context, "context");
        Intrinsics.h(videoFloatGestureListener, "videoFloatGestureListener");
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ScaleGestureDetector(context, new b(videoFloatGestureListener, this));
        this.d = new GestureDetector(context, new C0058a(videoFloatGestureListener));
    }

    public final boolean d(MotionEvent ev2) {
        Intrinsics.h(ev2, "ev");
        return this.c.onTouchEvent(ev2) || this.d.onTouchEvent(ev2);
    }
}
