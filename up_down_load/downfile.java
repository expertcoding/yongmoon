import java.io.FileOutputStream;
import java.io.File;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class downfile {
    String filepath;
    String address;
    int length;
    public downfile(){}; 
  public downfile(String Address, String path, int length) {
    address = Address;  // 주소 입력
    
    try {
      String fileName = new String(address.substring(address.lastIndexOf("/") + 1, address.length()));//URL 마지막부분에서 파일이름 추출
      URL website = new URL(address);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      filepath = new String(path);// 나중에 파라미터 화 하기
      File file = new File(filepath+fileName);     
      FileOutputStream fos = new FileOutputStream(file);
      
      fos.getChannel().transferFrom(rbc, 0, length);  // 처음부터 끝까지 다운로드 3번째 파라미터로 데이터량 조절
      fos.close();
      
      System.out.println("파일 다운로드되었음");
      
    } catch (Exception e) {
      e.printStackTrace();
    }     
    
  }
  public boolean Down(String Address, String path, int length){
    address = Address;  // 주소 입력
    
    try {
      String fileName = new String(address.substring(address.lastIndexOf("/") + 1, address.length()));//URL 마지막부분에서 파일이름 추출
      URL website = new URL(address);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      filepath = new String(path);// 나중에 파라미터 화 하기
      File file = new File(filepath+fileName);     
      FileOutputStream fos = new FileOutputStream(file);
      
      fos.getChannel().transferFrom(rbc, 0, length);  // 처음부터 끝까지 다운로드 3번째 파라미터로 데이터량 조절
      fos.close();
      
      System.out.println("파일 다운로드되었음");
      return true;
      
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }        

  }



  public String getAddress(){

    return address;
  }
  public String getPath(){

    return filepath;
  } 
  public int getLength(){

    return length;
  }
}

//버퍼가 없어서 받는용량 조절이 안됨. 저장은 가능
// no exist buffer in chnnel method, can't control receive amount of data.  but possible store
//설정한 데이터 블록 사이즈가 1000이고 파일 용량이 1200이면 1200만큼 수신 1000을 저장, 200은 버려짐 
// if set block size is 1000, and download file is 1200. we download 1200, and store 1000 and 
//Throw away 200
//이론적으로는 그런거 같다. 
//can't finded to test upload
//나중에 클래스 형식으로 바꾸면서 파일패스와 파일네임은 리턴 함수 생성하기
