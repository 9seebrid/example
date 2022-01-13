package kr.co.bskoo.run;

import java.io.*;

public class MainRun {
    public static void main(String[] args) {
        //프로그램을 통해 File을 생성해보자
        //프로그램을 통해서 시스템에 파일로 출력을 하겠다 -> 프로그램쪽에서 보면 outputstream
        File dir = new File("D:\\Test");
        File file1 = new File("D:\\Test\\file1.txt");
        File file2 = new File("D:\\Test\\file2.txt");

        if(!dir.exists()) {
            dir.mkdirs();
        }

        if(!file1.exists()){ //파일 생성
            try{
                file1.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }//file1 if문 종료

        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//file2 if문 종료

        String ori_file = "C:\\Windows\\DtcInstall.log"; //복사할 원본 파일 위치
        String copy_file = "D:\\Test\\file1.txt"; // 원본을 받아와서 복사할 파일 명

        //원본 받아와서 (InputStream) --> copy 저장하기 --> (Outputstream)
        //File에 관관련하여 input, Outpt 바이트 단위로 처리하기 위한 객체 FileInputStream, FileOutputStream
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(ori_file);
            fos = new FileOutputStream(copy_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }//main 메소드 종료
}//class 종료

