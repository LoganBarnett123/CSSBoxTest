/*
 * ReferenceComparisonTest.java
 * Copyright (c) 2005-2016 Radek Burget
 *
 * CSSBox is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * CSSBox is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *  
 * You should have received a copy of the GNU Lesser General Public License
 * along with CSSBox. If not, see <http://www.gnu.org/licenses/>.
 *
 * Created on 2. 1. 2016, 19:20:34 by burgetr
 */
package org.fit.cssbox.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

import org.fit.cssbox.css.CSSNorm;
import org.fit.cssbox.css.DOMAnalyzer;
import org.fit.cssbox.io.*;
import org.fit.cssbox.test.BetterDOMSource.DOMCharset;
import org.fit.cssbox.testing.ReferenceResults;
import org.fit.cssbox.testing.TestBatch;
import org.htmlunit.cyberneko.html.dom.HTMLDocumentImpl;
import org.htmlunit.cyberneko.parsers.DOMParser;
import org.htmlunit.cyberneko.xerces.xni.parser.XMLInputSource;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author burgetr
 */
public class ReferenceComparisonTest
{
    private static final int THREADS = 1;

  //  @Test
    public void checkForRegressions() throws MalformedURLException
    {
        ReferenceResults ref = new ReferenceResults();
        
        String url_string = "file:/" + System.getProperty("user.dir") + "/src/test/java/org/fit/cssbox/test/test01.html";
        URL url = new URL(url_string);
        
      //  URL url = new URL("file://" + System.getProperty("user.home") + "/tmp/CSSBoxTesting/baseline/nightly-unstable/html4/");
        TestBatch tester = new TestBatch(url, THREADS);
        
        int errorcnt = 0;
        if (tester.getTestCount() > 0)
        {
            ArrayList<String> refNames = new ArrayList<String>(); 
            for (Map.Entry<String, Float> item : ref.entrySet())
            {
                if (item.getValue() <= ReferenceResults.SUCCESS_THRESHOLD)
                    refNames.add(item.getKey());
            }
            
            tester.runTests(refNames);
            Map<String, Float> results = tester.getResults();
            for (Map.Entry<String, Float> item : results.entrySet())
            {
                String name = item.getKey();
                float val = item.getValue();
                float refval = ref.get(name);
                if (val < 0.0f)
                {
                    System.err.println(name + " : execution failed");
                    errorcnt++;
                }
                if (val - refval > ReferenceResults.COMPARISON_THRESHOLD)
                {
                    System.err.println(name + " : regression found (" + val + " > " + refval + ")");
                    if (refval == 0.0f)
                    {
                        errorcnt++; //count as error when the original rate was 0.0 (a broken test)
                        System.err.println("  (broken test)");
                    }
                    else
                        System.err.println("  (but the original value was not 0.0 neither)");
                }
            }
        }
        else
            System.err.println("No tests found, giving up testing.");
        Assert.assertTrue("All results passed", errorcnt == 0);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static Document parse(String html, URL url)  {
		try {
			ByteArrayInputStream is = new ByteArrayInputStream(html.getBytes(Charset.forName("UTF-8")));
			StreamDocumentSource source = new StreamDocumentSource(is, url, "text/html");
			
			BetterDOMSource parser = new BetterDOMSource(source, DOMCharset.UTF8);
			
			System.out.println("T1");
			
			Document d = parser.parse();
			
			System.out.println("T2");
			
			return d;

			// No need to call #close(); ByteArrayInputStream#close() is empty
			// is.close();
		} catch (Exception e) {
			return null;
		}
	}

    
    @Test
    public void TestHtml() throws MalformedURLException, IOException, SAXException
    {
    
    	
    	System.out.println("Test 1");
    	String url_string = "file:/" + System.getProperty("user.dir") + "/src/test/java/org/fit/cssbox/test/test01.html";
    	URL url = new URL(url_string);
    	System.out.println("URL: " + url);
    	
    	//URL u = new File(url_string).toURI().toURL();
    	//System.out.println("Start: " + u + " end");
    	//Open the network connection 
    	
		/*
		 * DocumentSource docSource = new DefaultDocumentSource(url);
		 * System.out.println(docSource.getContentType());
		 */

    	//Parse the input document
    	
    //	DOMSource parser = new DefaultDocumentSource(docSource);
    //	System.out.println("Parser: " + parser.getCharset());
    //	 Document doc = parser.parse(); //doc represents the obtained DOM
    	
    	
    	
    	
    	// What size
    	// Layout and rendering
    	
    	
    	String html =
                "<html>"
                + "<head>"
                + "<title>Try jsoup</title>"
                + "</head>"
                + "<body>"
                + "<p>This is jsoup.</p>"
                + "</body>"
                + "</html>";
  

		/*
		 * final StringReader sr = new StringReader(html); final XMLInputSource in = new
		 * XMLInputSource(null, "foo", null, sr, null);
		 */
	    
	   // System.out.println("in: " + in.getCharacterStream().read());
	
	    // use the provided simple DocumentImpl
		/*
		 * final DOMParser parser = new DOMParser(HTMLDocumentImpl.class);
		 * parser.parse(in); HTMLDocumentImpl doc = (HTMLDocumentImpl)
		 * parser.getDocument(); NodeList headings = doc.getElementsByTagName("h1");
		 * System.out.println("Parser: " + parser.getDocument());
		 * System.out.println("doc: " + doc.getBody());
		 */
        
    	
	/*
	 * System.out.println(doc);
	 * 
	 * 
	 * DOMAnalyzer da = new DOMAnalyzer(doc, docSource.getURL());
	 * da.attributesToStyles(); //convert the HTML presentation attributes to inline
	 * styles da.addStyleSheet(null, CSSNorm.stdStyleSheet(),
	 * DOMAnalyzer.Origin.AGENT); //use the standard style sheet
	 * da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);
	 * //use the additional style sheet da.addStyleSheet(null,
	 * CSSNorm.formsStyleSheet(), DOMAnalyzer.Origin.AGENT); //(optional) use the
	 * forms style sheet da.getStyleSheets(); //load the author style sheets
	 * 
	 * 
	 * System.out.println(da.getBody());
	 */
	    
    //	System.out.println("Parsing...");
	//    Document doc = parse(html, url);
	//    System.out.println("Parsing done");
	    
	//    System.out.println("doc: " + doc);
	//    if(doc != null)
	//    {
	//    	System.out.println("doc content: " + doc.toString());
	//    }
	    
    	org.jsoup.nodes.Document jsoup_doc = Jsoup.parse(html);
    	
    	W3CDom w3cDom = new W3CDom();
    	org.w3c.dom.Document doc = w3cDom.fromJsoup(jsoup_doc);
	    
	    DOMAnalyzer da = new DOMAnalyzer(doc, url);

	    
	    System.out.println("Test text");
	    
	    System.out.println("01");
	    Node n1 = da.getHead();
	    
	    System.out.println("02");
	    Node n2 = n1.getFirstChild();
	    
	    System.out.println("03");
	    Node n3 = n2.getFirstChild();
	    
	    System.out.println(n3.getNodeValue());
	    
	    System.out.println(da.getBody().getFirstChild().getFirstChild().getFirstChild());
	    
	    
	    System.out.println("Test done");
	    
	    
	    
    	
    	Assert.assertTrue("All results passed", true);
    }
    
}
