package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Streams$AppendableWriter extends Writer {
    private final Appendable appendable;
    private final CurrentWrite currentWrite = new CurrentWrite();

    private static class CurrentWrite implements CharSequence {
        private String cachedString;
        private char[] chars;

        private CurrentWrite() {
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return this.chars[i];
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.chars.length;
        }

        void setChars(char[] cArr) {
            this.chars = cArr;
            this.cachedString = null;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return new String(this.chars, i, i2 - i);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            if (this.cachedString == null) {
                this.cachedString = new String(this.chars);
            }
            return this.cachedString;
        }
    }

    Streams$AppendableWriter(Appendable appendable) {
        this.appendable = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        this.appendable.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        this.appendable.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.appendable.append((char) i);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        Objects.requireNonNull(str);
        this.appendable.append(str, i, i2 + i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.currentWrite.setChars(cArr);
        this.appendable.append(this.currentWrite, i, i2 + i);
    }
}
