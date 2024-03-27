package travel.journal.api.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@ConditionalOnMissingBean(BuildProperties.class)
public class SwaggerConfig {

    @Autowired(required = false)
    private BuildProperties properties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(openApiInfo())
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")))
                .security(
                        Collections.singletonList(
                                new SecurityRequirement().addList("bearerAuth", Collections.emptyList()
                                )
                        )
                );
    }

    private Info openApiInfo() {
        String version = "not initialized";
        if (properties != null) {
            version = "version: " + properties.getVersion() + " artifact: " + properties.getArtifact() + " datetime: " + properties.getTime();
        }

        return new Info()
                .title("Travel Journal Api")
                .description("Travel Journal Api")
                .version(version);
    }
}

