package cn.wzw.importTest;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author Wangzhiwen
 * @ClassName MyImportSelector
 * @Description：实现ImportSelector接口，返回一个指定的字符集合。里面是需要导入的bean对象的全路径名称。
 * @Date 2019/5/24 11:38
 * @Version 1.0
 */
public class MyImportSelector implements ImportSelector {
    //AnnotationMetadata ：获取当前标注了@Import注解类的全部注解
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String[] beans = new String[10];
        beans[0] = "cn.wzw.pojo.ImportSertceorBean";
        return beans;
    }
}
