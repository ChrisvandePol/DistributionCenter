package nl.utwente.DeliverySOAP;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class DeliveryNotifyServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/deliveryDoneService/*");
    }

    @Bean(name = "deliveryDoneService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema deliverySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DeliveryPort");
        wsdl11Definition.setLocationUri("/deliveryDoneService");
        wsdl11Definition.setTargetNamespace("http://localhost:8084/deliveryDoneService/");
        wsdl11Definition.setSchema(deliverySchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema deliverySchema() {
        return new SimpleXsdSchema(new ClassPathResource("deliveryDoneService.xsd"));
    }
}



