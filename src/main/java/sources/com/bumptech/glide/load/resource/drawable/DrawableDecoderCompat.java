package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, int i, @Nullable Resources.Theme theme) {
        return getDrawable(context, context, i, theme);
    }

    public static Drawable getDrawable(Context context, Context context2, int i) {
        return getDrawable(context, context2, i, null);
    }

    private static Drawable getDrawable(Context context, Context context2, int i, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return androidx.core.content.b.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i, theme);
    }

    private static Drawable loadDrawableV4(Context context, int i, @Nullable Resources.Theme theme) {
        return h.e(context.getResources(), i, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i, @Nullable Resources.Theme theme) {
        if (theme != null) {
            Context dVar = new androidx.appcompat.view.d(context, theme);
            dVar.a(theme.getResources().getConfiguration());
            context = dVar;
        }
        return g.a.b(context, i);
    }
}
