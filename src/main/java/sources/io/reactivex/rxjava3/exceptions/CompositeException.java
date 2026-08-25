package io.reactivex.rxjava3.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        ExceptionOverview(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    static abstract class a {
        a() {
        }

        abstract a a(Object obj);
    }

    static final class b extends a {
        private final PrintStream a;

        b(PrintStream printStream) {
            this.a = printStream;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Object obj) {
            this.a.print(obj);
            return this;
        }
    }

    static final class c extends a {
        private final PrintWriter a;

        c(PrintWriter printWriter) {
            this.a = printWriter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Object obj) {
            this.a.print(obj);
            return this;
        }
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void appendStackTrace(a aVar, Throwable th, String str) {
        aVar.a(str).a(th).a('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            aVar.a("\t\tat ").a(stackTraceElement).a('\n');
        }
        if (th.getCause() != null) {
            aVar.a("\tCaused by: ");
            appendStackTrace(aVar, th.getCause(), HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    private void printStackTrace(a aVar) {
        aVar.a(this).a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            aVar.a("\tat ").a(stackTraceElement).a("\n");
        }
        int i = 1;
        for (Throwable th : this.exceptions) {
            aVar.a("  ComposedException ").a(Integer.valueOf(i)).a(" :\n");
            appendStackTrace(aVar, th, "\t");
            i++;
        }
        aVar.a("\n");
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i;
        try {
            if (this.cause == null) {
                String property = System.getProperty("line.separator");
                if (this.exceptions.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.exceptions.size());
                    sb.append(")");
                    sb.append(property);
                    for (Throwable th : this.exceptions) {
                        int i2 = 0;
                        while (true) {
                            if (th != null) {
                                for (int i3 = 0; i3 < i2; i3++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append(th.getClass().getCanonicalName());
                                sb.append(": ");
                                String message = th.getMessage();
                                if (message == null || !message.contains(property)) {
                                    sb.append(message);
                                    sb.append(property);
                                } else {
                                    sb.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i4 = 0; i4 < i2 + 2; i4++) {
                                            sb.append("  ");
                                        }
                                        sb.append(str);
                                        sb.append(property);
                                    }
                                }
                                int i5 = 0;
                                while (true) {
                                    i = i2 + 2;
                                    if (i5 >= i) {
                                        break;
                                    }
                                    sb.append("  ");
                                    i5++;
                                }
                                StackTraceElement[] stackTrace = th.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb.append("at ");
                                    sb.append(stackTrace[0]);
                                    sb.append(property);
                                }
                                if (identityHashMap.containsKey(th)) {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        for (int i6 = 0; i6 < i; i6++) {
                                            sb.append("  ");
                                        }
                                        sb.append("|-- ");
                                        sb.append("(cause not expanded again) ");
                                        sb.append(cause.getClass().getCanonicalName());
                                        sb.append(": ");
                                        sb.append(cause.getMessage());
                                        sb.append(property);
                                    }
                                } else {
                                    identityHashMap.put(th, Boolean.TRUE);
                                    th = th.getCause();
                                    i2++;
                                }
                            }
                        }
                    }
                    this.cause = new ExceptionOverview(sb.toString().trim());
                } else {
                    this.cause = this.exceptions.get(0);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new b(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new c(printWriter));
    }

    public int size() {
        return this.exceptions.size();
    }
}
