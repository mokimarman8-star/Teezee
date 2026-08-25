package com.transsion.athena.aethna.anehat.aethna;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.athena.anateh.anehat;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.ga.anateh;
import com.transsion.ga.i;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class athena {
    private static volatile athena a;
    private byte[] b;
    public boolean c;
    private String d;
    private String e;

    private athena() {
    }

    private boolean a() {
        if (!this.c) {
            File file = new File(this.d);
            try {
                if (file.exists()) {
                    this.c = true;
                } else {
                    this.c = file.mkdirs();
                }
            } catch (Exception e) {
                aethna.b(Log.getStackTraceString(e));
            }
        }
        return this.c;
    }

    public static athena b() {
        if (a == null) {
            synchronized (athena.class) {
                try {
                    if (a == null) {
                        a = new athena();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(AthenaAnalytics.J().getFilesDir());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        this.d = sb.toString();
        if (!a()) {
            this.d = AthenaAnalytics.J().getFilesDir().getPath();
        }
        this.e = this.d + str2 + "remote_config.cfg";
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(this.d) && a()) {
            File file = new File(this.e);
            try {
                anehat.a(file, str, this.b);
            } catch (Exception e) {
                i.a().c(new anateh("bufferSave", e));
                try {
                    if (file.isDirectory()) {
                        com.transsion.athena.taaneh.athena.a(AthenaAnalytics.J(), this.e);
                    }
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public String c() {
        if (!TextUtils.isEmpty(this.d) && a()) {
            File file = new File(this.e);
            try {
                return anehat.a(file, this.b);
            } catch (Exception e) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("e", e.getClass().getSimpleName());
                    bundle.putString("pwd", com.transsion.athena.config.data.model.anehat.c(this.b));
                    bundle.putLong("len", file.length());
                    i.a().c(new anateh("bufferRead", bundle));
                    com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J(), file);
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
