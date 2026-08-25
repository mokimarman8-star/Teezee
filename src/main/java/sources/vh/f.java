package vh;

import androidx.room.RoomDatabase;
import com.transsion.ad.db.pslink.AppInstalledBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements vh.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `app_installed` (`packageName`,`source`,`appName`,`versionName`,`versionCode`,`horizontalImageUrl`,`eCPM`,`installTime`,`lastOpenTime`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, appInstalledBean.getPackageName());
            }
            if (appInstalledBean.getSource() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, appInstalledBean.getSource());
            }
            if (appInstalledBean.getAppName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, appInstalledBean.getAppName());
            }
            if (appInstalledBean.getVersionName() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, appInstalledBean.getVersionName());
            }
            if (appInstalledBean.getVersionCode() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, appInstalledBean.getVersionCode());
            }
            if (appInstalledBean.getHorizontalImageUrl() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, appInstalledBean.getHorizontalImageUrl());
            }
            if (appInstalledBean.getECPM() == null) {
                eVar.g(7);
            } else {
                eVar.a(7, appInstalledBean.getECPM().doubleValue());
            }
            if (appInstalledBean.getInstallTime() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, appInstalledBean.getInstallTime().longValue());
            }
            if (appInstalledBean.getLastOpenTime() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, appInstalledBean.getLastOpenTime().longValue());
            }
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `app_installed` WHERE `packageName` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, appInstalledBean.getPackageName());
            }
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `app_installed` SET `packageName` = ?,`source` = ?,`appName` = ?,`versionName` = ?,`versionCode` = ?,`horizontalImageUrl` = ?,`eCPM` = ?,`installTime` = ?,`lastOpenTime` = ? WHERE `packageName` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, AppInstalledBean appInstalledBean) {
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, appInstalledBean.getPackageName());
            }
            if (appInstalledBean.getSource() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, appInstalledBean.getSource());
            }
            if (appInstalledBean.getAppName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, appInstalledBean.getAppName());
            }
            if (appInstalledBean.getVersionName() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, appInstalledBean.getVersionName());
            }
            if (appInstalledBean.getVersionCode() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, appInstalledBean.getVersionCode());
            }
            if (appInstalledBean.getHorizontalImageUrl() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, appInstalledBean.getHorizontalImageUrl());
            }
            if (appInstalledBean.getECPM() == null) {
                eVar.g(7);
            } else {
                eVar.a(7, appInstalledBean.getECPM().doubleValue());
            }
            if (appInstalledBean.getInstallTime() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, appInstalledBean.getInstallTime().longValue());
            }
            if (appInstalledBean.getLastOpenTime() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, appInstalledBean.getLastOpenTime().longValue());
            }
            if (appInstalledBean.getPackageName() == null) {
                eVar.g(10);
            } else {
                eVar.i(10, appInstalledBean.getPackageName());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List i() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List j(long j, y3.b bVar) {
        y3.e F0 = bVar.F0("\n        SELECT * FROM app_installed\n        WHERE lastOpenTime IS NOT NULL\n        AND lastOpenTime >= ?\n    ");
        try {
            F0.c(1, j);
            int c2 = androidx.room.util.i.c(F0, "packageName");
            int c3 = androidx.room.util.i.c(F0, "source");
            int c4 = androidx.room.util.i.c(F0, "appName");
            int c5 = androidx.room.util.i.c(F0, "versionName");
            int c6 = androidx.room.util.i.c(F0, "versionCode");
            int c7 = androidx.room.util.i.c(F0, "horizontalImageUrl");
            int c8 = androidx.room.util.i.c(F0, "eCPM");
            int c9 = androidx.room.util.i.c(F0, "installTime");
            int c10 = androidx.room.util.i.c(F0, "lastOpenTime");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                arrayList.add(new AppInstalledBean(F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5), F0.isNull(c6) ? null : F0.q0(c6), F0.isNull(c7) ? null : F0.q0(c7), F0.isNull(c8) ? null : Double.valueOf(F0.getDouble(c8)), F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9)), F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10))));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AppInstalledBean k(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM app_installed WHERE packageName = ? LIMIT 1");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "packageName");
            int c3 = androidx.room.util.i.c(F0, "source");
            int c4 = androidx.room.util.i.c(F0, "appName");
            int c5 = androidx.room.util.i.c(F0, "versionName");
            int c6 = androidx.room.util.i.c(F0, "versionCode");
            int c7 = androidx.room.util.i.c(F0, "horizontalImageUrl");
            int c8 = androidx.room.util.i.c(F0, "eCPM");
            int c9 = androidx.room.util.i.c(F0, "installTime");
            int c10 = androidx.room.util.i.c(F0, "lastOpenTime");
            AppInstalledBean appInstalledBean = null;
            if (F0.C0()) {
                appInstalledBean = new AppInstalledBean(F0.isNull(c2) ? null : F0.q0(c2), F0.isNull(c3) ? null : F0.q0(c3), F0.isNull(c4) ? null : F0.q0(c4), F0.isNull(c5) ? null : F0.q0(c5), F0.isNull(c6) ? null : F0.q0(c6), F0.isNull(c7) ? null : F0.q0(c7), F0.isNull(c8) ? null : Double.valueOf(F0.getDouble(c8)), F0.isNull(c9) ? null : Long.valueOf(F0.getLong(c9)), F0.isNull(c10) ? null : Long.valueOf(F0.getLong(c10)));
            }
            F0.close();
            return appInstalledBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long l(AppInstalledBean appInstalledBean, y3.b bVar) {
        return Long.valueOf(this.b.e(bVar, appInstalledBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit m(long j, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("\n        UPDATE app_installed \n        SET lastOpenTime = ? \n        WHERE packageName = ?\n    ");
        try {
            F0.c(1, j);
            if (str == null) {
                F0.g(2);
            } else {
                F0.i(2, str);
            }
            F0.C0();
            Unit unit = Unit.a;
            F0.close();
            return unit;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    @Override // vh.a
    public Object a(final AppInstalledBean appInstalledBean, Continuation continuation) {
        appInstalledBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.b
            public final Object invoke(Object obj) {
                Long l;
                l = f.this.l(appInstalledBean, (y3.b) obj);
                return l;
            }
        }, continuation);
    }

    @Override // vh.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.c
            public final Object invoke(Object obj) {
                AppInstalledBean k;
                k = f.k(str, (y3.b) obj);
                return k;
            }
        }, continuation);
    }

    @Override // vh.a
    public Object c(final String str, final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vh.e
            public final Object invoke(Object obj) {
                Unit m;
                m = f.m(j, str, (y3.b) obj);
                return m;
            }
        }, continuation);
    }

    @Override // vh.a
    public Object d(final long j, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vh.d
            public final Object invoke(Object obj) {
                List j2;
                j2 = f.j(j, (y3.b) obj);
                return j2;
            }
        }, continuation);
    }
}
