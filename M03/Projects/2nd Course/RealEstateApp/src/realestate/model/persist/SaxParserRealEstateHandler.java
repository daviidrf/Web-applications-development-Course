package realestate.model.persist;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Helper class for reading Estates from XML data source.
 * @author todo
 */
public class SaxParserRealEstateHandler extends DefaultHandler{

    //ATTRIBUTES
    private String temp;

    public SaxParserRealEstateHandler() {
    }
 

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }


    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String string, String string1) throws SAXException {
        
    }

    @Override
    public void endPrefixMapping(String string) throws SAXException {
        
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String string, String string1) throws SAXException {
    }

    @Override
    public void skippedEntity(String string) throws SAXException {
    }

    @Override
    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
    }

    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
    
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       
    }
    
  
}
