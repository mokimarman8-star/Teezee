package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import com.cloud.tmc.kernel.utils.TraceLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOOO0 {
    public long OooO00o;

    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[RenderAnalyseType.values().length];
            try {
                iArr[RenderAnalyseType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RenderAnalyseType.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RenderAnalyseType.CONSOLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            OooO00o = iArr;
        }
    }

    public OooOOO0() {
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.INIT;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO00o(String str, RenderAnalyseType renderAnalyseType, String str2) {
        long currentTimeMillis;
        long j;
        long j2;
        String str3;
        String str4;
        Intrinsics.h(renderAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        int i = OooO00o.OooO00o[renderAnalyseType.ordinal()];
        if (i == 3) {
            currentTimeMillis = System.currentTimeMillis();
            j = this.OooO00o;
        } else {
            if (i != 5) {
                j2 = 0;
                if (str2 == null) {
                    str3 = "-信息:" + str2;
                } else {
                    str3 = "";
                }
                if (j2 != 0) {
                    str3 = "-耗时:" + j2 + ((Object) str3);
                    ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(RenderAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + renderAnalyseType.name(), str3);
                    Unit unit = Unit.a;
                    reportProxy.report(str, "render", bundle);
                }
                if (str == null) {
                    str4 = "[" + str + "]:" + renderAnalyseType.getDes() + ((Object) str3);
                } else {
                    str4 = renderAnalyseType.getDes() + ((Object) str3);
                }
                if (renderAnalyseType != RenderAnalyseType.ERROR) {
                    TraceLog.e(TmcConstants.PERFERENCE_RENDER_TAG, str4, j2 != 0);
                } else {
                    TraceLog.d(TmcConstants.PERFERENCE_RENDER_TAG, str4, j2 != 0);
                }
                a.a(renderAnalyseType, str4);
                this.OooO00o = System.currentTimeMillis();
            }
            currentTimeMillis = System.currentTimeMillis();
            j = this.OooO00o;
        }
        j2 = currentTimeMillis - j;
        if (str2 == null) {
        }
        if (j2 != 0) {
        }
        if (str == null) {
        }
        if (renderAnalyseType != RenderAnalyseType.ERROR) {
        }
        a.a(renderAnalyseType, str4);
        this.OooO00o = System.currentTimeMillis();
    }
}
