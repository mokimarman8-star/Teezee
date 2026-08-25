package com.bytedance.adsdk.sP.TKC.sP;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class uA implements TKC {
    private final String Sj;
    private final boolean TKC;
    private final Sj sP;

    public enum Sj {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static Sj Sj(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public uA(String str, Sj sj, boolean z) {
        this.Sj = str;
        this.sP = sj;
        this.TKC = z;
    }

    @Override // com.bytedance.adsdk.sP.TKC.sP.TKC
    public com.bytedance.adsdk.sP.Sj.Sj.TKC Sj(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.Jcg jcg, com.bytedance.adsdk.sP.TKC.TKC.Sj sj) {
        return new com.bytedance.adsdk.sP.Sj.Sj.aa(this);
    }

    public String Sj() {
        return this.Sj;
    }

    public boolean TKC() {
        return this.TKC;
    }

    public Sj sP() {
        return this.sP;
    }

    public String toString() {
        return "MergePaths{mode=" + this.sP + '}';
    }
}
