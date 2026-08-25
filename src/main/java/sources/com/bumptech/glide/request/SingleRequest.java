package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;

    @Nullable
    private Drawable errorDrawable;

    @Nullable
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;

    @Nullable
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;

    @Nullable
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;

    @Nullable
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;

    @Nullable
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;

    @Nullable
    private final String tag;
    private final Target<R> target;

    @Nullable
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;
    private static final String TAG = "GlideRequest";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null || requestCoordinator.canNotifyCleared(this)) {
            return true;
        }
        return IS_VERBOSE_LOGGABLE;
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this)) {
            return true;
        }
        return IS_VERBOSE_LOGGABLE;
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null || requestCoordinator.canSetImage(this)) {
            return true;
        }
        return IS_VERBOSE_LOGGABLE;
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    private void experimentalNotifyRequestStarted(Object obj) {
        List<RequestListener<R>> list = this.requestListeners;
        if (list == null) {
            return;
        }
        Iterator<RequestListener<R>> it = list.iterator();
        while (it.hasNext()) {
            ExperimentalRequestListener experimentalRequestListener = (RequestListener) it.next();
            if (experimentalRequestListener instanceof ExperimentalRequestListener) {
                experimentalRequestListener.onRequestStarted(obj);
            }
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet()) {
            return true;
        }
        return IS_VERBOSE_LOGGABLE;
    }

    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable(this.context, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            try {
                glideException.setOrigin(this.requestOrigin);
                int logLevel = this.glideContext.getLogLevel();
                if (logLevel <= i) {
                    Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", glideException);
                    if (logLevel <= 4) {
                        glideException.logRootCauses(GLIDE_TAG);
                    }
                }
                this.loadStatus = null;
                this.status = Status.FAILED;
                notifyRequestCoordinatorLoadFailed();
                boolean z2 = true;
                this.isCallingCallbacks = true;
                try {
                    List<RequestListener<R>> list = this.requestListeners;
                    if (list != null) {
                        Iterator<RequestListener<R>> it = list.iterator();
                        z = false;
                        while (it.hasNext()) {
                            z |= it.next().onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                        }
                    } else {
                        z = false;
                    }
                    RequestListener<R> requestListener = this.targetListener;
                    if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                        z2 = false;
                    }
                    if (!(z | z2)) {
                        setErrorPlaceholder();
                    }
                    this.isCallingCallbacks = IS_VERBOSE_LOGGABLE;
                    GlideTrace.endSectionAsync(TAG, this.cookie);
                } catch (Throwable th) {
                    this.isCallingCallbacks = IS_VERBOSE_LOGGABLE;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void onResourceReady(Resource<R> resource, R r, DataSource dataSource, boolean z) {
        boolean z2;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(dataSource);
            sb.append(" for ");
            sb.append(this.model);
            sb.append(" with size [");
            sb.append(this.width);
            sb.append("x");
            sb.append(this.height);
            sb.append("] in ");
            sb.append(LogTime.getElapsedMillis(this.startTime));
            sb.append(" ms");
        }
        notifyRequestCoordinatorLoadSucceeded();
        boolean z3 = true;
        this.isCallingCallbacks = true;
        try {
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                Iterator<RequestListener<R>> it = list.iterator();
                z2 = false;
                while (it.hasNext()) {
                    ExperimentalRequestListener experimentalRequestListener = (RequestListener) it.next();
                    boolean onResourceReady = z2 | experimentalRequestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource);
                    z2 = experimentalRequestListener instanceof ExperimentalRequestListener ? experimentalRequestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource, z) | onResourceReady : onResourceReady;
                }
            } else {
                z2 = false;
            }
            RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) {
                z3 = false;
            }
            if (!(z2 | z3)) {
                this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
            }
            this.isCallingCallbacks = IS_VERBOSE_LOGGABLE;
            GlideTrace.endSectionAsync(TAG, this.cookie);
        } catch (Throwable th) {
            this.isCallingCallbacks = IS_VERBOSE_LOGGABLE;
            throw th;
        }
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    public void begin() {
        synchronized (this.requestLock) {
            try {
                assertNotCallingCallbacks();
                this.stateVerifier.throwIfRecycled();
                this.startTime = LogTime.getLogTime();
                Object obj = this.model;
                if (obj == null) {
                    if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                        this.width = this.overrideWidth;
                        this.height = this.overrideHeight;
                    }
                    onLoadFailed(new GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                    return;
                }
                Status status = this.status;
                Status status2 = Status.RUNNING;
                if (status == status2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (status == Status.COMPLETE) {
                    onResourceReady(this.resource, DataSource.MEMORY_CACHE, IS_VERBOSE_LOGGABLE);
                    return;
                }
                experimentalNotifyRequestStarted(obj);
                this.cookie = GlideTrace.beginSectionAsync(TAG);
                Status status3 = Status.WAITING_FOR_SIZE;
                this.status = status3;
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    onSizeReady(this.overrideWidth, this.overrideHeight);
                } else {
                    this.target.getSize(this);
                }
                Status status4 = this.status;
                if ((status4 == status2 || status4 == status3) && canNotifyStatusChanged()) {
                    this.target.onLoadStarted(getPlaceholderDrawable());
                }
                if (IS_VERBOSE_LOGGABLE) {
                    logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clear() {
        synchronized (this.requestLock) {
            try {
                assertNotCallingCallbacks();
                this.stateVerifier.throwIfRecycled();
                Status status = this.status;
                Status status2 = Status.CLEARED;
                if (status == status2) {
                    return;
                }
                cancel();
                Resource<R> resource = this.resource;
                if (resource != null) {
                    this.resource = null;
                } else {
                    resource = null;
                }
                if (canNotifyCleared()) {
                    this.target.onLoadCleared(getPlaceholderDrawable());
                }
                GlideTrace.endSectionAsync(TAG, this.cookie);
                this.status = status2;
                if (resource != null) {
                    this.engine.release(resource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE ? true : IS_VERBOSE_LOGGABLE;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED ? true : IS_VERBOSE_LOGGABLE;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE ? true : IS_VERBOSE_LOGGABLE;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (!(request instanceof SingleRequest)) {
            return IS_VERBOSE_LOGGABLE;
        }
        synchronized (this.requestLock) {
            try {
                i = this.overrideWidth;
                i2 = this.overrideHeight;
                obj = this.model;
                cls = this.transcodeClass;
                baseRequestOptions = this.requestOptions;
                priority = this.priority;
                List<RequestListener<R>> list = this.requestListeners;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.requestLock) {
            try {
                i3 = singleRequest.overrideWidth;
                i4 = singleRequest.overrideHeight;
                obj2 = singleRequest.model;
                cls2 = singleRequest.transcodeClass;
                baseRequestOptions2 = singleRequest.requestOptions;
                priority2 = singleRequest.priority;
                List<RequestListener<R>> list2 = singleRequest.requestListeners;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && Util.bothBaseRequestOptionsNullEquivalentOrEquals(baseRequestOptions, baseRequestOptions2) && priority == priority2 && size == size2) {
            return true;
        }
        return IS_VERBOSE_LOGGABLE;
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            try {
                Status status = this.status;
                z = (status == Status.RUNNING || status == Status.WAITING_FOR_SIZE) ? true : IS_VERBOSE_LOGGABLE;
            } finally {
            }
        }
        return z;
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResourceReady(Resource<?> resource, DataSource dataSource, boolean z) {
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource2 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    try {
                        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (canSetResource()) {
                                onResourceReady(resource, obj, dataSource, z);
                                return;
                            }
                            this.resource = null;
                            this.status = Status.COMPLETE;
                            GlideTrace.endSectionAsync(TAG, this.cookie);
                            this.engine.release(resource);
                            return;
                        }
                        this.resource = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.transcodeClass);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(resource);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        onLoadFailed(new GlideException(sb.toString()));
                        this.engine.release(resource);
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.engine.release(resource2);
            }
            throw th3;
        }
    }

    public void onSizeReady(int i, int i2) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    if (this.status == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.status = status;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                        }
                        obj = obj2;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != status) {
                                this.loadStatus = null;
                            }
                            if (z) {
                                logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
