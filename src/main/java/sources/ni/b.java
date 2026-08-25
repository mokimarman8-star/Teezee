package ni;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RequestOptions implements Cloneable {
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b optionalCenterCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterCrop();
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b optionalCenterInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCenterInside();
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public b optionalCircleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalCircleCrop();
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public b optionalFitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalFitCenter();
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b optionalTransform(Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(transformation);
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b optionalTransform(Class cls, Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.optionalTransform(cls, transformation);
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public b override(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(i);
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public b override(int i, int i2) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.override(i, i2);
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public b placeholder(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(i);
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public b placeholder(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.placeholder(drawable);
    }

    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public b priority(Priority priority) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.priority(priority);
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public b set(Option option, Object obj) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.set(option, obj);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public b signature(Key key) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.signature(key);
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public b sizeMultiplier(float f) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.sizeMultiplier(f);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b skipMemoryCache(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.skipMemoryCache(z);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b theme(Resources.Theme theme) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.theme(theme);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b timeout(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.timeout(i);
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public b transform(Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(transformation);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public b transform(Class cls, Transformation transformation) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(cls, transformation);
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final b transform(Transformation... transformationArr) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transform(transformationArr);
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final b transforms(Transformation... transformationArr) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.transforms(transformationArr);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b useAnimationPool(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useAnimationPool(z);
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public b useUnlimitedSourceGeneratorsPool(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.useUnlimitedSourceGeneratorsPool(z);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b apply(BaseRequestOptions baseRequestOptions) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.apply(baseRequestOptions);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b autoClone() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.autoClone();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b centerCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerCrop();
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b centerInside() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.centerInside();
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b circleCrop() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.circleCrop();
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b m172clone() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.clone();
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b decode(Class cls) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.decode(cls);
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b disallowHardwareConfig() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.disallowHardwareConfig();
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.diskCacheStrategy(diskCacheStrategy);
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public b dontAnimate() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontAnimate();
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public b dontTransform() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.dontTransform();
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b downsample(DownsampleStrategy downsampleStrategy) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.downsample(downsampleStrategy);
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b encodeFormat(Bitmap.CompressFormat compressFormat) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeFormat(compressFormat);
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b encodeQuality(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.encodeQuality(i);
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public b error(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(i);
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b error(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.error(drawable);
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public b fallback(int i) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(i);
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public b fallback(Drawable drawable) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fallback(drawable);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public b fitCenter() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.fitCenter();
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public b format(DecodeFormat decodeFormat) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.format(decodeFormat);
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public b frame(long j) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.frame(j);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b lock() {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.lock();
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b onlyRetrieveFromCache(boolean z) {
        return super/*com.bumptech.glide.request.BaseRequestOptions*/.onlyRetrieveFromCache(z);
    }
}
