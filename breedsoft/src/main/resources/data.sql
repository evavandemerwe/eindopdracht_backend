/* Inserting dogs into the database */
INSERT INTO dogs (id, animal_type, birth_method, blood_temperature, hair_color, date_of_birth, date_of_death, food, sex, weight_in_grams, kind_of_hair, number_of_teeth, litter, breed, breed_group, chip_number, dog_years, name) VALUES (1001, 'carnivore', 'livebirth', 'warmblooded', 'brown', '2017-1-13', null, 'dogchow', 'female', 10.0, 'long haired', 42, null, 'Dachschund', 'Hound', 111111111111111, 5, 'Saartje');
INSERT INTO dogs (id, animal_type, birth_method, blood_temperature, hair_color, date_of_birth, date_of_death, food, sex, weight_in_grams, kind_of_hair, number_of_teeth, litter, breed, breed_group, chip_number, dog_years, name) VALUES (1002, 'carnivore', 'livebirth', 'warmblooded', 'brown', '2017-1-13', null, 'dogchow', 'female', 10.0, 'long haired', 42, null, 'Dachschund', 'Hound', 222222222222222, 2, 'Lotje');
INSERT INTO dogs (id, animal_type, birth_method, blood_temperature, hair_color, date_of_birth, date_of_death, food, sex, weight_in_grams, kind_of_hair, number_of_teeth, litter, breed, breed_group, chip_number, dog_years, name) VALUES (1003, 'carnivore', 'livebirth', 'warmblooded', 'brown', '2017-1-13', null, 'dogchow', 'female', 10.0, 'long haired', 42, null, 'Dachschund', 'Hound', 333333333333333, 0, 'Pip');
INSERT INTO dogs (id, animal_type, birth_method, blood_temperature, hair_color, date_of_birth, date_of_death, food, sex, weight_in_grams, kind_of_hair, number_of_teeth, litter, breed, breed_group, chip_number, dog_years, name) VALUES (1004, 'carnivore', 'livebirth', 'warmblooded', 'brown', '2017-1-13', null, 'dogchow', 'female', 10.0, 'long haired', 42, null, 'Dachschund', 'Hound', 444444444444444, 3, 'Hondje');
INSERT INTO dogs (id, animal_type, birth_method, blood_temperature, hair_color, date_of_birth, date_of_death, food, sex, weight_in_grams, kind_of_hair, number_of_teeth, litter, breed, breed_group, chip_number, dog_years, name) VALUES (1005, 'carnivore', 'livebirth', 'warmblooded', 'brown', '2017-1-13', null, 'dogchow', 'female', 10.0, 'long haired', 42, null, 'Dachschund', 'Hound', 555555555555555, 2, 'Takkie');

/* Inserting persons into the database */
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2001, 'omnivore','livebirth', 'warmblooded', '1986-1-2', null, 'beef', 'brown', 'female', 6300.00, 'long hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Eva', 31, null, 'van de Merwe', 'Maas', '5172 CN');
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2002, 'omnivore','livebirth', 'warmblooded', '1982-2-21', null, 'beef', 'brown', 'male', 8000.00, 'long hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Teun', 31, null, 'van de Merwe', 'Maas', '5172 CN');
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2003, 'omnivore','livebirth', 'warmblooded', '2011-02-04', null, 'beef', 'brown', 'female', 4500.00, 'long hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Demi', 31, null, 'Hamers', 'Maas', '5172 CN');
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2004, 'omnivore','livebirth', 'warmblooded', '2013-12-05', null, 'beef', 'blond', 'female', 3500.00, 'long hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Lara', 31, null, 'Hamers', 'Maas', '5172 CN');
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2005, 'omnivore','livebirth', 'warmblooded', '2014-12-27', null, 'beef', 'brown', 'male', 3500.00, 'short hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Tijl', 31, null, 'van de Merwe', 'Maas', '5172 CN');
INSERT INTO persons(id, animal_type, birth_method, blood_temperature, date_of_birth, date_of_death, food, hair_color, sex, weight_in_grams, kind_of_hair, number_of_teeth, city, country, first_name, house_number, house_number_extension, last_name, street, zip_code) VALUES (2006, 'omnivore','livebirth', 'warmblooded', '2018-12-23', null, 'beef', 'blond', 'female', 2300.00, 'medium long hair', 32, 'Kaatsheuvel', 'the Netherlands', 'Janina', 31, null, 'van de Merwe', 'Maas', '5172 CN');

/* Update my two dogs, set myself as owner */
UPDATE dogs
SET person_id = 2001
    WHERE id = 1001;

UPDATE dogs
SET person_id = 2001
    WHERE id = 1002;
