package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import model.SellerStatusInfo;
import model.Seller_transferInfoBean;
@Service("SellerTranserServiceImp")
public class SellerTranserServiceImp implements SellerTranserService {

	private final static String URL="http://tangmocd.cn/seller/v1.0.0/index.php?s=/home/index/points/";
	
	@Override
	public SellerStatusInfo point(Seller_transferInfoBean transferbean) {
		
		   String str=connect(transferbean.getName(),transferbean.getPassword(), transferbean.getTrade_type(), transferbean.getSeller_id());
		   return JSON.parseObject(str,SellerStatusInfo.class);	       
	}
	
	private static String getResponse(String requsetUrl, String content) {
        try {
            URL url = new URL(requsetUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true); // 使用 URL 连接进行输出
            httpConn.setDoInput(true); // 使用 URL 连接进行输入
            httpConn.setUseCaches(false); // 忽略缓存
            httpConn.setRequestMethod("POST"); // 设置URL请求方法
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(content.getBytes("UTF-8"));
            outputStream.close();
            BufferedReader responseReader = new BufferedReader(
                    new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String readLine;
            StringBuffer responseSb = new StringBuffer();
            while ((readLine = responseReader.readLine()) != null) {
                responseSb.append(readLine);
            }
            return responseSb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }
	
	
	//单元测试 是否成功连接
	 public static void main(String[] args) {
	        String str=connect("ken", "789", 2, 4);
	       SellerStatusInfo info=JSON.parseObject(str,SellerStatusInfo.class);
	       
	        System.out.println(info.toString());
	    }

	    private static String connect(String param1,String param2,int param3,int param4){
	        StringBuilder param=new StringBuilder();
	        param.append("name="+param1+"&");
	        param.append("password="+param2+"&");
	        param.append("trade_type="+param3+"&");
	        param.append("seller_id="+param3);
	      
	        return getResponse(URL,param.toString());
	    }
	
	
}
