-- Table: itemlocation.item_location_date_period
CREATE TABLE user_cred_table
(
  "account_id" smallint NOT NULL,
  "user_name" varchar(25) NOT NULL,
  "user_pd" varchar(25) NOT NULL,
  "create_timestamp" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT date_periods_pk PRIMARY KEY ( "account_id" )
)
WITH (
  OIDS=FALSE
);

INSERT INTO public.user_cred_table
(account_id, user_name, user_password, create_timestamp)
VALUES(11111, 'user1', 'abcdef', CURRENT_TIMESTAMP);

INSERT INTO public.user_cred_table
(account_id, user_name, user_password, create_timestamp)
VALUES(22222, 'user2', 'abcdef', CURRENT_TIMESTAMP);