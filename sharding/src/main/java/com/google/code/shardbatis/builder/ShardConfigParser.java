/**
 * 
 */
package com.google.code.shardbatis.builder;

import com.google.code.shardbatis.util.ConfigHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * @author sean.he
 * 
 */
public class ShardConfigParser {
	private static final Log log = LogFactory.getLog(ShardConfigParser.class);

	public ShardConfigHolder parse(InputStream input) throws Exception {
		ShardConfigHolder configHolder = ShardConfigHolder.getInstance();

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(true);
		spf.setNamespaceAware(true);
		SAXParser parser = spf.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		ConfigHandler handler = new ConfigHandler(configHolder);
		reader.setContentHandler(handler);
		reader.setEntityResolver(handler);
		reader.setErrorHandler(handler);
		reader.parse(new InputSource(input));

		return configHolder;
	}

}
