package io.github.qishr.cascara.lang.json.ast;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import io.github.qishr.cascara.common.lang.ast.SequenceAstNode;

public class JsonSequenceNode extends JsonNode implements SequenceAstNode<JsonNode> {
    private final List<JsonNode> items = new ArrayList<>();

    public JsonSequenceNode() { super(); }
    public JsonSequenceNode(int line, int column, URI uri) { super(line, column, uri); }

    @Override public void add(JsonNode item) { items.add(item); }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    @Override public void clear() { items.clear(); }
    @Override public int size() { return items.size(); }
    @Override public JsonNode get(int index) { return items.get(index); }
    @Override public List<JsonNode> getElements() { return items; }
    @Override public Iterable<JsonNode> items() { return items; }
    @Override public List<JsonNode> getChildren() { return items; }

    // TODO: This is in the API docs but not the API interface
    // @Override
    // public Iterator<JsonNode> iterator() {
    //     return items.iterator();
    // }
}

