package org.apache.lucene.analysis;

import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by franciscodans on 01/10/2014.
 */
public class PeliasAnalyzer extends Analyzer {
    private Boolean cacheTokenStreams;

    public PeliasAnalyzer(Version version, Analyzer... subAnalyzers) {

    }

    @Override
    public TokenStream tokenStream(String s, Reader reader) {
        return null;
    }

    public PeliasAnalyzer setTokenStreamCachingEnabled(Boolean tokenstreamCaching) {
        cacheTokenStreams = tokenstreamCaching;
        return this;
    }

    public void setDeduplicationEnabled(Boolean deduplication) {

    }
}
