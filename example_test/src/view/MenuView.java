package view;
import db.CarInfoVO;
import java.util.Scanner;

public class MenuView {
    CarInfoVO[] civ_arr = null; //배열이 지역 변수로 되면 사라지기 때문에 전역변수로 설정

    /**
     * 차량 등록 갯수 메뉴 설정 메소드
     * @author 구본세
     * @param 없음
    */

    public int setCarCount() {
        //메뉴 출력
        System.out.println("차량 등록 수를 정하세요 (1~10)");
        //차량 등록을 입력할 수 있도록 설정하기(사용자 입력 필요)
        // 입력받은 사용자의 값을 통해서(CarInfoVO) 배열 갯수를 설정하여 생성해야 한다.
        civ_arr = new CarInfoVO[Integer.parseInt(usr_input())];
        System.out.println("차량 등록 가능 갯수가 총 [" + civ_arr.length +"] 칸 입니다.");
        return civ_arr.length;
    }

    /**
     * 등록한 정보 전체 출력
     */
    public void printAllCar(){
        System.out.println("등록한 차량 정보는 다음과 같습니다");
        for(int i=0;i< civ_arr.length;i++){
            System.out.println(i+1+"번째 입력 차랑 이름 : " + civ_arr[i].getCar_name());
            System.out.println(i+1+"번째 입력 차랑 가격 : " + civ_arr[i].getCar_price());
        }
    }


    /**
     *  사용자 String 입력 메소드
     *  @return
     */
    public String usr_input(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * 차량 이름 입력 메소드
     */
    public void setCarName(int i){
        //i는 main에서 받아온 순번
        System.out.println(i+1 + "번째 차량의 이름을 입력하세요");
        //차량 이름 입력하기
        String car_name = usr_input();
        // 각 배열에 설정된 car_info_vo 객체에 해당 값을 설정해주기
        CarInfoVO civ = new CarInfoVO();
        civ.setCar_name(car_name); // 프라이빗 이기 때문에 set으로 가져와서 사용자가 입력한 값 car_name을 넣어준다
        civ_arr[i] = civ;
    }

    /**
     * 차량 가격 입력 메소드
     */

    public void setCarPrice(int i){
        //i는 main에서 받아온 순번
        System.out.println(i+1 + "번째 차량 가격을 입력하세요");
        int car_price = Integer.parseInt(usr_input());
        civ_arr[i].setCar_price(car_price);
    }

    /**
     * 반복 / 종료 수행 메소드
     */

    public boolean setContinue() {
        // 사용자 입력값이 Y면 return true;
        // 사용자 입력값이 N이면 return false;
        // 사용자 입력값이 그 외의 값이면 다시 반복 입력받기
        // 사용자 입력값 받아오기
        boolean chk = true;

        while(true) {
            System.out.println("계속 하시겠습니까?(Y/N)");
            String usr_input = usr_input();
            if (usr_input.equals("Y")) {
                return true;
            } else if (usr_input.equals("N")) {
                return false;
            } else {
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
    }

//    public void


}
