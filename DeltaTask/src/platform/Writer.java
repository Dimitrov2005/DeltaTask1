package platform;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Writer {
    public static void main(String[] args) {
        ArrayList<Person>personArrayList=new ArrayList<>();
        ArrayList<LegalEntity>legalEntities=new ArrayList<>();
        Scanner console = new Scanner(System.in);
        int clientNumber;
        boolean hasPaid;
        String address;
        double servicePrice;
        boolean isLegalEntity;
        String serviceName;
        Service service;
        String quest;

      doe:  do{
            System.out.println("More clients ? YES/NO");
            quest=console.nextLine();
            if(quest.equalsIgnoreCase("no"))
                break doe;

        System.out.println("Legal entity : true/false ");
        isLegalEntity=Boolean.parseBoolean(console.nextLine());
        if (!isLegalEntity){
            System.out.println("enter person number");
            clientNumber=Integer.parseInt(console.nextLine());
            System.out.println("enter person address \n");
            address=console.nextLine();
            System.out.println("does the person pay now ? \n");
            hasPaid=Boolean.parseBoolean(console.nextLine());
            System.out.println("enter service name: SILVER,GOLD,PLATINUM \n");
            serviceName=console.nextLine();
              switch (serviceName) {
                  case "SILVER":
                      servicePrice = 100.0;
                      service = new Service(Service.Services.SILVER);
                      break;
                  case "GOLD":
                      servicePrice = 200.0;
                      service = new Service(Service.Services.GOLD);
                      break;
                  case "PLATINUM":
                      servicePrice = 300.0;
                      service = new Service(Service.Services.PLATINUM);
                      break;
                      default:
                          servicePrice=0.0;
                          service=null;
                          break;
              }

            personArrayList.add(new Person(address,clientNumber,hasPaid,
                    new Bill(servicePrice,!hasPaid,clientNumber),service,
                    new PurchaseOrder(servicePrice,serviceName,clientNumber)));


        }
        else if(isLegalEntity){
            System.out.println("enter Legal Entity number");
            clientNumber=Integer.parseInt(console.nextLine());
            System.out.println("enter LE address \n");
            address=console.nextLine();
            System.out.println("does the LE pay now ? \n");
            hasPaid=Boolean.parseBoolean(console.nextLine());
            System.out.println("enter service name: SILVER,GOLD,PLATINUM \n");
            serviceName=console.nextLine();
            switch (serviceName) {
                case "SILVER":
                    servicePrice = 100.0;
                    service = new Service(Service.Services.SILVER);
                    break;
                case "GOLD":
                    servicePrice = 200.0;
                    service = new Service(Service.Services.GOLD);
                    break;
                case "PLATINUM":
                    servicePrice = 300.0;
                    service = new Service(Service.Services.PLATINUM);
                    break;
                default:
                    servicePrice=0;
                    service=null;
                    break;
            }
            LegalEntity entity = new LegalEntity(String.valueOf(clientNumber),address,new Bill(servicePrice,!hasPaid,clientNumber),
                    new Invoice(serviceName,servicePrice,clientNumber),service);
            System.out.println("does the LE have another address and number, if so, how many ?");
            int addressCounter=Integer.parseInt(console.nextLine());
                if(addressCounter!=0){
                    for (int i=0;i<addressCounter;i++){
                        System.out.printf("enter address # %d ",addressCounter );
                        String temp = console.nextLine();
                        entity.addAnotherAddress(entity,temp);
                        System.out.printf("enter number # %d",addressCounter);
                        temp=console.nextLine();
                        entity.addAnotherNumber(entity,temp);
                    }
                }
             legalEntities.add(entity);
        }

        }while(quest.equalsIgnoreCase("YES"));

       ObjectMapper mapper = new ObjectMapper();
       mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        try {
            mapper.writeValue(new File("D:\\PersonList.json"), personArrayList);
        } catch (IOException e) {
            e.printStackTrace();
       }
       ObjectMapper mapper1 = new ObjectMapper();
        mapper1.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        try{
            mapper.writeValue(new File("D:\\LegalEntities.json"),legalEntities);
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }

    }
}



