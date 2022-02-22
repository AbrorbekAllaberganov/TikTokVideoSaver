package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import payload.ResponseDTO;
import service.TIkTokService;

public class ApplicationBot extends TelegramLongPollingBot {
    private final String USERNAME = "Bot username";
    private final String TOKEN = "Bot Token";


    @Override
    public String getBotUsername() {
        return this.USERNAME;
    }

    @Override
    public String getBotToken() {
        return this.TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        TIkTokService tIkTokService=new TIkTokService();
        if(update.getMessage()!=null&&update.hasMessage()){
            Message message=update.getMessage();
            String text=message.getText();
            long chat_id=message.getChatId();

            if (text.equals("/start")){
                SendMessage sendMessage=new SendMessage(String.valueOf(chat_id),"Menga Tik Tokdan video linkini yubroing");
                executeSendMessage(sendMessage);
            }else {
                ResponseDTO responseDTO=tIkTokService.saveVideo(text);
                try {
                    SendVideo sendVideo=new SendVideo();
                    sendVideo.setChatId(String.valueOf(chat_id));
                    sendVideo.setVideo(new InputFile(responseDTO.getNoWatermarkDownloadUrl().get(0)));
                    sendVideo.setCaption(responseDTO.getDescription()+"\n"+text);
                    executeSendVideo(sendVideo);
                }catch (Exception e){
                    SendMessage sendMessage=new SendMessage();
                    sendMessage.setChatId(String.valueOf(chat_id));
                    sendMessage.setText("Bu url xato");
                    executeSendMessage(sendMessage);
                }
            }

        }
    }


    public void executeSendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executeSendVideo(SendVideo sendVideo) {
        try {
            execute(sendVideo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
