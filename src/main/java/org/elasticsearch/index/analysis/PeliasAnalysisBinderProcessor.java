package org.elasticsearch.index.analysis;

import org.elasticsearch.apache.lucene.analysis.PeliasAnalyzerWrapper;

public class PeliasAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    @Override public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer(PeliasAnalyzerWrapper.NAME, PeliasAnalyzerProvider.class);
    }

}
