package androidx.compose.ui.graphics.layer;

import android.view.RenderNode;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f3597a = new p0();

    private p0() {
    }

    public final int a(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public final int b(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public final void c(RenderNode renderNode, int i5) {
        renderNode.setAmbientShadowColor(i5);
    }

    public final void d(RenderNode renderNode, int i5) {
        renderNode.setSpotShadowColor(i5);
    }
}
