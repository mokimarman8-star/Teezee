package com.transsion.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class l {
    private int a;
    private final Reader b;
    private char c;
    private boolean d;

    public l(Reader reader) {
        this.b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.d = false;
        this.a = 0;
    }

    public l(String str) {
        this(new StringReader(str));
    }

    private void e(Map map, String str, Object obj) {
        if (str != null) {
            if (!map.containsKey(str)) {
                map.put(str, obj);
                return;
            }
            throw new k("Duplicate key \"" + str + "\"");
        }
    }

    private boolean g(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != '-' && charAt != '.' && charAt != '+' && charAt != 'e' && charAt != 'E') {
                return false;
            }
        }
        return true;
    }

    private Object i(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return null;
        }
        return g(str) ? new n(str) : str;
    }

    private Map l() {
        HashMap hashMap = new HashMap();
        if (h() != '{') {
            throw a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char h = h();
            if (h == 0) {
                throw a("A JSONObject text must end with '}'");
            }
            if (h == '}') {
                return hashMap;
            }
            d();
            String obj = j().toString();
            char h2 = h();
            if (h2 == '=') {
                if (f() != '>') {
                    d();
                }
            } else if (h2 != ':') {
                throw a("Expected a ':' after a key");
            }
            e(hashMap, obj, j());
            char h3 = h();
            if (h3 != ',' && h3 != ';') {
                if (h3 == '}') {
                    return hashMap;
                }
                throw a("Expected a ',' or '}'");
            }
            if (h() == '}') {
                return hashMap;
            }
            d();
        }
    }

    public k a(String str) {
        return new k(str + toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0084, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(char r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            char r1 = r5.f()
            if (r1 == 0) goto L7e
            r2 = 10
            if (r1 == r2) goto L7e
            r3 = 13
            if (r1 == r3) goto L7e
            r4 = 92
            if (r1 == r4) goto L22
            if (r1 != r6) goto L1e
            java.lang.String r6 = r0.toString()
            return r6
        L1e:
            r0.append(r1)
            goto L5
        L22:
            char r1 = r5.f()
            r4 = 98
            if (r1 == r4) goto L78
            r4 = 102(0x66, float:1.43E-43)
            if (r1 == r4) goto L72
            r4 = 110(0x6e, float:1.54E-43)
            if (r1 == r4) goto L6e
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L6a
            r2 = 120(0x78, float:1.68E-43)
            r3 = 16
            if (r1 == r2) goto L5c
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L56
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L48
            r0.append(r1)
            goto L5
        L48:
            r1 = 4
            java.lang.String r1 = r5.c(r1)
            int r1 = java.lang.Integer.parseInt(r1, r3)
            char r1 = (char) r1
            r0.append(r1)
            goto L5
        L56:
            r1 = 9
            r0.append(r1)
            goto L5
        L5c:
            r1 = 2
            java.lang.String r1 = r5.c(r1)
            int r1 = java.lang.Integer.parseInt(r1, r3)
            char r1 = (char) r1
            r0.append(r1)
            goto L5
        L6a:
            r0.append(r3)
            goto L5
        L6e:
            r0.append(r2)
            goto L5
        L72:
            r1 = 12
            r0.append(r1)
            goto L5
        L78:
            r1 = 8
            r0.append(r1)
            goto L5
        L7e:
            java.lang.String r6 = "Unterminated string"
            com.transsion.json.k r6 = r5.a(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.json.l.b(char):java.lang.String");
    }

    public String c(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e) {
                throw new k(e);
            }
        }
        this.a += i2;
        if (i2 < i) {
            throw a("Substring bounds error");
        }
        this.c = cArr[i - 1];
        return new String(cArr);
    }

    public void d() {
        int i;
        if (this.d || (i = this.a) <= 0) {
            throw new k("Stepping back two steps is not supported");
        }
        this.a = i - 1;
        this.d = true;
    }

    public char f() {
        if (this.d) {
            this.d = false;
            char c = this.c;
            if (c != 0) {
                this.a++;
            }
            return c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = (char) 0;
                return (char) 0;
            }
            this.a++;
            char c2 = (char) read;
            this.c = c2;
            return c2;
        } catch (IOException e) {
            throw new k(e);
        }
    }

    public char h() {
        char f;
        do {
            f = f();
            if (f == 0) {
                break;
            }
        } while (f <= ' ');
        return f;
    }

    public Object j() {
        char h = h();
        if (h != '\"') {
            if (h != '[') {
                if (h == '{') {
                    d();
                    return l();
                }
                if (h != '\'') {
                    if (h != '(') {
                        StringBuilder sb = new StringBuilder();
                        while (h >= ' ' && ",:]}/\\\"[{;=#".indexOf(h) < 0) {
                            sb.append(h);
                            h = f();
                        }
                        d();
                        String trim = sb.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        }
                        return i(trim);
                    }
                }
            }
            d();
            return k();
        }
        return b(h);
    }

    public List k() {
        char c;
        char h;
        ArrayList arrayList = new ArrayList();
        char h2 = h();
        if (h2 == '[') {
            c = ']';
        } else {
            if (h2 != '(') {
                throw a("A JSONArray text must start with '['");
            }
            c = ')';
        }
        if (h() == ']') {
            return arrayList;
        }
        d();
        while (true) {
            if (h() == ',') {
                d();
                arrayList.add(null);
            } else {
                d();
                arrayList.add(j());
            }
            h = h();
            if (h == ')') {
                break;
            }
            if (h == ',' || h == ';') {
                if (h() == ']') {
                    return arrayList;
                }
                d();
            } else if (h != ']') {
                throw a("Expected a ',' or ']'");
            }
        }
        if (c == h) {
            return arrayList;
        }
        throw a("Expected a '" + c + "'");
    }

    public String toString() {
        return " at character " + this.a;
    }
}
