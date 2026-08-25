package pb;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final /* synthetic */ class h implements OnFailureListener {
    public final void onFailure(Exception exc) {
        FirebaseCrashlytics.a(exc);
    }
}
