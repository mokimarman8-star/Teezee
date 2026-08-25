package com.cloud.h5update.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class j {
    public static final j a = new j();
    public static SharedPreferences b;
    public static SharedPreferences.Editor c;

    private j() {
    }

    private final SharedPreferences l() {
        return e();
    }

    public final SharedPreferences.Editor a() {
        SharedPreferences.Editor editor = c;
        if (editor != null) {
            return editor;
        }
        Intrinsics.y("editor");
        return null;
    }

    public final int b(String str, int i) {
        Intrinsics.h(str, "key");
        return l().getInt(str, i);
    }

    public final long c(String str, long j) {
        Intrinsics.h(str, "key");
        return l().getLong(str, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final Object d(String str, Class cls) {
        String string;
        ObjectInputStream objectInputStream;
        if (!l().contains(str) || (string = l().getString(str, null)) == null) {
            return null;
        }
        ObjectInputStream decode = Base64.decode(string, 0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decode);
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                    objectInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return readObject;
            } catch (StreamCorruptedException e3) {
                e = e3;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            } catch (ClassNotFoundException e8) {
                e = e8;
                e.printStackTrace();
                byteArrayInputStream.close();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return null;
            }
        } catch (StreamCorruptedException e9) {
            e = e9;
            objectInputStream = null;
        } catch (IOException e10) {
            e = e10;
            objectInputStream = null;
        } catch (ClassNotFoundException e11) {
            e = e11;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            decode = 0;
            try {
                byteArrayInputStream.close();
                if (decode != 0) {
                    decode.close();
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            throw th;
        }
    }

    public final SharedPreferences e() {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.y("sharedPreferences");
        return null;
    }

    public final void f(Context context) {
        Intrinsics.h(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("tupdate_sdk", 0);
        Intrinsics.g(sharedPreferences, "context.getSharedPrefere…REFERENCES, MODE_PRIVATE)");
        k(sharedPreferences);
        SharedPreferences.Editor edit = e().edit();
        Intrinsics.g(edit, "sharedPreferences.edit()");
        j(edit);
    }

    public final void g(String str, long j) {
        Intrinsics.h(str, "key");
        SharedPreferences.Editor edit = l().edit();
        Intrinsics.d(edit, "editor");
        edit.putLong(str, j);
        edit.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final void h(String str, Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ?? r1 = 0;
        ObjectOutputStream objectOutputStream2 = null;
        r1 = 0;
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 0);
            Intrinsics.g(encode, "encode(baos.toByteArray(), Base64.DEFAULT)");
            String str2 = new String(encode, Charsets.b);
            a().putString(str, str2);
            a().commit();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            r1 = str2;
        } catch (IOException e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            byteArrayOutputStream.close();
            r1 = objectOutputStream2;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
                r1 = objectOutputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = objectOutputStream;
            try {
                byteArrayOutputStream.close();
                if (r1 != 0) {
                    r1.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public final void i(String str) {
        Intrinsics.h(str, "key");
        a().remove(str);
        a().apply();
    }

    public final void j(SharedPreferences.Editor editor) {
        Intrinsics.h(editor, "<set-?>");
        c = editor;
    }

    public final void k(SharedPreferences sharedPreferences) {
        Intrinsics.h(sharedPreferences, "<set-?>");
        b = sharedPreferences;
    }
}
