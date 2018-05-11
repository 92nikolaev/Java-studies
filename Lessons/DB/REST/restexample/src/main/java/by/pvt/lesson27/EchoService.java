package by.pvt.lesson27;
import javax.ws.rs.*;

//echo - просто название, не путать с башем или пхп ))

@Path("/echo/{message}") //где развернем, {} переменная часть

public class EchoService {

    @GET //запрос типа GET же
    @Produces("text/plain")  //что посылает, тип (текст в данном случае)
    public String getEcho(@PathParam("message") String message,@QueryParam("value")String value){
        //кусочек uri передается в метод, типа на вход метода
        return message+" "+message+" "+value;
        //что выходит, а именно 2 раза введенный текст
    }



}
