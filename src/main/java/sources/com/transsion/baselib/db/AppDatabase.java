package com.transsion.baselib.db;

import androidx.room.RoomDatabase;
import com.transsion.baselib.db.member.MemberResolutionDao;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.db.video.a1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import si.a;
import ui.c;
import ui.d1;
import ui.n0;
import ui.v0;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 72\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H&¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H&¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H&¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H&¢\u0006\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/transsion/baselib/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lsi/a;", "n1", "()Lsi/a;", "Lui/c;", "o1", "()Lui/c;", "Laj/a;", "v1", "()Laj/a;", "Lui/v0;", "y1", "()Lui/v0;", "Lzi/a;", "s1", "()Lzi/a;", "Lui/n0;", "p1", "()Lui/n0;", "Lcom/transsion/baselib/db/video/a1;", "D1", "()Lcom/transsion/baselib/db/video/a1;", "Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "w1", "()Lcom/transsion/baselib/db/video/ShortTVPlayDao;", "Lui/d1;", "z1", "()Lui/d1;", "Lcom/transsion/baselib/db/video/IShortTvFavoriteStateDao;", "x1", "()Lcom/transsion/baselib/db/video/IShortTvFavoriteStateDao;", "Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "C1", "()Lcom/transsion/baselib/db/video/VideoDetailPlayDao;", "Lxi/a;", "t1", "()Lxi/a;", "Lcom/transsion/baselib/db/place/PlaceDao;", "u1", "()Lcom/transsion/baselib/db/place/PlaceDao;", "Lcom/transsion/baselib/db/video/UGCVideoDetailPlayDao;", "B1", "()Lcom/transsion/baselib/db/video/UGCVideoDetailPlayDao;", "Lcom/transsion/baselib/db/video/UGCCollectionVideoGroupDao;", "A1", "()Lcom/transsion/baselib/db/video/UGCCollectionVideoGroupDao;", "Lcom/transsion/baselib/db/member/MemberResolutionDao;", "r1", "()Lcom/transsion/baselib/db/member/MemberResolutionDao;", "Lvi/a;", "q1", "()Lvi/a;", "p", "f1", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase q;
    public static final f1 p = new f1((DefaultConstructorMarker) null);
    private static final k r = new k();
    private static final v s = new v();
    private static final g0 t = new g0();
    private static final r0 u = new r0();
    private static final a1 v = new a1();
    private static final b1 w = new b1();
    private static final c1 x = new c1();
    private static final d1 y = new d1();
    private static final e1 z = new e1();
    private static final a A = new a();
    private static final b B = new b();
    private static final c C = new c();
    private static final d D = new d();
    private static final e E = new e();
    private static final f F = new f();
    private static final g G = new g();
    private static final h H = new h();
    private static final i I = new i();
    private static final j J = new j();
    private static final l K = new l();
    private static final m L = new m();
    private static final n M = new n();
    private static final o N = new o();
    private static final p O = new p();
    private static final q P = new q();
    private static final r Q = new r();
    private static final s R = new s();
    private static final t S = new t();
    private static final u T = new u();
    private static final w U = new w();
    private static final x V = new x();
    private static final y W = new y();
    private static final z X = new z();
    private static final a0 Y = new a0();
    private static final b0 Z = new b0();
    private static final c0 a0 = new c0();
    private static final d0 b0 = new d0();
    private static final e0 c0 = new e0();
    private static final f0 d0 = new f0();
    private static final h0 e0 = new h0();
    private static final i0 f0 = new i0();
    private static final j0 g0 = new j0();
    private static final k0 h0 = new k0();
    private static final l0 i0 = new l0();
    private static final m0 j0 = new m0();
    private static final n0 k0 = new n0();
    private static final o0 l0 = new o0();
    private static final p0 m0 = new p0();
    private static final q0 n0 = new q0();
    private static final s0 o0 = new s0();
    private static final t0 p0 = new t0();
    private static final u0 q0 = new u0();
    private static final v0 r0 = new v0();
    private static final w0 s0 = new w0();
    private static final x0 t0 = new x0();
    private static final y0 u0 = new y0();
    private static final z0 v0 = new z0();

    public abstract UGCCollectionVideoGroupDao A1();

    public abstract UGCVideoDetailPlayDao B1();

    public abstract VideoDetailPlayDao C1();

    public abstract a1 D1();

    public abstract a n1();

    public abstract c o1();

    public abstract n0 p1();

    public abstract vi.a q1();

    public abstract MemberResolutionDao r1();

    public abstract zi.a s1();

    public abstract xi.a t1();

    public abstract PlaceDao u1();

    public abstract aj.a v1();

    public abstract ShortTVPlayDao w1();

    public abstract IShortTvFavoriteStateDao x1();

    public abstract v0 y1();

    public abstract d1 z1();
}
