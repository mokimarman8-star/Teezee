package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.util.Date;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class DefaultDateTypeAdapter$DateType<T extends Date> {
    public static final DefaultDateTypeAdapter$DateType<Date> DATE = new DefaultDateTypeAdapter$DateType<Date>(Date.class) { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType.1
        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType
        protected Date deserialize(Date date) {
            return date;
        }
    };
    private final Class<T> dateClass;

    protected DefaultDateTypeAdapter$DateType(Class<T> cls) {
        this.dateClass = cls;
    }

    private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
        return TypeAdapters.newFactory((Class) this.dateClass, (TypeAdapter) defaultDateTypeAdapter);
    }

    public final TypeAdapterFactory createAdapterFactory(int i) {
        return createFactory(new DefaultDateTypeAdapter<>(this, i, (DefaultDateTypeAdapter.1) null));
    }

    public final TypeAdapterFactory createAdapterFactory(int i, int i2) {
        return createFactory(new DefaultDateTypeAdapter<>(this, i, i2, (DefaultDateTypeAdapter.1) null));
    }

    public final TypeAdapterFactory createAdapterFactory(String str) {
        return createFactory(new DefaultDateTypeAdapter<>(this, str, (DefaultDateTypeAdapter.1) null));
    }

    public final TypeAdapterFactory createDefaultsAdapterFactory() {
        return createFactory(new DefaultDateTypeAdapter<>(this, 2, 2, (DefaultDateTypeAdapter.1) null));
    }

    protected abstract T deserialize(Date date);
}
