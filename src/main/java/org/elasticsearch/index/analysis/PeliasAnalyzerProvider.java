package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.PeliasAnalyzer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.Injector;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.settings.IndexSettings;

public class PeliasAnalyzerProvider extends AbstractIndexAnalyzerProvider<PeliasAnalyzer> {

    private final String name;
    private final Injector injector;
    private final Settings settings;

    private final PeliasAnalyzer analyzer;

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

        this.analyzer = new PeliasAnalyzer(version);
    }

    @Override
    public PeliasAnalyzer get() {
        return this.analyzer;
    }
}
