package cn.lvxg.development;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {

    @GetMapping("get")
    public String get(){
        return "get world!";
    }
    @PostMapping("post")
    public String post(@RequestParam MultiValueMap map){
        StringBuilder sb = new StringBuilder("post world! ");
        for (Object o : map.keySet()) {
            sb.append(o);
            sb.append("=");
            sb.append(map.get(o));
        }
        return sb.toString();
    }
    @PutMapping("put")
    public String put(){
        return "put world!";
    }
    @DeleteMapping("delete")
    public String delete(){
        return "delete world!";
    }
}
