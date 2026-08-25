package com.transsion.baseui.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    private Context b;
    private View c;
    private boolean e;
    private boolean f;
    private boolean g;
    private GestureDetector h;
    private a i;
    private boolean j;
    private View k;
    private final String a = f.class.getSimpleName();
    private boolean d = true;
    private final GestureDetector.OnGestureListener l = new c();

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
            a aVar = f.this.i;
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
            a aVar = f.this.i;
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
            a aVar = f.this.i;
            if (aVar != null) {
                aVar.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Intrinsics.h(motionEvent2, "e2");
            if (!f.this.d || motionEvent == null) {
                return false;
            }
            if (Math.abs(f) <= Math.abs(f2)) {
                boolean unused = f.this.e;
            } else if (!f.this.g && !f.this.f) {
                f.this.e = true;
            }
            if (f.this.e) {
                a aVar = f.this.i;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), motionEvent2.getX());
                }
            } else if (f.this.j) {
                f fVar = f.this;
                View view = fVar.k;
                Intrinsics.e(view);
                if (fVar.p(view, (int) this.a)) {
                    f.this.g = true;
                    a aVar2 = f.this.i;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), motionEvent2.getY());
                    }
                } else {
                    f fVar2 = f.this;
                    View view2 = fVar2.k;
                    Intrinsics.e(view2);
                    if (fVar2.r(view2, (int) this.a)) {
                        f.this.f = true;
                        a aVar3 = f.this.i;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), motionEvent2.getY());
                        }
                    }
                }
            } else if (f.this.o((int) this.a)) {
                f.this.g = true;
                a aVar4 = f.this.i;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), motionEvent2.getY());
                }
            } else if (f.this.q((int) this.a)) {
                f.this.f = true;
                a aVar5 = f.this.i;
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

    public f(Context context, View view) {
        this.b = context;
        this.c = view;
        m();
    }

    private final void m() {
        this.h = new GestureDetector(this.b, this.l);
        View view = this.c;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.baseui.widget.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean n;
                n = f.n(f.this, view2, motionEvent);
                return n;
            }
        });
        GestureDetector gestureDetector = this.h;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(f fVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = fVar.i;
            if (aVar != null) {
                aVar.e();
            }
            fVar.g = false;
            fVar.f = false;
            fVar.e = false;
        }
        GestureDetector gestureDetector = fVar.h;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final void l(boolean z) {
        this.d = z;
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
        this.i = aVar;
    }
}
