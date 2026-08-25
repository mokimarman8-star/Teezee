package aj;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.util.i;
import com.transsion.baselib.db.room.RoomItemBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements aj.a {
    private final RoomDatabase a;
    private final g b = new a();
    private final androidx.room.e c = new b();

    class a extends g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `room_table` (`groupId`,`name`,`avatar`,`hasJoin`,`newPostCount`,`description`,`postCount`,`userCount`,`level`,`updateTimeStamp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, roomItemBean.getGroupId());
            }
            if (roomItemBean.getName() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, roomItemBean.getName());
            }
            if (roomItemBean.getAvatar() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, roomItemBean.getAvatar());
            }
            if ((roomItemBean.getHasJoin() == null ? null : Integer.valueOf(roomItemBean.getHasJoin().booleanValue() ? 1 : 0)) == null) {
                eVar.g(4);
            } else {
                eVar.c(4, r0.intValue());
            }
            if (roomItemBean.getNewPostCount() == null) {
                eVar.g(5);
            } else {
                eVar.c(5, roomItemBean.getNewPostCount().longValue());
            }
            if (roomItemBean.getDescription() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, roomItemBean.getDescription());
            }
            if (roomItemBean.getPostCount() == null) {
                eVar.g(7);
            } else {
                eVar.c(7, roomItemBean.getPostCount().longValue());
            }
            if (roomItemBean.getUserCount() == null) {
                eVar.g(8);
            } else {
                eVar.c(8, roomItemBean.getUserCount().longValue());
            }
            if (roomItemBean.getLevel() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, roomItemBean.getLevel());
            }
            eVar.c(10, roomItemBean.getUpdateTimeStamp());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `room_table` WHERE `groupId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, RoomItemBean roomItemBean) {
            if (roomItemBean.getGroupId() == null) {
                eVar.g(1);
            } else {
                eVar.i(1, roomItemBean.getGroupId());
            }
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List g() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit h(RoomItemBean roomItemBean, y3.b bVar) {
        this.c.c(bVar, roomItemBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List i(y3.b bVar) {
        Boolean valueOf;
        y3.e F0 = bVar.F0("SELECT * FROM ROOM_TABLE ORDER BY updateTimeStamp DESC");
        try {
            int c = i.c(F0, "groupId");
            int c2 = i.c(F0, "name");
            int c3 = i.c(F0, "avatar");
            int c4 = i.c(F0, "hasJoin");
            int c5 = i.c(F0, "newPostCount");
            int c6 = i.c(F0, "description");
            int c7 = i.c(F0, "postCount");
            int c8 = i.c(F0, "userCount");
            int c9 = i.c(F0, "level");
            int c10 = i.c(F0, "updateTimeStamp");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                String q0 = F0.isNull(c) ? null : F0.q0(c);
                String q02 = F0.isNull(c2) ? null : F0.q0(c2);
                String q03 = F0.isNull(c3) ? null : F0.q0(c3);
                Integer valueOf2 = F0.isNull(c4) ? null : Integer.valueOf((int) F0.getLong(c4));
                if (valueOf2 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                }
                arrayList.add(new RoomItemBean(q0, q02, q03, valueOf, F0.isNull(c5) ? null : Long.valueOf(F0.getLong(c5)), F0.isNull(c6) ? null : F0.q0(c6), F0.isNull(c7) ? null : Long.valueOf(F0.getLong(c7)), F0.isNull(c8) ? null : Long.valueOf(F0.getLong(c8)), F0.isNull(c9) ? null : F0.q0(c9), F0.getLong(c10)));
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(RoomItemBean roomItemBean, y3.b bVar) {
        this.b.d(bVar, roomItemBean);
        return Unit.a;
    }

    @Override // aj.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: aj.c
            public final Object invoke(Object obj) {
                List i;
                i = e.i((y3.b) obj);
                return i;
            }
        }, continuation);
    }

    @Override // aj.a
    public Object b(final RoomItemBean roomItemBean, Continuation continuation) {
        roomItemBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: aj.b
            public final Object invoke(Object obj) {
                Unit j;
                j = e.this.j(roomItemBean, (y3.b) obj);
                return j;
            }
        }, continuation);
    }

    @Override // aj.a
    public Object c(final RoomItemBean roomItemBean, Continuation continuation) {
        roomItemBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: aj.d
            public final Object invoke(Object obj) {
                Unit h;
                h = e.this.h(roomItemBean, (y3.b) obj);
                return h;
            }
        }, continuation);
    }
}
