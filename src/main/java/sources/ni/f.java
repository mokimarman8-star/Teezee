package ni;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.transsion.base.image.R$color;
import com.transsion.base.image.blurhash.BlurHash;
import com.transsion.gslb.BuildConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ni.f;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f {
    public static final a a = new a(null);
    private static int b = y.e() / 3;
    private static int c = y.b() / 2;
    private static int d = y.c();
    private static final BlurHash e;
    private static final DrawableTransitionOptions f;

    public static final class a {

        /* renamed from: ni.f$a$a, reason: collision with other inner class name */
        public static final class C0086a implements RequestListener {
            final /* synthetic */ long a;
            final /* synthetic */ Function3 b;

            C0086a(long j, Function3 function3) {
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

        public static final class b implements RequestListener {
            final /* synthetic */ long a;
            final /* synthetic */ Function3 b;

            b(long j, Function3 function3) {
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

        public static final class d implements RequestListener {
            final /* synthetic */ Function1 a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;

            d(Function1 function1, String str, int i) {
                this.a = function1;
                this.b = str;
                this.c = i;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable drawable, Object obj, Target target, DataSource dataSource, boolean z) {
                Intrinsics.h(drawable, "resource");
                Intrinsics.h(obj, "model");
                Intrinsics.h(dataSource, "dataSource");
                g.a.h(this.b, this.c);
                Function1 function1 = this.a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.TRUE);
                return true;
            }

            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
                Intrinsics.h(target, "target");
                Function1 function1 = this.a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.FALSE);
                return true;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String e(a aVar, String str, int i, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            if ((i2 & 8) != 0) {
                z2 = false;
            }
            return aVar.d(str, i, z, z2);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void f(Context context, final ImageView imageView, String str, int i, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Priority priority, int i5, Function3 function3) {
            String str3;
            String a;
            String d2;
            long currentTimeMillis;
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            g gVar = g.a;
            int c2 = gVar.c(str);
            if (1 <= c2 && c2 < i3 + 1) {
                a = gVar.a(str, c2, (r18 & 4) != 0 ? true : z, (r18 & 8) != 0, (r18 & 16) != 0 ? 0 : 0, (r18 & 32) != 0 ? false : false, (r18 & 64) != 0 ? 0 : 0);
            } else {
                if (str2.length() != 0 || i3 <= 96 || c2 > i3) {
                    str3 = str2;
                    d2 = gVar.d(str, i3, z, z2, i4, z5, false, i5);
                    currentTimeMillis = System.currentTimeMillis();
                    if (!StringsKt.W(str3, "http", false, 2, (Object) null) || StringsKt.W(str3, "data:image", false, 2, (Object) null)) {
                        RequestBuilder load = !z3 ? (RequestBuilder) Glide.with(context).load(str3).optionalCenterCrop() : Glide.with(context).load(str3);
                        Intrinsics.e(load);
                        Glide.with(context).load(d2).thumbnail(load).listener(new C0086a(currentTimeMillis, function3)).transition(f.f).apply(k(i, i2, !z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    } else if (str3.length() >= 6) {
                        RequestBuilder load2 = Glide.with(context).load(d2);
                        Intrinsics.g(load2, "load(...)");
                        com.transsion.base.image.blurhash.c.b(load2, str3, 20, 20, f.e, new Function1() { // from class: ni.e
                            public final Object invoke(Object obj) {
                                Unit g;
                                g = f.a.g(imageView, (RequestBuilder) obj);
                                return g;
                            }
                        });
                        load2.transition(f.f).listener(new b(currentTimeMillis, function3)).apply(k(0, i2, z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    } else {
                        Glide.with(context).load(d2).transition(f.f).listener(new c(currentTimeMillis, function3)).apply(k(i, i2, z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
                    }
                    a.a.f(wf.a.a, "ImageHelper", "load " + i3 + " use " + d2 + " with small " + str3, false, 4, (Object) null);
                }
                a = gVar.a(str, 32, (r18 & 4) != 0 ? true : z, (r18 & 8) != 0, (r18 & 16) != 0 ? 0 : 0, (r18 & 32) != 0 ? false : false, (r18 & 64) != 0 ? 0 : 0);
            }
            str3 = a;
            d2 = gVar.d(str, i3, z, z2, i4, z5, false, i5);
            currentTimeMillis = System.currentTimeMillis();
            if (StringsKt.W(str3, "http", false, 2, (Object) null)) {
            }
            if (!z3) {
            }
            Intrinsics.e(load);
            Glide.with(context).load(d2).thumbnail(load).listener(new C0086a(currentTimeMillis, function3)).transition(f.f).apply(k(i, i2, !z4 ? i4 : -1, z4 ? i3 : -1, priority)).into(imageView);
            a.a.f(wf.a.a, "ImageHelper", "load " + i3 + " use " + d2 + " with small " + str3, false, 4, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(ImageView imageView, RequestBuilder requestBuilder) {
            Intrinsics.h(requestBuilder, "it");
            requestBuilder.into(imageView);
            return Unit.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(Context context, ImageView imageView, String str, int i, int i2, int i3, int i4, boolean z, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Priority priority, int i5, Function3 function3) {
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                Glide.with(context).load(BuildConfig.FLAVOR).transition(f.f).apply(l(this, i, i4, z4 ? i3 : -1, z4 ? i2 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                f(context, imageView, str, i, i4, (i2 != f.c || imageView.getLayoutParams().width <= 0) ? i2 : imageView.getLayoutParams().width, i3, z, str2, z2, z3, z4, z5, priority, i5, function3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static /* synthetic */ void j(a aVar, String str, String str2, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            aVar.i(str, str2, i, function1);
        }

        private final RequestOptions k(int i, int i2, int i3, int i4, Priority priority) {
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

        static /* synthetic */ RequestOptions l(a aVar, int i, int i2, int i3, int i4, Priority priority, int i5, Object obj) {
            if ((i5 & 16) != 0) {
                priority = Priority.NORMAL;
            }
            return aVar.k(i, i2, i3, i4, priority);
        }

        public final int c() {
            return f.b;
        }

        public final String d(String str, int i, boolean z, boolean z2) {
            String d2;
            Intrinsics.h(str, "url");
            d2 = g.a.d(str, i, (r21 & 4) != 0 ? true : z, (r21 & 8) != 0, (r21 & 16) != 0 ? 0 : 0, (r21 & 32) != 0 ? false : false, (r21 & 64) != 0 ? false : z2, (r21 & 128) != 0 ? 0 : 0);
            return d2;
        }

        public final void i(String str, String str2, int i, Function1 function1) {
            Intrinsics.h(str, "url");
            Intrinsics.h(str2, "originUrl");
            Glide.with(Utils.a()).load(str).diskCacheStrategy(DiskCacheStrategy.DATA).addListener(new d(function1, str2, i)).preload();
        }

        public final b m(Context context) {
            Intrinsics.h(context, "context");
            return new b(context);
        }
    }

    public static final class b {
        private final Context a;
        private final int b;
        private final int c;
        private int d;
        private int e;
        private String f;
        private String g;
        private int h;
        private int i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean n;
        private Priority o;
        private Function3 p;
        private int q;

        public b(Context context) {
            Intrinsics.h(context, "context");
            this.a = context;
            int b = y.b() / 2;
            this.b = b;
            int c = y.c();
            this.c = c;
            this.d = b;
            this.e = c;
            this.f = BuildConfig.FLAVOR;
            this.g = BuildConfig.FLAVOR;
            this.h = R$color.image_default;
            this.j = true;
            this.k = true;
            this.l = true;
            this.o = Priority.NORMAL;
        }

        public final b a(int i) {
            this.q = i;
            return this;
        }

        public final b b(Function3 function3) {
            this.p = function3;
            return this;
        }

        public final b c(int i) {
            this.e = i;
            this.n = true;
            return this;
        }

        public final void d(ImageView imageView) {
            Intrinsics.h(imageView, "imageView");
            f.a.h(this.a, imageView, this.f, this.h, this.d, this.e, this.i, this.j, this.g, this.k, this.l, this.m, this.n, this.o, this.q, this.p);
        }

        public final b e(boolean z) {
            this.k = z;
            return this;
        }

        public final b f(boolean z) {
            this.j = z;
            return this;
        }

        public final b g(String str) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            this.f = str;
            return this;
        }

        public final b h(boolean z) {
            this.m = z;
            return this;
        }

        public final b i(int i) {
            this.h = i;
            return this;
        }

        public final b j(int i) {
            this.i = i;
            return this;
        }

        public final b k(boolean z) {
            this.l = z;
            return this;
        }

        public final b l(String str) {
            Intrinsics.h(str, "thumbnail");
            this.g = str;
            return this;
        }

        public final b m(int i) {
            this.d = i;
            return this;
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
