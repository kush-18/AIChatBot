package org.example.aichatbot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/website")
public class WebsiteBuilderController {
    private final WebsiteBuilderService websiteBuilderService;
    public WebsiteBuilderController(WebsiteBuilderService websiteService) {
        this.websiteBuilderService = websiteService;
    }
    @PostMapping
    public String generateWebsite(@RequestBody String message) {
        return websiteBuilderService.generate(message);
    }

}
