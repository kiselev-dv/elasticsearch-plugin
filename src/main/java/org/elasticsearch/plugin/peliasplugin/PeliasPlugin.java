package org.elasticsearch.plugin.peliasplugin;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.PeliasAnalysisBinderProcessor;
import org.elasticsearch.plugins.AbstractPlugin;

/**
 * Hello world!
 *
 */
public class PeliasPlugin extends AbstractPlugin
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public String name() {
        return "pelias-analysis";
    }

    @Override
    public String description() {
        return "Plugin that performs all analysis tasks in Pelias";
    }

    @Override public void processModule(Module module) {
        if (module instanceof AnalysisModule) {
            AnalysisModule analysisModule = (AnalysisModule) module;
            analysisModule.addProcessor(new PeliasAnalysisBinderProcessor());
        }
    }
}
