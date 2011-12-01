/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.berkos.currency;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.jdom.*;
import org.jdom.input.SAXBuilder;


/**
 *
 * @author BerkosDesk
 * plirofories gia tin roi tou kodika mporeite na vreite sto doc.html
 *diladi sto koumpi ( ? ) tis efarmogis.  
 */



public class CurrencyConverter extends HttpServlet {

    private Attribute[] attrName;
    private Attribute[] attrCurr;
    private String Date;
    private Attribute realAttrName;
    private Attribute realAtrrCurr;
    private int i;
    SAXBuilder builder;
    Document doc;
    Element root;
    List<?> alleWaehrungen;
        
    // private  final double EXCHANGE_RATE = 1.37;
    private double isotimia;
    
   
      public  void readxml() {
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
            attrName = new Attribute[alleWaehrungen.size()];
            attrCurr = new Attribute[alleWaehrungen.size()];
            for (i = 0; i < alleWaehrungen.size(); i++) {
                if (alleWaehrungen.get(i) != null) {
                    realAttrName = ((Element) alleWaehrungen.get(i))
                            .getAttribute("currency");
                   // System.out.println(realAttrName);
                } else {
                    realAttrName = null;
                }
 
                if (alleWaehrungen.get(i) != null) {
                    realAtrrCurr = ((Element) alleWaehrungen.get(i))
                            .getAttribute("rate");
                } else {
                    realAtrrCurr = null;
                }
 
                attrName[i] = (Attribute) realAttrName;
                attrCurr[i] = (Attribute) realAtrrCurr;
            }
           // System.out.println("ginete to init...!");
           
            
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     /*
      public void init() throws ServletException{
          
         readxml();
          
      }
*/
      
    
     
      
    public void doPost(HttpServletRequest req,
                      HttpServletResponse res)
              throws ServletException, IOException {
        
        
        
          // readxml(); // me ayton ton tropo arxikopoioume ta orismata!
           
                String amount = req.getParameter("amount");
                String value = req.getParameter("value");
                String value2 = req.getParameter("value2");
                String method = req.getParameter("method");
                System.out.println("ta value kai ta 1 einai " +value  );
                System.out.println("ta value kai ta 2 einai " +value2 );
           if(method.equals("redirect")){
             //  res.sendRedirect("/Curency_Converter/doc.html");
              
               Doc docc =(Doc) getServletContext().getAttribute("doccc");
               
               //System.out.println("hello");
             //  System.out.println(docc.getSRC());
              // out.println(docc.getSRC());
               res.sendRedirect(docc.getSRC());
               
               
               
               
               
               return;
           } 
           
        
        
           res.setContentType("text/html");
           PrintWriter out = res.getWriter();
           out.println("<html>");
           out.println("<head><title>Currency Conversion by Antonis</title> <link rel=\"stylesheet\" type=\"text/css\" href=\"grafika2.css\" /> </head>");
           out.println("<body>");
           
            
            
            
            
         try {
             
             
             
             readxml(); // me ayton ton tropo arxikopoioume ta orismata!
             isotimia(value,value2); // kaloume tin methodo gia na paroume tin sosti isotimia!
             
            
//_______________________  edo kanoume  tin allagi me to
               
             
              DecimalFormat df = new DecimalFormat("#.###");
             
              if(!amount.contains(".")){  
               NumberFormat nf = NumberFormat.getInstance();
               double Value = nf.parse(amount).doubleValue();
               
               System.out.println("to valueeee einai " +Value);
               Value *= 1/isotimia;
             //  System.out.println(attrName[2]);
               nf.setMaximumFractionDigits(2);
               nf.setMinimumFractionDigits(2);
               out.println("<big>" + value + " " +
                    amount + " = "+ value2 + " "+
                    nf.format(Value) + "</BIG>");
               out.println("<br></br>");
               out.println("<big>" +" the exchange rate is :" + df.format(1/isotimia) +  "</BIG>");
               
              }
              else{
                  
               
               Double Value = new Double(amount);
               
               System.out.println("to valueeee einai " +Value);
               Value *= 1/isotimia;
             //  System.out.println(attrName[2]);
              
               out.println("<big>" + value + " " +
                    amount + " = " +value2 + " "+
                    Value + "</BIG>");
               out.println("<br></br>");
               out.println("<big>" +" the exchange rate for 1&euro; is :" + df.format(1/isotimia) +  "</BIG>");
                  
                  
                  
              } 
               
               
            }
            catch (ParseException e) {
                out.println("Bad number format");
            }
            out.println("</body></html>");
       }
    
    
    
    
    private void isotimia(String value, String value2)
    {

                       if(value2.equals(value) ){ isotimia=1;}
            
            else if(value.equals("EURO") || value2.equals("EURO") ){
                 
              int j=0;
            for (int k = 0; k < attrName.length; k++) {
                
                 if(attrName[k].toString().contains(value) && !(value.equals("EURO")) ) {
                   //  System.out.println("i sotimia einai " + attrCurr[k]);
                     j=k;
                 }
                 else if(attrName[k].toString().contains(value2) && !(value2.equals("EURO")))
                 {
                     j=k;
                 }
             //   System.out.println(attrName[k]);
             //   System.out.println(attrCurr[k]);
                //System.out.println("");
            }
           
            
            // ayti i synartisi epistrefei tin isotimia....!!
            String stringNo= attrCurr[j].toString();
           // Double apot=new Double();
            String parsedNo=new String();
             String i=new String();
            for(int n=0; n<stringNo.length(); n++)
            { i = stringNo.substring(n, n+1);
                        if(i.equals("1") ||i.equals("2") ||i.equals("3") ||i.equals("4") ||i.equals("5") ||i.equals("6") ||i.equals("7") ||i.equals("8") ||i.equals("9") ||i.equals("0") ||i.equals(".") )

                                parsedNo += i;
             }
                                
                              isotimia=new Double(parsedNo);
                             if(value.equals("EURO") )  isotimia=1/isotimia;
                             
                               System.out.println("i eisotimia einai" + isotimia);

            //------------------------------------------
               
             }
             // edo exoume tis periptoseis pou den aforoun to EURO!
             else{
                 
                 Double[] isotimia1 =new Double[2];
                 
                 for(int kk=0;kk<2;kk++)
                 {
                     
                     
                        int j=0;
            for (int k = 0; k < attrName.length; k++) 
            {
                
                 if((attrName[k].toString().contains(value)   && kk==0  )    || (attrName[k].toString().contains(value2)  && kk==1  ))
                 {
                   //  System.out.println("i sotimia einai " + attrCurr[k]);
                     j=k;
                 }
             //   System.out.println(attrName[k]);
             //   System.out.println(attrCurr[k]);
                //System.out.println("");
            }
           
            
            // ayti i synartisi epistrefei tin isotimia....!!
            String stringNo= attrCurr[j].toString();
           // Double apot=new Double();
            String parsedNo=new String();
             String i=new String();
            for(int n=0; n<stringNo.length(); n++)
            { i = stringNo.substring(n, n+1);
                        if(i.equals("1") ||i.equals("2") ||i.equals("3") ||i.equals("4") ||i.equals("5") ||i.equals("6") ||i.equals("7") ||i.equals("8") ||i.equals("9") ||i.equals("0") ||i.equals(".") )

                                parsedNo += i;
             }
                                
            
                              isotimia1[kk]= isotimia1[kk].parseDouble(parsedNo);
                             System.out.println("i eisotimia einai" + isotimia1[kk]);
                             
                         //      System.out.println("i eisotimia einai" + isotimia);

            //------------------------------------------
               
             }
                     
                     isotimia=isotimia1[0]/isotimia1[1];
                     System.out.println("i eisotimia einai" + isotimia);
                     
                     
                 
                 
             
                 
                 
             }                 



    }
    
    
    
}

