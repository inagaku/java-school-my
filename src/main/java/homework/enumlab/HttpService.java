package homework.enumlab;

public class HttpService {
    public void handleHttpCode(int httpCode) {
        HttpCode.findByCodeIndex(httpCode/100).handleCode();
    }

    public static void main(String[] args) {
        HttpService httpService = new HttpService();
        httpService.handleHttpCode(200);

    }
}
