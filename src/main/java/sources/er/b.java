package er;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.image.blurhash.BlurHash;
import er.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final a a = new a(null);
    private static int b = y.e() / 3;
    private static int c = y.b() / 2;
    private static int d = y.c();
    private static final BlurHash e;
    private static final DrawableTransitionOptions f;

    public static final class a {

        /* renamed from: er.b$a$a, reason: collision with other inner class name */
        public static final class C0067a implements RequestListener {
            final /* synthetic */ long a;
            final /* synthetic */ Function3 b;

            C0067a(long j, Function3 function3) {
                this.a = j;
                this.b = function3;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
                Intrinsics.h(drawable, "resource");
                Intrinsics.h(obj, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 != null) {
                }
                return false;
            }

            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        /* renamed from: er.b$a$b, reason: collision with other inner class name */
        public static final class C0068b implements RequestListener {
            final /* synthetic */ long a;
            final /* synthetic */ Function3 b;

            C0068b(long j, Function3 function3) {
                this.a = j;
                this.b = function3;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
                Intrinsics.h(drawable, "resource");
                Intrinsics.h(obj, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 != null) {
                }
                return false;
            }

            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        public static final class c implements RequestListener {
            final /* synthetic */ long a;
            final /* synthetic */ Function3 b;

            c(long j, Function3 function3) {
                this.a = j;
                this.b = function3;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
                Intrinsics.h(drawable, "resource");
                Intrinsics.h(obj, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 != null) {
                }
                return false;
            }

            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.a;
                Function3 function3 = this.b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x013c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void f(Context context, final ImageView imageView, String str, int i, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5, Priority priority, Function3 function3) {
            String str3;
            String a;
            String str4;
            String d;
            long currentTimeMillis;
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            er.c cVar = er.c.a;
            int c2 = cVar.c(str);
            if (1 <= c2 && c2 < i3 + 1) {
                a = cVar.a(str, c2, (r21 & 4) != 0 ? true : z, (r21 & 8) != 0, (r21 & 16) != 0 ? 0 : 0, (r21 & 32) != 0 ? false : false, (r21 & 64) != 0 ? false : z6, (r21 & 128) != 0 ? 25 : i5);
            } else {
                if (str2.length() != 0 || i3 <= 96 || c2 > i3) {
                    str3 = str2;
                    str4 = str3;
                    d = cVar.d(str, i3, (r23 & 4) != 0 ? true : z, (r23 & 8) != 0 ? true : z2, (r23 & 16) != 0 ? 0 : i4, (r23 & 32) != 0 ? false : z5, (r23 & 64) != 0 ? false : false, (r23 & 128) != 0 ? false : z6, (r23 & 256) != 0 ? 25 : i5);
                    currentTimeMillis = System.currentTimeMillis();
                    if (!StringsKt.W(str4, "http", false, 2, (Object) null) || StringsKt.W(str4, "data:image", false, 2, (Object) null)) {
                        RequestBuilder load = !z3 ? (RequestBuilder) Glide.with(context).load(str4).optionalCenterCrop() : Glide.with(context).load(str4);
                        Intrinsics.e(load);
                        Glide.with(context).load(d).thumbnail(load).listener(new C0067a(currentTimeMillis, function3)).transition(b.f).apply(o(i, i2, !z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    } else if (str4.length() >= 6) {
                        RequestBuilder load2 = Glide.with(context).load(d);
                        Intrinsics.g(load2, "load(...)");
                        com.transsion.shorttv.base.image.blurhash.c.b(load2, str4, 20, 20, b.e, new Function1() { // from class: er.a
                            public final Object invoke(Object obj) {
                                Unit h;
                                h = b.a.h(imageView, (RequestBuilder) obj);
                                return h;
                            }
                        });
                        load2.transition(b.f).listener(new C0068b(currentTimeMillis, function3)).apply(o(0, i2, z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    } else {
                        Glide.with(context).load(d).transition(b.f).listener(new c(currentTimeMillis, function3)).apply(o(i, i2, z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    }
                    a.a.f(wf.a.a, "ImageHelper", "load " + i3 + " use " + d + " with small " + str4, false, 4, (Object) null);
                }
                a = cVar.a(str, 32, (r21 & 4) != 0 ? true : z, (r21 & 8) != 0, (r21 & 16) != 0 ? 0 : 0, (r21 & 32) != 0 ? false : false, (r21 & 64) != 0 ? false : z6, (r21 & 128) != 0 ? 25 : i5);
            }
            str3 = a;
            str4 = str3;
            d = cVar.d(str, i3, (r23 & 4) != 0 ? true : z, (r23 & 8) != 0 ? true : z2, (r23 & 16) != 0 ? 0 : i4, (r23 & 32) != 0 ? false : z5, (r23 & 64) != 0 ? false : false, (r23 & 128) != 0 ? false : z6, (r23 & 256) != 0 ? 25 : i5);
            currentTimeMillis = System.currentTimeMillis();
            if (StringsKt.W(str4, "http", false, 2, (Object) null)) {
            }
            if (!z3) {
            }
            Intrinsics.e(load);
            Glide.with(context).load(d).thumbnail(load).listener(new C0067a(currentTimeMillis, function3)).transition(b.f).apply(o(i, i2, !z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
            a.a.f(wf.a.a, "ImageHelper", "load " + i3 + " use " + d + " with small " + str4, false, 4, (Object) null);
        }

        static /* synthetic */ void g(a aVar, Context context, ImageView imageView, String str, int i, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5, Priority priority, Function3 function3, int i6, Object obj) {
            aVar.f(context, imageView, str, (i6 & 8) != 0 ? R.color.image_skeleton : i, (i6 & 16) != 0 ? 0 : i2, (i6 & 32) != 0 ? -1 : i3, (i6 & 64) != 0 ? -1 : i4, (i6 & 128) != 0 ? true : z, (i6 & 256) != 0 ? BuildConfig.FLAVOR : str2, (i6 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? true : z2, (i6 & 1024) != 0 ? true : z3, (i6 & 2048) != 0 ? false : z4, (i6 & 4096) != 0 ? false : z5, (i6 & 8192) != 0 ? false : z6, (i6 & 16384) != 0 ? 25 : i5, (32768 & i6) != 0 ? Priority.NORMAL : priority, (i6 & 65536) != 0 ? null : function3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(ImageView imageView, RequestBuilder requestBuilder) {
            Intrinsics.h(requestBuilder, "it");
            try {
                Intrinsics.e(requestBuilder.into(imageView));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return Unit.a;
        }

        private final RequestOptions o(int i, int i2, int i3, int i4, Priority priority) {
            RequestOptions diskCacheStrategy = new RequestOptions().priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            Intrinsics.g(diskCacheStrategy, "diskCacheStrategy(...)");
            RequestOptions requestOptions = diskCacheStrategy;
            if (i != 0) {
                BaseRequestOptions placeholder = requestOptions.placeholder(i);
                Intrinsics.g(placeholder, "placeholder(...)");
                requestOptions = (RequestOptions) placeholder;
            }
            if (i2 > 0) {
                RequestOptions transform = requestOptions.transform(new MultiTransformation(new Transformation[]{new CenterCrop(), new RoundedCorners(i2)}));
                Intrinsics.g(transform, "transform(...)");
                requestOptions = transform;
            } else if (i2 < 0) {
                requestOptions = RequestOptions.circleCropTransform();
                Intrinsics.g(requestOptions, "circleCropTransform(...)");
            }
            if (i3 == -1 && i4 == -1) {
                return requestOptions;
            }
            RequestOptions override = requestOptions.override(i4, i3);
            Intrinsics.g(override, "override(...)");
            return override;
        }

        static /* synthetic */ RequestOptions p(a aVar, int i, int i2, int i3, int i4, Priority priority, int i5, Object obj) {
            if ((i5 & 16) != 0) {
                priority = Priority.NORMAL;
            }
            return aVar.o(i, i2, i3, i4, priority);
        }

        public final int b() {
            return b.d;
        }

        public final int c() {
            return b.c;
        }

        public final String d(String str, int i, int i2, boolean z, boolean z2, boolean z3, int i3) {
            String d;
            Intrinsics.h(str, "url");
            d = er.c.a.d(str, i, (r23 & 4) != 0 ? true : z, (r23 & 8) != 0, (r23 & 16) != 0 ? 0 : 0, (r23 & 32) != 0 ? false : false, (r23 & 64) != 0 ? false : z2, (r23 & 128) != 0 ? false : z3, (r23 & 256) != 0 ? 25 : i3);
            return d;
        }

        public final void i(Context context, ImageView imageView, String str, int i, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i5) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "thumbnail");
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (str.length() == 0) {
                Glide.with(context).load(BuildConfig.FLAVOR).transition(b.f).apply(p(this, i, i4, z4 ? i3 : -1, z4 ? i2 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                g(this, context, imageView, str, i, i4, (i2 != c() || imageView.getLayoutParams().width <= 0) ? i2 : imageView.getLayoutParams().width, i3, z, str2, z2, z3, z4, z5, z6, i5, null, null, 98304, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void j(Context context, ImageView imageView, String str, int i, int i2, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "thumbnail");
            i(context, imageView, str, R.color.image_skeleton, i, i2, 0, z, str2, z2, z3, z4, z5, z6, i3);
        }

        public final void k(Context context, ImageView imageView, String str, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(str, "url");
            i(context, imageView, str, R.color.image_skeleton, i, i2, 0, z, BuildConfig.FLAVOR, z2, z3, z4, z5, z6, i3);
        }
    }

    static {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        e = new BlurHash(a2, 5, 0.6f);
        DrawableTransitionOptions with = DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder(100).setCrossFadeEnabled(true).build());
        Intrinsics.g(with, "with(...)");
        f = with;
    }
}
