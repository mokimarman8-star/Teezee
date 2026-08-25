package androidx.coroutines.impl.utils;

import android.content.Context;
import androidx.coroutines.impl.WorkDatabase;
import androidx.work.e;
import androidx.work.f;
import androidx.work.impl.foreground.a;
import androidx.work.j;
import com.google.common.util.concurrent.r;
import j4.v;
import java.util.UUID;
import k4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class WorkForegroundUpdater implements f {
    private static final String d = j.i("WMFgUpdater");
    private final c a;
    final a b;
    final v c;

    public WorkForegroundUpdater(WorkDatabase workDatabase, a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
        this.c = workDatabase.n0();
    }

    public r a(Context context, UUID uuid, e eVar) {
        androidx.work.impl.utils.futures.a x = androidx.work.impl.utils.futures.a.x();
        this.a.c(new 1(this, x, uuid, eVar, context));
        return x;
    }
}
