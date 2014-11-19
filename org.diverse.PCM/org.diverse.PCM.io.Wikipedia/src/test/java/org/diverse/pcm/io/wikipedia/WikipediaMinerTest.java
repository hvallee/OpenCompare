package org.diverse.pcm.io.wikipedia;

import org.diverse.pcm.api.java.PCM;
import org.diverse.pcm.io.wikipedia.WikipediaPageMiner;
import org.diverse.pcm.io.wikipedia.export.CSVExporter;
import org.diverse.pcm.io.wikipedia.export.HTMLExporter;
import org.diverse.pcm.io.wikipedia.export.PCMModelExporter;
import org.diverse.pcm.io.wikipedia.pcm.Matrix;
import org.diverse.pcm.io.wikipedia.pcm.Page;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by gbecan on 19/11/14.
 */
public class WikipediaMinerTest {

    @Test
    public void test() {
        WikipediaPageMiner miner = new WikipediaPageMiner();

        // Parse article from Wikipedia
        String code = miner.getPageCodeFromWikipedia("Comparison_of_Nikon_DSLR_cameras");
        String preprocessedCode = miner.preprocess(code);
        Page page = miner.parse(preprocessedCode);


        // HTML export
        HTMLExporter htmlExporter = new HTMLExporter();
        String html = htmlExporter.export(page);
        assertNotNull(html);

        // CSV export
        CSVExporter csvExporter = new CSVExporter();
        String csv = csvExporter.export(page);
        assertNotNull(csv);

        // PCM model export
        PCMModelExporter pcmExporter = new PCMModelExporter();
        PCM pcm = pcmExporter.export(page);
        assertNotNull(pcm);

    }

}
