package cn.lvxg.development;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(public * cn.lvxg.development.*Controller.*(..))")
    public void webLog(){}

    /**
     * 打印请求内容
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("=============================================");
        System.out.println("【REQUEST】");
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }
    /**
     * 打印响应内容
     */
    @AfterReturning(returning = "returnValue", pointcut = "webLog()")
    public void doAfterReturning(Object returnValue){
        // 处理响应内容
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();//获取response
        final String separator = System.getProperty("line.separator");
        try(ServletOutputStream outputStream = response.getOutputStream()){
            String message = returnValue + separator;
            outputStream.write(message.getBytes());

            // 打印响应内容
            System.out.println();
            System.out.println("【RESPONSE】");
            System.out.println(message);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

}