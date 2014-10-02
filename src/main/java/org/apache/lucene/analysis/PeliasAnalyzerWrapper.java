package org.apache.lucene.analysis;

import org.apache.lucene.util.Version;
import org.elasticsearch.ElasticSearchIllegalArgumentException;
import org.elasticsearch.common.inject.Injector;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.ESLoggerFactory;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.AnalysisService;
import org.elasticsearch.index.analysis.NamedAnalyzer;

import java.io.Reader;
import java.util.ArrayList;

public class PeliasAnalyzerWrapper extends Analyzer{

    public static final String NAME = "pelias-analysis";

    private final ESLogger logger;
    private final Settings settings;
    private final String name;
    private final Injector injector;
    private final Version version;

    private PeliasAnalyzer analyzer;

    @Override
    public TokenStream tokenStream(String s, Reader reader) {
        return null;
    }

    public PeliasAnalyzerWrapper(Version version, String name, Settings settings, Injector injector){

        logger = ESLoggerFactory.getLogger(NAME + ">" + name);

        this.name = name;
        this.version = version;
        this.injector = injector;
        this.settings = settings;
        this.analyzer = null;
    }

    synchronized protected void init(){
        if(analyzer != null) return;
        AnalysisService analysisService = injector.getInstance(AnalysisService.class);
        String[] sub = settings.getAsArray("sub_analyzers");
        ArrayList<Analyzer> subAnalyzers = new ArrayList<Analyzer>();

        if (sub == null) {
            throw new ElasticSearchIllegalArgumentException("Analyzer ["+name+"] analyzer of type ["+NAME+"], must have a \"sub_analyzers\" list property");
        }

        for (String subname: sub){
            NamedAnalyzer analyzer = analysisService.analyzer(subname);
            if(analyzer == null){
                logger.debug("Sub-analyzer \""+subname+"\" not found");
            }
            else{
                subAnalyzers.add(analyzer);
            }
        }

        this.analyzer = new PeliasAnalyzer(version, subAnalyzers.toArray(new Analyzer[subAnalyzers.size()]));

        Boolean tokenstreamCaching = settings.getAsBoolean("deduplication", null);
        if (tokenstreamCaching != null){
            this.analyzer.setTokenStreamCachingEnabled(tokenstreamCaching);
        }

        Boolean deduplication = settings.getAsBoolean("deduplication", null);
        if (deduplication != null) {
            this.analyzer.setDeduplicationEnabled(deduplication);
        }
    }

    protected ReusableAnalyzerBase.TokenStreamComponents createComponents(String fieldName, Reader reader) {
        if (analyzer == null) init();
        return null;
        // return this.analyzer.createComponents(fieldName, reader);
    }

    @Override
    public void close() {
        if(analyzer == null) init();
        super.close();
    }


}
