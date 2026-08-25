package zx;

import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.disposables.d;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements c, d {
    List a;
    volatile boolean b;

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean a(c cVar) {
        if (!c(cVar)) {
            return false;
        }
        cVar.dispose();
        return true;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean b(c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        List list = this.a;
                        if (list == null) {
                            list = new LinkedList();
                            this.a = list;
                        }
                        list.add(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // io.reactivex.rxjava3.disposables.d
    public boolean c(c cVar) {
        Objects.requireNonNull(cVar, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                List list = this.a;
                if (list != null && list.remove(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((c) it.next()).dispose();
            } catch (Throwable th) {
                io.reactivex.rxjava3.exceptions.a.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.g((Throwable) arrayList.get(0));
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                List list = this.a;
                this.a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.rxjava3.disposables.c
    public boolean isDisposed() {
        return this.b;
    }
}
