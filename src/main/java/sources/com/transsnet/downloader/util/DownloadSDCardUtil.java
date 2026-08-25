package com.transsnet.downloader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.miniutils.util.g;
import com.cloud.tmc.miniutils.util.i;
import com.cloud.tmc.miniutils.util.j;
import com.cloud.tmc.miniutils.util.k;
import com.transsion.commercialization.pslink.c;
import com.transsnet.downloader.R$string;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.DownloadRefreshEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ui.b;
import wf.a;
import yw.e;
import yw.f;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadSDCardUtil {
    public static final DownloadSDCardUtil a = new DownloadSDCardUtil();
    private static final String b;
    private static boolean c;
    private static boolean d;
    private static final DownloadSDCardUtil$sdcardBroadcastReceiver$1 e;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1] */
    static {
        String string = Utils.a().getString(R$string.sdcard_name);
        Intrinsics.g(string, "getString(...)");
        b = string;
        e = new BroadcastReceiver() { // from class: com.transsnet.downloader.util.DownloadSDCardUtil$sdcardBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.h(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1665311200:
                            if (!action.equals("android.intent.action.MEDIA_REMOVED")) {
                                return;
                            }
                            break;
                        case -1514214344:
                            if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
                                DownloadSDCardUtil.a.d(true);
                                a.a.c("DownloadSDCard", "SD/TF卡已插入", true);
                                DownloadRefreshEvent downloadRefreshEvent = new DownloadRefreshEvent("", "", false, false, 12, (DefaultConstructorMarker) null);
                                AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
                                FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                                String name = DownloadRefreshEvent.class.getName();
                                Intrinsics.g(name, "getName(...)");
                                flowEventBus.postEvent(name, downloadRefreshEvent, 0L);
                                e eVar = new e(true, false);
                                FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
                                String name2 = e.class.getName();
                                Intrinsics.g(name2, "getName(...)");
                                flowEventBus2.postEvent(name2, eVar, 0L);
                                return;
                            }
                            return;
                        case -963871873:
                            if (!action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
                                return;
                            }
                            break;
                        case 2045140818:
                            if (!action.equals("android.intent.action.MEDIA_BAD_REMOVAL")) {
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                    DownloadSDCardUtil.a.d(false);
                    a.a.c("DownloadSDCard", "SD/TF卡已拔出", true);
                    DownloadRefreshEvent downloadRefreshEvent2 = new DownloadRefreshEvent("", "", false, false, 12, (DefaultConstructorMarker) null);
                    AppScopeVMlProvider appScopeVMlProvider2 = AppScopeVMlProvider.INSTANCE;
                    FlowEventBus flowEventBus3 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                    String name3 = DownloadRefreshEvent.class.getName();
                    Intrinsics.g(name3, "getName(...)");
                    flowEventBus3.postEvent(name3, downloadRefreshEvent2, 0L);
                    e eVar2 = new e(true, false);
                    FlowEventBus flowEventBus4 = (FlowEventBus) appScopeVMlProvider2.getApplicationScopeViewModel(FlowEventBus.class);
                    String name4 = e.class.getName();
                    Intrinsics.g(name4, "getName(...)");
                    flowEventBus4.postEvent(name4, eVar2, 0L);
                }
            }
        };
    }

    private DownloadSDCardUtil() {
    }

    public final List a() {
        List<f> b2;
        ArrayList arrayList = new ArrayList();
        try {
            b2 = b();
        } catch (Throwable unused) {
        }
        if (b2.size() < 2) {
            return arrayList;
        }
        String str = "";
        Iterator it = b2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f fVar = (f) it.next();
            if (!fVar.c()) {
                str = fVar.b();
                break;
            }
        }
        if (str.length() == 0) {
            return arrayList;
        }
        int i = 0;
        boolean z = b2.size() > 2;
        for (f fVar2 : b2) {
            if (fVar2.c()) {
                i++;
                String b3 = fVar2.b();
                String str2 = File.separator;
                b.a aVar = b.a;
                arrayList.add(new yw.b(b3 + str2 + aVar.f(), str2 + aVar.f(), z ? b + " " + i + " " : b, 2, fVar2.a(), 3));
            }
        }
        return arrayList;
    }

    public final List b() {
        int i = 1;
        Object systemService = Utils.a().getSystemService("storage");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        StorageManager storageManager = (StorageManager) systemService;
        ArrayList arrayList = new ArrayList();
        Object[] objArr = null;
        if (Build.VERSION.SDK_INT >= 24) {
            List a2 = g.a(storageManager);
            Intrinsics.g(a2, "getStorageVolumes(...)");
            try {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    StorageVolume a3 = i.a(it.next());
                    boolean a5 = j.a(a3);
                    boolean a6 = i.a(a3);
                    String a7 = k.a(a3);
                    if (a5) {
                        d = true;
                    }
                    try {
                        Class<?> cls = Class.forName(a3.getClass().getName());
                        try {
                            Method declaredMethod = cls.getDeclaredMethod("getPath", null);
                            declaredMethod.setAccessible(true);
                            Object invoke = declaredMethod.invoke(a3, null);
                            Intrinsics.f(invoke, "null cannot be cast to non-null type kotlin.String");
                            Intrinsics.e(a7);
                            arrayList.add(new f((String) invoke, a7, a5, a6));
                        } catch (Throwable unused) {
                            Field declaredField = cls.getDeclaredField("mPath");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(a3);
                            if (obj != null) {
                                String obj2 = obj.toString();
                                Intrinsics.e(a7);
                                arrayList.add(new f(obj2, a7, a5, a6));
                            }
                            Unit unit = Unit.a;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        Unit unit2 = Unit.a;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else {
            try {
                Class<?> cls2 = Class.forName("android.os.storage.StorageVolume");
                Method method = cls2.getMethod("getPath", null);
                Method method2 = cls2.getMethod("isRemovable", null);
                Method method3 = cls2.getMethod("isEmulated", null);
                Method method4 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object invoke2 = StorageManager.class.getMethod("getVolumeList", null).invoke(storageManager, null);
                int length = Array.getLength(invoke2);
                int i2 = 0;
                while (i2 < length) {
                    Object obj3 = Array.get(invoke2, i2);
                    Object invoke3 = method.invoke(obj3, objArr);
                    Intrinsics.f(invoke3, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) invoke3;
                    Object invoke4 = method2.invoke(obj3, objArr);
                    Intrinsics.f(invoke4, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue = ((Boolean) invoke4).booleanValue();
                    Object invoke5 = method3.invoke(obj3, objArr);
                    Intrinsics.f(invoke5, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean booleanValue2 = ((Boolean) invoke5).booleanValue();
                    Object[] objArr2 = new Object[i];
                    objArr2[0] = str;
                    Object invoke6 = method4.invoke(storageManager, objArr2);
                    Intrinsics.f(invoke6, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add(new f(str, (String) invoke6, booleanValue, booleanValue2));
                    i2++;
                    i = 1;
                    objArr = null;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void c() {
        if (c) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addDataScheme("file");
        if (Build.VERSION.SDK_INT >= 33) {
            c.a(Utils.a(), e, intentFilter, 2);
        } else {
            Utils.a().registerReceiver(e, intentFilter);
        }
        c = true;
    }

    public final void d(boolean z) {
        d = z;
    }

    public final void e() {
        try {
            if (c) {
                c = false;
                Utils.a().unregisterReceiver(e);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
