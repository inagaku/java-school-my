package homework.enumlab;

/**
 * @author Evgeny Borisov
 */
public enum HttpCode {
    INFO(1), SUCCESS(2), REDIRECTION(3), CLIENT_ERROR(4), SERVER_ERROR(5);

    private int codeIndex;

    HttpCode(int codeIndex) {
        this.codeIndex = codeIndex;
    }

    public void handleCode() {
        System.out.println(this.toString() + " is handled");
    }

    public static HttpCode findByCodeIndex(int codeIndex) {
        HttpCode[] codes = values();
        for (HttpCode status : codes) {
            if (status.codeIndex == codeIndex) {
                return status;
            }
        }
        throw new IllegalStateException(codeIndex + " is invalid");
    }

}
