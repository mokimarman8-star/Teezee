package com.transsion.ad;

import com.blankj.utilcode.util.Utils;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a {
    public static final a a = new a();
    private static final String b;
    private static final String c;

    static {
        File externalFilesDir = Utils.a().getExternalFilesDir("mb");
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        char c2 = File.separatorChar;
        b = absolutePath + c2 + "non_ad";
        File externalFilesDir2 = Utils.a().getExternalFilesDir("ps");
        c = (externalFilesDir2 != null ? externalFilesDir2.getAbsolutePath() : null) + c2 + "non_ad";
    }

    private a() {
    }

    public final String a() {
        return c;
    }

    public final String b() {
        return b;
    }
}
