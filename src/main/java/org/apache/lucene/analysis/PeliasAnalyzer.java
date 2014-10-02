package org.apache.lucene.analysis;

import org.apache.lucene.util.Version;

import java.io.Reader;

public class PeliasAnalyzer extends Analyzer {
    private Boolean cacheTokenStreams;

    public PeliasAnalyzer(Version version, Analyzer... subAnalyzers) {

    }

    @Override
    protected TokenStreamComponents createComponents(String s, Reader reader) {
        return null;
    }

    public PeliasAnalyzer setTokenStreamCachingEnabled(Boolean tokenstreamCaching) {
        cacheTokenStreams = tokenstreamCaching;
        return this;
    }

    public void setDeduplicationEnabled(Boolean deduplication) {

    }
}
