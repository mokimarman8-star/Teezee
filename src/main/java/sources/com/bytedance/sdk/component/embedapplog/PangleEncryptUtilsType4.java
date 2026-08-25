package com.bytedance.sdk.component.embedapplog;

import android.util.Log;
import android.util.Pair;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class PangleEncryptUtilsType4 {
    PangleEncryptUtilsType4() {
    }

    static Pair<Integer, String> decrypt(String str) {
        try {
            Pair<Integer, String> cypher4Decrypt = PglCryptUtils.getInstance().cypher4Decrypt(str);
            return new Pair<>(Integer.valueOf(getCryptFailedReason(((Integer) cypher4Decrypt.first).intValue())), cypher4Decrypt.second);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "decrypt exception " + th.getMessage());
            return new Pair<>(2, null);
        }
    }

    static JSONObject encrypt(JSONObject jSONObject, IDefaultEncrypt iDefaultEncrypt) {
        Pair<Integer, JSONObject> pair;
        Object obj;
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(jSONObject);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            pair = null;
        }
        if (pair != null && ((Integer) pair.first).intValue() == 0 && (obj = pair.second) != null) {
            return (JSONObject) obj;
        }
        if (iDefaultEncrypt == null) {
            return null;
        }
        try {
            return iDefaultEncrypt.encrypt(jSONObject, pair == null ? 0 : getCryptFailedReason(((Integer) pair.first).intValue()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static JSONObject encryptType4WithNoWrapBase64(JSONObject jSONObject, IDefaultEncrypt iDefaultEncrypt) {
        Pair<Integer, String> cypher4EncryptWithNoWrapBase64;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        if (jSONObject != null) {
            try {
                cypher4EncryptWithNoWrapBase64 = PglCryptUtils.getInstance().cypher4EncryptWithNoWrapBase64(jSONObject.toString());
            } catch (Throwable th) {
                Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            }
            if (cypher4EncryptWithNoWrapBase64 != null || ((Integer) cypher4EncryptWithNoWrapBase64.first).intValue() != 0 || cypher4EncryptWithNoWrapBase64.second == null) {
                if (iDefaultEncrypt != null) {
                    return null;
                }
                try {
                    return iDefaultEncrypt.encrypt(jSONObject, cypher4EncryptWithNoWrapBase64 == null ? 0 : getCryptFailedReason(((Integer) cypher4EncryptWithNoWrapBase64.first).intValue()));
                } catch (Exception unused) {
                    return null;
                }
            }
            try {
                jSONObject2 = new JSONObject();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, cypher4EncryptWithNoWrapBase64.second);
                jSONObject2.put("cypher", 4);
                return jSONObject2;
            } catch (Throwable th3) {
                th = th3;
                jSONObject3 = jSONObject2;
                Log.e("pangle-encrypt", "encrypt json exception " + th.getMessage());
                return jSONObject3;
            }
        }
        cypher4EncryptWithNoWrapBase64 = null;
        if (cypher4EncryptWithNoWrapBase64 != null) {
        }
        if (iDefaultEncrypt != null) {
        }
    }

    static Pair<Integer, byte[]> encryptWithoutBase64(byte[] bArr) {
        Pair<Integer, byte[]> pair;
        Object obj;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            pair = PglCryptUtils.getInstance().cypher4Encrypt(bArr);
        } catch (Throwable th) {
            Log.e("pangle-encrypt", "encrypt exception " + th.getMessage());
            pair = null;
        }
        int i = 0;
        if (pair != null && ((Integer) pair.first).intValue() == 0 && (obj = pair.second) != null && ((byte[]) obj).length > 0) {
            bArr2 = (byte[]) obj;
        } else if (pair != null) {
            i = getCryptFailedReason(((Integer) pair.first).intValue());
        }
        return new Pair<>(Integer.valueOf(i), bArr2);
    }

    private static int getCryptFailedReason(int i) {
        switch (i) {
            case PglCryptUtils.LOAD_SO_FAILED /* 501 */:
                return 6;
            case PglCryptUtils.INPUT_INVALID /* 502 */:
                return 4;
            case PglCryptUtils.COMPRESS_FAILED /* 503 */:
                return 1;
            case PglCryptUtils.BASE64_FAILED /* 504 */:
                return 3;
            case PglCryptUtils.ENCRYPT_FAILED /* 505 */:
            case PglCryptUtils.DECRYPT_FAILED /* 506 */:
                return 2;
            default:
                return 0;
        }
    }
}
