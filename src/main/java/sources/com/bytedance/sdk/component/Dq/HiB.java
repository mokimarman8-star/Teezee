package com.bytedance.sdk.component.Dq;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB {
    private static TEQ Sj = new TEQ() { // from class: com.bytedance.sdk.component.Dq.HiB.1
        @Override // com.bytedance.sdk.component.Dq.TEQ
        public uA createThreadFactory(int i, String str) {
            return new uA(i, str);
        }
    };

    public static TEQ Sj() {
        return Sj;
    }

    public static void Sj(TEQ teq) {
        Sj = teq;
    }
}
