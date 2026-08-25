package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
        return null;
    }

    public void onActivityResized(int i5, int i6, @NonNull Bundle bundle) {
    }

    public void onMessageChannelReady(@Nullable Bundle bundle) {
    }

    public void onNavigationEvent(int i5, Bundle bundle) {
    }

    public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
    }

    public void onRelationshipValidationResult(int i5, @NonNull Uri uri, boolean z5, @Nullable Bundle bundle) {
    }
}
