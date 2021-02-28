package work.config;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * https://howtodoinjava.com/java/xml/read-xml-dom-parser-example/
 */
public class ConfigReader
{
  private String xsdPath;
  private String xmlPath;

  private Document document;

  @Inject
  public ConfigReader( @Named( "QuickTip.xsd") String iniXsdPath, @Named( "QuickTip.xml") String iniXmlPath)
  {
    xsdPath = iniXsdPath;
    xmlPath = iniXmlPath;
  }

  /**
   *
   * @param algorithm - one of "quickTipAlgorithmUL", "quickTipAlgorithmULAP", "quickTipAlgorithmAP"
   * @param parameter - the name of the particular parameter
   * @return          - the parameter integer value, if found, an could be converted to integer
   * @throws SAXException - in case of error
   */
  public int getConfigurationValue( String algorithm, String parameter) throws SAXException, NumberFormatException
  {
    int configurationValue = 0;

    if ( document == null )
    {
      readConfiguration();
    }

    NodeList nodeList = document.getElementsByTagName( algorithm);

    Node node = nodeList.item( 0); // must be exactly one, as document (XML file) has been validated

    if ( node.getNodeType() == Node.ELEMENT_NODE ) // ???
    {
      Element eElement = (Element) node;

      configurationValue = Integer.parseInt( eElement.getElementsByTagName( parameter).item(0).getTextContent());
    }

    return configurationValue;
  }

  /**
   * Reads and validates the configuration file.
   *
   * @return ???
   * @throws SAXException
   */
  private boolean readConfiguration() throws SAXException
  {
    document = null;

    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();

      Document localDocument = builder.parse( new File( xmlPath));

      SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = schemaFactory.newSchema( new File( xsdPath));

      Validator validator = schema.newValidator();
      validator.validate( new DOMSource( localDocument));

      document = localDocument;

//      NodeList nodeList = document.getElementsByTagName( "quickTipAlgorithmULAP");
//      printNodeList( nodeList);
    }
    catch ( IOException ioException)
    {
      System.err.println("Exception: " + ioException.getMessage());
      return false;
    }
    catch ( SAXException saxException)
    {
      System.err.println("SAX Exception: " + saxException.getMessage());
      return false;
    }
    catch ( ParserConfigurationException parserConfigurationException )
    {
      System.err.println("ParserConfigurationException Exception: " + parserConfigurationException.getMessage());
      return false;
    }

    return true;
  }

  private void printNodeList( NodeList nodeListToPrint)
  {
    for (int idx = 0; idx < nodeListToPrint.getLength(); idx++)
    {
      Node node = nodeListToPrint.item( idx);

      System.out.println("");

      if (node.getNodeType() == Node.ELEMENT_NODE)
      {
        Element eElement = (Element) node;
        System.out.println("Element name : "    + eElement.getNodeName());
        System.out.println("amountRandomNumbers : "  + eElement.getElementsByTagName("amountRandomNumbers").item(0).getTextContent());
        System.out.println("upperLimit : "   + eElement.getElementsByTagName("upperLimit").item(0).getTextContent());
        System.out.println("amountOfPanels : "    + eElement.getElementsByTagName("amountOfPanels").item(0).getTextContent());
      }
    }
  }

  private String getResource( String filename) throws FileNotFoundException
  {
    URL resource = getClass().getClassLoader().getResource( filename);
    Objects.requireNonNull( resource);

    return resource.getFile();
  }
}