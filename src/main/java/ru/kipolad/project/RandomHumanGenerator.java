/**
 * Created by Yulya Telysheva
 */
package ru.kipolad.project;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomHumanGenerator {

    public TableRow getRandomHuman() {
        List<String> data = new ArrayList<>();
        String gender = randomGender();
        String dateOfBirth = randomDateOfBirth();

        data.add(randomName(gender));
        data.add(randomSurname(gender));
        data.add(randomMiddleName(gender));
        data.add(ageCount(dateOfBirth));
        data.add(gender);
        data.add(dateOfBirth);
        data.add(randomPlaceOfBirth());
        data.add(randomIndex());
        data.add("Россия");
        data.add(randomRegion());
        data.add(randomCity());
        data.add(randomStreet());
        data.add(randomHomeNumber());
        data.add(randomApartmentNumber());

        return new TableRow(data);
    }

    private String randomName(String gender) {
        List<String> maleNames = Arrays.asList("Алексей", "Александр", "Андрей", "Антон", "Борис", "Василий", "Георгий",
                "Дмитрий", "Евгений", "Елисей", "Игорь", "Константин", "Максим",  "Олег", "Роман");
        List<String> femaleNames = Arrays.asList("Алевтина", "Антонина", "Валентина", "Галина", "Дарья", "Дарина", "Елена",
                "Екатерина", "Зинаида", "Клавдия", "Лаура", "Мария", "Марина",  "Наталья", "Ольга");

        int randomMaleName = (int) (Math.random() * maleNames.size());
        int randomFemaleName = (int) (Math.random() * femaleNames.size());

        if (gender.equals("МУЖ")) return maleNames.get(randomMaleName);
        else return femaleNames.get(randomFemaleName);
    }

    private String randomMiddleName(String gender) {
        List<String> maleMiddleNames = Arrays.asList("Алексеевич", "Александрович", "Андреевич", "Антонович", "Борисович",
                "Васильевич", "Георгиевич", "Дмитриевич", "Евгеньевич", "Елисеевич", "Игоревич", "Константинович",
                "Мирославович",  "Олегович", "Романович");
        List<String> femaleMiddleNames = Arrays.asList("Алексеевна", "Александровна", "Андреевна", "Антоновна", "Борисовна",
                "Васильевна", "Георгиевна", "Дмитриевна", "Евгеньевна", "Елисеевна", "Игоревна", "Константиновна",
                "Мирославовна",  "Олеговна", "Романовна");

        int randomMaleMiddleName = (int) (Math.random() * maleMiddleNames.size());
        int randomFemaleMiddleName = (int) (Math.random() * femaleMiddleNames.size());

        if (gender.equals("МУЖ")) return maleMiddleNames.get(randomMaleMiddleName);
        else return femaleMiddleNames.get(randomFemaleMiddleName);
    }


    private String randomSurname(String gender) {
        List<String> maleSurnames = Arrays.asList("Галкин", "Воронов", "Воробьёв", "Русаков", "Медведев", "Комаров",
                "Гусев", "Лебедев", "Соболев", "Кошкин", "Соколов", "Михайлов", "Волков",  "Зайцев", "Мухин");
        List<String> femaleSurnames = Arrays.asList("Баранова", "Барсукова", "Блохина", "Быкова", "Голубева", "Грачева",
                "Дроздова", "Ежова", "Жукова", "Журавлёва", "Заяц", "Карасёва", "Карпова",  "Козина", "Коровина");

        int randomMaleSurname = (int) (Math.random() * maleSurnames.size());
        int randomFemaleSurname = (int) (Math.random() * femaleSurnames.size());

        if (gender.equals("МУЖ")) return maleSurnames.get(randomMaleSurname);
        else return femaleSurnames.get(randomFemaleSurname);
    }

    private String ageCount(String date) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(date);
        int age = Period.between(birthday, today).getYears();
        return Integer.toString(age);
    }


    private String randomGender() {
        int setGender = (int) (Math.random() * 2);
        if (setGender == 1) return "МУЖ";
        else return "ЖЕН";
    }


    private String randomDateOfBirth() {
        LocalDate today = LocalDate.now();
        int randomDay = (int) (Math.random() * 36500);
        return today.minusDays(randomDay).toString();
    }

    private String randomPlaceOfBirth() {
        List<String> places = Arrays.asList("Смирных", "Холмск", "Анива", "Оха", "Сочи", "Казань", "Самара", "Анапа",
                "Хабаровск", "Корсаков", "Невельск", "Геленджик", "Электросталь", "Углегорск", "Москва");

        int randomPlace = (int) (Math.random() * places.size());

        return places.get(randomPlace);
    }

    private String randomIndex() {
        int index = (int) (100000 + Math.random() * 899999);
        return Integer.toString(index);
    }

    private String randomRegion() {
        List<String> regions = Arrays.asList("Сахалинская", "Владимирская", "Орловская", "Ростовская", "Магаданская",
                "Пермская", "Тверская", "Белгородская", "Тамбовская", "Иркутская", "Амурская", "Брянская", "Ивановская");

        int randomRegion = (int) (Math.random() * regions.size());

        return regions.get(randomRegion);
    }

    private String randomCity() {
        List<String> cities = Arrays.asList("Смирных", "Холмск", "Анива", "Оха", "Сочи", "Казань", "Самара", "Анапа",
                "Хабаровск", "Корсаков", "Невельск", "Геленджик", "Электросталь", "Углегорск", "Амурск");

        int randomCity = (int) (Math.random() * cities.size());

        return cities.get(randomCity);
    }

    private String randomStreet() {
        List<String> streets = Arrays.asList("Ленина", "Горького", "Амурская", "Чехова", "Сахалинская", "Зимняя", "Победы",
                "Дзержинского", "Авиационная", "Больничная", "Лермонтова", "Комсомольская", "Пограничная", "Крайняя");

        int randomStreet = (int) (Math.random() * streets.size());

        return streets.get(randomStreet);
    }

    private String randomHomeNumber() {
        int randomHomeNum = (int) (Math.random() * 300);
        return Integer.toString(randomHomeNum);
    }

    private String randomApartmentNumber() {
        int randomApartmentNumber = (int) (Math.random() * 150);
        return Integer.toString(randomApartmentNumber);
    }
}
