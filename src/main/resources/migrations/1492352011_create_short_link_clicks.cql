-- description: create short link clicks table
-- authoredAt: 1492352011
-- up:

CREATE TABLE short_link_clicks (
   link_id varchar,
   timestamp timestamp,
   country_code varchar,
   ip_address varchar,
   PRIMARY KEY(link_id, timestamp, country_code)
) WITH CLUSTERING ORDER BY (timestamp DESC);

-- down:

DROP TABLE short_link_clicks;
