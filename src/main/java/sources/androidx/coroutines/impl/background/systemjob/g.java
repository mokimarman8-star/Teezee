package androidx.coroutines.impl.background.systemjob;

import android.app.job.JobInfo;
import android.net.Uri;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class g {
    public static /* synthetic */ JobInfo.TriggerContentUri a(Uri uri, int i5) {
        return new JobInfo.TriggerContentUri(uri, i5);
    }
}
