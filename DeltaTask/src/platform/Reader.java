package platform;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
//  static ArrayList<Person> personList=new ArrayList<>();
 // static ArrayList<LegalEntity>legalEntities=new ArrayList<>();

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("enter list to read : \n1.Person List\n2.Legal Entity list");
        String temp = console.nextLine();
        if(temp.equals("1"))
        try {

            JsonFactory jfactory = new JsonFactory();
            JsonParser jparser = jfactory.createJsonParser(new File("D:\\PersonList.json"));

               while (jparser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jparser.getCurrentName();

                if("address".equals(fieldName)){
                    jparser.nextToken();
                    System.out.println("Client Address : "+jparser.getText());
                }
                if ("clientNumber".equals(fieldName)) {
                    jparser.nextToken();
                    System.out.println("Client Number : "+jparser.getText());
                }
                if("hasPaid".equals(fieldName)){
                    jparser.nextToken();
                    System.out.println("The client has paid: "+jparser.getText());
                }
                if ("bill".equals(fieldName))
                {
                    jparser.nextToken();
                    System.out.println("\n ++BILL++ ");
                    while (jparser.nextToken()!=JsonToken.END_OBJECT) {
                        System.out.println(jparser.getText());
                    }
                }
                 if("service".equals(fieldName)){
                    jparser.nextToken();
                     System.out.println("\n ++SERVICE INFORMATION++ ");
                        while (jparser.nextToken() != JsonToken.END_OBJECT) {
                            System.out.println(jparser.getText());
                        }
                }

                if("purchaseOrder".equals(fieldName)){
                    jparser.nextFieldName();
                    System.out.println("\n ++PURCHASE ORDER++ ");
                    while (jparser.nextToken()!=JsonToken.END_OBJECT) {
                        System.out.println(jparser.getText());
                    }
                }
            }
            jparser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       // personList.add(new Person())
        else if(temp.equals("2")){
            int clNumber;
            ArrayList<String> clAddress=new ArrayList<>();
            boolean hasPaid;
            String sName;
            try {

                JsonFactory jfactory = new JsonFactory();
                JsonParser jparser = jfactory.createJsonParser(new File("D:\\LegalEntities.json"));

                while (jparser.nextToken() != JsonToken.END_ARRAY) {
                    String fieldName = jparser.getCurrentName();

                    if("services".equals(fieldName)){
                        sName=jparser.nextTextValue();
                        System.out.println("Client is using service : "+sName);
                    }

                    if("hasPaid".equals(fieldName)){
                        jparser.nextToken();
                        hasPaid=jparser.getValueAsBoolean();
                        System.out.println("client has paid : "+hasPaid);
                    }
                    if ("numberArray".equals(fieldName)) {
                        jparser.nextToken();
                        while(jparser.nextToken()!=JsonToken.END_ARRAY) {
                        clNumber=Integer.parseInt(jparser.getText());
                            System.out.println("client number : " +clNumber);
                        }

                    }
                    if("addressArray".equals(fieldName)){
                        jparser.nextToken();
                        while(jparser.nextToken()!=JsonToken.END_ARRAY) {
                            clAddress.add(jparser.getText());
                            System.out.println("Client addresses:"+clAddress);

                        }clAddress.clear();
                    }
                    if("invoice".equals(fieldName)){
                        jparser.nextFieldName();
                        System.out.println("\n++INVOICE++");
                        while (jparser.nextToken()!=JsonToken.END_OBJECT) {
                            System.out.println(jparser.getText());
                        }
                    }
                    if ("bill".equals(fieldName))
                    {
                        jparser.nextToken();
                        System.out.println("\n++BILL++");
                        while (jparser.nextToken()!=JsonToken.END_OBJECT) {
                            System.out.println(jparser.getText());
                        }
                    }
                }
                jparser.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }//legalEntities.add(new LegalEntity())

    }
}
