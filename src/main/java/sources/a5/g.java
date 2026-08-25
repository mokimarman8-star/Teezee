package a5;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Type;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class g {
    public Object a;
    public final g b;
    public final Object c;
    public final int d;
    public Type e;
    private transient String f;

    public g(g gVar, Object obj, Object obj2) {
        this.b = gVar;
        this.a = obj;
        this.c = obj2;
        this.d = gVar == null ? 0 : gVar.d + 1;
    }

    public String toString() {
        if (this.f == null) {
            if (this.b == null) {
                this.f = "$";
            } else if (this.c instanceof Integer) {
                this.f = this.b.toString() + "[" + this.c + "]";
            } else {
                this.f = this.b.toString() + InstructionFileId.DOT + this.c;
            }
        }
        return this.f;
    }
}
