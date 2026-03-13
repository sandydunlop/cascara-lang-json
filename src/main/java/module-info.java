module cascara.lang.json {
    requires transitive cascara.common;

    exports io.github.qishr.cascara.lang.json;
    exports io.github.qishr.cascara.lang.json.ast;
    exports io.github.qishr.cascara.lang.json.processor;
    exports io.github.qishr.cascara.lang.json.token;

    opens io.github.qishr.cascara.lang.json;
    opens io.github.qishr.cascara.lang.json.ast;
    opens io.github.qishr.cascara.lang.json.processor;
    opens io.github.qishr.cascara.lang.json.token;
}
