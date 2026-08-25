package com.google.common.base;

import com.google.common.base.Suppliers;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class Suppliers {

    static class MemoizingSupplier<T> implements q, Serializable {
        private static final long serialVersionUID = 0;
        private transient Object a = new Object();
        final q delegate;
        volatile transient boolean initialized;
        transient T value;

        MemoizingSupplier(q qVar) {
            this.delegate = (q) m.o(qVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.a = new Object();
        }

        @Override // com.google.common.base.q
        public T get() {
            if (!this.initialized) {
                synchronized (this.a) {
                    try {
                        if (!this.initialized) {
                            T t = (T) this.delegate.get();
                            this.value = t;
                            this.initialized = true;
                            return t;
                        }
                    } finally {
                    }
                }
            }
            return (T) i.a(this.value);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    private static class SupplierOfInstance<T> implements q, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T t) {
            this.instance = t;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return j.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.q
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return j.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    static class a implements q {
        private static final q d = new q() { // from class: com.google.common.base.r
            @Override // com.google.common.base.q
            public final Object get() {
                Void b;
                b = Suppliers.a.b();
                return b;
            }
        };
        private final Object a = new Object();
        private volatile q b;
        private Object c;

        a(q qVar) {
            this.b = (q) m.o(qVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.q
        public Object get() {
            q qVar = this.b;
            q qVar2 = d;
            if (qVar != qVar2) {
                synchronized (this.a) {
                    try {
                        if (this.b != qVar2) {
                            Object obj = this.b.get();
                            this.c = obj;
                            this.b = qVar2;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return i.a(this.c);
        }

        public String toString() {
            Object obj = this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == d) {
                obj = "<supplier that returned " + this.c + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static q a(q qVar) {
        return ((qVar instanceof a) || (qVar instanceof MemoizingSupplier)) ? qVar : qVar instanceof Serializable ? new MemoizingSupplier(qVar) : new a(qVar);
    }

    public static q b(Object obj) {
        return new SupplierOfInstance(obj);
    }
}
