package com.bytedance.sdk.component.HiB.EjP.TKC.Sj.Sj;

import com.bytedance.sdk.component.HiB.TKC;
import com.bytedance.sdk.component.utils.TEQ;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements TKC {
    private int Sj;
    private Sj sP;

    public sP(File file, long j) {
        int i = (int) j;
        this.Sj = i;
        this.sP = Sj.Sj(i, file);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.HiB.TKC
    public InputStream Sj(String str) {
        Sj sj = this.sP;
        if (sj == null) {
            return null;
        }
        return sj.Sj(str);
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    public boolean Sj(String str, byte[] bArr) {
        Sj sj = this.sP;
        if (sj == null || bArr == null || str == null) {
            return false;
        }
        return sj.Sj(str, bArr);
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public boolean sP(String str) {
        try {
            InputStream Sj = this.sP.Sj(str);
            boolean z = Sj != null;
            TEQ.Sj(Sj);
            return z;
        } catch (Throwable th) {
            try {
                th.getMessage();
                return false;
            } finally {
                TEQ.Sj(null);
            }
        }
    }

    @Override // com.bytedance.sdk.component.HiB.Sj
    /* renamed from: sP, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] Sj(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        Sj sj = this.sP;
        if (sj != null && str != null) {
            try {
                inputStream = sj.Sj(str);
                if (inputStream != null) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            th = th2;
                            TEQ.Sj(inputStream);
                            TEQ.Sj(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        TEQ.Sj(inputStream);
                        TEQ.Sj(byteArrayOutputStream);
                        throw th;
                    }
                } else {
                    byteArrayOutputStream = null;
                }
                if (byteArrayOutputStream != null) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    TEQ.Sj(inputStream);
                    TEQ.Sj(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException unused3) {
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStream = null;
            }
            TEQ.Sj(inputStream);
            TEQ.Sj(byteArrayOutputStream);
        }
        return null;
    }
}
