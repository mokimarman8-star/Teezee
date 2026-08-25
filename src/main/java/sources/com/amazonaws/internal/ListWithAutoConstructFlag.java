package com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class ListWithAutoConstructFlag<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1;
    private boolean autoConstruct;

    public ListWithAutoConstructFlag() {
    }

    public ListWithAutoConstructFlag(int i) {
        super(i);
    }

    public ListWithAutoConstructFlag(Collection<? extends T> collection) {
        super(collection);
    }

    public boolean isAutoConstruct() {
        return this.autoConstruct;
    }

    public void setAutoConstruct(boolean z) {
        this.autoConstruct = z;
    }
}
