package org.mvel2.util;

import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class StackElement implements Serializable {
    public StackElement next;
    public Object value;

    public StackElement(StackElement stackElement, Object obj) {
        this.next = stackElement;
        this.value = obj;
    }
}
