import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotTutorial extends TelegramLongPollingBot {

  @Override
  public String getBotUsername() {
    //Devolvemos el usuario que configuramos en BotFather
    return "username";
  }

  @Override
  public String getBotToken() {
    //Devolvemos el token generado por BotFather
    return "token";
  }

  //Manejamos la actualización recibida y capturamos el texto y el id de la conversación
  @Override
  public void onUpdateReceived(Update update) {
    String message = update.getMessage().getText();
    Long chatId = update.getMessage().getChatId();
    System.out.println("Mensaje recibido: " + message);
    int length = message.length();
    System.out.println("El mensaje tiene " + length + " caracteres");
    sendMessage(generateSendMessage(chatId, length));
  }

  //Creamos un SendMessage con el texto que queremos enviar al chat
  private SendMessage generateSendMessage(Long chatId, int characterCount) {
    return new SendMessage(chatId.toString(), "El mensaje tiene " + characterCount + " caracteres");
  }

  //Enviamos el mensaje a la API de Telegram
  private void sendMessage(SendMessage sendMessage) {
    try {
      execute(sendMessage);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

}
