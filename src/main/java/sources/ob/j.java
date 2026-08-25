package ob;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface j {
    public static final j a = new j() { // from class: ob.i
        @Override // ob.j
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List a(ComponentRegistrar componentRegistrar);
}
