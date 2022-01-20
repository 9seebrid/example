package vo;

import java.io.Serializable;

public class ChatVO implements Serializable{

    private int num;
    private String sendName;
    private String receiveName;
    private String message;
    private int state;
    private String filelink;
    private String time;
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getSendName() {
        return sendName;
    }
    public void setSendName(String sendName) {
        this.sendName = sendName;
    }
    public String getReceiveName() {
        return receiveName;
    }
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getFilelink() {
        return filelink;
    }
    public void setFilelink(String filelink) {
        this.filelink = filelink;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }


}
