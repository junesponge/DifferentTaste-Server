package com.differenttaste.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Configuration
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 重新指定springboot的静态资源处理前缀
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 将前端请求的String类型参数转为Date类型
     * @param requestMappingHandlerAdapter
     */
    @Autowired
    public void setWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {

        /**
         * 扩展web初始化的配置
         */
        requestMappingHandlerAdapter.setWebBindingInitializer(new WebBindingInitializer() {

            /**
             * @see org.springframework.web.bind.support.WebBindingInitializer#initBinder(org.springframework.web.bind.WebDataBinder,
             *      org.springframework.web.context.request.WebRequest)
             */
            @Override
            public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
                webDataBinder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

                    /**
                     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
                     */
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        setValue(new Date(Long.decode(text)));
                    }

                    /**
                     * @see java.beans.PropertyEditorSupport#getAsText()
                     */
                    @Override
                    public String getAsText() {
                        Date value = (Date) getValue();
                        return (value != null ? String.valueOf(TimeUnit.MILLISECONDS.toSeconds(value.getTime())) : "");
                    }

                });
            }
        });
    }

}
