package weather;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };


    public static WeatherProvider getProvider()
    {
        return WeatherProvider.weatherProvider;
    }
    private WeatherProvider()
    {
    }


    private int convertByteToInt(byte[] b)
    {
        int value= 0;
        for(int i=0; i<b.length; i++)
            value = (value << 8) | b[i];
        return value;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
        int w = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[w % 4];
    }
}