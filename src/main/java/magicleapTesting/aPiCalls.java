package magicleapTesting;

import static io.restassured.RestAssured.given;

public class aPiCalls {
//
//    private final String username;   //LT_username
//    private final String accesskey; //LT_accessKey
//    private final String ApiBaseUrl;

    // Authorization with username and accesskey
    public void concurrency() {
        String username = "prateeks";
        String accesskey = "c5nvx3MGUzs8Lzv8NZVKbNiOeQaElnMtDp3nZEbwwhKc9NV8Qd";

        String ApiBaseUrl = "https://" + username + ":" + accesskey + "@stage-api.lambdatest.com/automation/api/v1/"; // API base URL with authorization
        //   given().when().get(ApiBaseUrl + "org/concurrency").then().log().body();
        System.out.println(given().when().get("Concurrency of my ORG----->> " + "   " + ApiBaseUrl + "org/concurrency").then().log().body());
    }

    // API session detail function
//    public void getSessionDetails(String sid) throws IOException {
//       // System.setOut(new PrintStream(createLogFile(sid)));
//
//        //given().when().get(ApiBaseUrl + "builds").then().log().body();       // Request to fetch all the build details
//         // Request to fetch particular session details contains command, visual, video, selenium logs
//        //given().when().get(ApiBaseUrl + "lighthouse/report/" + sid).then().log().body(); // Request to fetch performance report if exist
//        //https://${apiCredentials}@api.lambdatest.com/automation/api/v1/builds/${buildId}/sessions
//
//
//
//
//
//    }

    // Create new file to save output Data
//    private FileOutputStream createLogFile(String sid) throws FileNotFoundException {
//
//        if (new File( sid + ".json").exists()) {
//            System.out.println("file already exists");
//
//        } else {
//            return new FileOutputStream( sid + ".json");
//        }
//        return null;
//    }

}
