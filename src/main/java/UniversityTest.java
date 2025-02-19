import controller.JsonManager;
import controller.Run;
import model.University;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {

    @Test
    public void testUniversitySerializationAndDeserialization() {
        // Створення університету
        Run run = new Run();
        University oldUniversity = run.createTypicalUniversity();

        // Запис університету у файл JSON
        JsonManager jsonManager = new JsonManager();
        String filePath = "university.json";
        jsonManager.saveUniversityToJson(oldUniversity, filePath);

        // Зчитування університету з файлу JSON
        University newUniversity = jsonManager.loadUniversityFromJson(filePath);

        // Порівняння старого та нового університетів
        assertEquals(oldUniversity.toString(), newUniversity.toString(), "Університети не еквівалентні!");
    }
}