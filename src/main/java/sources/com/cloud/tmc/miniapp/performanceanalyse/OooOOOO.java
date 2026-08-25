package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.a;
import com.cloud.tmc.kernel.utils.TraceLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOOOO {
    public long OooO00o;
    public WorkerAnalyseType OooO0O0 = WorkerAnalyseType.INIT;

    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[WorkerAnalyseType.values().length];
            try {
                iArr[WorkerAnalyseType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerAnalyseType.CREATE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerAnalyseType.CREATE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerAnalyseType.LOAD_JS_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerAnalyseType.LOAD_JS_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_END_1.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[WorkerAnalyseType.EXECUTE_JS_END_2.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[WorkerAnalyseType.SEND_TO_NATIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[WorkerAnalyseType.ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[WorkerAnalyseType.CONSOLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            OooO00o = iArr;
        }
    }

    public void OooO00o(String str, WorkerAnalyseType workerAnalyseType, String str2) {
        long currentTimeMillis;
        long j;
        long j2;
        String str3;
        String str4;
        Intrinsics.h(workerAnalyseType, TmcConstants.EXTRA_SHARE_TARGET);
        int i = OooO00o.OooO00o[workerAnalyseType.ordinal()];
        boolean z = false;
        if (i == 3) {
            if (this.OooO0O0 == WorkerAnalyseType.CREATE_START) {
                currentTimeMillis = System.currentTimeMillis();
                j = this.OooO00o;
                j2 = currentTimeMillis - j;
            }
            j2 = 0;
        } else if (i == 5) {
            if (this.OooO0O0 == WorkerAnalyseType.LOAD_JS_START) {
                currentTimeMillis = System.currentTimeMillis();
                j = this.OooO00o;
                j2 = currentTimeMillis - j;
            }
            j2 = 0;
        } else if (i != 7) {
            if (i == 8) {
                WorkerAnalyseType workerAnalyseType2 = this.OooO0O0;
                if (workerAnalyseType2 == WorkerAnalyseType.EXECUTE_JS_START) {
                    currentTimeMillis = System.currentTimeMillis();
                    j = this.OooO00o;
                    j2 = currentTimeMillis - j;
                } else if (workerAnalyseType2 == WorkerAnalyseType.SEND_TO_NATIVE) {
                    z = true;
                }
            }
            j2 = 0;
        } else {
            if (this.OooO0O0 == WorkerAnalyseType.EXECUTE_JS_START) {
                currentTimeMillis = System.currentTimeMillis();
                j = this.OooO00o;
                j2 = currentTimeMillis - j;
            }
            j2 = 0;
        }
        if (z) {
            return;
        }
        if (str2 != null) {
            str3 = "-信息:" + str2;
        } else {
            str3 = "";
        }
        if (j2 != 0) {
            str3 = "-耗时:" + j2 + ((Object) str3);
            ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
            Bundle bundle = new Bundle();
            bundle.putString(WorkerAnalyseType.class.getSimpleName() + TmcConstants.EXTENSION_SEPARATOR + workerAnalyseType.name(), str3);
            Unit unit = Unit.a;
            reportProxy.report(str, "webviewWorker", bundle);
        }
        if (str != null) {
            str4 = "[" + str + "]:" + workerAnalyseType.getDes() + ((Object) str3);
        } else {
            str4 = workerAnalyseType.getDes() + ((Object) str3);
        }
        if (workerAnalyseType == WorkerAnalyseType.ERROR) {
            TraceLog.e(TmcConstants.PERFERENCE_WORKER_TAG, str4);
        } else {
            TraceLog.d(TmcConstants.PERFERENCE_WORKER_TAG, str4);
        }
        a.a(workerAnalyseType, str4);
        this.OooO0O0 = workerAnalyseType;
        this.OooO00o = System.currentTimeMillis();
    }
}
