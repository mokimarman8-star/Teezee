package com.transsion.shorttv.base.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.y;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    private Context b;
    private View c;
    private boolean e;
    private boolean f;
    private boolean g;
    private GestureDetector h;
    private a i;
    private boolean j;
    private View k;
    private final String a = e.class.getSimpleName();
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
            a aVar = e.this.i;
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
            a aVar = e.this.i;
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
            a aVar = e.this.i;
            if (aVar != null) {
                aVar.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Intrinsics.h(motionEvent2, "e2");
            if (!e.this.d || motionEvent == null) {
                return false;
            }
            if (Math.abs(f) <= Math.abs(f2)) {
                boolean unused = e.this.e;
            } else if (!e.this.g && !e.this.f) {
                e.this.e = true;
            }
            if (e.this.e) {
                a aVar = e.this.i;
                if (aVar != null) {
                    aVar.b(motionEvent.getX(), motionEvent2.getX());
                }
            } else if (e.this.j) {
                e eVar = e.this;
                View view = eVar.k;
                Intrinsics.e(view);
                if (eVar.o(view, (int) this.a)) {
                    e.this.g = true;
                    a aVar2 = e.this.i;
                    if (aVar2 != null) {
                        aVar2.c(motionEvent.getY(), motionEvent2.getY());
                    }
                } else {
                    e eVar2 = e.this;
                    View view2 = eVar2.k;
                    Intrinsics.e(view2);
                    if (eVar2.q(view2, (int) this.a)) {
                        e.this.f = true;
                        a aVar3 = e.this.i;
                        if (aVar3 != null) {
                            aVar3.d(motionEvent.getY(), motionEvent2.getY());
                        }
                    }
                }
            } else if (e.this.n((int) this.a)) {
                e.this.g = true;
                a aVar4 = e.this.i;
                if (aVar4 != null) {
                    aVar4.c(motionEvent.getY(), motionEvent2.getY());
                }
            } else if (e.this.p((int) this.a)) {
                e.this.f = true;
                a aVar5 = e.this.i;
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
        this.b = context;
        this.c = view;
        l();
    }

    private final void l() {
        this.h = new GestureDetector(this.b, this.l);
        View view = this.c;
        Intrinsics.e(view);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.shorttv.base.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean m;
                m = e.m(e.this, view2, motionEvent);
                return m;
            }
        });
        GestureDetector gestureDetector = this.h;
        Intrinsics.e(gestureDetector);
        gestureDetector.setOnDoubleTapListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(e eVar, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            a aVar = eVar.i;
            if (aVar != null) {
                aVar.e();
            }
            eVar.g = false;
            eVar.f = false;
            eVar.e = false;
        }
        GestureDetector gestureDetector = eVar.h;
        Intrinsics.e(gestureDetector);
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public final boolean n(int i) {
        return i < y.e() / 2;
    }

    public final boolean o(View view, int i) {
        Intrinsics.h(view, "view");
        return i < view.getMeasuredWidth() / 2;
    }

    public final boolean p(int i) {
        return i > y.e() / 2;
    }

    public final boolean q(View view, int i) {
        Intrinsics.h(view, "view");
        return i > view.getMeasuredWidth() / 2;
    }

    public final void r(a aVar) {
        this.i = aVar;
    }
}
