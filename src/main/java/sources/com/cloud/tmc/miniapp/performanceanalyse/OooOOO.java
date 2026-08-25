package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import com.cloud.tmc.kernel.utils.TraceLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOOO {
    public long OooO00o;

    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[V8AnalyseType.values().length];
            try {
                iArr[V8AnalyseType.CHECK_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[V8AnalyseType.CHECK_EXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[V8AnalyseType.CHECK_UN_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            OooO00o = iArr;
        }
    }

    public OooOOO() {
        V8AnalyseType v8AnalyseType = V8AnalyseType.CHECK_START;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OooO00o(String str, V8AnalyseType v8AnalyseType, String str2) {
        long currentTimeMillis;
        long j;
        long j2;
        String str3;
        String str4;
        Intrinsics.h(v8AnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        int i = OooO00o.OooO00o[v8AnalyseType.ordinal()];
        if (i == 5) {
            currentTimeMillis = System.currentTimeMillis();
            j = this.OooO00o;
        } else {
            if (i != 8) {
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
                    bundle.putString(V8AnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + v8AnalyseType.name(), str3);
                    Unit unit = Unit.a;
                    reportProxy.report(str, "v8", bundle);
                }
                if (str == null) {
                    str4 = "[" + str + "]:" + v8AnalyseType.getDes() + ((Object) str3);
                } else {
                    str4 = v8AnalyseType.getDes() + ((Object) str3);
                }
                if (v8AnalyseType != V8AnalyseType.DOWNLOAD_FAIL || v8AnalyseType == V8AnalyseType.UNZIP_FAIL) {
                    TraceLog.e(TmcConstants.PERFERENCE_V8_TAG, str4, j2 != 0);
                } else {
                    TraceLog.d(TmcConstants.PERFERENCE_V8_TAG, str4, j2 != 0);
                }
                a.a(v8AnalyseType, str4);
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
        if (v8AnalyseType != V8AnalyseType.DOWNLOAD_FAIL) {
        }
        TraceLog.e(TmcConstants.PERFERENCE_V8_TAG, str4, j2 != 0);
        a.a(v8AnalyseType, str4);
        this.OooO00o = System.currentTimeMillis();
    }
}
