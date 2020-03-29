package ace.pinduoduo.base.api.web.application.aop;

import com.alibaba.fastjson.JSONObject;
import com.pdd.pop.sdk.http.PopBaseHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Component
@Aspect
@Slf4j
public class PinduoduoHttpClientAop {

    @Around("execution(* com.pdd.pop.sdk.http.PopClient.*Invoke(..))")
    public Object methodHandle(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
            PopBaseHttpResponse popBaseHttpResponse = (PopBaseHttpResponse) result;
            if(popBaseHttpResponse.getErrorResponse() != null){
                Object[] objects = proceedingJoinPoint.getArgs();
                String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
                String methodName = proceedingJoinPoint.getSignature().getName();
                log.error("调用拼多多接口异常,className:[{}],methodName:[{}],request:[{}],result:[{}]",
                        className, methodName, JSONObject.toJSON(objects), JSONObject.toJSON(result));
            }
        }catch (Throwable e){
            log.error("拼多多接口调用AOP拦截器异常:[{}]", e);
        }
        return result;
    }

}
