package com.transsion.push.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.transsion.lib.push.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends com.transsion.push.notification.b {
    public static final b b = new b(null);

    public static final class a extends com.transsion.push.notification.a {
        private Context z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i, int i2, int i3) {
            super(context, i);
            Intrinsics.h(context, "context");
            this.z = context;
            D(Q(i2));
            if (i3 > 0) {
                C(Q(i3));
            }
        }

        private final RemoteViews Q(int i) {
            return new RemoteViews(this.z.getPackageName(), i);
        }

        @Override // com.transsion.push.notification.a
        public com.transsion.push.notification.a O(long j) {
            long currentTimeMillis = j <= 0 ? System.currentTimeMillis() : j;
            super.O(j);
            try {
                RemoteViews j2 = j();
                if (j2 != null) {
                    j2.setLong(R$id.time, "setTime", currentTimeMillis);
                }
            } catch (Exception e) {
                a.a.e(wf.a.a, "CustomNotification", "setTime error:", e, false, 8, (Object) null);
            }
            return this;
        }

        public final c P() {
            if (r() <= 0) {
                O(0L);
            }
            return new c(this);
        }

        public final a R(int i, Bitmap bitmap) {
            if (bitmap == null) {
                return this;
            }
            RemoteViews i2 = i();
            if (i2 != null) {
                i2.setViewVisibility(i, 0);
            }
            RemoteViews i3 = i();
            if (i3 != null) {
                i3.setImageViewBitmap(i, bitmap);
            }
            return this;
        }

        public final a S(int i, CharSequence charSequence) {
            RemoteViews i2 = i();
            if (i2 != null) {
                i2.setTextViewText(i, charSequence);
            }
            return this;
        }

        public final a T(int i, int i2) {
            if (i() != null) {
                RemoteViews i3 = i();
                Intrinsics.e(i3);
                i3.setViewVisibility(i, i2);
            }
            return this;
        }

        public final a U(int i, String str) {
            B(str);
            W(i, str);
            return this;
        }

        public a V(int i, Bitmap bitmap) {
            if (j() == null) {
                return this;
            }
            if (bitmap == null || bitmap.isRecycled()) {
                RemoteViews j = j();
                if (j != null) {
                    j.setViewVisibility(i, 8);
                }
                return this;
            }
            H(bitmap);
            RemoteViews j2 = j();
            if (j2 != null) {
                j2.setImageViewBitmap(i, bitmap);
            }
            RemoteViews j3 = j();
            if (j3 != null) {
                j3.setViewVisibility(i, 0);
            }
            return this;
        }

        public final a W(int i, String str) {
            RemoteViews j = j();
            if (j != null) {
                j.setTextViewText(i, str);
            }
            return this;
        }

        public final a X(int i, int i2) {
            if (j() != null) {
                RemoteViews j = j();
                Intrinsics.e(j);
                j.setViewVisibility(i, i2);
            }
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar) {
        super(aVar);
        Intrinsics.h(aVar, "builder");
    }
}
