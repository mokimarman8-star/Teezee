package ni;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class c extends RequestBuilder implements Cloneable {
    c(Glide glide, RequestManager requestManager, Class cls, Context context) {
        super(glide, requestManager, cls, context);
    }

    c(Class cls, RequestBuilder requestBuilder) {
        super(cls, requestBuilder);
    }

    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public c frame(long j) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.frame(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public c getDownloadOnlyRequest() {
        return new c(File.class, this).m173apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public c listener(RequestListener requestListener) {
        return (c) super.listener(requestListener);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m176load(Bitmap bitmap) {
        return (c) super.load(bitmap);
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m177load(Drawable drawable) {
        return (c) super.load(drawable);
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m178load(Uri uri) {
        return (c) super.load(uri);
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m179load(File file) {
        return (c) super.load(file);
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m180load(Integer num) {
        return (c) super.load(num);
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m181load(Object obj) {
        return (c) super.load(obj);
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m182load(String str) {
        return (c) super.load(str);
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m183load(URL url) {
        return (c) super.load(url);
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m184load(byte[] bArr) {
        return (c) super.load(bArr);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public c lock() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.lock();
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public c onlyRetrieveFromCache(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.onlyRetrieveFromCache(z);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public c optionalCenterCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterCrop();
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public c optionalCenterInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterInside();
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public c optionalCircleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCircleCrop();
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public c optionalFitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalFitCenter();
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public c optionalTransform(Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(transformation);
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public c optionalTransform(Class cls, Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(cls, transformation);
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public c override(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(i);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public c override(int i, int i2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(i, i2);
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public c placeholder(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(i);
    }

    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public c placeholder(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(drawable);
    }

    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public c priority(Priority priority) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.priority(priority);
    }

    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public c set(Option option, Object obj) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.set(option, obj);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c addListener(RequestListener requestListener) {
        return (c) super.addListener(requestListener);
    }

    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public c signature(Key key) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.signature(key);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m173apply(BaseRequestOptions baseRequestOptions) {
        return (c) super.apply(baseRequestOptions);
    }

    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public c sizeMultiplier(float f) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.sizeMultiplier(f);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c autoClone() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.autoClone();
    }

    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public c skipMemoryCache(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.skipMemoryCache(z);
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public c theme(Resources.Theme theme) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.theme(theme);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c centerCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerCrop();
    }

    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public c thumbnail(float f) {
        return (c) super.thumbnail(f);
    }

    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public c thumbnail(RequestBuilder requestBuilder) {
        return (c) super.thumbnail(requestBuilder);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c centerInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerInside();
    }

    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public c thumbnail(List list) {
        return (c) super.thumbnail(list);
    }

    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final c thumbnail(RequestBuilder... requestBuilderArr) {
        return (c) super.thumbnail(requestBuilderArr);
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c circleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.circleCrop();
    }

    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public c timeout(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.timeout(i);
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m175clone() {
        return (c) super.clone();
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public c transform(Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(transformation);
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c decode(Class cls) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.decode(cls);
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public c transform(Class cls, Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(cls, transformation);
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c disallowHardwareConfig() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.disallowHardwareConfig();
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c transform(Transformation... transformationArr) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(transformationArr);
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public c diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.diskCacheStrategy(diskCacheStrategy);
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c transforms(Transformation... transformationArr) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transforms(transformationArr);
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public c dontAnimate() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontAnimate();
    }

    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c transition(TransitionOptions transitionOptions) {
        return (c) super.transition(transitionOptions);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public c dontTransform() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontTransform();
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public c useAnimationPool(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useAnimationPool(z);
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public c downsample(DownsampleStrategy downsampleStrategy) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.downsample(downsampleStrategy);
    }

    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public c useUnlimitedSourceGeneratorsPool(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useUnlimitedSourceGeneratorsPool(z);
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public c encodeFormat(Bitmap.CompressFormat compressFormat) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeFormat(compressFormat);
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public c encodeQuality(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeQuality(i);
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c error(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(i);
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public c error(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(drawable);
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public c error(RequestBuilder requestBuilder) {
        return (c) super.error(requestBuilder);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public c error(Object obj) {
        return (c) super.error(obj);
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public c fallback(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(i);
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c fallback(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(drawable);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public c fitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fitCenter();
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public c format(DecodeFormat decodeFormat) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.format(decodeFormat);
    }
}
