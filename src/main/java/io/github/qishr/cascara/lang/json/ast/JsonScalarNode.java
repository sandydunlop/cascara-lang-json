package io.github.qishr.cascara.lang.json.ast;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import io.github.qishr.cascara.common.lang.QuoteStyle;
import io.github.qishr.cascara.common.lang.ast.ScalarAstNode;
import io.github.qishr.cascara.lang.json.JsonPrimitive;

public class JsonScalarNode extends JsonNode implements ScalarAstNode<JsonNode> {
    private String raw;
    private JsonPrimitive primitive;
    private QuoteStyle quoteStyle = QuoteStyle.PLAIN;

    public JsonScalarNode(URI uri, int line, int column, String raw, String unescapedContent, QuoteStyle quoteStyle) {
        super(uri, line, column);
        this.raw = raw;
        this.primitive = new JsonPrimitive(unescapedContent, quoteStyle);
        this.quoteStyle = quoteStyle;
    }

    public JsonScalarNode(String stringValue) {
        super(null, 0, 0);
        this.raw = stringValue;
        this.primitive = new JsonPrimitive(stringValue, QuoteStyle.PLAIN);
    }

    public JsonScalarNode() {
        super(null, 0, 0);
        this.raw = null;
        this.primitive = new JsonPrimitive(null, QuoteStyle.PLAIN);
    }

    @Override
    public List<JsonNode> getChildren() {
        return List.of();
    }

    @Override
    public QuoteStyle getQuoteStyle() {
        return quoteStyle;
    }

    @Override
    public void setQuoteStyle(QuoteStyle style) {
        this.quoteStyle = style;
    }

    @Override
    public String getRaw() {
        return raw;
    }

    @Override
    public void setRaw(String newValue) {
        this.raw = newValue;
    }

    @Override
    public Object getPrimitive() {
        return primitive.unwrap();
    }

    @Override
    public void setPrimitive(Object value) {
        this.primitive = new JsonPrimitive(value, this.quoteStyle);
        this.raw = null;
    }

    /// Returns the logical clean text value, stripped of outer formatting and escape markers.
    @Override
    public String getString() {
        return primitive.asString();
    }

    @Override
    public int getInteger() {
        return getInteger(0);
    }

    @Override
    public int getInteger(int defaultValue) {
        return primitive.asInteger(defaultValue);
    }

    @Override
    public double getDouble() {
        return getDouble(0.0);
    }

    @Override
    public double getDouble(double defaultValue) {
        return primitive.asDouble(defaultValue);
    }

    @Override
    public boolean getBoolean() {
        return getBoolean(false);
    }

    @Override
    public boolean getBoolean(boolean defaultValue) {
        return primitive.asBoolean(defaultValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonScalarNode that)) return false;
        return Objects.equals(raw, that.raw) && Objects.equals(primitive, that.primitive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raw, primitive);
    }

    /// {@inheritDoc}
    @Override
    public String toString() {
        return raw;
    }
}