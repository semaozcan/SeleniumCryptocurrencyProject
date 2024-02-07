package constants;

public class ErrorMessages {

    public enum ERROR_MESSAGES {
        ACCOUNT_NOT_FOUND("Binance hesabı bulunamadı."),
        ERROR_MESSAGE_NOT_VERIFIED("Hata mesajı doğrulanamadı."),
        URL_NOT_VERIFIED("URL'ler eşleşmiyor!");

        private final String message;

        ERROR_MESSAGES(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
