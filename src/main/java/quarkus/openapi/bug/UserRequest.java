package quarkus.openapi.bug;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {
  String name;
}
