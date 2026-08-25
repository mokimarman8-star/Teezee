package qa;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f extends Property {
    private final Matrix a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
