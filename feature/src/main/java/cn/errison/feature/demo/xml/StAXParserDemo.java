package cn.errison.feature.demo.xml;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

public class StAXParserDemo {

    private static List<Website> parse(String xmlName) throws XMLStreamException {
        Website website = null;
        List<Website> websites = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(DomParserDemo.class.getClassLoader().getResourceAsStream(xmlName));
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "website":
                        website = new Website();
                        Attribute url = startElement.getAttributeByName(new QName("url"));
                        if (url != null) {
                            website.setUrl(url.getValue());
                        }
                        break;
                    case "name":
                        nextEvent = reader.nextEvent();
                        website.setName(nextEvent.asCharacters().getData());
                        break;
                    case "category":
                        nextEvent = reader.nextEvent();
                        website.setCategory(nextEvent.asCharacters().getData());
                        break;
                    case "status":
                        nextEvent = reader.nextEvent();
                        website.setStatus(nextEvent.asCharacters().getData());
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("website")) {
                    websites.add(website);
                }
            }
        }
        return websites;
    }

    public static void main(String[] args) throws Exception {
        List<Website> websites = parse("websites.xml");
        System.out.println(websites);
    }
}
