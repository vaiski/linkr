-- description: creates short links table
-- authoredAt: 1492351862
-- up:

CREATE TABLE linkr.short_links (
    id text PRIMARY KEY,
    created_at timestamp,
    url text
);

-- down:

DROP TABLE linkr.short_links;
