package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.kernel.datastructure.immutable.ImmutableList;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.ReflectUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class ExtensionInvoker implements InvocationHandler {
    private static final String TAG = "TmcKernel:ExtensionInvoker";
    protected final InvokeCallback invokeCallback;
    private AtomicBoolean isOwner;
    protected final ExtensionInvoker nextInvoker;
    protected ImmutableList<Extension> targetExtensions;
    protected final Node targetNode;

    public interface InvokeCallback<T> {
        void onComplete(T t);

        void onFail(Throwable th);
    }

    public static class InvokeResult<T> {
        private final boolean isPending;
        private T result;

        private InvokeResult(boolean z, T t) {
            this.isPending = z;
            this.result = t;
        }

        public static InvokeResult decide(Object obj) {
            return new InvokeResult(false, obj);
        }

        public static InvokeResult pending() {
            return new InvokeResult(true, null);
        }

        public static InvokeResult proceed() {
            return null;
        }
    }

    public ExtensionInvoker(ExtensionInvoker extensionInvoker) {
        this.isOwner = new AtomicBoolean(false);
        this.nextInvoker = extensionInvoker;
        if (extensionInvoker != null) {
            this.invokeCallback = extensionInvoker.invokeCallback;
            this.targetNode = extensionInvoker.targetNode;
        } else {
            this.invokeCallback = null;
            this.targetNode = null;
        }
    }

    public ExtensionInvoker(Node node, InvokeCallback invokeCallback) {
        this.isOwner = new AtomicBoolean(false);
        this.targetNode = node;
        this.invokeCallback = invokeCallback;
        this.nextInvoker = null;
    }

    public void attacheTargetExtensions(Extension extension) {
        this.targetExtensions = new ImmutableList<>(extension);
        this.isOwner.set(true);
    }

    public void attacheTargetExtensions(List<Extension> list) {
        this.targetExtensions = new ImmutableList<>(list);
        this.isOwner.set(true);
    }

    final boolean hasNext() {
        return this.nextInvoker != null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        InvokeCallback invokeCallback;
        InvokeCallback invokeCallback2;
        try {
            InvokeResult onInvoke = onInvoke(obj, method, objArr);
            if (onInvoke == null) {
                return proceed(this.targetExtensions, obj, method, objArr);
            }
            if (onInvoke.isPending) {
                if (onInvoke.result == null) {
                    onInvoke.result = ReflectUtils.getDefaultValue(method.getReturnType());
                }
            } else if (this.isOwner.get() && (invokeCallback2 = this.invokeCallback) != null) {
                invokeCallback2.onComplete(onInvoke.result);
            }
            return onInvoke.result;
        } catch (Throwable th) {
            TmcLogger.e(TAG, "Java exception happened!\nExtension: " + this.targetExtensions.get(0) + "\nMethod: " + method, th);
            if (this.isOwner.get() && (invokeCallback = this.invokeCallback) != null) {
                invokeCallback.onFail(th);
            }
            throw th;
        }
    }

    protected abstract InvokeResult onInvoke(Object obj, Method method, Object[] objArr) throws Throwable;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    protected final Object proceed(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) throws InvokeException {
        ImmutableList<Extension> immutableList2 = immutableList;
        if (!hasNext()) {
            try {
                if (immutableList.size() != 1) {
                    throw new IllegalStateException("only single extension is accepted in last invoker");
                }
                try {
                    try {
                        immutableList = method.invoke(immutableList.get(0), objArr);
                        return immutableList;
                    } catch (Throwable th) {
                        throw new InvokeException(th);
                    }
                } catch (InvocationTargetException e) {
                    throw new InvokeException(e.getCause());
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2);
                immutableList2 = immutableList;
            }
        }
        if (this.isOwner.compareAndSet(true, false)) {
            this.nextInvoker.isOwner.set(true);
        }
        try {
            ExtensionInvoker extensionInvoker = this.nextInvoker;
            extensionInvoker.targetExtensions = immutableList2;
            return extensionInvoker.invoke(obj, method, objArr);
        } catch (InvokeException e2) {
            throw e2;
        } catch (Throwable th3) {
            throw new InvokeException(th3);
        }
    }

    protected final Object proceedSafe(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        try {
            return proceed(immutableList, obj, method, objArr);
        } catch (Throwable th) {
            TmcLogger.e(TAG, "extension invoke exception!", th);
            return ReflectUtils.getDefaultValue(method.getReturnType());
        }
    }
}
