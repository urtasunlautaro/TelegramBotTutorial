import org.telegram.telegrambots.meta.*;
import org.telegram.telegrambots.meta.exceptions.*;
import org.telegram.telegrambots.updatesreceivers.*;

public class Main {

  public static void main(String[] args) {

    try {
      TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
      botsApi.registerBot(new TelegramBotTutorial());
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }

  }

}
