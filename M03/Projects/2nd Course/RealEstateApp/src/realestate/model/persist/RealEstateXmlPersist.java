package realestate.model.persist;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import realestate.model.Estate;
import realestate.model.RealEstate;
import org.xml.sax.SAXException;

/**
 * Persistence class for reading Estates from XML data source.
 * @author todo
 */
public class RealEstateXmlPersist {

    /**
     * Returns all Estates from XML fileName 
     * @param fileName XML data source for RealEstate data
     * @return List of Estate. If there is no data, ir returns an empty list.
     * In case of error accessing data source returns null.
     */
    public List<Estate> readRealEstateFromFile(File fileName){
           
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
        
            SAXParser sp = spf.newSAXParser();
            //TODO
        } catch (ParserConfigurationException ex) {
        } catch (SAXException ex) {
        }
       
        return null;
    }
}
