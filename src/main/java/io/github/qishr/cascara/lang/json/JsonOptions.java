package io.github.qishr.cascara.lang.json;

import io.github.qishr.cascara.common.lang.LanguageOptions;

public class JsonOptions extends LanguageOptions<JsonOptions> {
    private boolean allowUnicode = true;
    private boolean strict = false;

    /// Sets whether unicode characters are allowed in scalars.
    public JsonOptions setAllowUnicode(boolean val) {
        this.allowUnicode = val;
        return this;
    }

    public JsonOptions setStrict(boolean val) {
        this.strict = val;
        return this;
    }

    public boolean isAllowUnicode() { return allowUnicode; }
    public boolean isStrict() { return strict; }
}