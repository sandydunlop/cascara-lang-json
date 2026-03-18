package io.github.qishr.cascara.lang.json;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import io.github.qishr.cascara.common.lang.StructuredDocument;
import io.github.qishr.cascara.common.lang.annotation.Nullable;
import io.github.qishr.cascara.common.lang.ast.CommentAstNode;
import io.github.qishr.cascara.lang.json.ast.JsonCommentNode;
import io.github.qishr.cascara.lang.json.ast.JsonMapNode;
import io.github.qishr.cascara.lang.json.ast.JsonNode;
import io.github.qishr.cascara.lang.json.ast.JsonScalarNode;
import io.github.qishr.cascara.lang.json.ast.JsonSequenceNode;

public class JsonDocument extends JsonNode implements StructuredDocument {
    private final JsonNode root;
    private URI schemaUri = null;

    public JsonDocument(JsonNode root) {
        super(root.getStartLine(), root.getStartColumn(), root.getOriginUri());
        this.root = root;
    }

    /// {@inheritDoc}
    @Override public List<JsonNode> getChildren() { return List.of(root); }

    //
    // StructuredDocument Implementation
    //

    @Override public URI getSchemaUri() {
        return schemaUri;
    }

    /// Returns the primary content node of the document.
    @Override public JsonNode getRoot() { return root; }

    //
    // Convenience Methods
    //

    @Nullable
    public JsonNode get(String key) {
        if (root instanceof JsonMapNode map) {
            return map.get(key);
        }
        return null;
    }
}