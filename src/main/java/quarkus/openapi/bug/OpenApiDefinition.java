package quarkus.openapi.bug;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

// @formatter:off
@OpenAPIDefinition(
    info = @Info(
        title = "dummyTitle",
        version = "dummyVersion"
    ),
    components = @Components(
        parameters = {
            @Parameter(
                name = HttpHeaders.ACCEPT_ENCODING,
                in = ParameterIn.HEADER,
                schema = @Schema(
                    type = SchemaType.STRING,
                    enumeration = {
                        "gzip",
                        "deflate",
                    })),
        },
        schemas = {
            @Schema(
                name = OpenApiDefinition.SCHEMA_USER_REQUEST,
                implementation = UserRequest.class),
            @Schema(
                name = OpenApiDefinition.SCHEMA_USER_RESPONSE,
                implementation = UserResponse.class),
        },
        requestBodies = {
            @RequestBody(
                name = OpenApiDefinition.REQUEST_USER,
                content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(ref = OpenApiDefinition.SCHEMA_USER_REQUEST))),
        },
        responses = {
            @APIResponse(
                name = OpenApiDefinition.RESPONSE_USER,
                content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(ref = OpenApiDefinition.SCHEMA_USER_RESPONSE))),
        }
    )
)
// @formatter:on
public class OpenApiDefinition extends Application {
  public static final String REQUEST_USER = "User Request";
  public static final String RESPONSE_USER = "User Response";
  public static final String SCHEMA_USER_REQUEST = "User Request";
  public static final String SCHEMA_USER_RESPONSE = "User Response";
}
