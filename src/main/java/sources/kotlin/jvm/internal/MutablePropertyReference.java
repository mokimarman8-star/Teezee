package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference() {
    }

    @SinceKotlin
    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    @SinceKotlin
    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ KProperty.Getter getGetter();

    public abstract /* synthetic */ KMutableProperty.Setter getSetter();
}
