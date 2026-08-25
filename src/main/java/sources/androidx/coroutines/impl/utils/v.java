package androidx.coroutines.impl.utils;

import androidx.coroutines.impl.WorkDatabase;
import androidx.work.j;
import androidx.work.n;
import k4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class v implements n {
    static final String c = j.i("WorkProgressUpdater");
    final WorkDatabase a;
    final c b;

    public v(WorkDatabase workDatabase, c cVar) {
        this.a = workDatabase;
        this.b = cVar;
    }
}
