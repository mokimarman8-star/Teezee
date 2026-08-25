package com.transsion.commercialization.pslink;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.transsion.gslb.BuildConfig;
import com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ww.a;
import ww.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PsLinkServiceHelper {
    private static ww.b b;
    private static long d;
    public static final PsLinkServiceHelper a = new PsLinkServiceHelper();
    private static CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private static final ServiceConnection e = new a();

    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.h(componentName, "componentName");
            Intrinsics.h(iBinder, "iBinder");
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.a;
            PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.a;
            aVar.a(psLinkServiceHelper.j() + " --> onServiceConnected() --> 连接成功 --> componentName = " + componentName);
            psLinkServiceHelper.l(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.h(componentName, "componentName");
            com.transsion.commercialization.pslink.a.a.b(PsLinkServiceHelper.a.j() + " --> onServiceDisconnected() --> 断开连接 --> componentName = " + componentName);
            PsLinkServiceHelper.b = null;
            PsLinkInstallReceiver.INSTANCE.b();
        }
    }

    private PsLinkServiceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = PsLinkServiceHelper.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(IBinder iBinder) {
        Object obj;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            ww.b X0 = b.a.X0(iBinder);
            b = X0;
            if (X0 != null) {
                X0.j(new a.a() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
                    
                        if (r9.equals("onAction") == false) goto L21;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
                    
                        if (r9.equals("addTask") != false) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
                    
                        if (r9.equals("onProgress") == false) goto L21;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:5:0x004a, code lost:
                    
                        r0 = com.blankj.utilcode.util.o.e(r10, new com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1().getType());
                        r3 = (com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo) r0;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:6:0x005a, code lost:
                    
                        if (r3 == null) goto L20;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
                    
                        r2 = r3.getPkgName();
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0060, code lost:
                    
                        r7 = r2;
                        r2 = r0;
                        r0 = r7;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void M0(String str, String str2) {
                        String str3;
                        CopyOnWriteArrayList copyOnWriteArrayList;
                        long j;
                        Intrinsics.h(str, "callBackName");
                        Intrinsics.h(str2, "param");
                        String str4 = null;
                        switch (str.hashCode()) {
                            case -1148589626:
                                break;
                            case 975459573:
                                break;
                            case 1098563625:
                                if (str.equals("removeTask")) {
                                    str3 = ((PalmStoreDownLoadTaskInfo) o.e(str2, new TypeToken<PalmStoreDownLoadTaskInfo>() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$info$1
                                    }.getType())).getPkgName();
                                    break;
                                }
                                str3 = BuildConfig.FLAVOR;
                                break;
                            case 1768875308:
                                break;
                            default:
                                str3 = BuildConfig.FLAVOR;
                                break;
                        }
                        if (Intrinsics.c(str, "onProgress")) {
                            long currentTimeMillis = System.currentTimeMillis();
                            j = PsLinkServiceHelper.d;
                            if (currentTimeMillis - j < 1000) {
                                return;
                            }
                        }
                        PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.a;
                        PsLinkServiceHelper.d = System.currentTimeMillis();
                        copyOnWriteArrayList = PsLinkServiceHelper.c;
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).a(str, str2, (PalmStoreDownLoadTaskInfo) str4, str3);
                        }
                    }
                }, "Moviebox");
                unit = Unit.a;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 == null) {
            return;
        }
        com.transsion.commercialization.pslink.a.a.b(a.j() + " --> register() --> it = " + Log.getStackTraceString(th3));
    }

    public final void g(b bVar) {
        Intrinsics.h(bVar, "psLinkCallBackCommon");
        if (c.contains(bVar)) {
            return;
        }
        c.add(bVar);
    }

    public final void h() {
        Object obj;
        if (b != null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.a;
            PsLinkServiceHelper psLinkServiceHelper = a;
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... ");
            Intent intent = new Intent();
            intent.setClassName("com.transsnet.store", "com.transsnet.launcherlib.services.DispenseCommonService");
            boolean bindService = Utils.a().bindService(intent, e, 1);
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... --> isConnect = " + bindService);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            com.transsion.commercialization.pslink.a.a.b(a.j() + " --> bindService() --> " + Log.getStackTraceString(th3));
        }
        PsLinkInstallReceiver.INSTANCE.a();
    }

    public final CopyOnWriteArrayList i() {
        return c;
    }

    public final boolean k() {
        return b == null;
    }

    public final void m(b bVar) {
        Intrinsics.h(bVar, "psLinkCallBackCommon");
        c.remove(bVar);
    }
}
