package com.berkos.currency;



import java.io.IOException;
import java.util.List;
 import java.io.*;
 import java.lang.*;
import java.lang.Double;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
 
public class German {
    private Attribute[] waehrungsName;
    private Attribute[] waehrungsKurs;
    private String Datum;
    private Attribute aktuellerWaehrungsName;
    private Attribute aktuellerWaehrungsKurs;
    private int i;
    SAXBuilder builder;
    Document doc;
    Element root;
    List<?> alleWaehrungen;
 
    public void readxml() {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = new Document();
            doc = builder
                    .build("http://www.ecb.int/stats/eurofxref/eurofxref-daily.xml");
            Element root = new Element("root");
            root = doc.getRootElement();
            Namespace ns = Namespace
                    .getNamespace("http://www.ecb.int/vocabulary/2002-08-01/eurofxref");
            alleWaehrungen = root.getChild("Cube", ns).getChild("Cube", ns)
                    .getChildren();
            waehrungsName = new Attribute[alleWaehrungen.size()];
            waehrungsKurs = new Attribute[alleWaehrungen.size()];
            for (i = 0; i < alleWaehrungen.size(); i++) {
                if (alleWaehrungen.get(i) != null) {
                    aktuellerWaehrungsName = ((Element) alleWaehrungen.get(i))
                            .getAttribute("currency");
                   // System.out.println(aktuellerWaehrungsName);
                } else {
                    aktuellerWaehrungsName = null;
                }
 
                if (alleWaehrungen.get(i) != null) {
                    aktuellerWaehrungsKurs = ((Element) alleWaehrungen.get(i))
                            .getAttribute("rate");
                } else {
                    aktuellerWaehrungsKurs = null;
                }
 
                waehrungsName[i] = (Attribute) aktuellerWaehrungsName;
                waehrungsKurs[i] = (Attribute) aktuellerWaehrungsKurs;
            }
            for (i = 0; i < waehrungsName.length; i++) {
                System.out.println(waehrungsName[i]);
                System.out.println(waehrungsKurs[i]);
                System.out.println("");
            }
           
            String stringNo= waehrungsKurs[2].toString();
           // Double apot=new Double();
            String parsedNo=new String();
             String i=new String();
            for(int n=0; n<stringNo.length(); n++)
               
            { i = stringNo.substring(n, n+1);
                        if(i.equals("1") ||i.equals("2") ||i.equals("3") ||i.equals("4") ||i.equals("5") ||i.equals("6") ||i.equals("7") ||i.equals("8") ||i.equals("9") ||i.equals("0") ||i.equals(".") )

                                parsedNo += i;
                        }
                                
                                        Double apot=new Double(parsedNo);
                               System.out.println( apot);

            
            
            
            
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}