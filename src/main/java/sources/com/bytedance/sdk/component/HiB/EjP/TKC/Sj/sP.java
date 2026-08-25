package com.bytedance.sdk.component.HiB.EjP.TKC.Sj;

import android.content.Context;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP implements com.bytedance.sdk.component.HiB.sP, Cloneable {
    private static volatile com.bytedance.sdk.component.HiB.sP uA;
    private File Dq;
    private int EjP;
    private boolean HiB;
    private boolean Jcg;
    private long Sj;
    private int TKC;
    private int sP;
    private boolean vS;

    public sP(int i, int i2, int i3, long j, File file) {
        this(i, i2, i3, j, i2 != 0, j != 0, file);
    }

    public sP(int i, int i2, int i3, long j, boolean z, boolean z2, File file) {
        this.Sj = j;
        this.sP = i;
        this.TKC = i2;
        this.EjP = i3;
        this.HiB = z;
        this.vS = z2;
        this.Dq = file;
        this.Jcg = i3 != 0;
    }

    public static com.bytedance.sdk.component.HiB.sP Sj(File file) {
        long Sj;
        int TKC;
        int EjP;
        file.mkdirs();
        if (uA == null) {
            TKC = 10;
            EjP = 14;
            Sj = 20;
        } else {
            Sj = uA.Sj();
            TKC = uA.TKC();
            EjP = uA.EjP();
        }
        return new sP(0, TKC, EjP, Sj, file);
    }

    public static void Sj(Context context, com.bytedance.sdk.component.HiB.sP sPVar) {
        if (sPVar != null) {
            uA = sPVar;
        } else {
            uA = Sj(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.HiB.sP TEQ() {
        return uA;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public File Dq() {
        return this.Dq;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public int EjP() {
        return this.EjP;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public boolean HiB() {
        return this.HiB;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public boolean Jcg() {
        return this.vS;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public long Sj() {
        return this.Sj;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public int TKC() {
        return this.TKC;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public int sP() {
        return this.sP;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public boolean uA() {
        return true;
    }

    @Override // com.bytedance.sdk.component.HiB.sP
    public boolean vS() {
        return this.Jcg;
    }
}
