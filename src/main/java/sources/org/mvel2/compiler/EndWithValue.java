package org.mvel2.compiler;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class EndWithValue extends RuntimeException {
    private Object value;

    public EndWithValue(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }
}
