package medya.soft.com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/home") // Anasayfa index.html yükleniyor
    public String index()
    {
        return "index";
    }
}