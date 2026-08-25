package mg;

import com.cloud.config.utils.CommonUtils;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0150a a = new C0150a(null);
    private static MMKV b = xg.a.a.a();

    /* renamed from: mg.a$a, reason: collision with other inner class name */
    public static final class C0150a {
        private C0150a() {
        }

        public /* synthetic */ C0150a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String string;
            MMKV c = c();
            return (c == null || (string = c.getString("install_ch", "")) == null) ? "" : string;
        }

        public final String b() {
            String string;
            MMKV c = c();
            return (c == null || (string = c.getString("install_id", "")) == null) ? "" : string;
        }

        public final MMKV c() {
            return a.b;
        }

        public final String d() {
            String string;
            MMKV c = c();
            return (c == null || (string = c.getString("install_share_uid", "")) == null) ? "" : string;
        }

        public final void e(String str) {
            Intrinsics.h(str, "v");
            MMKV c = c();
            if (c != null) {
                c.putString("install_ch", str);
            }
        }

        public final void f(String str) {
            Intrinsics.h(str, "v");
            MMKV c = c();
            if (c != null) {
                c.putString("install_id", str);
            }
        }

        public final void g(String str) {
            Intrinsics.h(str, CommonUtils.PARAM_UID);
            MMKV c = c();
            if (c != null) {
                c.putString("install_share_uid", str);
            }
        }

        public final void h(String str) {
            Intrinsics.h(str, "userId");
            MMKV c = c();
            if (c != null) {
                c.putString("myuserid", str);
            }
        }
    }
}
