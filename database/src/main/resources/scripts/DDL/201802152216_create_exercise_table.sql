CREATE TABLE public.exercise (
  ID                  BIGSERIAL PRIMARY KEY,
  TITLE               TEXT NOT NULL,
  SUBTITLE            TEXT,
  MUSCLE_IMAGE_URL    TEXT,
  VIDEO_URL           TEXT,
  MAIN_MUSCLES        TEXT,
  AUXILIARY_MUSCLES   TEXT,
  STABILIZERS         TEXT,
  EXECUTION           TEXT,
  REMARKS             TEXT,
  IMAGE_URL_LIST      TEXT
)