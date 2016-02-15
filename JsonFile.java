package ReadJSONFile;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFile {

    public static void main(String[] args) {
        
        /*{
            "Name": "ComanyList.com",
            "Author": "Arjun",
            "Company List": [
                "Compnay: eBay",
                "Compnay: Paypal",
                "Compnay: Google"
            ]
        }*/
        
        JSONParser parser = new JSONParser();
        
        try {
            Object obj = parser.parse(new FileReader("/home/nanobi/info.txt"));
            JSONObject jObj = (JSONObject) obj;
            String name = (String) jObj.get("Name");
            String author = (String)jObj.get("Author");
            
            JSONArray list = (JSONArray)jObj.get("Company List");
            
            System.out.println("Name : "+name);
            System.out.println("Author : "+author);
            System.out.println("\nCompany List :");
            Iterator <String> itr = list.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
            System.out.println(jObj.toJSONString());
        }catch(Exception e){
            e.printStackTrace();
        }        

    }

