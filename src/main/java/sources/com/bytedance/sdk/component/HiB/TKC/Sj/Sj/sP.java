package com.bytedance.sdk.component.HiB.TKC.Sj.Sj;

import android.util.Log;
import com.bytedance.sdk.component.HiB.TKC.Sj.Sj.Sj;
import com.bytedance.sdk.component.utils.TEQ;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements com.bytedance.sdk.component.HiB.TKC {
    private long Sj;
    private Sj sP;

    public sP(File file, long j, ExecutorService executorService) {
        this.Sj = j;
        try {
            this.sP = Sj.Sj(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.HiB.TKC
    public InputStream Sj(String str) {
        Sj sj = this.sP;
        if (sj == null) {
            return null;
        }
        try {
            Sj.TKC Sj = sj.Sj(str);
            if (Sj != null) {
                return Sj.Sj(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean Sj(String str, byte[] bArr) {
        Closeable closeable;
        Sj.C0038Sj sP;
        Sj sj = this.sP;
        if (sj == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable2 = null;
        Sj.C0038Sj c0038Sj = null;
        try {
            try {
                sP = sj.sP(str);
            } catch (IOException e) {
                e = e;
                closeable = null;
            }
            try {
                if (sP == null) {
                    Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                    TEQ.Sj(null);
                    return false;
                }
                OutputStream Sj = sP.Sj(0);
                if (Sj != Sj.TKC) {
                    Sj.write(bArr);
                    sP.Sj();
                    this.sP.Sj();
                    TEQ.Sj(Sj);
                    return true;
                }
                Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                TEQ.Sj(Sj);
                return false;
            } catch (IOException e2) {
                e = e2;
                closeable = null;
                c0038Sj = sP;
                try {
                    Log.w("LruCountDiskCache", e.toString());
                    if (c0038Sj != null) {
                        try {
                            c0038Sj.sP();
                        } catch (IOException unused) {
                        }
                    }
                    TEQ.Sj(closeable);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    TEQ.Sj(closeable2);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            TEQ.Sj(closeable2);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public boolean sP(String str) {
        try {
            try {
                Sj.TKC Sj = this.sP.Sj(str);
                boolean z = Sj != null;
                TEQ.Sj(Sj);
                return z;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                TEQ.Sj(null);
                return false;
            }
        } catch (Throwable th) {
            TEQ.Sj(null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable, java.io.InputStream] */
    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: sP, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] Sj(String str) {
        Closeable closeable;
        Closeable closeable2;
        ByteArrayOutputStream byteArrayOutputStream;
        Sj sj = this.sP;
        Closeable closeable3 = null;
        if (sj != null) {
            try {
                if (str != 0) {
                    try {
                        Sj.TKC Sj = sj.Sj((String) str);
                        if (Sj == null) {
                            TEQ.Sj(null);
                            TEQ.Sj(null);
                            return null;
                        }
                        str = Sj.Sj(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = str.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    closeable2 = str;
                                    Log.w("LruCountDiskCache", e.toString());
                                    TEQ.Sj(closeable2);
                                    TEQ.Sj(byteArrayOutputStream);
                                    return null;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                byteArrayOutputStream = null;
                                closeable2 = str;
                                Log.w("LruCountDiskCache", e.toString());
                                TEQ.Sj(closeable2);
                                TEQ.Sj(byteArrayOutputStream);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                closeable = null;
                                closeable3 = str;
                                TEQ.Sj(closeable3);
                                TEQ.Sj(closeable);
                                throw th;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        TEQ.Sj(str);
                        TEQ.Sj(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e3) {
                        e = e3;
                        closeable2 = null;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        TEQ.Sj(closeable3);
                        TEQ.Sj(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }
}
