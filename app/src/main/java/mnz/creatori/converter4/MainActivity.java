package mnz.creatori.converter4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mnz.creatori.converter4.Models.Valute;
import mnz.creatori.converter4.Network.CbrApi;
import mnz.creatori.converter4.Network.DataLoader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private List<Valute> valutes;
    private Retrofit retrofit;
    private static CbrApi cbrApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.cbr.ru")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        cbrApi = retrofit.create(CbrApi.class);

        getApi().getData().enqueue(new Callback<List<Valute>>() {
            @Override
            public void onResponse(Call<List<Valute>> call, Response<List<Valute>> response) {

                valutes = response.body();
                tv.setText(valutes.get(0).toString());
            }

            @Override
            public void onFailure(Call<List<Valute>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });


//        valutes = new DataLoader().getValutes();
//
//        tv.setText(valutes.get(0).toString());

    }

    public static CbrApi getApi(){
        return cbrApi;
    }
}
