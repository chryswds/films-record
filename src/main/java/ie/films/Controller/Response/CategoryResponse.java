package ie.films.Controller.Response;


import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
