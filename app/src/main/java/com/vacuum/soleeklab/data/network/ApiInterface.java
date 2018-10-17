package com.vacuum.soleeklab.data.network;
import com.vacuum.soleeklab.data.network.model.Country;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("rest/v2/all")
    Call<List<Country>> getAllCountries();
}
