package by.pvt.lesson27;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Path("/json/{request}")
public class JsonService {

    @GET
    @Produces("application/json")  //no ";"!!!!!!

    public Collection<Address> getJSON(@PathParam("request") String request) {
        List<Address> addressList = new ArrayList<>();
        Address address1 = new Address();
        address1.setCity("Minsk");
        address1.setCountry("Belarus");
        address1.setStreet("Lenina");

        Address address2 = new Address();
        address2.setCity("Grodno");
        address2.setCountry("Belarus");
        address2.setStreet("Pushkina");

        Address address3 = new Address();
        address3.setCountry("Russia");
        address3.setCity("Moscow");
        address3.setStreet("Arbat");

        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        return addressList;
    }
}

class Main {

    public static void callRestService(String URI) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URI);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(httpResponse.getEntity().getContent()));
        String s;
        while ((s = rd.readLine()) != null) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        try {
            callRestService("http://localhost:8080/rest/echo/test?value=ebut");
            //previously created REST example

        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}


class Address {
    private String street;
    private String city;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}