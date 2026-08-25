package com.amazonaws.services.s3.model;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class CORSRule {
    private String a;
    private List b;
    private List c;
    private int d;
    private List e;
    private List f;

    public enum AllowedMethods {
        GET("GET"),
        PUT("PUT"),
        HEAD("HEAD"),
        POST("POST"),
        DELETE("DELETE");

        private final String AllowedMethod;

        AllowedMethods(String str) {
            this.AllowedMethod = str;
        }

        public static AllowedMethods fromValue(String str) throws IllegalArgumentException {
            for (AllowedMethods allowedMethods : values()) {
                String allowedMethods2 = allowedMethods.toString();
                if (allowedMethods2 == null && str == null) {
                    return allowedMethods;
                }
                if (allowedMethods2 != null && allowedMethods2.equals(str)) {
                    return allowedMethods;
                }
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.AllowedMethod;
        }
    }

    public void a(List list) {
        this.f = list;
    }

    public void b(List list) {
        this.b = list;
    }

    public void c(List list) {
        this.c = list;
    }

    public void d(List list) {
        this.e = list;
    }

    public void e(String str) {
        this.a = str;
    }

    public void f(int i) {
        this.d = i;
    }
}
