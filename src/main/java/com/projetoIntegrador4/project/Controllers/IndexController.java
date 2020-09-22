// package com.projetoIntegrador4.project.Controllers;
package com.projetoIntegrador4.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index()
    {
        return "pages/index";
    }
}