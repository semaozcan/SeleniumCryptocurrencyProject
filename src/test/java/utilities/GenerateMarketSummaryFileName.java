package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateMarketSummaryFileName {
    public static String generateMarketSummaryFileName() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy-HH:mm");
        return "BinanceMarketSummary-" + formatter.format(now) + ".xlsx";
    }
}
