package ui;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.download.SubtitleLanguageMapBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h1 implements d1 {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `subtitle_language_map_table` (`lan`,`lanIOS3`,`lanName`,`inSearch`) VALUES (?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, SubtitleLanguageMapBean subtitleLanguageMapBean) {
            if (subtitleLanguageMapBean.getLan() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, subtitleLanguageMapBean.getLan());
            }
            if (subtitleLanguageMapBean.getLanIOS3() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, subtitleLanguageMapBean.getLanIOS3());
            }
            if (subtitleLanguageMapBean.getLanName() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, subtitleLanguageMapBean.getLanName());
            }
            eVar.c(4, subtitleLanguageMapBean.getInSearch() ? 1L : 0L);
        }
    }

    public h1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List h(y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM SUBTITLE_LANGUAGE_MAP_TABLE ");
        try {
            int c = androidx.room.util.i.c(F0, "lan");
            int c2 = androidx.room.util.i.c(F0, "lanIOS3");
            int c3 = androidx.room.util.i.c(F0, "lanName");
            int c4 = androidx.room.util.i.c(F0, "inSearch");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String str = null;
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                if (!F0.isNull(c3)) {
                    str = F0.q0(c3);
                }
                arrayList.add(new SubtitleLanguageMapBean(q0, q02, str, ((int) F0.getLong(c4)) != 0));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(SubtitleLanguageMapBean subtitleLanguageMapBean, y3.b bVar) {
        this.b.d(bVar, subtitleLanguageMapBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit j(boolean z, String str, y3.b bVar) {
        y3.e F0 = bVar.F0("UPDATE SUBTITLE_LANGUAGE_MAP_TABLE SET inSearch = ?  WHERE lan = ?");
        try {
            F0.c(1, z ? 1L : 0L);
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

    @Override // ui.d1
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.e1
            public final Object invoke(Object obj) {
                List h;
                h = h1.h((y3.b) obj);
                return h;
            }
        }, continuation);
    }

    @Override // ui.d1
    public Object b(final String str, final boolean z, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.f1
            public final Object invoke(Object obj) {
                Unit j;
                j = h1.j(z, str, (y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // ui.d1
    public Object c(final SubtitleLanguageMapBean subtitleLanguageMapBean, Continuation continuation) {
        subtitleLanguageMapBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.g1
            public final Object invoke(Object obj) {
                Unit i;
                i = h1.this.i(subtitleLanguageMapBean, (y3.b) obj);
                return i;
            }
        }, continuation);
    }
}
