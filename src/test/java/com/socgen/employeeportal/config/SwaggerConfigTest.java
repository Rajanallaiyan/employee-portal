package com.socgen.employeeportal.config;

import com.socgen.employeeportal.config.SwaggerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.Assert.assertEquals;

/**
 * Created by rajnalla on 7/19/2019.
 */

@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig = new SwaggerConfig();

    @Test
    public void testApi() {
        //given
        Docket expected = new Docket(DocumentationType.SWAGGER_2);

        //when
        Docket result = swaggerConfig.api();

        //then
        assertEquals(expected.getDocumentationType(), result.getDocumentationType());
    }
}
