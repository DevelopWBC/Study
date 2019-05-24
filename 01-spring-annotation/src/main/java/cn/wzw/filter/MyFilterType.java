package cn.wzw.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author Wangzhiwen
 * @ClassName MyFilterType
 * @Description：自定义的包扫描过滤规则，实现TypeFilter接口。返回true表示通过
 * @Date 2019/5/23 13:50
 * @Version 1.0
 */
public class MyFilterType implements TypeFilter {
    /**
      *@author Wangzhiwen
      *@description
      *@date 2019/5/23 13:52
      *@param metadataReader：读取当前正在扫描的类的信息
     *        metadataReaderFactory：获取其他任意类的信息
      *@return boolean
    */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取正在扫面类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源(类路径)
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("--->"+className);
        //这里可以进行判断，过滤掉不需要的对象
       // if (className.contains("co"))
            return true;
        //return false;
    }
}
