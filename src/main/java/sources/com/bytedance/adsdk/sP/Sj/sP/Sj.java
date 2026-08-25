package com.bytedance.adsdk.sP.Sj.sP;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class Sj<K, A> {
    private final TKC<K> HiB;
    protected com.bytedance.adsdk.sP.Jcg.sP<A> TKC;
    final List<InterfaceC0021Sj> Sj = new ArrayList(1);
    private boolean EjP = false;
    protected float sP = 0.0f;
    private A vS = null;
    private float Jcg = -1.0f;
    private float Dq = -1.0f;

    private static final class EjP<T> implements TKC<T> {
        private final List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> Sj;
        private com.bytedance.adsdk.sP.Jcg.Sj<T> TKC = null;
        private float EjP = -1.0f;
        private com.bytedance.adsdk.sP.Jcg.Sj<T> sP = TKC(0.0f);

        EjP(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
            this.Sj = list;
        }

        private com.bytedance.adsdk.sP.Jcg.Sj<T> TKC(float f) {
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj = this.Sj.get(r0.size() - 1);
            if (f >= sj.TKC()) {
                return sj;
            }
            for (int size = this.Sj.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.sP.Jcg.Sj<T> sj2 = this.Sj.get(size);
                if (this.sP != sj2 && sj2.Sj(f)) {
                    return sj2;
                }
            }
            return this.Sj.get(0);
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return this.Sj.get(r0.size() - 1).EjP();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f) {
            if (this.sP.Sj(f)) {
                return !this.sP.HiB();
            }
            this.sP = TKC(f);
            return true;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return this.Sj.get(0).TKC();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            return this.sP;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f) {
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj = this.TKC;
            com.bytedance.adsdk.sP.Jcg.Sj<T> sj2 = this.sP;
            if (sj == sj2 && this.EjP == f) {
                return true;
            }
            this.TKC = sj2;
            this.EjP = f;
            return false;
        }
    }

    private static final class HiB<T> implements TKC<T> {
        private final com.bytedance.adsdk.sP.Jcg.Sj<T> Sj;
        private float sP = -1.0f;

        HiB(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
            this.Sj = list.get(0);
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return this.Sj.EjP();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f) {
            return !this.Sj.HiB();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return this.Sj.TKC();
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            return this.Sj;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f) {
            if (this.sP == f) {
                return true;
            }
            this.sP = f;
            return false;
        }
    }

    /* renamed from: com.bytedance.adsdk.sP.Sj.sP.Sj$Sj, reason: collision with other inner class name */
    public interface InterfaceC0021Sj {
        void Sj();
    }

    private interface TKC<T> {
        float EjP();

        boolean Sj();

        boolean Sj(float f);

        float TKC();

        com.bytedance.adsdk.sP.Jcg.Sj<T> sP();

        boolean sP(float f);
    }

    private static final class sP<T> implements TKC<T> {
        private sP() {
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float EjP() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj() {
            return true;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean Sj(float f) {
            return false;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public float TKC() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public com.bytedance.adsdk.sP.Jcg.Sj<T> sP() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.TKC
        public boolean sP(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    Sj(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<K>> list) {
        this.HiB = Sj(list);
    }

    private static <T> TKC<T> Sj(List<? extends com.bytedance.adsdk.sP.Jcg.Sj<T>> list) {
        return list.isEmpty() ? new sP() : list.size() == 1 ? new HiB(list) : new EjP(list);
    }

    private float uA() {
        if (this.Jcg == -1.0f) {
            this.Jcg = this.HiB.TKC();
        }
        return this.Jcg;
    }

    public float Dq() {
        return this.sP;
    }

    float EjP() {
        if (this.EjP) {
            return 0.0f;
        }
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        if (TKC2.HiB()) {
            return 0.0f;
        }
        return (this.sP - TKC2.TKC()) / (TKC2.EjP() - TKC2.TKC());
    }

    protected float HiB() {
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        if (TKC2 == null || TKC2.HiB()) {
            return 0.0f;
        }
        return TKC2.TKC.getInterpolation(EjP());
    }

    public A Jcg() {
        float EjP2 = EjP();
        if (this.TKC == null && this.HiB.sP(EjP2)) {
            return this.vS;
        }
        com.bytedance.adsdk.sP.Jcg.Sj<K> TKC2 = TKC();
        Interpolator interpolator = TKC2.EjP;
        A Sj = (interpolator == null || TKC2.HiB == null) ? Sj(TKC2, HiB()) : Sj(TKC2, EjP2, interpolator.getInterpolation(EjP2), TKC2.HiB.getInterpolation(EjP2));
        this.vS = Sj;
        return Sj;
    }

    abstract A Sj(com.bytedance.adsdk.sP.Jcg.Sj<K> sj, float f);

    protected A Sj(com.bytedance.adsdk.sP.Jcg.Sj<K> sj, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void Sj() {
        this.EjP = true;
    }

    public void Sj(float f) {
        if (this.HiB.Sj()) {
            return;
        }
        if (f < uA()) {
            f = uA();
        } else if (f > vS()) {
            f = vS();
        }
        if (f == this.sP) {
            return;
        }
        this.sP = f;
        if (this.HiB.Sj(f)) {
            sP();
        }
    }

    public void Sj(InterfaceC0021Sj interfaceC0021Sj) {
        this.Sj.add(interfaceC0021Sj);
    }

    protected com.bytedance.adsdk.sP.Jcg.Sj<K> TKC() {
        com.bytedance.adsdk.sP.HiB.Sj("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.sP.Jcg.Sj<K> sP2 = this.HiB.sP();
        com.bytedance.adsdk.sP.HiB.sP("BaseKeyframeAnimation#getCurrentKeyframe");
        return sP2;
    }

    public void sP() {
        for (int i = 0; i < this.Sj.size(); i++) {
            this.Sj.get(i).Sj();
        }
    }

    float vS() {
        if (this.Dq == -1.0f) {
            this.Dq = this.HiB.EjP();
        }
        return this.Dq;
    }
}
