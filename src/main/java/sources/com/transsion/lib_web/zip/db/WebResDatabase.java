package com.transsion.lib_web.zip.db;

import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/transsion/lib_web/zip/db/WebResDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "p", "b", "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class WebResDatabase extends RoomDatabase {
    private static final a q = new a();

    public static final class a extends b {
        a() {
            super(1, 2);
        }

        public void b(d dVar) {
            Intrinsics.h(dVar, "database");
            dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN postId TEXT");
            dVar.E("ALTER TABLE AUDIO ADD COLUMN ops TEXT");
        }
    }
}
