package com.transsion.athena.ehatna;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.athena.data.Track;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import java.io.FileInputStream;
import java.io.IOException;
import m4.a;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class aethna {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile aethna a;
    private athena b;
    private String c;
    private boolean d;
    private long e = -1;
    private volatile boolean f;

    private aethna() {
    }

    public static aethna b() {
        if (a == null) {
            synchronized (aethna.class) {
                try {
                    if (a == null) {
                        a = new aethna();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public long a(long j, long j2) {
        if (!this.d) {
            return j;
        }
        athena athenaVar = this.b;
        return (athenaVar.a + j2) - athenaVar.b;
    }

    public String a() {
        return this.c;
    }

    public void a(Track track) {
        if (!this.d) {
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            track.setBootId(this.c);
        } else {
            long trackErTs = this.b.a + (track.getTrackErTs() - this.b.b);
            if (trackErTs < 1633017600000L) {
                trackErTs = track.getTrackTs();
            }
            track.setTrackTs(trackErTs);
        }
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public boolean a(long j) {
        this.f = false;
        this.e = -1L;
        if (j > 1633017600000L) {
            long currentTimeMillis = System.currentTimeMillis();
            this.b = new athena(j, SystemClock.elapsedRealtime(), this.c);
            if (Math.abs(currentTimeMillis - j) > 600000) {
                this.d = true;
            }
            try {
                if (!TextUtils.isEmpty(this.c)) {
                    a a2 = a.a(AthenaAnalytics.J());
                    athena athenaVar = this.b;
                    athenaVar.getClass();
                    a2.g("base_time", new JSONObject().put("serverTime", athenaVar.a).put("elapsedRealtime", athenaVar.b).put("bootId", athenaVar.c).toString());
                }
            } catch (Exception e) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
        } else {
            this.b = new athena(System.currentTimeMillis(), SystemClock.elapsedRealtime(), this.c);
            this.d = false;
        }
        return this.d;
    }

    public long c() {
        athena athenaVar = this.b;
        if (athenaVar != null) {
            return athenaVar.a - athenaVar.b;
        }
        return 0L;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|2|3|(1:5)|7|(5:8|9|10|11|12)|(5:14|15|16|17|(1:31)(2:21|(2:23|(2:25|26)(1:28))(2:29|30)))|36|37|38|17|(2:19|31)(1:32)|(2:(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0063, code lost:
    
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        FileInputStream fileInputStream;
        String str;
        byte[] bArr;
        int read;
        try {
            String i = a.a(AthenaAnalytics.J()).i("base_time");
            com.transsion.athena.taaneh.aethna.a("baseTimeJs = " + i);
            if (!TextUtils.isEmpty(i)) {
                this.b = new athena(i);
            }
        } catch (Exception e) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/sys/kernel/random/boot_id");
            try {
                bArr = new byte[1024];
                read = fileInputStream.read(bArr);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
        if (read > 0) {
            str = new String(bArr, 0, read).trim();
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
            this.c = str;
            if (this.b != null || TextUtils.isEmpty(str)) {
            }
            if (!this.c.equals(this.b.c)) {
                this.b = null;
                a.a(AthenaAnalytics.J()).g("base_time", BuildConfig.FLAVOR);
                return;
            } else {
                if (Math.abs((this.b.a + (SystemClock.elapsedRealtime() - this.b.b)) - System.currentTimeMillis()) > 600000) {
                    this.d = true;
                    return;
                }
                return;
            }
        }
        fileInputStream.close();
        str = null;
        this.c = str;
        if (this.b != null) {
        }
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        if (this.e > 0 && SystemClock.elapsedRealtime() - this.e > 60000) {
            return false;
        }
        athena athenaVar = this.b;
        return athenaVar == null || !TextUtils.equals(athenaVar.c, this.c);
    }
}
