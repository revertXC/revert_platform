package com.revert.core.platform.generator.controller;

import com.revert.core.platform.generator.model.SysTable;
import com.revert.core.platform.generator.service.SysTableService;
import com.revert.platform.common.base.result.web.WebResult;
import com.revert.platform.common.base.result.web.WebResultBuild;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/platform/api/v1/sysTable")
public class SysTableController {

    @Autowired
    private SysTableService sysTableService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value("${platform.java.target}")
    private String genJavaPath;

    private static Map<String, String> mapTemplates;
    static {
        mapTemplates.put("javaModel","/generator/Model.java.ftl");
    }
    /**
     * 分页查询表列表
     * @param sysTable
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public WebResult<List<SysTable>> findByPage(SysTable sysTable){
        return new WebResultBuild<List<SysTable>>().data(sysTableService.selectByModel(sysTable)).build();
    }

    /**
     * 代码生成
     * @param sysTable
     * @return
     */
    @RequestMapping(value = "generatorCode")
    public WebResult<String> generatorCode(SysTable sysTable) throws IOException, TemplateException {
        List<SysTable> listTables = sysTableService.selectByModel(sysTable);
        if(! CollectionUtils.isEmpty(listTables)){
            Set<String> keys = mapTemplates.keySet();
            listTables.forEach( tab -> {
                for(String key : keys){
                    try{
                        String templatePath = mapTemplates.get(key);
                        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);

                    }catch (Exception e){
                        /**代码生成异常不加入到日志文件中*/
                        e.printStackTrace();
                    }

                }
            });

            String templatePath = "/generator/Test.java.ftl";
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);
            File file = new File("D:/Java/xc/Test.java");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            template.process(listTables.get(0), out);
            out.flush();
            out.close();
        }
        return new WebResultBuild<String>().build();
    }

}
