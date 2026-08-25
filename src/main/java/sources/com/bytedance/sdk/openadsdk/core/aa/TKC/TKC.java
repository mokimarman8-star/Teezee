package com.bytedance.sdk.openadsdk.core.aa.TKC;

import com.bytedance.sdk.component.utils.Jcg;
import java.io.File;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC extends com.bytedance.sdk.openadsdk.sP.sP {
    public TKC(int i, int i2) {
        super(i, i2);
    }

    public TKC(int i, int i2, boolean z) {
        super(i, i2);
        this.Sj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.sP.sP, com.bytedance.sdk.openadsdk.sP.Sj
    protected void Sj(List<File> list) {
        int size = list.size();
        if (Sj(0L, size)) {
            return;
        }
        for (File file : list) {
            Jcg.TKC(file);
            size--;
            if (Sj(file, 0L, size)) {
                return;
            }
        }
    }
}
