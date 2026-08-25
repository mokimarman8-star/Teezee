package com.transsion.lib_web.zip.db;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements zl.a {
    public static final d e = new d(null);
    private final RoomDatabase a;
    private final g b;
    private final e c;
    private final e d;

    /* renamed from: com.transsion.lib_web.zip.db.a$a, reason: collision with other inner class name */
    public static final class C0036a extends g {
        C0036a() {
        }

        protected String b() {
            return "INSERT OR REPLACE INTO `mb_web_res_db` (`scene`,`htmlUrl`,`zipUrl`,`zipMd5`,`sourceType`,`updateTime`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, WebViewCacheConfigData webViewCacheConfigData) {
            Intrinsics.h(eVar, "statement");
            Intrinsics.h(webViewCacheConfigData, "entity");
            eVar.i(1, webViewCacheConfigData.getScene());
            eVar.i(2, webViewCacheConfigData.getHtmlUrl());
            eVar.i(3, webViewCacheConfigData.getZipUrl());
            eVar.i(4, webViewCacheConfigData.getZipMd5());
            eVar.c(5, webViewCacheConfigData.getSourceType());
            String updateTime = webViewCacheConfigData.getUpdateTime();
            if (updateTime == null) {
                eVar.g(6);
            } else {
                eVar.i(6, updateTime);
            }
        }
    }

    public static final class b extends e {
        b() {
        }

        protected String b() {
            return "DELETE FROM `mb_web_res_db` WHERE `scene` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, WebViewCacheConfigData webViewCacheConfigData) {
            Intrinsics.h(eVar, "statement");
            Intrinsics.h(webViewCacheConfigData, "entity");
            eVar.i(1, webViewCacheConfigData.getScene());
        }
    }

    public static final class c extends e {
        c() {
        }

        protected String b() {
            return "UPDATE OR ABORT `mb_web_res_db` SET `scene` = ?,`htmlUrl` = ?,`zipUrl` = ?,`zipMd5` = ?,`sourceType` = ?,`updateTime` = ? WHERE `scene` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(y3.e eVar, WebViewCacheConfigData webViewCacheConfigData) {
            Intrinsics.h(eVar, "statement");
            Intrinsics.h(webViewCacheConfigData, "entity");
            eVar.i(1, webViewCacheConfigData.getScene());
            eVar.i(2, webViewCacheConfigData.getHtmlUrl());
            eVar.i(3, webViewCacheConfigData.getZipUrl());
            eVar.i(4, webViewCacheConfigData.getZipMd5());
            eVar.c(5, webViewCacheConfigData.getSourceType());
            String updateTime = webViewCacheConfigData.getUpdateTime();
            if (updateTime == null) {
                eVar.g(6);
            } else {
                eVar.i(6, updateTime);
            }
            eVar.i(7, webViewCacheConfigData.getScene());
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.l();
        }
    }

    public a(RoomDatabase roomDatabase) {
        Intrinsics.h(roomDatabase, "__db");
        this.a = roomDatabase;
        this.b = new C0036a();
        this.c = new b();
        this.d = new c();
    }
}
