package u3;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.media3.common.PlaybackException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18022a = new a();

    /* renamed from: u3.a$a, reason: collision with other inner class name */
    private static final class C0175a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0175a f18023a = new C0175a();

        private C0175a() {
        }

        public final int a() {
            int extensionVersion;
            extensionVersion = SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE);
            return extensionVersion;
        }
    }

    private a() {
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0175a.f18023a.a();
        }
        return 0;
    }
}
