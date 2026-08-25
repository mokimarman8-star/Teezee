package jn;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private Context a;
    private View b;
    private boolean d;
    private boolean e;
    private boolean f;
    private GestureDetector g;
    private a h;
    private boolean i;
    private View j;
    private boolean c = true;
    private final GestureDetector.OnGestureListener k = new c();

    public interface a {
        void a();

        void b(float f, float f2);

        void c(float f, float f2);

        void d(float f, float f2);

        void e();

        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);
    }

    public static final class b implements GestureDetector.OnDoubleTapListener {
        b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            a aVar = e.this.h;
            if (aVar == null) {
                return false;
            }
            aVar.onDoubleTap(motionEvent);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            a aVar = e.this.h;
            if (aVar == null) {
                return false;
            }
            aVar.a();
            return false;
        }
    }

    public static final class c implements GestureDetector.OnGestureListener {
        private float a;

        c() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            this.a = motionEvent.getX();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Intrinsics.h(motionEvent2, "e2");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            a aVar = e.this.h;
            if (aVar != null) {
                aVar.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Intrinsics.h(motionEvent2, "e2");
            if (!e.this.c || motionEvent == null) {
                return false;
            }
            if (Math.abs(f) <= Math.abs(f2)) {
                boolean unused = e.this.d;
            } else if (!e.this.f && !e.this.e) {
                e.this.d = true;
            }
            if (e.this.d) {
                a aVar = e.this.h;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), motionEvent2.getX());
                }
            } else if (e.this.i) {
                e eVar = e.this;
                View view = eVar.j;
                Intrinsics.e(view);
                if (eVar.p(view, (int) this.a)) {
                    e.this.f = true;
                    a aVar2 = e.this.h;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), motionEvent2.getY());
                    }
                } else {
                    e eVar2 = e.this;
                    View view2 = eVar2.j;
                    Intrinsics.e(view2);
                    if (eVar2.r(view2, (int) this.a)) {
                        e.this.e = true;
                        a aVar3 = e.this.h;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), motionEvent2.getY());
                        }
                    }
                }
            } else if (e.this.o((int) this.a)) {
                e.this.f = true;
                a aVar4 = e.this.h;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), motionEvent2.getY());
                }
            } else if (e.this.q((int) this.a)) {
                e.this.e = true;
                a aVar5 = e.this.h;
                if (aVar5 != null) {
                    aVar5.d(motionEvent.getY(), motionEvent2.getY());
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Intrinsics.h(motionEvent, "e");
            return false;
        }
    }

    public e(Context context, View view) {
        this.a = context;
        this.b = view;
        m();
    }

    private final void m() {
        this.g = new GestureDetector(this.a, this.k);
        View view = this.b;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: jn.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean n;
                n = e.n(e.this, view2, motionEvent);
                return n;
            }
        });
        GestureDetector gestureDetector = this.g;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(e eVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = eVar.h;
            if (aVar != null) {
                aVar.e();
            }
            eVar.f = false;
            eVar.e = false;
            eVar.d = false;
        }
        GestureDetector gestureDetector = eVar.g;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final void l(boolean z) {
        this.c = z;
    }

    public final boolean o(int i) {
        return i < y.e() / 2;
    }

    public final boolean p(View view, int i) {
        Intrinsics.h(view, "view");
        return i < view.getMeasuredWidth() / 2;
    }

    public final boolean q(int i) {
        return i > y.e() / 2;
    }

    public final boolean r(View view, int i) {
        Intrinsics.h(view, "view");
        return i > view.getMeasuredWidth() / 2;
    }

    public final void s(a aVar) {
        this.h = aVar;
    }
}
