package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class GlideException$IndentedAppendable implements Appendable {
    private static final String EMPTY_SEQUENCE = "";
    private static final String INDENT = "  ";
    private final Appendable appendable;
    private boolean printedNewLine = true;

    GlideException$IndentedAppendable(Appendable appendable) {
        this.appendable = appendable;
    }

    @NonNull
    private CharSequence safeSequence(@Nullable CharSequence charSequence) {
        return charSequence == null ? "" : charSequence;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c) throws IOException {
        if (this.printedNewLine) {
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        }
        this.printedNewLine = c == '\n';
        this.appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(@Nullable CharSequence charSequence) throws IOException {
        CharSequence safeSequence = safeSequence(charSequence);
        return append(safeSequence, 0, safeSequence.length());
    }

    @Override // java.lang.Appendable
    public Appendable append(@Nullable CharSequence charSequence, int i, int i2) throws IOException {
        CharSequence safeSequence = safeSequence(charSequence);
        boolean z = false;
        if (this.printedNewLine) {
            this.printedNewLine = false;
            this.appendable.append(INDENT);
        }
        if (safeSequence.length() > 0 && safeSequence.charAt(i2 - 1) == '\n') {
            z = true;
        }
        this.printedNewLine = z;
        this.appendable.append(safeSequence, i, i2);
        return this;
    }
}
