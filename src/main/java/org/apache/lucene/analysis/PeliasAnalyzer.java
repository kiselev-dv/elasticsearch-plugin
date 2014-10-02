package org.apache.lucene.analysis;

import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.miscellaneous.WordDelimiterFilter;
import org.apache.lucene.analysis.synonym.SynonymFilter;
import org.apache.lucene.analysis.synonym.SynonymMap;
import org.apache.lucene.util.Version;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Reader;


public class PeliasAnalyzer extends Analyzer {
    private final Version version;

    public PeliasAnalyzer(Version version) {
        this.version = version;
    }


    @Override
    protected TokenStreamComponents createComponents(String fieldName,
                                                     Reader reader) {
        Tokenizer source = new WhitespaceTokenizer(version, reader);
        TokenStream filter = new LowerCaseFilter(version, source);
        //TODO AMPERSAND FILTER
        filter = new WordDelimiterFilter(version, filter, 0, null);
//        SynonymMap synonymMap = null;
//        try {
//            synonymMap = new SynonymMap(new FileInputStream("samples/fulltext/wn_s.pl"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        filter = new SynonymFilter(filter, );

        return new TokenStreamComponents(source, filter);
    }
}
