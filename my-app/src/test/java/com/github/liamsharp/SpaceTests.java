package com.github.liamsharp;

import java.util.List;

import junit.framework.TestCase;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class SpaceTests extends TestCase
{
    
    private static final String HTML_NB_SPACE = "&nbsp;";
    private static final String SPACE = "\u0020";
    private static final String NB_SPACE =  "\u00A0";
 
    public void testHtmlNbSpace()
    {
        runSpaceTest(HTML_NB_SPACE, NB_SPACE);
    }

    public void testSpace()
    {
        runSpaceTest(SPACE, SPACE);
    }

    public void testNbSpace()
    {
        runSpaceTest(NB_SPACE, NB_SPACE);
    }
    
    private void runSpaceTest(
        final String inputSpace,
        final String expectedOutputSpace)
    {
        final String content = 
                  "<html>"
                + " <body>"
                + " <a href='before" + inputSpace + "after'>foo</a>"
                + " </body>" 
                + "</html>";
        
        final Source source = new Source(content);
        source.fullSequentialParse();
        final List<Element> h1s = source.getAllElements("a");
        
        assertTrue(!h1s.isEmpty());
        Element anchor = h1s.get(0);
        
        final String href = anchor.getAttributeValue("href");
        
        assertEquals("before" + expectedOutputSpace + "after", href);
    }

}
