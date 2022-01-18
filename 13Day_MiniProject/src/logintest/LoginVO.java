package logintest;

import java.io.Serializable;

public class LoginVO implements Serializable { //Serializable화 해주어야 병렬을 직렬로 보내고 다시 병렬로 구성해서 보내줌
    //습관적으로 프라이빗으로 만들고 게터 세터 해주어야 함(캡슐화)

    private String id;
    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
