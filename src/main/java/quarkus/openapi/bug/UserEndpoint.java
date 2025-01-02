package quarkus.openapi.bug;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("users")
@Tag(name = "Users")
public class UserEndpoint {
  @POST
  @Parameter(ref = HttpHeaders.ACCEPT_ENCODING)
  @APIResponse(ref = OpenApiDefinition.RESPONSE_USER, responseCode = "200")
  public Uni<Response> post(
      @RequestBody(ref = OpenApiDefinition.REQUEST_USER) UserRequest request) {
    return Uni.createFrom().item(() -> Response.ok(UserResponse.from(request)).build());
  }
}
