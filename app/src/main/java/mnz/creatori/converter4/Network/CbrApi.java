package mnz.creatori.converter4.Network;


import java.util.List;

import mnz.creatori.converter4.Models.Valute;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CbrApi {

    @GET("scripts/XML_daily.asp")
    Call<List<Valute>> getData();
}
