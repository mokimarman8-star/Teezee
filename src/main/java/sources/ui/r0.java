package ui;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.download.DownloadRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r0 implements n0 {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `download_thread_range` (`threadId`,`rangeId`,`resourceId`,`start`,`end`,`progress`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, DownloadRange downloadRange) {
            eVar.c(1, downloadRange.getThreadId());
            eVar.c(2, downloadRange.getRangeId());
            if (downloadRange.getResourceId() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, downloadRange.getResourceId());
            }
            eVar.c(4, downloadRange.getStart());
            eVar.c(5, downloadRange.getEnd());
            eVar.c(6, downloadRange.getProgress());
        }
    }

    public r0(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM DOWNLOAD_THREAD_RANGE WHERE resourceId=?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List i(String str, y3.b bVar) {
        y3.e F0 = bVar.F0("SELECT * FROM DOWNLOAD_THREAD_RANGE WHERE resourceId = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c = androidx.room.util.i.c(F0, "threadId");
            int c2 = androidx.room.util.i.c(F0, "rangeId");
            int c3 = androidx.room.util.i.c(F0, "resourceId");
            int c4 = androidx.room.util.i.c(F0, "start");
            int c5 = androidx.room.util.i.c(F0, "end");
            int c6 = androidx.room.util.i.c(F0, "progress");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                DownloadRange downloadRange = new DownloadRange();
                downloadRange.setThreadId((int) F0.getLong(c));
                downloadRange.setRangeId((int) F0.getLong(c2));
                downloadRange.setResourceId(F0.isNull(c3) ? null : F0.q0(c3));
                downloadRange.setStart(F0.getLong(c4));
                downloadRange.setEnd(F0.getLong(c5));
                downloadRange.setProgress(F0.getLong(c6));
                arrayList.add(downloadRange);
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(DownloadRange downloadRange, y3.b bVar) {
        this.b.d(bVar, downloadRange);
        return Unit.a;
    }

    @Override // ui.n0
    public Object a(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: ui.o0
            public final Object invoke(Object obj) {
                List i;
                i = r0.i(str, (y3.b) obj);
                return i;
            }
        }, continuation);
    }

    @Override // ui.n0
    public Object b(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.q0
            public final Object invoke(Object obj) {
                Unit h;
                h = r0.h(str, (y3.b) obj);
                return h;
            }
        }, continuation);
    }

    @Override // ui.n0
    public Object c(final DownloadRange downloadRange, Continuation continuation) {
        downloadRange.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: ui.p0
            public final Object invoke(Object obj) {
                Unit j;
                j = r0.this.j(downloadRange, (y3.b) obj);
                return j;
            }
        }, continuation);
    }
}
