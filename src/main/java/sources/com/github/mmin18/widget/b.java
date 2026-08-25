package com.github.mmin18.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.ScriptIntrinsicBlur;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b implements c {
    static Boolean e;
    private RenderScript a;
    private ScriptIntrinsicBlur b;
    private Allocation c;
    private Allocation d;

    static boolean c(Context context) {
        if (e == null && context != null) {
            e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return e == Boolean.TRUE;
    }

    @Override // com.github.mmin18.widget.c
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.c.copyFrom(bitmap);
        this.b.setInput(this.c);
        this.b.forEach(this.d);
        this.d.copyTo(bitmap2);
    }

    @Override // com.github.mmin18.widget.c
    public boolean b(Context context, Bitmap bitmap, float f) {
        if (this.a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.a = create;
                this.b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException e2) {
                if (c(context)) {
                    throw e2;
                }
                release();
                return false;
            }
        }
        this.b.setRadius(f);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.c = createFromBitmap;
        this.d = Allocation.createTyped(this.a, createFromBitmap.getType());
        return true;
    }

    @Override // com.github.mmin18.widget.c
    public void release() {
        Allocation allocation = this.c;
        if (allocation != null) {
            allocation.destroy();
            this.c = null;
        }
        Allocation allocation2 = this.d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.b = null;
        }
        RenderScript renderScript = this.a;
        if (renderScript != null) {
            renderScript.destroy();
            this.a = null;
        }
    }
}
