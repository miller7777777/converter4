package mnz.creatori.converter4.Network;


import java.util.ArrayList;
import java.util.List;

import mnz.creatori.converter4.Models.Valute;
import retrofit2.Retrofit;

public class DataLoader {
    private Retrofit retrofit;


    public List<Valute> getValutes() {

        return fakeData();
    }

    private List<Valute> fakeData() {
        List<Valute> fakeValutes = new ArrayList<>();
        fakeValutes.add(new Valute("36", "643", "RUB", "1", "Российский Рубль", "1.0"));

        return fakeValutes;
    }
}
