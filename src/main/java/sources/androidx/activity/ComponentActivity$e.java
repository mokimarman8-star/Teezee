package androidx.activity;

import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface ComponentActivity$e extends Executor {
    void activityDestroyed();

    void viewCreated(View view);
}
