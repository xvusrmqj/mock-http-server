package cn.lvxg.development;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EchoController {
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("echo")
    public String echo(){
        return request.getQueryString();
    }
}
