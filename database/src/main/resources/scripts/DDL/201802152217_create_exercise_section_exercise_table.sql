CREATE TABLE public.exercise_section_exercise (
    EXERCISE_SECTION_ID     BIGINT NOT NULL,
    EXERCISE_ID             BIGINT NOT NULL,
    CONSTRAINT PK_EXERCISE_SECTION_EXERCISE_ID PRIMARY KEY (EXERCISE_SECTION_ID, EXERCISE_ID)
);