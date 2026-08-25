package com.transsion.baselib.db;

import aj.e;
import androidx.room.InvalidationTracker;
import androidx.room.f0;
import com.hisavana.common.constant.ComConstants;
import com.transsion.baselib.db.member.MemberResolutionDao;
import com.transsion.baselib.db.member.g;
import com.transsion.baselib.db.place.PlaceDao;
import com.transsion.baselib.db.video.IShortTvFavoriteStateDao;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCCollectionVideoGroupDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.db.video.a1;
import com.transsion.baselib.db.video.b1;
import com.transsion.baselib.db.video.d;
import com.transsion.baselib.db.video.j0;
import com.transsion.baselib.db.video.k0;
import com.transsion.baselib.db.video.m;
import com.transsion.baselib.db.video.q;
import com.transsion.baselib.db.video.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import si.j;
import ti.b;
import ui.c;
import ui.c1;
import ui.d1;
import ui.h1;
import ui.l0;
import ui.n0;
import ui.r0;
import ui.t0;
import ui.u0;
import ui.v0;
import zi.a;
import zi.h;
import zi.i;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile a A0;
    private volatile n0 B0;
    private volatile a1 C0;
    private volatile ShortTVPlayDao D0;
    private volatile d1 E0;
    private volatile IShortTvFavoriteStateDao F0;
    private volatile VideoDetailPlayDao G0;
    private volatile xi.a H0;
    private volatile PlaceDao I0;
    private volatile UGCVideoDetailPlayDao J0;
    private volatile UGCCollectionVideoGroupDao K0;
    private volatile MemberResolutionDao L0;
    private volatile vi.a M0;
    private volatile si.a w0;
    private volatile c x0;
    private volatile aj.a y0;
    private volatile v0 z0;

    @Override // com.transsion.baselib.db.AppDatabase
    public UGCCollectionVideoGroupDao A1() {
        UGCCollectionVideoGroupDao uGCCollectionVideoGroupDao;
        if (this.K0 != null) {
            return this.K0;
        }
        synchronized (this) {
            try {
                if (this.K0 == null) {
                    this.K0 = new q(this);
                }
                uGCCollectionVideoGroupDao = this.K0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uGCCollectionVideoGroupDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public UGCVideoDetailPlayDao B1() {
        UGCVideoDetailPlayDao uGCVideoDetailPlayDao;
        if (this.J0 != null) {
            return this.J0;
        }
        synchronized (this) {
            try {
                if (this.J0 == null) {
                    this.J0 = new j0(this);
                }
                uGCVideoDetailPlayDao = this.J0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uGCVideoDetailPlayDao;
    }

    @Override // androidx.room.RoomDatabase
    public Set C() {
        return new HashSet();
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public VideoDetailPlayDao C1() {
        VideoDetailPlayDao videoDetailPlayDao;
        if (this.G0 != null) {
            return this.G0;
        }
        synchronized (this) {
            try {
                if (this.G0 == null) {
                    this.G0 = new z0(this);
                }
                videoDetailPlayDao = this.G0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return videoDetailPlayDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public a1 D1() {
        a1 a1Var;
        if (this.C0 != null) {
            return this.C0;
        }
        synchronized (this) {
            try {
                if (this.C0 == null) {
                    this.C0 = new b1(this);
                }
                a1Var = this.C0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a1Var;
    }

    @Override // androidx.room.RoomDatabase
    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(si.a.class, j.q());
        hashMap.put(c.class, l0.q0());
        hashMap.put(k0.class, com.transsion.baselib.db.video.l0.a());
        hashMap.put(t0.class, u0.a());
        hashMap.put(aj.a.class, e.g());
        hashMap.put(v0.class, c1.m());
        hashMap.put(i.class, zi.j.a());
        hashMap.put(a.class, h.m());
        hashMap.put(ti.a.class, b.a());
        hashMap.put(yi.a.class, yi.b.a());
        hashMap.put(wi.a.class, wi.b.a());
        hashMap.put(n0.class, r0.g());
        hashMap.put(a1.class, b1.a());
        hashMap.put(ShortTVPlayDao.class, m.r());
        hashMap.put(d1.class, h1.g());
        hashMap.put(IShortTvFavoriteStateDao.class, d.h());
        hashMap.put(VideoDetailPlayDao.class, z0.E());
        hashMap.put(xi.a.class, xi.h.m());
        hashMap.put(PlaceDao.class, com.transsion.baselib.db.place.d.h());
        hashMap.put(UGCVideoDetailPlayDao.class, j0.P());
        hashMap.put(UGCCollectionVideoGroupDao.class, q.j());
        hashMap.put(MemberResolutionDao.class, g.m());
        hashMap.put(vi.a.class, vi.d.e());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a(this, 58, "b0c54b19a40cfcf785b1ce6277c3b3a2", "7ab4a93e3b6040b69ab078acec2bef77");
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public si.a n1() {
        si.a aVar;
        if (this.w0 != null) {
            return this.w0;
        }
        synchronized (this) {
            try {
                if (this.w0 == null) {
                    this.w0 = new j(this);
                }
                aVar = this.w0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public c o1() {
        c cVar;
        if (this.x0 != null) {
            return this.x0;
        }
        synchronized (this) {
            try {
                if (this.x0 == null) {
                    this.x0 = new l0(this);
                }
                cVar = this.x0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public n0 p1() {
        n0 n0Var;
        if (this.B0 != null) {
            return this.B0;
        }
        synchronized (this) {
            try {
                if (this.B0 == null) {
                    this.B0 = new r0(this);
                }
                n0Var = this.B0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return n0Var;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "audio", "download_table", ComConstants.VIDEO_TAG, "download_thread_info", "room_table", "permanent_msg", "download_subtitle_table", "msg", "consume_bean", "download_thread_range", "video_land_ad", "subtitle_language_map_table", "non_ad_plans", "local_mcc", "short_tv_play", "ShortTvFavoriteState", "video_detail_play", "music_liked", "place_list", "ugc_video_detail_play", "ugc_collection_video_group", "member_resolution", "home_preferences_interval_time");
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public vi.a q1() {
        vi.a aVar;
        if (this.M0 != null) {
            return this.M0;
        }
        synchronized (this) {
            try {
                if (this.M0 == null) {
                    this.M0 = new vi.d(this);
                }
                aVar = this.M0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public MemberResolutionDao r1() {
        MemberResolutionDao memberResolutionDao;
        if (this.L0 != null) {
            return this.L0;
        }
        synchronized (this) {
            try {
                if (this.L0 == null) {
                    this.L0 = new g(this);
                }
                memberResolutionDao = this.L0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return memberResolutionDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public a s1() {
        a aVar;
        if (this.A0 != null) {
            return this.A0;
        }
        synchronized (this) {
            try {
                if (this.A0 == null) {
                    this.A0 = new h(this);
                }
                aVar = this.A0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public xi.a t1() {
        xi.a aVar;
        if (this.H0 != null) {
            return this.H0;
        }
        synchronized (this) {
            try {
                if (this.H0 == null) {
                    this.H0 = new xi.h(this);
                }
                aVar = this.H0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public PlaceDao u1() {
        PlaceDao placeDao;
        if (this.I0 != null) {
            return this.I0;
        }
        synchronized (this) {
            try {
                if (this.I0 == null) {
                    this.I0 = new com.transsion.baselib.db.place.d(this);
                }
                placeDao = this.I0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return placeDao;
    }

    @Override // androidx.room.RoomDatabase
    public List v(Map map) {
        return new ArrayList();
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public aj.a v1() {
        aj.a aVar;
        if (this.y0 != null) {
            return this.y0;
        }
        synchronized (this) {
            try {
                if (this.y0 == null) {
                    this.y0 = new e(this);
                }
                aVar = this.y0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public ShortTVPlayDao w1() {
        ShortTVPlayDao shortTVPlayDao;
        if (this.D0 != null) {
            return this.D0;
        }
        synchronized (this) {
            try {
                if (this.D0 == null) {
                    this.D0 = new m(this);
                }
                shortTVPlayDao = this.D0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return shortTVPlayDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public IShortTvFavoriteStateDao x1() {
        IShortTvFavoriteStateDao iShortTvFavoriteStateDao;
        if (this.F0 != null) {
            return this.F0;
        }
        synchronized (this) {
            try {
                if (this.F0 == null) {
                    this.F0 = new d(this);
                }
                iShortTvFavoriteStateDao = this.F0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iShortTvFavoriteStateDao;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public v0 y1() {
        v0 v0Var;
        if (this.z0 != null) {
            return this.z0;
        }
        synchronized (this) {
            try {
                if (this.z0 == null) {
                    this.z0 = new c1(this);
                }
                v0Var = this.z0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return v0Var;
    }

    @Override // com.transsion.baselib.db.AppDatabase
    public d1 z1() {
        d1 d1Var;
        if (this.E0 != null) {
            return this.E0;
        }
        synchronized (this) {
            try {
                if (this.E0 == null) {
                    this.E0 = new h1(this);
                }
                d1Var = this.E0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return d1Var;
    }
}
