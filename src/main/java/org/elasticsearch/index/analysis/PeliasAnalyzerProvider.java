package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.PeliasAnalyzerWrapper;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Injector;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;

public class PeliasAnalyzerProvider extends AbstractIndexAnalyzerProvider<PeliasAnalyzerWrapper> {

    private final String name;
    private final Injector injector;
    private final Settings settings;

    @Inject
    PeliasAnalyzerProvider(Index index,
                           @IndexSettings Settings indexSettings,
                           @Assisted String name,
                           @Assisted Settings settings,
                           Injector injector){
        super(index, indexSettings, name, settings);
        this.injector = injector;
        this.settings = settings;
        this.name = name;
    }

    @Override
    public PeliasAnalyzerWrapper get() {
        return new PeliasAnalyzerWrapper(version, name, settings, injector);
    }
}
