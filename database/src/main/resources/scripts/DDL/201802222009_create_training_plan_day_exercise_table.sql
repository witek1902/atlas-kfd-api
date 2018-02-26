CREATE TABLE public.training_plan_day_exercise (
  TRAINING_PLAN_DAY_ID        BIGINT NOT NULL,
  EXERCISE_ID                 BIGINT NOT NULL,
  CONSTRAINT PK_TRAINING_PLAN_DAY_EXERCISE_ID PRIMARY KEY (TRAINING_PLAN_DAY_ID, EXERCISE_ID)
);