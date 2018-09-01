package com.climapp.stefandraghici.climapp;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherModel
{
    private String temperature;
    private int contidion;
    private String city;
    private String iconName;

    public static WeatherModel fromJSON(JSONObject jsonObject)
    {
        try
        {
            WeatherModel weatherModel=new WeatherModel();
            weatherModel.city=jsonObject.getString("name");
            weatherModel.contidion=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherModel.iconName=updateWeatherIcon(weatherModel.contidion);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherModel.temperature=Integer.toString(roundedValue);
            return weatherModel;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300)
        {
            return "tstorm1";
        }
        else if (condition >= 300 && condition < 500)
        {
            return "light_rain";
        }
        else if (condition >= 500 && condition < 600)
        {
            return "shower3";
        }
        else if (condition >= 600 && condition <= 700)
        {
            return "snow4";
        }
        else if (condition >= 701 && condition <= 771)
        {
            return "fog";
        }
        else if (condition >= 772 && condition < 800)
        {
            return "tstorm3";
        }
        else if (condition == 800)
        {
            return "sunny";
        }
        else if (condition >= 801 && condition <= 804)
        {
            return "cloudy2";
        }
        else if (condition >= 900 && condition <= 902)
        {
            return "tstorm3";
        }
        else if (condition == 903)
        {
            return "snow5";
        }
        else if (condition == 904)
        {
            return "sunny";
        }
        else if (condition >= 905 && condition <= 1000)
        {
            return "tstorm3";
        }
        return "dunno";
    }


    public String getTemperature()
    {
        return temperature;
    }

    public void setTemperature(String temperature)
    {
        this.temperature = temperature;
    }

    public int getContidion()
    {
        return contidion;
    }

    public void setContidion(int contidion)
    {
        this.contidion = contidion;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getIconName()
    {
        return iconName;
    }

    public void setIconName(String iconName)
    {
        this.iconName = iconName;
    }
}
