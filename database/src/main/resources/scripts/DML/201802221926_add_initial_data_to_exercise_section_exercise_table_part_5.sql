DO
$$
DECLARE
  section_id bigint := (SELECT id FROM public.exercise_section WHERE title = 'Triceps');
  exercise_codes bigint[] := ARRAY(SELECT id FROM public.exercise WHERE code LIKE 'TRIC%');
BEGIN
  FOR i IN 1 .. array_length(exercise_codes, 1) LOOP
    EXECUTE
    'INSERT INTO public.exercise_section_exercise (exercise_section_id, exercise_id) VALUES ($1, $2)'
    USING section_id, exercise_codes[i];
  END LOOP;
END
$$;