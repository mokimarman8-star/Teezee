package zi;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements zi.a {
    private final RoomDatabase a;
    private final androidx.room.g b = new a();
    private final androidx.room.e c = new b();
    private final androidx.room.e d = new c();

    class a extends androidx.room.g {
        a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `msg` (`id`,`deep_link`,`desc`,`image_list`,`message_id`,`source`,`style`,`title`,`type`,`receive_time`,`msg_status`,`show_time`,`force_show`,`has_screen_on`,`built_in`,`permanent_msg_status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MsgBean msgBean) {
            eVar.c(1, msgBean.getId());
            if (msgBean.getDeeplink() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, msgBean.getDeeplink());
            }
            if (msgBean.getDesc() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, msgBean.getDesc());
            }
            if (msgBean.getImageList() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, msgBean.getImageList());
            }
            if (msgBean.getMessageId() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, msgBean.getMessageId());
            }
            if (msgBean.getSource() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, msgBean.getSource());
            }
            if (msgBean.getStyle() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, msgBean.getStyle());
            }
            if (msgBean.getTitle() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, msgBean.getTitle());
            }
            if (msgBean.getType() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, msgBean.getType());
            }
            if (msgBean.getReceiveTime() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, msgBean.getReceiveTime().longValue());
            }
            eVar.c(11, msgBean.getMsgStatus());
            if (msgBean.getShowTime() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, msgBean.getShowTime().longValue());
            }
            eVar.c(13, msgBean.getForceShow() ? 1L : 0L);
            eVar.c(14, msgBean.getHasScreenOn() ? 1L : 0L);
            eVar.c(15, msgBean.getBuiltIn() ? 1L : 0L);
            eVar.c(16, msgBean.getPermanentMsgStatus());
        }
    }

    class b extends androidx.room.e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `msg` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MsgBean msgBean) {
            eVar.c(1, msgBean.getId());
        }
    }

    class c extends androidx.room.e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `msg` SET `id` = ?,`deep_link` = ?,`desc` = ?,`image_list` = ?,`message_id` = ?,`source` = ?,`style` = ?,`title` = ?,`type` = ?,`receive_time` = ?,`msg_status` = ?,`show_time` = ?,`force_show` = ?,`has_screen_on` = ?,`built_in` = ?,`permanent_msg_status` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, MsgBean msgBean) {
            eVar.c(1, msgBean.getId());
            if (msgBean.getDeeplink() == null) {
                eVar.g(2);
            } else {
                eVar.i(2, msgBean.getDeeplink());
            }
            if (msgBean.getDesc() == null) {
                eVar.g(3);
            } else {
                eVar.i(3, msgBean.getDesc());
            }
            if (msgBean.getImageList() == null) {
                eVar.g(4);
            } else {
                eVar.i(4, msgBean.getImageList());
            }
            if (msgBean.getMessageId() == null) {
                eVar.g(5);
            } else {
                eVar.i(5, msgBean.getMessageId());
            }
            if (msgBean.getSource() == null) {
                eVar.g(6);
            } else {
                eVar.i(6, msgBean.getSource());
            }
            if (msgBean.getStyle() == null) {
                eVar.g(7);
            } else {
                eVar.i(7, msgBean.getStyle());
            }
            if (msgBean.getTitle() == null) {
                eVar.g(8);
            } else {
                eVar.i(8, msgBean.getTitle());
            }
            if (msgBean.getType() == null) {
                eVar.g(9);
            } else {
                eVar.i(9, msgBean.getType());
            }
            if (msgBean.getReceiveTime() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, msgBean.getReceiveTime().longValue());
            }
            eVar.c(11, msgBean.getMsgStatus());
            if (msgBean.getShowTime() == null) {
                eVar.g(12);
            } else {
                eVar.c(12, msgBean.getShowTime().longValue());
            }
            eVar.c(13, msgBean.getForceShow() ? 1L : 0L);
            eVar.c(14, msgBean.getHasScreenOn() ? 1L : 0L);
            eVar.c(15, msgBean.getBuiltIn() ? 1L : 0L);
            eVar.c(16, msgBean.getPermanentMsgStatus());
            eVar.c(17, msgBean.getId());
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(y3.b bVar) {
        y3.e F0 = bVar.F0("DELETE FROM MSG");
        try {
            F0.C0();
            return Unit.a;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List o(y3.b bVar) {
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM MSG ORDER BY receive_time DESC");
        try {
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "deep_link");
            int c4 = androidx.room.util.i.c(F0, "desc");
            int c5 = androidx.room.util.i.c(F0, GifImagePreviewActivity.IMAGE_LIST);
            int c6 = androidx.room.util.i.c(F0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int c7 = androidx.room.util.i.c(F0, "source");
            int c8 = androidx.room.util.i.c(F0, "style");
            int c9 = androidx.room.util.i.c(F0, "title");
            int c10 = androidx.room.util.i.c(F0, "type");
            int c11 = androidx.room.util.i.c(F0, "receive_time");
            int c12 = androidx.room.util.i.c(F0, "msg_status");
            int c13 = androidx.room.util.i.c(F0, "show_time");
            int c14 = androidx.room.util.i.c(F0, "force_show");
            int c15 = androidx.room.util.i.c(F0, "has_screen_on");
            int c16 = androidx.room.util.i.c(F0, "built_in");
            int c17 = androidx.room.util.i.c(F0, "permanent_msg_status");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                int i8 = c15;
                ArrayList arrayList2 = arrayList;
                int i9 = (int) F0.getLong(c2);
                String q0 = F0.isNull(c3) ? null : F0.q0(c3);
                String q02 = F0.isNull(c4) ? null : F0.q0(c4);
                String q03 = F0.isNull(c5) ? null : F0.q0(c5);
                String q04 = F0.isNull(c6) ? null : F0.q0(c6);
                String q05 = F0.isNull(c7) ? null : F0.q0(c7);
                String q06 = F0.isNull(c8) ? null : F0.q0(c8);
                String q07 = F0.isNull(c9) ? null : F0.q0(c9);
                String q08 = F0.isNull(c10) ? null : F0.q0(c10);
                if (F0.isNull(c11)) {
                    i2 = c3;
                    i = c4;
                    valueOf = null;
                } else {
                    i = c4;
                    valueOf = Long.valueOf(F0.getLong(c11));
                    i2 = c3;
                }
                int i10 = (int) F0.getLong(c12);
                if (F0.isNull(c13)) {
                    i3 = c5;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(c13));
                    i3 = c5;
                }
                if (((int) F0.getLong(c14)) != 0) {
                    i4 = i8;
                    z = true;
                } else {
                    i4 = i8;
                    z = false;
                }
                int i11 = c6;
                if (((int) F0.getLong(i4)) != 0) {
                    i5 = c16;
                    i6 = c7;
                    z2 = true;
                } else {
                    z2 = false;
                    i5 = c16;
                    i6 = c7;
                }
                int i12 = i4;
                if (((int) F0.getLong(i5)) != 0) {
                    i7 = c17;
                    z3 = true;
                } else {
                    i7 = c17;
                    z3 = false;
                }
                int i13 = i5;
                arrayList2.add(new MsgBean(i9, q0, q02, q03, q04, q05, q06, q07, q08, valueOf, i10, valueOf2, z, z2, z3, (int) F0.getLong(i7)));
                c15 = i12;
                c4 = i;
                c5 = i3;
                c7 = i6;
                c16 = i13;
                c17 = i7;
                c6 = i11;
                int i14 = i2;
                arrayList = arrayList2;
                c3 = i14;
            }
            return arrayList;
        } finally {
            F0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MsgBean p(String str, y3.b bVar) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        y3.e F0 = bVar.F0("SELECT * FROM MSG WHERE message_id = ?");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "deep_link");
            int c4 = androidx.room.util.i.c(F0, "desc");
            int c5 = androidx.room.util.i.c(F0, GifImagePreviewActivity.IMAGE_LIST);
            int c6 = androidx.room.util.i.c(F0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int c7 = androidx.room.util.i.c(F0, "source");
            int c8 = androidx.room.util.i.c(F0, "style");
            int c9 = androidx.room.util.i.c(F0, "title");
            int c10 = androidx.room.util.i.c(F0, "type");
            int c11 = androidx.room.util.i.c(F0, "receive_time");
            int c12 = androidx.room.util.i.c(F0, "msg_status");
            int c13 = androidx.room.util.i.c(F0, "show_time");
            int c14 = androidx.room.util.i.c(F0, "force_show");
            int c15 = androidx.room.util.i.c(F0, "has_screen_on");
            int c16 = androidx.room.util.i.c(F0, "built_in");
            int c17 = androidx.room.util.i.c(F0, "permanent_msg_status");
            MsgBean msgBean = null;
            if (F0.C0()) {
                int i3 = (int) F0.getLong(c2);
                String q0 = F0.isNull(c3) ? null : F0.q0(c3);
                String q02 = F0.isNull(c4) ? null : F0.q0(c4);
                String q03 = F0.isNull(c5) ? null : F0.q0(c5);
                String q04 = F0.isNull(c6) ? null : F0.q0(c6);
                String q05 = F0.isNull(c7) ? null : F0.q0(c7);
                String q06 = F0.isNull(c8) ? null : F0.q0(c8);
                String q07 = F0.isNull(c9) ? null : F0.q0(c9);
                String q08 = F0.isNull(c10) ? null : F0.q0(c10);
                Long valueOf = F0.isNull(c11) ? null : Long.valueOf(F0.getLong(c11));
                int i4 = (int) F0.getLong(c12);
                Long valueOf2 = F0.isNull(c13) ? null : Long.valueOf(F0.getLong(c13));
                if (((int) F0.getLong(c14)) != 0) {
                    i = c15;
                    z = true;
                } else {
                    z = false;
                    i = c15;
                }
                if (((int) F0.getLong(i)) != 0) {
                    z2 = true;
                    i2 = c16;
                } else {
                    i2 = c16;
                    z2 = false;
                }
                msgBean = new MsgBean(i3, q0, q02, q03, q04, q05, q06, q07, q08, valueOf, i4, valueOf2, z, z2, ((int) F0.getLong(i2)) != 0, (int) F0.getLong(c17));
            }
            F0.close();
            return msgBean;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(String str, y3.b bVar) {
        int i;
        Long valueOf;
        int i2;
        Long valueOf2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        y3.e F0 = bVar.F0("SELECT * FROM MSG WHERE type = ? ORDER BY id ASC");
        try {
            if (str == null) {
                F0.g(1);
            } else {
                F0.i(1, str);
            }
            int c2 = androidx.room.util.i.c(F0, "id");
            int c3 = androidx.room.util.i.c(F0, "deep_link");
            int c4 = androidx.room.util.i.c(F0, "desc");
            int c5 = androidx.room.util.i.c(F0, GifImagePreviewActivity.IMAGE_LIST);
            int c6 = androidx.room.util.i.c(F0, PushConstants.EXTRA_PUSH_MESSAGE_ID);
            int c7 = androidx.room.util.i.c(F0, "source");
            int c8 = androidx.room.util.i.c(F0, "style");
            int c9 = androidx.room.util.i.c(F0, "title");
            int c10 = androidx.room.util.i.c(F0, "type");
            int c11 = androidx.room.util.i.c(F0, "receive_time");
            int c12 = androidx.room.util.i.c(F0, "msg_status");
            int c13 = androidx.room.util.i.c(F0, "show_time");
            int c14 = androidx.room.util.i.c(F0, "force_show");
            int c15 = androidx.room.util.i.c(F0, "has_screen_on");
            int c16 = androidx.room.util.i.c(F0, "built_in");
            int c17 = androidx.room.util.i.c(F0, "permanent_msg_status");
            ArrayList arrayList = new ArrayList();
            while (F0.C0()) {
                int i10 = c14;
                int i11 = c15;
                int i12 = (int) F0.getLong(c2);
                String q0 = F0.isNull(c3) ? null : F0.q0(c3);
                String q02 = F0.isNull(c4) ? null : F0.q0(c4);
                String q03 = F0.isNull(c5) ? null : F0.q0(c5);
                String q04 = F0.isNull(c6) ? null : F0.q0(c6);
                String q05 = F0.isNull(c7) ? null : F0.q0(c7);
                String q06 = F0.isNull(c8) ? null : F0.q0(c8);
                String q07 = F0.isNull(c9) ? null : F0.q0(c9);
                String q08 = F0.isNull(c10) ? null : F0.q0(c10);
                if (F0.isNull(c11)) {
                    i2 = c3;
                    i = c4;
                    valueOf = null;
                } else {
                    i = c4;
                    valueOf = Long.valueOf(F0.getLong(c11));
                    i2 = c3;
                }
                int i13 = (int) F0.getLong(c12);
                if (F0.isNull(c13)) {
                    i3 = c6;
                    i4 = i10;
                    valueOf2 = null;
                } else {
                    valueOf2 = Long.valueOf(F0.getLong(c13));
                    i3 = c6;
                    i4 = i10;
                }
                int i14 = c5;
                if (((int) F0.getLong(i4)) != 0) {
                    i5 = i11;
                    z = true;
                } else {
                    i5 = i11;
                    z = false;
                }
                int i15 = c7;
                if (((int) F0.getLong(i5)) != 0) {
                    i6 = c16;
                    i7 = i4;
                    i8 = i5;
                    z2 = true;
                } else {
                    i6 = c16;
                    i7 = i4;
                    i8 = i5;
                    z2 = false;
                }
                if (((int) F0.getLong(i6)) != 0) {
                    i9 = c17;
                    z3 = true;
                } else {
                    i9 = c17;
                    z3 = false;
                }
                int i16 = i6;
                arrayList.add(new MsgBean(i12, q0, q02, q03, q04, q05, q06, q07, q08, valueOf, i13, valueOf2, z, z2, z3, (int) F0.getLong(i9)));
                c14 = i7;
                c3 = i2;
                c5 = i14;
                c7 = i15;
                c6 = i3;
                c15 = i8;
                c16 = i16;
                c17 = i9;
                c4 = i;
            }
            F0.close();
            return arrayList;
        } catch (Throwable th2) {
            F0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(MsgBean msgBean, y3.b bVar) {
        this.b.d(bVar, msgBean);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(MsgBean msgBean, y3.b bVar) {
        this.d.c(bVar, msgBean);
        return Unit.a;
    }

    @Override // zi.a
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: zi.g
            public final Object invoke(Object obj) {
                Unit n;
                n = h.n((y3.b) obj);
                return n;
            }
        }, continuation);
    }

    @Override // zi.a
    public Object b(final MsgBean msgBean, Continuation continuation) {
        msgBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: zi.d
            public final Object invoke(Object obj) {
                Unit s;
                s = h.this.s(msgBean, (y3.b) obj);
                return s;
            }
        }, continuation);
    }

    @Override // zi.a
    public Object c(final MsgBean msgBean, Continuation continuation) {
        msgBean.getClass();
        return androidx.room.util.b.f(this.a, false, true, new Function1() { // from class: zi.e
            public final Object invoke(Object obj) {
                Unit r;
                r = h.this.r(msgBean, (y3.b) obj);
                return r;
            }
        }, continuation);
    }

    @Override // zi.a
    public Object d(Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: zi.c
            public final Object invoke(Object obj) {
                List o;
                o = h.o((y3.b) obj);
                return o;
            }
        }, continuation);
    }

    @Override // zi.a
    public Object e(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: zi.f
            public final Object invoke(Object obj) {
                MsgBean p;
                p = h.p(str, (y3.b) obj);
                return p;
            }
        }, continuation);
    }

    @Override // zi.a
    public Object f(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.a, true, false, new Function1() { // from class: zi.b
            public final Object invoke(Object obj) {
                List q;
                q = h.q(str, (y3.b) obj);
                return q;
            }
        }, continuation);
    }
}
