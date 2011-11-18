<%-- 
    Document   : index
    Created on : 3 Νοε 2011, 11:28:04 πμ
    Author     : BerkosDesk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

 
<html>
  <head>
     <title>Currency Converter by Antonis</title>
      <link rel="stylesheet" type="text/css" href="grafika2.css" />
  </head>
  <body>
     <form method="post" action="CurrencyConverter">
         <h2> Currency Converter</h2>
         <p>Use this form to convert any currency to Euros (€) and not only!
         </p>
          <p>Berkakis Antonis </p>
          <p>from
       <td><select name="value" >
                                 <option value="EURO" > EURO,Euro </option>
                                <option value="AED" > AED, United Arab Emirates Dirham </option>
                                <option value="AUD" > AUD, Australian Dollar </option>
                                <option value="BGN" > BGN, Bulgarian Leva </option>
                                <option value="BRL" > BRL, Brazilian Real </option>
                                <option value="CAD" > CAD, Canadian Dollar </option>
                                <option value="CHF" > CHF, Swiss Franc </option>
                                <option value="CNY" > CNY, Chinese Yuan Renminbi </option>
                                <option value="CZK"> CZK, Czech Republic Koruna </option>
                                <option value="DKK" > DKK, Danish Krone </option>
                                <option value="GBP" > GBP, British Pound Sterling </option>
                                <option value="HKD" > HKD, Hong Kong Dollar </option>
                                <option value="HRK" > HRK, Croatian Kuna </option>
                                <option value="HUF" > HUF, Hungarian Forint </option>
                                <option value="IDR" > IDR, Indonesian Rupiah </option>
                                <option value="ILS" > ILS, Israeli New Sheqel </option>
                                <option value="INR" > INR, Indian Rupee </option>
                                <option value="JPY"> JPY, Japanese Yen </option>
                                <option value="KRW"> KRW, South Korean Won </option>
                                <option value="LTL" > LTL, Lithuanian Litas </option>
                                <option value="MXN" > MXN, Mexican Peso </option>
                                <option value="MYR"> MYR, Malaysian Ringgit </option>
                                <option value="NOK"> NOK, Norwegian Krone </option>
                                <option value="NZD" > NZD, New Zealand Dollar </option>
                                <option value="PHP" > PHP, Philippine Peso </option>
                                <option value="PLN" > PLN, Polish Zloty </option>
                                <option value="RON"> RON, Romanian Leu </option>
                                <option value="RUB" > RUB, Russian Ruble </option>
                                <option value="SEK" > SEK, Swedish Krona </option>
                                <option value="SGD" > SGD, Singapore Dollar </option>
                                <option value="THB"> THB, Thai Baht </option>
                                <option value="TRY" > TRY, Turkish Lira </option>
                                <option selected="selected" value="USD" > USD, US Dollar </option>
                                <option value="LVL" > LVL, Latvian lats  </option>
                                <option value="ZAR" > ZAR, South African Ran </option>
                           
                                </select></td>
                                
                                to
       <td><select name="value2" >
                                <option selected="selected" value="EURO" > EURO,Euro </option>
                                <option value="AED" > AED, United Arab Emirates Dirham </option>
                                <option value="AUD" > AUD, Australian Dollar </option>
                                <option value="BGN" > BGN, Bulgarian Leva </option>
                                <option value="BRL" > BRL, Brazilian Real </option>
                                <option value="CAD" > CAD, Canadian Dollar </option>
                                <option value="CHF" > CHF, Swiss Franc </option>
                                <option value="CNY" > CNY, Chinese Yuan Renminbi </option>
                                <option value="CZK"> CZK, Czech Republic Koruna </option>
                                <option value="DKK" > DKK, Danish Krone </option>
                                <option value="GBP" > GBP, British Pound Sterling </option>
                                <option value="HKD" > HKD, Hong Kong Dollar </option>
                                <option value="HRK" > HRK, Croatian Kuna </option>
                                <option value="HUF" > HUF, Hungarian Forint </option>
                                <option value="IDR" > IDR, Indonesian Rupiah </option>
                                <option value="ILS" > ILS, Israeli New Sheqel </option>
                                <option value="INR" > INR, Indian Rupee </option>
                                <option value="JPY"> JPY, Japanese Yen </option>
                                <option value="KRW"> KRW, South Korean Won </option>
                                <option value="LTL" > LTL, Lithuanian Litas </option>
                                <option value="MXN" > MXN, Mexican Peso </option>
                                <option value="MYR"> MYR, Malaysian Ringgit </option>
                                <option value="NOK"> NOK, Norwegian Krone </option>
                                <option value="NZD" > NZD, New Zealand Dollar </option>
                                <option value="PHP" > PHP, Philippine Peso </option>
                                <option value="PLN" > PLN, Polish Zloty </option>
                                <option value="RON"> RON, Romanian Leu </option>
                                <option value="RUB" > RUB, Russian Ruble </option>
                                <option value="SEK" > SEK, Swedish Krona </option>
                                <option value="SGD" > SGD, Singapore Dollar </option>
                                <option value="THB"> THB, Thai Baht </option>
                                <option value="TRY" > TRY, Turkish Lira </option>
                                <option value="USD" > USD, US Dollar </option>
                                <option value="LVL" > LVL, Latvian lats  </option>
                                <option value="ZAR" > ZAR, South African Ran </option>
                           
                                </select></td>
                                

                                
                                
         <input type="hidden" name="method" value="curency">
         
         <p></p>
         Type the amount to be converted in the box
         <input type=text name="amount">
         <input type=submit>
         
     </form>
      </p>
      
       <form method="post" action="CurrencyConverter">
           <p></p>
           <input type=submit  value="?" />
           <input type="hidden" name="method" value="redirect">
           <INPUT TYPE="BUTTON" VALUE="SRC" ONCLICK="window.location.href='http://dl.dropbox.com/u/12925667/project1_WWW_Berkakis.rar'" >  
           
       </form>
      
   
        
 
      
      
      
  </body>
</html>