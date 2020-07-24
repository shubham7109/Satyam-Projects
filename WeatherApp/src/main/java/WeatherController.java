public class WeatherController {
    public static void main(String[] args) {
        System.out.println("lol");
    }

    //TODO: Step 1
    /**
     * Print a question and the location from
     * user.
     * @return String of the location: Eg. "Dubai"
     */
    private String getLocationFromUser(){
        //TODO
        return "";
    }

    //TODO: Step 2
    //Hint: Look up how to make Java GET request: https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java
    /**
     * Make a GET request.
     * @return String of the GET response
     */
    private String makeGETRequest(){
        //TODO
        return "";
    }


    //TODO: Step 3
    /**
     * Parse the JSON String response to a
     * WeatherModel object.
     * @return A weather model object based on the response given.
     */
    private WeatherModel parseWeather(String response){
        //TODO
        return new WeatherModel();
    }

    //TODO: Step 4

    /**
     * Saves the location as a location.txt file
     * @param location Location string
     */
    private void saveLocation(String location){

    }
}
