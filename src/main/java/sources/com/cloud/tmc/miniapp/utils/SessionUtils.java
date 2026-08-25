package com.cloud.tmc.miniapp.utils;

import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.render.proxy.SessionUtilProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class SessionUtils implements SessionUtilProxy {
    public final ConcurrentHashMap<String, OooO00o> OooO00o = new ConcurrentHashMap<>();

    public static final class OooO00o {
        public boolean OooO00o;
        public String OooO0O0;

        public OooO00o() {
            this(false, null, 3);
        }

        public OooO00o(boolean z, String str) {
            Intrinsics.h(str, "id");
            this.OooO00o = z;
            this.OooO0O0 = str;
        }

        public /* synthetic */ OooO00o(boolean z, String str, int i) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "" : str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OooO00o)) {
                return false;
            }
            OooO00o oooO00o = (OooO00o) obj;
            return this.OooO00o == oooO00o.OooO00o && Intrinsics.c(this.OooO0O0, oooO00o.OooO0O0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z = this.OooO00o;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return this.OooO0O0.hashCode() + (r0 * 31);
        }

        public String toString() {
            return "IdData(isColdOpen=" + this.OooO00o + ", id=" + this.OooO0O0 + ")";
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public String getId(String str) {
        OooO00o oooO00o;
        if (str == null) {
            return "";
        }
        try {
            if (!this.OooO00o.containsKey(str) || (oooO00o = this.OooO00o.get(str)) == null) {
                return "";
            }
            String str2 = oooO00o.OooO0O0;
            return str2 == null ? "" : str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public void removeSession(String str) {
        if (str != null) {
            try {
                this.OooO00o.remove(str);
            } catch (Throwable unused) {
                Unit unit = Unit.a;
            }
        }
    }

    @Override // com.cloud.tmc.render.proxy.SessionUtilProxy
    public void updateSession(String str, boolean z, boolean z2) {
        if (str != null) {
            int i = 1;
            boolean z3 = false;
            try {
                if (z2) {
                    this.OooO00o.remove(str);
                    this.OooO00o.put(str, new OooO00o(z3, DeviceUtil.getGAId() + "_" + System.currentTimeMillis(), i));
                } else if (this.OooO00o.containsKey(str)) {
                    OooO00o oooO00o = (OooO00o) MapsKt.i(this.OooO00o, str);
                    boolean z4 = oooO00o.OooO00o;
                    if (z4 && z) {
                        oooO00o.OooO00o = false;
                    } else if (z && !z4) {
                        String str2 = DeviceUtil.getGAId() + "_" + System.currentTimeMillis();
                        Intrinsics.h(str2, "<set-?>");
                        oooO00o.OooO0O0 = str2;
                    }
                } else {
                    this.OooO00o.put(str, new OooO00o(z3, DeviceUtil.getGAId() + "_" + System.currentTimeMillis(), i));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
