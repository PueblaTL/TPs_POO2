package tp7.ejercicio1_observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherChannelService implements ClimaOnline {
 private final String apiKey = "fe5977a32fa675be10931c0c61ac9cc2";
 private final String ciudad = "Viedma,Argentina";

 @Override
 public String temperatura() {
  try {
   String endpoint = String.format(
           "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=%s",
           ciudad, apiKey);

   URL url = new URL(endpoint);
   HttpURLConnection conn = (HttpURLConnection) url.openConnection();
   conn.setRequestMethod("GET");

   BufferedReader in = new BufferedReader(
           new InputStreamReader(conn.getInputStream()));
   StringBuilder response = new StringBuilder();
   String line;
   while ((line = in.readLine()) != null) response.append(line);
   in.close();

   JSONObject root = new JSONObject(response.toString());
   double temp = root.getJSONObject("main").getDouble("temp");
   return String.format("%.1f c", temp);

  } catch (Exception e) {
   e.printStackTrace();
   return "N/D";
  }
 }
}
