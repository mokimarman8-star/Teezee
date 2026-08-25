package com.transsion.mbwidget.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.transsion.mbwidget.R$mipmap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.y0;
import ni.g;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class BitmapUtils {
    public static final BitmapUtils a = new BitmapUtils();

    private BitmapUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:17:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(Context context, String str, int i, Continuation continuation) {
        BitmapUtils$loadImageWithRetry$1 bitmapUtils$loadImageWithRetry$1;
        int i2;
        Context context2;
        int i3;
        int i4;
        String str2;
        BitmapUtils$loadImageWithRetry$1 bitmapUtils$loadImageWithRetry$12;
        int i5;
        Exception e;
        if (continuation instanceof BitmapUtils$loadImageWithRetry$1) {
            bitmapUtils$loadImageWithRetry$1 = (BitmapUtils$loadImageWithRetry$1) continuation;
            int i6 = bitmapUtils$loadImageWithRetry$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                bitmapUtils$loadImageWithRetry$1.label = i6 - Integer.MIN_VALUE;
                Object obj = bitmapUtils$loadImageWithRetry$1.result;
                Object f = IntrinsicsKt.f();
                i2 = bitmapUtils$loadImageWithRetry$1.label;
                if (i2 == 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = bitmapUtils$loadImageWithRetry$1.I$1;
                    int i7 = bitmapUtils$loadImageWithRetry$1.I$0;
                    str2 = (String) bitmapUtils$loadImageWithRetry$1.L$1;
                    Context context3 = (Context) bitmapUtils$loadImageWithRetry$1.L$0;
                    try {
                        ResultKt.b(obj);
                    } catch (Exception e2) {
                        e = e2;
                        bitmapUtils$loadImageWithRetry$12 = bitmapUtils$loadImageWithRetry$1;
                        i5 = i7;
                        context2 = context3;
                        BitmapUtils$loadImageWithRetry$1 bitmapUtils$loadImageWithRetry$13 = bitmapUtils$loadImageWithRetry$12;
                        i3++;
                        wf.a.a.c("DeskWidget_", "load Bitmap Failed-attempt-" + i3 + " :" + str2, true);
                        if (i3 == i5) {
                        }
                        i4 = i5;
                        bitmapUtils$loadImageWithRetry$1 = bitmapUtils$loadImageWithRetry$13;
                        if (i3 >= i4) {
                        }
                    }
                }
                ResultKt.b(obj);
                context2 = context;
                i3 = 0;
                i4 = i;
                str2 = str;
                if (i3 >= i4) {
                    return null;
                }
                try {
                } catch (Exception e3) {
                    bitmapUtils$loadImageWithRetry$12 = bitmapUtils$loadImageWithRetry$1;
                    i5 = i4;
                    e = e3;
                    BitmapUtils$loadImageWithRetry$1 bitmapUtils$loadImageWithRetry$132 = bitmapUtils$loadImageWithRetry$12;
                    i3++;
                    wf.a.a.c("DeskWidget_", "load Bitmap Failed-attempt-" + i3 + " :" + str2, true);
                    if (i3 == i5) {
                        e.printStackTrace();
                    }
                    i4 = i5;
                    bitmapUtils$loadImageWithRetry$1 = bitmapUtils$loadImageWithRetry$132;
                    if (i3 >= i4) {
                    }
                }
                i0 b = y0.b();
                BitmapUtils$loadImageWithRetry$2 bitmapUtils$loadImageWithRetry$2 = new BitmapUtils$loadImageWithRetry$2(context2, str2, null);
                bitmapUtils$loadImageWithRetry$1.L$0 = context2;
                bitmapUtils$loadImageWithRetry$1.L$1 = str2;
                bitmapUtils$loadImageWithRetry$1.I$0 = i4;
                bitmapUtils$loadImageWithRetry$1.I$1 = i3;
                bitmapUtils$loadImageWithRetry$1.label = 1;
                obj = i.g(b, bitmapUtils$loadImageWithRetry$2, bitmapUtils$loadImageWithRetry$1);
                return obj == f ? f : obj;
            }
        }
        bitmapUtils$loadImageWithRetry$1 = new BitmapUtils$loadImageWithRetry$1(this, continuation);
        Object obj2 = bitmapUtils$loadImageWithRetry$1.result;
        Object f2 = IntrinsicsKt.f();
        i2 = bitmapUtils$loadImageWithRetry$1.label;
        if (i2 == 0) {
        }
    }

    static /* synthetic */ Object f(BitmapUtils bitmapUtils, Context context, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 2;
        }
        return bitmapUtils.e(context, str, i, continuation);
    }

    public final Bitmap b(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(Utils.a().getResources(), i);
        Intrinsics.g(decodeResource, "decodeResource(...)");
        return decodeResource;
    }

    public final Bitmap c() {
        return b(R$mipmap.ic_default_cover);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(Context context, String str, int i, Continuation continuation) {
        BitmapUtils$loadBitmap$1 bitmapUtils$loadBitmap$1;
        int i2;
        String a2;
        Bitmap bitmap;
        Bitmap.Config config;
        if (continuation instanceof BitmapUtils$loadBitmap$1) {
            bitmapUtils$loadBitmap$1 = (BitmapUtils$loadBitmap$1) continuation;
            int i3 = bitmapUtils$loadBitmap$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bitmapUtils$loadBitmap$1.label = i3 - Integer.MIN_VALUE;
                Object obj = bitmapUtils$loadBitmap$1.result;
                Object f = IntrinsicsKt.f();
                i2 = bitmapUtils$loadBitmap$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj);
                    if (str == null || str.length() == 0) {
                        return null;
                    }
                    n0 a3 = o0.a(y0.b());
                    a2 = g.a.a(str, i <= 0 ? y.e() : RangesKt.h(i, y.e()), (r18 & 4) != 0, (r18 & 8) != 0, (r18 & 16) != 0 ? 0 : 0, (r18 & 32) != 0 ? false : false, (r18 & 64) != 0 ? 0 : 0);
                    r0 b = i.b(a3, (CoroutineContext) null, (CoroutineStart) null, new BitmapUtils$loadBitmap$bitmap$1(context, a2, null), 3, (Object) null);
                    bitmapUtils$loadBitmap$1.label = 1;
                    obj = b.f(bitmapUtils$loadBitmap$1);
                    if (obj == f) {
                        return f;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                bitmap = (Bitmap) obj;
                if (bitmap != null || bitmap.isRecycled() || (config = bitmap.getConfig()) == null) {
                    return null;
                }
                return bitmap.copy(config, true);
            }
        }
        bitmapUtils$loadBitmap$1 = new BitmapUtils$loadBitmap$1(this, continuation);
        Object obj2 = bitmapUtils$loadBitmap$1.result;
        Object f2 = IntrinsicsKt.f();
        i2 = bitmapUtils$loadBitmap$1.label;
        if (i2 != 0) {
        }
        bitmap = (Bitmap) obj2;
        return bitmap != null ? null : null;
    }
}
