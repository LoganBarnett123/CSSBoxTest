package org.fit.cssbox.test;

/**
 * 
 */


import java.io.IOException;



import org.apache.xerces.impl.Constants;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLDocumentFilter;
//import org.eclipse.jdt.annotation.NonNull;
import org.fit.cssbox.io.DOMSource;
import org.fit.cssbox.io.DefaultDOMSource;
import org.fit.cssbox.io.DocumentSource;

//import org.htmlunit.cyberneko.HTMLConfiguration;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import org.htmlunit.cyberneko.HTMLConfiguration;
import org.htmlunit.cyberneko.filters.DefaultFilter;


/**
 * Makes getElementById() work. Copied from {@link DefaultDOMSource} and
 * <a href="https://sourceforge.net/p/nekohtml/mailman/nekohtml-user/?viewmonth=201005&viewday=25">https://sourceforge.net/p/nekohtml/mailman/nekohtml-user/?viewmonth=201005&viewday=25</a>
 * 
 * @see https://github.com/radkovo/CSSBox/issues/70
 * @author Jevon
 *
 */
public class BetterDOMSource extends DOMSource {
	
	/** list of supported charsets */
	public static enum DOMCharset {
		UTF8("UTF-8"),
		;

		private String charsetString;

		DOMCharset(String string) {
			this.charsetString = string;
		}
	}
	
	/** @param charset the charset to use, not sure what this format should be */
	public BetterDOMSource(DocumentSource src, DOMCharset charset) {
		super(src);
		this.charset = charset.charsetString;
	}

	@Override
	public Document parse() throws SAXException, IOException {
		// start tweak
		HTMLConfiguration config = new HTMLConfiguration();
		
		System.out.println("01");
		
		/*XMLDocumentFilter idEnhancer = new BetterDefaultFilter() {
			
			
			private void possiblyAddIdAttribute(XMLAttributes attributes) {
				int idx = attributes.getIndex("id");
				if (idx > -1) {
					attributes.setType(idx, "ID");
					Augmentations attrsAugs = attributes.getAugmentations(idx);
					attrsAugs.putItem(Constants.ATTRIBUTE_DECLARED, Boolean.TRUE);
				}
			}
			
			@Override
			public void startElement(QName element, XMLAttributes attributes, Augmentations augs) throws XNIException {
				possiblyAddIdAttribute(attributes);
				super.startElement(element, attributes, augs);
			}

			@Override
			public void emptyElement(QName element, XMLAttributes attributes, Augmentations augs) throws XNIException {
				possiblyAddIdAttribute(attributes);
				super.emptyElement(element, attributes, augs);
			}
		};*/
		
		System.out.println("02");
		
		//XMLDocumentFilter[] filters = { idEnhancer };
		
		//config.setProperty("http://cyberneko.org/html/properties/filters", filters);

		
		System.out.println("03");
		//DOMParser parser = new DOMParser(config);
		
		
		DOMParser parser = new DOMParser();
		
		
		//parser.setProperty("http://cyberneko.org/html/properties/filters", filters);
		
		System.out.println("04");
		
		// end tweak
	//	parser.setProperty("http://cyberneko.org/html/properties/names/elems", "lower");
		if (charset != null) {
	//		parser.setProperty("http://cyberneko.org/html/properties/default-encoding", charset);
		}
		
		System.out.println("05");
		
		parser.parse(new org.xml.sax.InputSource(getDocumentSource().getInputStream()));
		
		System.out.println("06");
		
		return parser.getDocument();
	}

}