import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.net.URL;

public class WeatherApp {

    private static final String CITY_CODE = "294021"; //Moscow
    private static final String API_KEY = "3wHMyNLiSNlyT3riDm0mDPVQiBBRwgeo";

    public static String getWeather() throws IOException {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();

            URL url = new HttpUrl.Builder()
                    .scheme("http")
                    .host("dataservice.accuweather.com")
                    .addPathSegments("forecasts/v1/daily/5day")
                    .addPathSegments(CITY_CODE)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-RU")
                    .addQueryParameter("details", "false")
                    .addQueryParameter("metric", "false")
                    .build().url();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) {
            return new String("Не удалось получить информацию");
        }
    }
}
