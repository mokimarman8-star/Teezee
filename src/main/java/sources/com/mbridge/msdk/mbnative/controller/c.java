package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    private WeakReference<ViewTreeObserver> a;
    private List<View> b;
    private ViewTreeObserver.OnPreDrawListener c;
    private d d;
    private Handler e;
    private boolean f;
    private int g;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            c.this.b();
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
        }
    }

    /* renamed from: com.mbridge.msdk.mbnative.controller.c$c, reason: collision with other inner class name */
    class RunnableC0104c implements Runnable {
        final /* synthetic */ View a;

        RunnableC0104c(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                c.this.a = new WeakReference(viewTreeObserver);
                if (c.this.c != null) {
                    viewTreeObserver.addOnPreDrawListener(c.this.c);
                }
            }
        }
    }

    public interface d {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public c(List<View> list, d dVar, Handler handler, int i) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = null;
        this.d = dVar;
        this.e = handler;
        this.g = i;
        if (list != null) {
            this.b = list;
        } else {
            arrayList.clear();
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f) {
            return;
        }
        Handler handler = this.e;
        if (handler != null) {
            if (this.g == 1) {
                d();
            } else {
                handler.postDelayed(new b(), 100L);
            }
        }
        this.f = true;
    }

    private boolean b(View view) {
        return !b1.a(view, this.g);
    }

    private void c() {
        try {
            b();
        } catch (Throwable th) {
            o0.b("ImpressionTracker", th.getMessage(), th);
        }
        try {
            this.c = new a();
        } catch (Throwable th2) {
            o0.b("ImpressionTracker", th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f = false;
            List<View> list = this.b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i = 0; i < this.b.size(); i++) {
                View view = this.b.get(i);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    public void a() {
        try {
            this.f = false;
            WeakReference<ViewTreeObserver> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.c);
                }
                this.a.clear();
            }
            this.d = null;
            this.c = null;
            List<View> list = this.b;
            if (list != null) {
                list.clear();
            }
            this.b = null;
        } catch (Throwable unused) {
        }
    }

    public void a(View view) {
        View view2;
        View view3;
        if (view != null) {
            view2 = f.a(view.getContext(), view);
            this.b.add(view);
        } else {
            List<View> list = this.b;
            view2 = null;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.b.size() && ((view3 = this.b.get(i)) == null || (view2 = f.a(view3.getContext(), view3)) == null); i++) {
                }
            }
        }
        if (view2 == null) {
            return;
        }
        view2.post(new RunnableC0104c(view2));
    }
}
