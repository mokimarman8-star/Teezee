package vi;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.i;
import com.transsion.baselib.db.home.HomePreferencesIntervalTimeDbBean;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements vi.a {
    private final RoomDatabase a;
    private final g b = new a();

    class a extends g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `home_preferences_interval_time` (`id`,`showTime`,`closeTime`,`chooseTime`,`showIntervalSeconds`,`closeIntervalSeconds`,`chooseIntervalSeconds`) VALUES (?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(e eVar, HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean) {
            if (homePreferencesIntervalTimeDbBean.getId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, homePreferencesIntervalTimeDbBean.getId());
            }
            eVar.c(2, homePreferencesIntervalTimeDbBean.getShowTime());
            eVar.c(3, homePreferencesIntervalTimeDbBean.getCloseTime());
            eVar.c(4, homePreferencesIntervalTimeDbBean.getChooseTime());
            eVar.c(5, homePreferencesIntervalTimeDbBean.getShowIntervalSeconds());
            eVar.c(6, homePreferencesIntervalTimeDbBean.getCloseIntervalSeconds());
            eVar.c(7, homePreferencesIntervalTimeDbBean.getChooseIntervalSeconds());
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List e() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit f(HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, y3.b bVar) {
        this.b.d(bVar, homePreferencesIntervalTimeDbBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HomePreferencesIntervalTimeDbBean g(String str, y3.b bVar) {
        e F0 = bVar.F0("\n        SELECT * FROM home_preferences_interval_time\n        WHERE id = ?\n        LIMIT 1\n    ");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = i.c(F0, "id");
            int c2 = i.c(F0, "showTime");
            int c3 = i.c(F0, "closeTime");
            int c4 = i.c(F0, "chooseTime");
            int c5 = i.c(F0, "showIntervalSeconds");
            int c6 = i.c(F0, "closeIntervalSeconds");
            int c7 = i.c(F0, "chooseIntervalSeconds");
            HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean = null;
            if (F0.C0()) {
                homePreferencesIntervalTimeDbBean = new HomePreferencesIntervalTimeDbBean(F0.isNull(c) ? null : F0.q0(c), F0.getLong(c2), F0.getLong(c3), F0.getLong(c4), F0.getLong(c5), F0.getLong(c6), F0.getLong(c7));
            }
            F0.close();
            return homePreferencesIntervalTimeDbBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    @Override // vi.a
    public Object a(final HomePreferencesIntervalTimeDbBean homePreferencesIntervalTimeDbBean, Continuation continuation) {
        homePreferencesIntervalTimeDbBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: vi.b
            public final Object invoke(Object obj) {
                Unit f;
                f = d.this.f(homePreferencesIntervalTimeDbBean, (y3.b) obj);
                return f;
            }
        }, continuation);
    }

    @Override // vi.a
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: vi.c
            public final Object invoke(Object obj) {
                HomePreferencesIntervalTimeDbBean g;
                g = d.g(str, (y3.b) obj);
                return g;
            }
        }, continuation);
    }
}
