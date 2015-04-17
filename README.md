AFJP-lab1
======

Simple GUIs.

Random number generator - 
An activity named Random containing a button New Random. When pushing this button generates a new
random integer (1-100) and displays it. The number 100 is displayed in the middle of
the screen when the activity starts.

BMI Caluculator - 
An activity named BMI that reads two values (length and weight) and then display the corresponding
Body-Mass Index value.

A color display - 
An activity named ColorDisplay that, when button "Display Color" is pushed, reads three integer values
(0-255, red, green, blue) and then sets the corresponding color as the background color for the upper part
of the screen in portrait mode or right part of the screen in landscape mode.

Countries visited - 
An application named MyCountries that allows the user to list all countries he/she has ever visited.
The display should show a list where each entry is a country and the year when first visited. It looks
like:
1964 Sverige
1970 Finland
1979 Danmark
1980 England
1982 Norge
...
2009 Ukraine

The user adds a new country by pressing Add Country button located in the Action Bar. This action
presents a new page (Activity) where the user can add a new entry (Country + Year). A database is added to
this application in the project AFJP - lab2.

Weather app - 
The class WeatherHandler downloads an XML markup of weather data. The WeatherHandler reads the document
and constructs a WeatherReport object. The WeatherReport is a data structure containing weather data.
It contains meta data for a given location (e.g. city, country, last updated, next update) and a sequence
of WeatherForecasts.

Each WeatherForecast represents a forecast (weather, rain, wind, etc) for a given time period.
The class VaxjoWeather (extends ListActivity) is the application entry point. Currently it just askes the
WeatherHandler for a WeatherReport and prints the contained weather data (using System.out).

My task was to provide the weather app with a nice looking GUI. That is, add code to VaxjoWeather that
reads weather data from WeatherReport and constructs a (dynamic) list where each row represents a forecast
for a given time period. Download suitable weather icons from the Internet.

List of all these activities - 
A new Android project containing a list of all Activities above.
