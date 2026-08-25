package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class r {
    private static final Map c = new HashMap();
    private final Context a;
    private final String b;

    private r(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public static synchronized r c(Context context, String str) {
        r rVar;
        synchronized (r.class) {
            try {
                Map map = c;
                if (!map.containsKey(str)) {
                    map.put(str, new r(context, str));
                }
                rVar = (r) map.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    public synchronized Void a() {
        this.a.deleteFile(this.b);
        return null;
    }

    String b() {
        return this.b;
    }

    public synchronized f d() {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = this.a.openFileInput(this.b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            f b = f.b(new JSONObject(new String(bArr, C.UTF8_NAME)));
            fileInputStream.close();
            return b;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public synchronized Void e(f fVar) {
        FileOutputStream openFileOutput = this.a.openFileOutput(this.b, 0);
        try {
            openFileOutput.write(fVar.toString().getBytes(C.UTF8_NAME));
        } finally {
            openFileOutput.close();
        }
        return null;
    }
}
