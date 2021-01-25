# Fibonacci calculation

This app can calculate fibonacci numbers.
The currently interactive menu is working only for the default sequence [0, 1, ..., n], but the app is prepared for work upon any sequence (e.g. [-5, 8, ..., n]), all we need to do is create an instance of Fibonacci.class providing which should be the first and the second element on the list.
This apps stores previous calculations in memory, so there is no need to re-calculate everything from scratch when we request different values.


* To run directly
    * ./gradlew bootRun
* To generate runnable jar artifact under build/libs path
    * ./gradlew clean build
    
After run follow instructions on iterable menu
