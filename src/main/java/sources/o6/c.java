package o6;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.config.utils.XLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    private final BaseQuickAdapter a;
    private final d b;
    private final j c;
    private Executor d;
    private final Executor e;
    private final List f;
    private int g;

    private static final class a implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Intrinsics.h(runnable, "command");
            this.a.post(runnable);
        }
    }

    public static final class b extends DiffUtil.a {
        final /* synthetic */ List a;
        final /* synthetic */ List b;
        final /* synthetic */ c c;

        b(List list, List list2, c cVar) {
            this.a = list;
            this.b = list2;
            this.c = cVar;
        }

        public boolean a(int i, int i2) {
            Object obj = this.a.get(i);
            Object obj2 = this.b.get(i2);
            if (obj != null && obj2 != null) {
                return this.c.b.b().areContentsTheSame(obj, obj2);
            }
            if (obj == null && obj2 == null) {
                return true;
            }
            throw new AssertionError();
        }

        public boolean b(int i, int i2) {
            Object obj = this.a.get(i);
            Object obj2 = this.b.get(i2);
            return (obj == null || obj2 == null) ? obj == null && obj2 == null : this.c.b.b().areItemsTheSame(obj, obj2);
        }

        public Object c(int i, int i2) {
            Object obj = this.a.get(i);
            Object obj2 = this.b.get(i2);
            if (obj == null || obj2 == null) {
                throw new AssertionError();
            }
            return this.c.b.b().getChangePayload(obj, obj2);
        }

        public int d() {
            return this.b.size();
        }

        public int e() {
            return this.a.size();
        }
    }

    public c(BaseQuickAdapter baseQuickAdapter, d dVar) {
        Intrinsics.h(baseQuickAdapter, "adapter");
        Intrinsics.h(dVar, XLogUtil.TAG);
        this.a = baseQuickAdapter;
        this.b = dVar;
        this.c = new e(baseQuickAdapter);
        Executor aVar = new a();
        this.e = aVar;
        Executor c = dVar.c();
        this.d = c != null ? c : aVar;
        this.f = new CopyOnWriteArrayList();
    }

    private final void d(List list, DiffUtil.d dVar, Runnable runnable) {
        List data = this.a.getData();
        this.a.Q0(list);
        dVar.b(this.c);
        e(data, runnable);
    }

    private final void e(List list, Runnable runnable) {
        Iterator it = this.f.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            this.a.getData();
            throw null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final c cVar, List list, final List list2, final int i, final Runnable runnable) {
        Intrinsics.h(cVar, "this$0");
        Intrinsics.h(list, "$oldList");
        final DiffUtil.d b2 = DiffUtil.b(new b(list, list2, cVar));
        Intrinsics.g(b2, "@JvmOverloads\n    fun su…        }\n        }\n    }");
        cVar.d.execute(new Runnable() { // from class: o6.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c.this, i, list2, b2, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c cVar, int i, List list, DiffUtil.d dVar, Runnable runnable) {
        Intrinsics.h(cVar, "this$0");
        Intrinsics.h(dVar, "$result");
        if (cVar.g == i) {
            cVar.d(list, dVar, runnable);
        }
    }

    public final void f(final List list, final Runnable runnable) {
        final int i = this.g + 1;
        this.g = i;
        if (list == this.a.getData()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        final List data = this.a.getData();
        if (list == null) {
            int size = this.a.getData().size();
            this.a.Q0(new ArrayList());
            this.c.onRemoved(0, size);
            e(data, runnable);
            return;
        }
        if (!this.a.getData().isEmpty()) {
            this.b.a().execute(new Runnable() { // from class: o6.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.g(c.this, data, list, i, runnable);
                }
            });
            return;
        }
        this.a.Q0(list);
        this.c.onInserted(0, list.size());
        e(data, runnable);
    }
}
