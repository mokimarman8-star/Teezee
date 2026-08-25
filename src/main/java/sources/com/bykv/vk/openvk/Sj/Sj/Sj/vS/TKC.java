package com.bykv.vk.openvk.Sj.Sj.Sj.vS;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import c6.b;
import com.bykv.vk.openvk.Sj.Sj.Sj.vS.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC extends HiB implements SurfaceHolder.Callback, a {
    private static final ArrayList c = new ArrayList();
    private WeakReference a;
    private b b;

    public TKC(Context context) {
        super(context);
        a();
    }

    private void a() {
        b bVar = new b(this);
        this.b = bVar;
        c.add(bVar);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public void Sj(c6.a aVar) {
        this.a = new WeakReference(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator it = c.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null && bVar.a() == null) {
                holder.removeCallback(bVar);
                it.remove();
            }
        }
        holder.addCallback(this.b);
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.Sj.vS.a
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(a.InterfaceC0013a interfaceC0013a) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c6.a) this.a.get()).Sj(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c6.a) this.a.get()).Sj(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((c6.a) this.a.get()).sP(surfaceHolder);
    }
}
