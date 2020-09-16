package cn.errison.feature.demo.annotation.processor;

import cn.errison.feature.demo.annotation.CopyRight;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@SupportedAnnotationTypes({"cn.errison.feature.demo.annotation.CopyRight"})
public class TestProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for( final Element element: roundEnv.getElementsAnnotatedWith( CopyRight.class ) ) {
            if( element instanceof TypeElement ) {
                final TypeElement typeElement = ( TypeElement )element;
                final PackageElement packageElement =
                        ( PackageElement )typeElement.getEnclosingElement();

                try {
                    final String className = typeElement.getSimpleName() + "CopyRight";
                    final JavaFileObject fileObject = processingEnv.getFiler().createSourceFile(
                            packageElement.getQualifiedName() + "." + className);
                    System.out.println("package " + packageElement.getQualifiedName() + ";");
                    System.out.println( "public class " + className );
                    System.out.println(fileObject.getNestingKind());


                } catch( final IOException ex ) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, ex.getMessage());
                }
            }
        }
        return true;
    }
}