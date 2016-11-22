package com.github.liamsharp;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        final String content = 
                  "<html>"
                + " <head> "
                + "  <style type=\"text/css\">"
                // This line causes the whole doc to be ignored
                + "<!-- "
                + "  body {"
                + "  background-color: yellow;"
                + "  }"
                + "  </style>"
                + "  </head>"
                + " <body>"
                + " <h1>foo</h1>"
                + " </body>" 
                + " <script>" 
                + " -->"
                + " </script>" 
                + "</html>";
        
        final Source source = new Source(content);
        source.fullSequentialParse();
        final List<Element> h1s = source.getAllElements("h1");
        assertTrue(!h1s.isEmpty());
    }
}
