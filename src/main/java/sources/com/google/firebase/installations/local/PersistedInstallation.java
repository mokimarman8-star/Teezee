package com.google.firebase.installations.local;

import com.google.firebase.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class PersistedInstallation {
    private File a;
    private final f b;

    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(f fVar) {
        this.b = fVar;
    }

    private File a() {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = new File(this.b.k().getFilesDir(), "PersistedInstallation." + this.b.o() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    private JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[ASTNode.BLOCK_UNTIL];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, ASTNode.BLOCK_UNTIL);
                    if (read < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public b b(b bVar) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.d());
            jSONObject.put("Status", bVar.g().ordinal());
            jSONObject.put("AuthToken", bVar.b());
            jSONObject.put("RefreshToken", bVar.f());
            jSONObject.put("TokenCreationEpochInSecs", bVar.h());
            jSONObject.put("ExpiresInSecs", bVar.c());
            jSONObject.put("FisError", bVar.e());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.b.k().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (createTempFile.renameTo(a())) {
            return bVar;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    public b d() {
        JSONObject c = c();
        String optString = c.optString("Fid", null);
        int optInt = c.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = c.optString("AuthToken", null);
        String optString3 = c.optString("RefreshToken", null);
        long optLong = c.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = c.optLong("ExpiresInSecs", 0L);
        return b.a().d(optString).g(RegistrationStatus.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(c.optString("FisError", null)).a();
    }
}
