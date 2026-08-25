package com.transsion.athena.hatnea;

import android.text.TextUtils;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class taaneh extends anateh {
    private final long c;
    private File d;
    private final com.transsion.athena.config.data.model.aethna e;

    public taaneh(long j, File file, com.transsion.athena.config.data.model.aethna aethnaVar) {
        this.c = j;
        this.d = file;
        this.e = aethnaVar;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        String str;
        int i;
        File file = this.d;
        if (file != null && file.exists() && this.d.isFile() && this.d.getName().contains("upload")) {
            File file2 = this.d;
            if (file2.exists()) {
                str = new com.transsion.athena.anateh.aethna(file2.getPath()).a();
                i = str.split("\n").length;
            } else {
                str = BuildConfig.FLAVOR;
                i = str.split("\n").length;
            }
        } else {
            str = null;
            i = 0;
        }
        if (TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        if (anehat.a(this.c, str.getBytes(), i, this.e).a != 0) {
            com.transsion.athena.taaneh.aethna.b("PostEventFileTask requestByPost error");
        } else if (this.d != null) {
            com.transsion.athena.taaneh.aethna.c("PostEventFileTask lines : %d, deleteFile : %s", Long.valueOf(this.c), Integer.valueOf(i), Boolean.valueOf(com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J(), this.d)));
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Upload-File";
    }
}
