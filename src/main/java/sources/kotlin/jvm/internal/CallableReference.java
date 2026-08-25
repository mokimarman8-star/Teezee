package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class CallableReference implements KCallable, Serializable {

    @SinceKotlin
    public static final Object NO_RECEIVER = NoReceiver.a;

    @SinceKotlin
    private final boolean isTopLevel;

    @SinceKotlin
    private final String name;

    @SinceKotlin
    private final Class owner;

    @SinceKotlin
    protected final Object receiver;
    private transient KCallable reflected;

    @SinceKotlin
    private final String signature;

    @SinceKotlin
    private static class NoReceiver implements Serializable {
        private static final NoReceiver a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @SinceKotlin
    protected CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @SinceKotlin
    protected CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @SinceKotlin
    public KCallable compute() {
        KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract KCallable computeReflected();

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @SinceKotlin
    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.c(cls) : Reflection.b(cls);
    }

    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @SinceKotlin
    protected KCallable getReflected() {
        KCallable compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @SinceKotlin
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @SinceKotlin
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @SinceKotlin
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @SinceKotlin
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @SinceKotlin
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @SinceKotlin
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
