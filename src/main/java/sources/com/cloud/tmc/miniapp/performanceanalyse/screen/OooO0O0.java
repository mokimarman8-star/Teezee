package com.cloud.tmc.miniapp.performanceanalyse.screen;

import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.render.IRender;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public IRender OooO00o;
    public int OooO0O0;
    public IEventSubscriber OooO0OO;
    public IEventSubscriber OooO0Oo;
    public OooOO0 OooO0o;
    public int OooO0o0;
    public boolean OooO0oO;
    public boolean OooO0oo;

    public OooO0O0() {
        this(null, 0, null, null, 0, null, false, false, 255);
    }

    public OooO0O0(IRender iRender, int i, IEventSubscriber iEventSubscriber, IEventSubscriber iEventSubscriber2, int i2, OooOO0 oooOO0, boolean z, boolean z2) {
        this.OooO00o = iRender;
        this.OooO0O0 = i;
        this.OooO0OO = iEventSubscriber;
        this.OooO0Oo = iEventSubscriber2;
        this.OooO0o0 = i2;
        this.OooO0o = oooOO0;
        this.OooO0oO = z;
        this.OooO0oo = z2;
    }

    public /* synthetic */ OooO0O0(IRender iRender, int i, IEventSubscriber iEventSubscriber, IEventSubscriber iEventSubscriber2, int i2, OooOO0 oooOO0, boolean z, boolean z2, int i3) {
        this(null, (i3 & 2) != 0 ? 0 : i, null, null, (i3 & 16) != 0 ? 0 : i2, null, (i3 & 64) != 0 ? false : z, (i3 & 128) == 0 ? z2 : false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO0O0)) {
            return false;
        }
        OooO0O0 oooO0O0 = (OooO0O0) obj;
        return Intrinsics.c(this.OooO00o, oooO0O0.OooO00o) && this.OooO0O0 == oooO0O0.OooO0O0 && Intrinsics.c(this.OooO0OO, oooO0O0.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO0O0.OooO0Oo) && this.OooO0o0 == oooO0O0.OooO0o0 && Intrinsics.c(this.OooO0o, oooO0O0.OooO0o) && this.OooO0oO == oooO0O0.OooO0oO && this.OooO0oo == oooO0O0.OooO0oo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IRender iRender = this.OooO00o;
        int hashCode = (this.OooO0O0 + ((iRender == null ? 0 : iRender.hashCode()) * 31)) * 31;
        IEventSubscriber iEventSubscriber = this.OooO0OO;
        int hashCode2 = (hashCode + (iEventSubscriber == null ? 0 : iEventSubscriber.hashCode())) * 31;
        IEventSubscriber iEventSubscriber2 = this.OooO0Oo;
        int hashCode3 = (this.OooO0o0 + ((hashCode2 + (iEventSubscriber2 == null ? 0 : iEventSubscriber2.hashCode())) * 31)) * 31;
        OooOO0 oooOO0 = this.OooO0o;
        int hashCode4 = (hashCode3 + (oooOO0 != null ? oooOO0.hashCode() : 0)) * 31;
        boolean z = this.OooO0oO;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z2 = this.OooO0oo;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "PageData(render=" + this.OooO00o + ", renderConnectionStatus=" + this.OooO0O0 + ", renderSubscriber=" + this.OooO0OO + ", checkWhiteScreenSubscriber=" + this.OooO0Oo + ", renderStatus=" + this.OooO0o0 + ", timeCountTask=" + this.OooO0o + ", checkFinished=" + this.OooO0oO + ", onPageReady=" + this.OooO0oo + ")";
    }
}
