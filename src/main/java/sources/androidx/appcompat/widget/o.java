package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private TextView f1089a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f1090b;

    private static final class a {
        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    o(TextView textView) {
        this.f1089a = (TextView) androidx.core.util.i.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1090b;
        return textClassifier == null ? a.a(this.f1089a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1090b = textClassifier;
    }
}
