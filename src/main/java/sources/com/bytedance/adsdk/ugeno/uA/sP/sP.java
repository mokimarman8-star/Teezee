package com.bytedance.adsdk.ugeno.uA.sP;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.sP.Sj;
import com.cloud.tmc.integration.constants.IntegrationConstants;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class sP extends com.bytedance.adsdk.ugeno.sP.Sj<com.bytedance.adsdk.ugeno.uA.sP.Sj> {
    private com.bytedance.adsdk.ugeno.uA.sP.Sj AVc;

    public static class Sj extends Sj.C0030Sj {
        protected int wE;

        public Sj(com.bytedance.adsdk.ugeno.sP.Sj sj) {
            super(sj);
            this.wE = -1;
        }

        private int Sj(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length <= 0) {
                return -1;
            }
            int i = 0;
            for (String str2 : split) {
                i |= sP(str2);
            }
            return i;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int sP(String str) {
            char c;
            str.hashCode();
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals(IntegrationConstants.TAB_BAR_POSITION_DEFAULT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -348726240:
                    if (str.equals("center_vertical")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals(IntegrationConstants.TAB_BAR_POSITION_TOP)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1063616078:
                    if (str.equals("center_horizontal")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 80;
                case 1:
                    return 17;
                case 2:
                    return 16;
                case 3:
                    return 48;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0030Sj
        public void Sj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.Sj(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.wE = Sj(str2);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.sP.Sj.C0030Sj
        /* renamed from: sP, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams Sj() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.Sj, (int) this.sP);
            layoutParams.leftMargin = (int) this.vS;
            layoutParams.rightMargin = (int) this.Jcg;
            layoutParams.topMargin = (int) this.Dq;
            layoutParams.bottomMargin = (int) this.uA;
            layoutParams.gravity = this.wE;
            return layoutParams;
        }
    }

    public sP(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj
    public Sj.C0030Sj TEQ() {
        return new Sj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.sP.TKC
    /* renamed from: TKC, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ugeno.uA.sP.Sj Sj() {
        com.bytedance.adsdk.ugeno.uA.sP.Sj sj = new com.bytedance.adsdk.ugeno.uA.sP.Sj(this.sP);
        this.AVc = sj;
        sj.Sj(this);
        return this.AVc;
    }

    @Override // com.bytedance.adsdk.ugeno.sP.Sj, com.bytedance.adsdk.ugeno.sP.TKC
    public void sP() {
        this.AVc.setEventMap(this.QZ);
        super.sP();
    }
}
