CREATE TABLE public.training_plan (
  ID              BIGSERIAL PRIMARY KEY,
  TITLE           TEXT NOT NULL,
  SUBTITLE        TEXT,
  DESCRIPTION     TEXT,
  BEFORE_TRAINING TEXT,
  AFTER_TRAINING  TEXT,
  TIPS            TEXT,
  ABOUT_AUTHOR    TEXT
);