package com.transsion.lib_web.zip.db;

import androidx.room.InvalidationTracker;
import androidx.room.f0;
import androidx.room.util.m;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.zip.db.WebResDatabase_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import y3.b;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\f0\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b\u0012\u0004\u0012\u00020\u00100\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/transsion/lib_web/zip/db/WebResDatabase_Impl;", "Lcom/transsion/lib_web/zip/db/WebResDatabase;", "<init>", "()V", "Landroidx/room/f0;", "j0", "()Landroidx/room/f0;", "Landroidx/room/InvalidationTracker;", "q", "()Landroidx/room/InvalidationTracker;", BuildConfig.FLAVOR, "Lkotlin/reflect/KClass;", BuildConfig.FLAVOR, "D", "()Ljava/util/Map;", BuildConfig.FLAVOR, "Lx3/a;", "B", "()Ljava/util/Set;", "autoMigrationSpecs", "Lx3/b;", "n", "(Ljava/util/Map;)Ljava/util/List;", "Lkotlin/Lazy;", "Lzl/a;", "r", "Lkotlin/Lazy;", "_webResDao", "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WebResDatabase_Impl extends WebResDatabase {

    /* renamed from: r, reason: from kotlin metadata */
    private final Lazy _webResDao = LazyKt.b(new Function0() { // from class: zl.b
        public final Object invoke() {
            com.transsion.lib_web.zip.db.a h0;
            h0 = WebResDatabase_Impl.h0(WebResDatabase_Impl.this);
            return h0;
        }
    });

    public static final class a extends f0 {
        a() {
            super(1, "8fb9548e62ef8b007d7fa7c9d6d00479", "a675d4e34806d9830871c01a4db0b4d7");
        }

        public void a(b bVar) {
            Intrinsics.h(bVar, "connection");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `mb_web_res_db` (`scene` TEXT NOT NULL, `htmlUrl` TEXT NOT NULL, `zipUrl` TEXT NOT NULL, `zipMd5` TEXT NOT NULL, `sourceType` INTEGER NOT NULL, `updateTime` TEXT, PRIMARY KEY(`scene`))");
            y3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            y3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8fb9548e62ef8b007d7fa7c9d6d00479')");
        }

        public void b(b bVar) {
            Intrinsics.h(bVar, "connection");
            y3.a.a(bVar, "DROP TABLE IF EXISTS `mb_web_res_db`");
        }

        public void f(b bVar) {
            Intrinsics.h(bVar, "connection");
        }

        public void g(b bVar) {
            Intrinsics.h(bVar, "connection");
            WebResDatabase_Impl.this.P(bVar);
        }

        public void h(b bVar) {
            Intrinsics.h(bVar, "connection");
        }

        public void i(b bVar) {
            Intrinsics.h(bVar, "connection");
            androidx.room.util.b.a(bVar);
        }

        public f0.a j(b bVar) {
            Intrinsics.h(bVar, "connection");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("scene", new m.a("scene", "TEXT", true, 1, (String) null, 1));
            linkedHashMap.put("htmlUrl", new m.a("htmlUrl", "TEXT", true, 0, (String) null, 1));
            linkedHashMap.put("zipUrl", new m.a("zipUrl", "TEXT", true, 0, (String) null, 1));
            linkedHashMap.put("zipMd5", new m.a("zipMd5", "TEXT", true, 0, (String) null, 1));
            linkedHashMap.put("sourceType", new m.a("sourceType", "INTEGER", true, 0, (String) null, 1));
            linkedHashMap.put("updateTime", new m.a("updateTime", "TEXT", false, 0, (String) null, 1));
            m mVar = new m("mb_web_res_db", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
            m a = m.e.a(bVar, "mb_web_res_db");
            if (mVar.equals(a)) {
                return new f0.a(true, (String) null);
            }
            return new f0.a(false, "mb_web_res_db(com.transsion.lib_web.zip.db.WebViewCacheConfigData).\n Expected:\n" + mVar + "\n Found:\n" + a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.lib_web.zip.db.a h0(WebResDatabase_Impl webResDatabase_Impl) {
        return new com.transsion.lib_web.zip.db.a(webResDatabase_Impl);
    }

    public Set B() {
        return new LinkedHashSet();
    }

    protected Map D() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Reflection.b(zl.a.class), com.transsion.lib_web.zip.db.a.e.a());
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public f0 r() {
        return new a();
    }

    public List n(Map autoMigrationSpecs) {
        Intrinsics.h(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), new String[]{"mb_web_res_db"});
    }
}
