package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Analyzer;

public class PeliasAnalyzerProvider implements AnalyzerProvider {
    @Override
    public String name() {
        return null;
    }

    @Override
    public AnalyzerScope scope() {
        return null;
    }

    @Override
    public Analyzer get() {
        return null;
    }
}
