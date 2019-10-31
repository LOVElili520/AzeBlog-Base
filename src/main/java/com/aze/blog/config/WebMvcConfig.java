package com.aze.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：Aze
 * @description：拓展SpringMvc的配置
 * @date ：Created in 2019/10/25 11:36
 * @modified By：
 * @version:
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * @description: 配置页面的访问
     * @author: Aze
     * @time: 2019/10/25 18:36
     * @return:
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/about.html").setViewName("about");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/contact.html").setViewName("contact");
        registry.addViewController("/single").setViewName("single");
        registry.addViewController("/single.html").setViewName("single");
        //注意urlPath为浏览器发送的请求地址， setViewNmae为html的文件路径
        registry.addViewController("/admin-home.html").setViewName("admin/admin-home");
        registry.addViewController("/admin-home").setViewName("admin/admin-home");

        registry.addViewController("/blog-list").setViewName("admin/blog-list");
        registry.addViewController("/blog-add").setViewName("admin/blog-add");

    }

    /**
     * @description: 配置资源的拦截
     * @author: Aze
     * @time: 2019/10/25 18:36
     * @return:
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}


