package xh;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public static final class a {
        public static String a(b bVar) {
            String simpleName = bVar.getClass().getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            return simpleName;
        }

        public static void b(b bVar, int i, String str, String str2, boolean z) {
            String str3;
            Intrinsics.h(str, "msg");
            Intrinsics.h(str2, "tag");
            if (TextUtils.isEmpty(bVar.getSceneId())) {
                str3 = bVar.getClassTag() + " --> " + str;
            } else {
                str3 = bVar.getClassTag() + " --> sceneId = " + bVar.getSceneId() + " --> " + str;
            }
            xh.a.a.l(bVar.getLogTag(), str3, i, z);
        }

        public static /* synthetic */ void c(b bVar, int i, String str, String str2, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLog");
            }
            if ((i2 & 1) != 0) {
                i = 3;
            }
            if ((i2 & 4) != 0) {
                str2 = bVar.getLogTag();
            }
            if ((i2 & 8) != 0) {
                z = true;
            }
            bVar.onLog(i, str, str2, z);
        }
    }

    String getClassTag();

    String getLogTag();

    String getSceneId();

    void onLog(int i, String str, String str2, boolean z);
}
