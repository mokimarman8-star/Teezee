package yb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import xb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private final File a;

    public a(g gVar) {
        this.a = gVar.g("com.crashlytics.settings.json");
    }

    private File a() {
        return this.a;
    }

    public JSONObject b() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        qb.g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File a = a();
                if (a.exists()) {
                    fileInputStream = new FileInputStream(a);
                    try {
                        jSONObject = new JSONObject(CommonUtils.A(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        qb.g.f().e("Failed to fetch cached settings", e);
                        CommonUtils.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    qb.g.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.f(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.f((Closeable) null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.f((Closeable) null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j, JSONObject jSONObject) {
        FileWriter fileWriter;
        qb.g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                CommonUtils.f(fileWriter, "Failed to close settings writer.");
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
                qb.g.f().e("Failed to cache settings", e);
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                CommonUtils.f(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
