package com.forum.hub.ForumApi.dto.topic;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicDTO(@NotNull Long user_id, @NotNull Long response_id) {
}
