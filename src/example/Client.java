


package example;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

    public class Client {

        public static void main(String[] args) {
            Service service = new Service();
            try {
                Call call = (Call)service.createCall();
                //设置地址
                call.setTargetEndpointAddress("http://localhost:8080/services/HelloWorld?wsdl");
                //设置要执行的方法(以下两种方式都可以)
                call.setOperationName("sayHelloWorldFrom");
//            call.setOperationName(new QName("http://server.ws.javalab.codefish.com","sayHelloWorldFrom"));
                //设置要传入参数,如果没有要传入的参数，则不要写这个（参数名、参数类型、ParameterMode）
                call.addParameter("from", org.apache.axis.Constants.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
                //设置返回的类型
                call.setReturnType(org.apache.axis.Constants.XSD_STRING);
                //调用WebService服务
                String from = "呆某人";
                String result = (String) call.invoke(new Object[]{from});
                System.out.println(result);
            } catch (ServiceException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

