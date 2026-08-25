package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private boolean clearOnStop;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    protected final Glide glide;
    final Lifecycle lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final RequestTracker requestTracker;
    private final TargetTracker targetTracker;
    private final RequestManagerTreeNode treeNode;

    public RequestManager(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.getConnectivityMonitorFactory(), context);
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.targetTracker = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.lifecycle.addListener(requestManager);
            }
        };
        this.addSelfToLifecycle = runnable;
        this.glide = glide;
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.context = context;
        ConnectivityMonitor build = connectivityMonitorFactory.build(context.getApplicationContext(), new RequestManagerConnectivityListener(this, requestTracker));
        this.connectivityMonitor = build;
        glide.registerRequestManager(this);
        if (Util.isOnBackgroundThread()) {
            Util.postOnUiThread(runnable);
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(glide.getGlideContext().getDefaultRequestListeners());
        setRequestOptions(glide.getGlideContext().getDefaultRequestOptions());
    }

    private synchronized void clearRequests() {
        try {
            Iterator it = this.targetTracker.getAll().iterator();
            while (it.hasNext()) {
                clear((Target<?>) it.next());
            }
            this.targetTracker.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void untrackOrDelegate(@NonNull Target<?> target) {
        boolean untrack = untrack(target);
        Request request = target.getRequest();
        if (untrack || this.glide.removeFromManagers(target) || request == null) {
            return;
        }
        target.setRequest((Request) null);
        request.clear();
    }

    private synchronized void updateRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    @NonNull
    public synchronized RequestManager applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> RequestBuilder<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply(DECODE_TYPE_BITMAP);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> asFile() {
        return as(File.class).apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply(DECODE_TYPE_GIF);
    }

    public void clear(@NonNull View view) {
        clear((Target<?>) new ClearTarget(view));
    }

    public void clear(@Nullable Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    @NonNull
    public synchronized RequestManager clearOnStop() {
        this.clearOnStop = true;
        return this;
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @NonNull
    @CheckResult
    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    @NonNull
    <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.isPaused();
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m13load(@Nullable Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14load(@Nullable Drawable drawable) {
        return asDrawable().load(drawable);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m15load(@Nullable Uri uri) {
        return asDrawable().load(uri);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m16load(@Nullable File file) {
        return asDrawable().load(file);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m17load(@Nullable Integer num) {
        return asDrawable().load(num);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m18load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m19load(@Nullable String str) {
        return asDrawable().load(str);
    }

    @CheckResult
    @Deprecated
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m20load(@Nullable URL url) {
        return asDrawable().load(url);
    }

    @NonNull
    @CheckResult
    /* renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m21load(@Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        clearRequests();
        this.requestTracker.clearRequests();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        Util.removeCallbacksOnUiThread(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    public synchronized void onStop() {
        try {
            this.targetTracker.onStop();
            if (this.clearOnStop) {
                clearRequests();
            } else {
                pauseRequests();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.pauseAllRequests();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            ((RequestManager) it.next()).pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.pauseRequests();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            ((RequestManager) it.next()).pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.resumeRequests();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        Iterator it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            ((RequestManager) it.next()).resumeRequests();
        }
    }

    @NonNull
    public synchronized RequestManager setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    protected synchronized void setRequestOptions(@NonNull RequestOptions requestOptions) {
        this.requestOptions = requestOptions.clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    synchronized void track(@NonNull Target<?> target, @NonNull Request request) {
        this.targetTracker.track(target);
        this.requestTracker.runRequest(request);
    }

    synchronized boolean untrack(@NonNull Target<?> target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearAndRemove(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest((Request) null);
        return true;
    }
}
