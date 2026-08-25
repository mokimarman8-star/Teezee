package androidx.coroutines;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.d0;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class WorkManager {

    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    protected WorkManager() {
    }

    public static WorkManager f(Context context) {
        return d0.o(context);
    }

    public static void h(Context context, a aVar) {
        d0.h(context, aVar);
    }

    public final p a(String str, ExistingWorkPolicy existingWorkPolicy, k kVar) {
        return b(str, existingWorkPolicy, Collections.singletonList(kVar));
    }

    public abstract p b(String str, ExistingWorkPolicy existingWorkPolicy, List list);

    public final l c(r rVar) {
        return d(Collections.singletonList(rVar));
    }

    public abstract l d(List list);

    public abstract l e(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, m mVar);

    public abstract LiveData g(UUID uuid);
}
