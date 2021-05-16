package Action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class BookInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation arg0) throws Exception {
        BookAction action=(BookAction)arg0.getAction();
        if(action.getBook().getPrice()<=10)
        {action.setMessage("价格要大于十元");return action.INPUT;}
        return arg0.invoke();
    }
}
