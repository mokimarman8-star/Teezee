package org.mvel2.optimizers.dynamic;

import b00.b;
import b00.c;
import b00.d;
import b00.e;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.AbstractOptimizer;
import org.mvel2.optimizers.a;
import org.mvel2.optimizers.impl.asm.ASMAccessorOptimizer;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class DynamicOptimizer extends AbstractOptimizer implements a {
    public static final int COLLECTION = 2;
    public static final int OBJ_CREATION = 3;
    public static final int REGULAR_ACCESSOR = 0;
    public static final int SET_ACCESSOR = 1;
    private static volatile b classLoader = null;
    private static ReadWriteLock lock = null;
    public static int maximumTenure = 1500;
    private static final Object oLock = new Object();
    private static Lock readLock = null;
    public static int tenuringThreshold = 50;
    public static long timeSpan = 100;
    public static int totalRecycled;
    private static volatile boolean useSafeClassloading;
    private static Lock writeLock;
    private a firstStage = org.mvel2.optimizers.b.b(org.mvel2.optimizers.b.b);

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        lock = reentrantReadWriteLock;
        readLock = reentrantReadWriteLock.readLock();
        writeLock = lock.writeLock();
    }

    private static void _init() {
        b bVar = new b(Thread.currentThread().getContextClassLoader(), maximumTenure);
        classLoader = bVar;
        ASMAccessorOptimizer.setMVELClassLoader(bVar);
    }

    public static void enforceTenureLimit() {
        writeLock.lock();
        try {
            if (classLoader.d()) {
                classLoader.b();
                totalRecycled = classLoader.c();
                _init();
            }
        } finally {
            writeLock.unlock();
        }
    }

    public static boolean isOverloaded() {
        return classLoader.d();
    }

    @Override // org.mvel2.optimizers.a
    public Class getEgressType() {
        return this.firstStage.getEgressType();
    }

    @Override // org.mvel2.optimizers.a
    public Object getResultOptPass() {
        return this.firstStage.getResultOptPass();
    }

    @Override // org.mvel2.optimizers.a
    public void init() {
        _init();
    }

    @Override // org.mvel2.optimizers.a
    public boolean isLiteralOnly() {
        return this.firstStage.isLiteralOnly();
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Class cls) {
        readLock.lock();
        try {
            parserContext.optimizationNotify();
            try {
                b00.a e = classLoader.e(new d(parserContext, cArr, i, i2, 0, this.firstStage.optimizeAccessor(parserContext, cArr, i, i2, obj, obj2, variableResolverFactory, z, cls)));
                readLock.unlock();
                return e;
            } catch (Throwable th) {
                th = th;
                readLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeCollection(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i, int i2, Object obj2, Object obj3, VariableResolverFactory variableResolverFactory) {
        readLock.lock();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            b00.a e = classLoader.e(new c(parserContext, obj, cls, cArr, i, i2, 2, this.firstStage.optimizeCollection(parserContext, obj, cls, cArr, i, i2, obj2, obj3, variableResolverFactory)));
            readLock.unlock();
            return e;
        } catch (Throwable th2) {
            th = th2;
            readLock.unlock();
            throw th;
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeObjectCreation(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        readLock.lock();
        try {
            try {
                b00.a e = classLoader.e(new d(parserContext, cArr, i, i2, 3, this.firstStage.optimizeObjectCreation(parserContext, cArr, i, i2, obj, obj2, variableResolverFactory)));
                readLock.unlock();
                return e;
            } catch (Throwable th) {
                th = th;
                readLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // org.mvel2.optimizers.a
    public org.mvel2.compiler.a optimizeSetAccessor(ParserContext parserContext, char[] cArr, int i, int i2, Object obj, Object obj2, VariableResolverFactory variableResolverFactory, boolean z, Object obj3, Class cls) {
        readLock.lock();
        try {
            try {
                b00.a e = classLoader.e(new e(parserContext, cArr, i, i2, this.firstStage.optimizeSetAccessor(parserContext, cArr, i, i2, obj, obj2, variableResolverFactory, z, obj3, cls)));
                readLock.unlock();
                return e;
            } catch (Throwable th) {
                th = th;
                readLock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
