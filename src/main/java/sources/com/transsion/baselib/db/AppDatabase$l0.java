package com.transsion.baselib.db;

import kotlin.jvm.internal.Intrinsics;
import x3.b;
import z3.d;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AppDatabase$l0 extends b {
    AppDatabase$l0() {
        super(44, 45);
    }

    public void b(d dVar) {
        Intrinsics.h(dVar, "database");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN restrictLevel TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN releaseDate TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN countryName TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN subtitles TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN imdbRate TEXT");
        dVar.E("ALTER TABLE DOWNLOAD_TABLE ADD COLUMN seNum INTEGER");
    }
}
