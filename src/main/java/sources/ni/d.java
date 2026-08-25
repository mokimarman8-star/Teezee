package ni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d extends RequestManager {
    public d(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d addDefaultRequestListener(RequestListener requestListener) {
        return (d) super.addDefaultRequestListener(requestListener);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized d applyDefaultRequestOptions(RequestOptions requestOptions) {
        return (d) super.applyDefaultRequestOptions(requestOptions);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c as(Class cls) {
        return new c(((RequestManager) this).glide, this, cls, ((RequestManager) this).context);
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c asBitmap() {
        return (c) super.asBitmap();
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c asDrawable() {
        return (c) super.asDrawable();
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c asFile() {
        return (c) super.asFile();
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c asGif() {
        return (c) super.asGif();
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized d clearOnStop() {
        return (d) super.clearOnStop();
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c download(Object obj) {
        return (c) super.download(obj);
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public c downloadOnly() {
        return (c) super.downloadOnly();
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m185load(Bitmap bitmap) {
        return (c) super.load(bitmap);
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m186load(Drawable drawable) {
        return (c) super.load(drawable);
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m187load(Uri uri) {
        return (c) super.load(uri);
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m188load(File file) {
        return (c) super.load(file);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m189load(Integer num) {
        return (c) super.load(num);
    }

    /* renamed from: p, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m190load(Object obj) {
        return (c) super.load(obj);
    }

    /* renamed from: q, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m191load(String str) {
        return (c) super.load(str);
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m192load(URL url) {
        return (c) super.load(url);
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c m193load(byte[] bArr) {
        return (c) super.load(bArr);
    }

    protected void setRequestOptions(RequestOptions requestOptions) {
        if (requestOptions instanceof b) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new b().apply(requestOptions));
        }
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public synchronized d setDefaultRequestOptions(RequestOptions requestOptions) {
        return (d) super.setDefaultRequestOptions(requestOptions);
    }
}
