package androidx.core.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$q {

    /* renamed from: d, reason: collision with root package name */
    private static final ArrayList f7163d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap f7164a = null;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray f7165b = null;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f7166c = null;

    ViewCompat$q() {
    }

    static ViewCompat$q a(View view) {
        ViewCompat$q viewCompat$q = (ViewCompat$q) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (viewCompat$q != null) {
            return viewCompat$q;
        }
        ViewCompat$q viewCompat$q2 = new ViewCompat$q();
        view.setTag(R.id.tag_unhandled_key_event_manager, viewCompat$q2);
        return viewCompat$q2;
    }

    private View c(View view, KeyEvent keyEvent) {
        WeakHashMap weakHashMap = this.f7164a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View c5 = c(viewGroup.getChildAt(childCount), keyEvent);
                    if (c5 != null) {
                        return c5;
                    }
                }
            }
            if (e(view, keyEvent)) {
                return view;
            }
        }
        return null;
    }

    private SparseArray d() {
        if (this.f7165b == null) {
            this.f7165b = new SparseArray();
        }
        return this.f7165b;
    }

    private boolean e(View view, KeyEvent keyEvent) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            return false;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((ViewCompat$OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        WeakHashMap weakHashMap = this.f7164a;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        ArrayList arrayList = f7163d;
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (arrayList) {
            try {
                if (this.f7164a == null) {
                    this.f7164a = new WeakHashMap();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList arrayList2 = f7163d;
                    View view = (View) ((WeakReference) arrayList2.get(size)).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f7164a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f7164a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void h(View view) {
        ArrayList arrayList = f7163d;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() == view) {
                        return;
                    }
                }
                f7163d.add(new WeakReference(view));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void i(View view) {
        synchronized (f7163d) {
            int i5 = 0;
            while (true) {
                try {
                    ArrayList arrayList = f7163d;
                    if (i5 >= arrayList.size()) {
                        return;
                    }
                    if (((WeakReference) arrayList.get(i5)).get() == view) {
                        arrayList.remove(i5);
                        return;
                    }
                    i5++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    boolean b(View view, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            g();
        }
        View c5 = c(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (c5 != null && !KeyEvent.isModifierKey(keyCode)) {
                d().put(keyCode, new WeakReference(c5));
            }
        }
        return c5 != null;
    }

    boolean f(KeyEvent keyEvent) {
        WeakReference weakReference;
        int indexOfKey;
        WeakReference weakReference2 = this.f7166c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        this.f7166c = new WeakReference(keyEvent);
        SparseArray d5 = d();
        if (keyEvent.getAction() != 1 || (indexOfKey = d5.indexOfKey(keyEvent.getKeyCode())) < 0) {
            weakReference = null;
        } else {
            weakReference = (WeakReference) d5.valueAt(indexOfKey);
            d5.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) d5.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view = (View) weakReference.get();
        if (view != null && view.isAttachedToWindow()) {
            e(view, keyEvent);
        }
        return true;
    }
}
