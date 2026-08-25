package com.alibaba.fastjson;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.Closeable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class JSONValidator implements Cloneable, Closeable {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f14636a;

    /* renamed from: c, reason: collision with root package name */
    protected char f14638c;

    /* renamed from: d, reason: collision with root package name */
    protected Type f14639d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f14640e;

    /* renamed from: b, reason: collision with root package name */
    protected int f14637b = -1;

    /* renamed from: f, reason: collision with root package name */
    protected int f14641f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f14642g = false;

    public enum Type {
        Object,
        Array,
        Value
    }

    static class a extends JSONValidator {

        /* renamed from: h, reason: collision with root package name */
        private final String f14643h;

        public a(String str) {
            this.f14643h = str;
            o();
            p();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        protected final void l() {
            char charAt;
            int i5 = this.f14637b;
            do {
                i5++;
                if (i5 >= this.f14643h.length() || (charAt = this.f14643h.charAt(i5)) == '\\') {
                    o();
                    while (true) {
                        char c5 = this.f14638c;
                        if (c5 == '\\') {
                            o();
                            if (this.f14638c == 'u') {
                                o();
                                o();
                                o();
                                o();
                                o();
                            } else {
                                o();
                            }
                        } else if (c5 == '\"') {
                            o();
                            return;
                        } else if (this.f14636a) {
                            return;
                        } else {
                            o();
                        }
                    }
                }
            } while (charAt != '\"');
            int i6 = i5 + 1;
            this.f14638c = this.f14643h.charAt(i6);
            this.f14637b = i6;
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void o() {
            int i5 = this.f14637b + 1;
            this.f14637b = i5;
            if (i5 < this.f14643h.length()) {
                this.f14638c = this.f14643h.charAt(this.f14637b);
            } else {
                this.f14638c = (char) 0;
                this.f14636a = true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x0173, code lost:
    
        if (r0 <= '9') goto L181;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean k() {
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        char c12;
        char c13 = this.f14638c;
        if (c13 == '\"') {
            o();
            while (!this.f14636a) {
                char c14 = this.f14638c;
                if (c14 == '\\') {
                    o();
                    if (this.f14638c == 'u') {
                        o();
                        o();
                        o();
                        o();
                        o();
                    } else {
                        o();
                    }
                } else {
                    if (c14 == '\"') {
                        o();
                        this.f14639d = Type.Value;
                        return true;
                    }
                    o();
                }
            }
            return false;
        }
        if (c13 != '+' && c13 != '-') {
            if (c13 == '[') {
                o();
                p();
                if (this.f14638c == ']') {
                    o();
                    this.f14639d = Type.Array;
                    return true;
                }
                while (k()) {
                    p();
                    char c15 = this.f14638c;
                    if (c15 != ',') {
                        if (c15 != ']') {
                            return false;
                        }
                        o();
                        this.f14639d = Type.Array;
                        return true;
                    }
                    o();
                    p();
                }
                return false;
            }
            if (c13 == 'f') {
                o();
                if (this.f14638c != 'a') {
                    return false;
                }
                o();
                if (this.f14638c != 'l') {
                    return false;
                }
                o();
                if (this.f14638c != 's') {
                    return false;
                }
                o();
                if (this.f14638c != 'e') {
                    return false;
                }
                o();
                if (!n(this.f14638c) && (c10 = this.f14638c) != ',' && c10 != ']' && c10 != '}' && c10 != 0) {
                    return false;
                }
                this.f14639d = Type.Value;
                return true;
            }
            if (c13 == 'n') {
                o();
                if (this.f14638c != 'u') {
                    return false;
                }
                o();
                if (this.f14638c != 'l') {
                    return false;
                }
                o();
                if (this.f14638c != 'l') {
                    return false;
                }
                o();
                if (!n(this.f14638c) && (c11 = this.f14638c) != ',' && c11 != ']' && c11 != '}' && c11 != 0) {
                    return false;
                }
                this.f14639d = Type.Value;
                return true;
            }
            if (c13 == 't') {
                o();
                if (this.f14638c != 'r') {
                    return false;
                }
                o();
                if (this.f14638c != 'u') {
                    return false;
                }
                o();
                if (this.f14638c != 'e') {
                    return false;
                }
                o();
                if (!n(this.f14638c) && (c12 = this.f14638c) != ',' && c12 != ']' && c12 != '}' && c12 != 0) {
                    return false;
                }
                this.f14639d = Type.Value;
                return true;
            }
            if (c13 == '{') {
                o();
                while (n(this.f14638c)) {
                    o();
                }
                if (this.f14638c == '}') {
                    o();
                    this.f14639d = Type.Object;
                    return true;
                }
                while (true) {
                    if (this.f14638c != '\"') {
                        break;
                    }
                    l();
                    p();
                    if (this.f14638c != ':') {
                        break;
                    }
                    o();
                    p();
                    if (!k()) {
                        return false;
                    }
                    p();
                    char c16 = this.f14638c;
                    if (c16 == ',') {
                        o();
                        p();
                    } else if (c16 == '}') {
                        o();
                        this.f14639d = Type.Object;
                        return true;
                    }
                }
                return false;
            }
            switch (c13) {
                case '0':
                case '1':
                case AccessibilityNodeInfoCompat.MAX_NUMBER_OF_PREFETCHED_NODES /* 50 */:
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;
            }
        }
        if (c13 == '-' || c13 == '+') {
            o();
            p();
            char c17 = this.f14638c;
            if (c17 >= '0') {
            }
            return false;
        }
        do {
            o();
            c5 = this.f14638c;
            if (c5 >= '0') {
            }
            if (c5 == '.') {
                o();
                char c18 = this.f14638c;
                if (c18 < '0' || c18 > '9') {
                    return false;
                }
                while (true) {
                    char c19 = this.f14638c;
                    if (c19 >= '0' && c19 <= '9') {
                        o();
                    }
                }
            }
            c6 = this.f14638c;
            if (c6 != 'e' || c6 == 'E') {
                o();
                c7 = this.f14638c;
                if (c7 != '-' || c7 == '+') {
                    o();
                }
                c8 = this.f14638c;
                if (c8 >= '0' && c8 <= '9') {
                    o();
                    while (true) {
                        c9 = this.f14638c;
                        if (c9 >= '0' && c9 <= '9') {
                            o();
                        }
                    }
                }
                return false;
            }
            this.f14639d = Type.Value;
            return true;
        } while (c5 <= '9');
        if (c5 == '.') {
        }
        c6 = this.f14638c;
        if (c6 != 'e') {
        }
        o();
        c7 = this.f14638c;
        if (c7 != '-') {
        }
        o();
        c8 = this.f14638c;
        if (c8 >= '0') {
            o();
            while (true) {
                c9 = this.f14638c;
                if (c9 >= '0') {
                    o();
                }
            }
            this.f14639d = Type.Value;
            return true;
        }
        return false;
    }

    public static JSONValidator m(String str) {
        return new a(str);
    }

    static final boolean n(char c5) {
        return c5 == ' ' || c5 == '\t' || c5 == '\r' || c5 == '\n' || c5 == '\f' || c5 == '\b';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    protected void l() {
        o();
        while (true) {
            char c5 = this.f14638c;
            if (c5 == '\\') {
                o();
                if (this.f14638c == 'u') {
                    o();
                    o();
                    o();
                    o();
                    o();
                } else {
                    o();
                }
            } else {
                if (c5 == '\"') {
                    o();
                    return;
                }
                o();
            }
        }
    }

    abstract void o();

    void p() {
        while (n(this.f14638c)) {
            o();
        }
    }

    public boolean q() {
        Boolean bool = this.f14640e;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (k()) {
            p();
            this.f14641f++;
            if (this.f14636a) {
                this.f14640e = Boolean.TRUE;
                return true;
            }
            if (!this.f14642g) {
                this.f14640e = Boolean.FALSE;
                return false;
            }
            p();
            if (this.f14636a) {
                this.f14640e = Boolean.TRUE;
                return true;
            }
        }
        this.f14640e = Boolean.FALSE;
        return false;
    }
}
