package org.elasticsearch.index.analysis;

public class PeliasAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    @Override public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer("pelias-analysis", PeliasAnalyzerProvider.class);
    }

}
