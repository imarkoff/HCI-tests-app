package com.imarkoff.hci_tests.data

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imarkoff.hci_tests.MainViewModel

@Composable
fun InsertInitialTest() {
    val testViewModel: MainViewModel = viewModel(factory =  MainViewModel.factory)

    testViewModel.insertTest(
        Test(
            testId = 0,
            testName = "Основні терміни та поняття",
            testDescription = "Цей тест допоможе вам перевірити свої знання основних термінів та понять з предмету Інтерфейси та взаємодія людини з комп'ютером.",
            questions = listOf(
                Question(
                    questionText = "Що таке людинно-машинна взаємодія?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Це галузь науки, яка вивчає взаємодію людей з комп'ютерами та іншими машинами.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Це тип програмного забезпечення, яке використовується для управління комп'ютером.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Це мережа комп'ютерів, яка дозволяє людям обмінюватися інформацією.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Це тип комп'ютера, який використовується для виконання складних завдань.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які основні цілі взаємодії людини з комп'ютером?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Принципи програмування, інженерії та математики.", isCorrect = false),
                        Answer(answerId = 1, answerText = "Принципи дизайну, графіки та мультимедіа.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Принципи штучного інтелекту, машинного навчання та робототехніки.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Принципи ергономіки, психології та когнітивної науки.", isCorrect = true),

                        )
                ),
                Question(
                    questionText = "Які методи використовуються для вивчення ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Експерименти, опитування та спостереження.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Моделювання, симуляції та прототипування.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Аналіз даних, машинне навчання та штучний інтелект.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які фактори впливають на взаємодію людини з комп'ютером?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Дизайн та ергономіка інтерфейсу системи.", isCorrect = false),
                        Answer(answerId = 1, answerText = "Технологічні можливості та обмеження системи.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Індивідуальні характеристики користувача, такі як вік, стать, досвід та навички.", isCorrect = true),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 1,
            testName = "Принципи проєктування інтерфейсів",
            testDescription = "Цей тест допоможе вам перевірити свої знання про основні принципи проектування користувацьких інтерфейсів.",
            questions = listOf(
                Question(
                    questionText = "Які основні принципи проектування користувацьких інтерфейсів (КІ)?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Чіткість, простота, послідовність, естетика, ефективність.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Швидкість, потужність, гнучкість, масштабованість, безпека.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зручність, інтуїтивність, доступність, адаптивність, персоналізація.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Візуальна привабливість, інтерактивність, мультимедійність, інтеграція, надійність.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які методи використовуються для оцінки КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Тестування користувачів, аналіз експертів, когнітивні методи, опитування.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Моделювання, симуляції, прототипування, аналіз даних.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Експерименти, фокус-групи, інтерв'ю, анкетування.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які існують типи КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Командні інтерфейси, графічні інтерфейси, інтерфейси віртуальної та доповненої реальності, інтерфейси природної мови.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Інтерфейси на основі жестів, голосові інтерфейси, інтерфейси на основі сенсорних екранів, інтерфейси на основі мозкових сигналів.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Інтерфейси для веб-застосунків, мобільних застосунків, десктопних застосунків, вбудованих систем.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Як проектувати КІ для різних груп користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Проводити дослідження користувачів, щоб зрозуміти їхні потреби та очікування.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Використовувати принципи універсального дизайну, щоб зробити КІ доступними для всіх.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Проводити тестування користувачів з різними групами користувачів, щоб отримати відгуки.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які помилки часто робляться при проектуванні КІ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Не проводити дослідженнями користувачів.", isCorrect = true),
                        Answer(answerId = 1, answerText = "Занадто складний дизайн.", isCorrect = false),
                        Answer(answerId = 2, answerText = "Непослідовний дизайн.", isCorrect = false),
                        Answer(answerId = 3, answerText = "Недоступний дизайн.", isCorrect = false),
                        Answer(answerId = 5, answerText = "Всі вищезазначені.", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 2,
            testName = "Методи введення даних",
            testDescription = "Цей тест призначений для оцінки ваших знань про різні методи введення даних, які використовуються в комп'ютерних системах.",
            questions = listOf(
                Question(
                    questionText = "Який метод введення даних використовується для введення тексту та символів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Клавіатура", isCorrect = true),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для вибору елементів на екрані та переміщення курсору?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 1, answerText = "Миша", isCorrect = true),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = false),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення даних шляхом дотику до екрану?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 1, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = true),
                        Answer(answerId = 3, answerText = "Сканер штрих-коду", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування штрих-кодів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = true),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = false),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення голосу?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Клавіатура", isCorrect = false),
                        Answer(answerId = 1, answerText = "Миша", isCorrect = false),
                        Answer(answerId = 2, answerText = "Сенсорний екран", isCorrect = false),
                        Answer(answerId = 3, answerText = "Голосове введення", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для перетворення зображень у текст?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = true),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = false),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для перетворення мови в текст?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Голосове введення", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування даних з RFID-міток?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зчитувач RFID", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для зчитування даних з магнітних смуг?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зчитувач магнітної смуги", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який метод введення даних використовується для введення даних за допомогою інших датчиків або пристроїв?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розпізнавання зображень", isCorrect = false),
                        Answer(answerId = 1, answerText = "Сканер штрих-коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Інші методи введення даних", isCorrect = true),
                        Answer(answerId = 3, answerText = "Розпізнавання мови", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 3,
            testName = "Ергономічні принципи",
            testDescription = "Цей тест оцінює знання про ергономічні принципи. \nВін складається з 5 питань з множинним вибором, які охоплюють: фізичні та когнітивні фактори, дизайн робочого місця, устаткування та інструменти, робоче середовище, безпека та гігієна праці.",
            questions = listOf(
                Question(
                    questionText = "Який принцип стверджує, що системи та робочі місця повинні відповідати можливостям користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Універсальний дизайн", isCorrect = true),
                        Answer(answerId = 1, answerText = "Індивідуальне налаштування", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження навантаження", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення продуктивності", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип рекомендує правильне розташування монітора, клавіатури та миші?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Дизайн робочого місця, орієнтований на користувача", isCorrect = false),
                        Answer(answerId = 1, answerText = "Ергономічна робоча поза", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження ризику травм", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення концентрації уваги", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Який принцип стверджує, що інструменти та обладнання повинні бути зручними та безпечними?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Безпечний дизайн", isCorrect = false),
                        Answer(answerId = 1, answerText = "Ергономічні інструменти", isCorrect = true),
                        Answer(answerId = 2, answerText = "Зниження ризику помилок", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення точності роботи", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип рекомендує регулярні перерви та фізичну активність?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Активний відпочинок", isCorrect = true),
                        Answer(answerId = 1, answerText = "Зміна положення тіла", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження навантаження на м'язи", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення кровообігу", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип стверджує, що робоче середовище повинне бути комфортним, безпечним та сприятливим для роботи?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Сприятливі умови праці", isCorrect = true),
                        Answer(answerId = 1, answerText = "Контроль за факторами навколишнього середовища", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зниження ризику для здоров'я", isCorrect = false),
                        Answer(answerId = 3, answerText = "Поліпшення самопочуття", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 4,
            testName = "Етичні аспекти ЛМВ",
            testDescription = "Цей тест спрямований на перевірку знань етичних аспектів використання штучного інтелекту, зокрема великих мовних моделей (ЛМВ). Запитання охоплюють теми, пов'язані з відповідальним використанням технологій, захистом даних, запобіганням упередженням, забезпеченням прозорості та дотриманням етичних норм. Проходження цього тесту допоможе визначити, наскільки добре ви розумієте етичні принципи, які лежать в основі роботи з ЛМВ.",
            questions = listOf(
                Question(
                    questionText = "Який із наступних принципів є ключовим у розробці етичних штучних інтелектів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Швидкість обробки", isCorrect = false),
                        Answer(answerId = 1, answerText = "Прозорість", isCorrect = true),
                        Answer(answerId = 2, answerText = "Конкурентоспроможність", isCorrect = false),
                        Answer(answerId = 3, answerText = "Прибутковість", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що мається на увазі під \"упередженням\" у контексті ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Затримка у відповідях моделі", isCorrect = false),
                        Answer(answerId = 1, answerText = "Неправильна граматика", isCorrect = false),
                        Answer(answerId = 2, answerText = "Невірне передбачення", isCorrect = false),
                        Answer(answerId = 3, answerText = "Відображення стереотипів чи дискримінації", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Чому важливо забезпечувати конфіденційність даних при використанні ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Щоб знизити витрати на обчислення", isCorrect = false),
                        Answer(answerId = 1, answerText = "Щоб уникнути порушення прав користувачів", isCorrect = true),
                        Answer(answerId = 2, answerText = "Щоб покращити якість відповіді моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Щоб прискорити навчання моделі", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який принцип \"не нашкодь\" у контексті етичних аспектів ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Розробка моделей, що не зазнають збоїв", isCorrect = false),
                        Answer(answerId = 1, answerText = "Запобігання використанню моделей для завдання шкоди", isCorrect = true),
                        Answer(answerId = 2, answerText = "Створення моделей з високою продуктивністю", isCorrect = false),
                        Answer(answerId = 3, answerText = "Забезпечення підтримки користувачів", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яким чином можна знизити упередження в ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використовувати лише одну велику мовну модель", isCorrect = false),
                        Answer(answerId = 1, answerText = "Постійно оновлювати та перевіряти навчальні дані", isCorrect = true),
                        Answer(answerId = 2, answerText = "Забороняти доступ до моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Зменшувати кількість оброблюваних даних", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка з наступних практик сприяє прозорості ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Приховування джерел даних", isCorrect = false),
                        Answer(answerId = 1, answerText = "Надання користувачам інформації про принципи роботи моделі", isCorrect = true),
                        Answer(answerId = 2, answerText = "Мінімізація звітності", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання складних термінів у документації", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яким чином можна знизити упередження в ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використовувати лише одну велику мовну модель", isCorrect = false),
                        Answer(answerId = 1, answerText = "Постійно оновлювати та перевіряти навчальні дані", isCorrect = true),
                        Answer(answerId = 2, answerText = "Забороняти доступ до моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Зменшувати кількість оброблюваних даних", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка з наступних практик сприяє прозорості ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Приховування джерел даних", isCorrect = false),
                        Answer(answerId = 1, answerText = "Надання користувачам інформації про принципи роботи моделі", isCorrect = true),
                        Answer(answerId = 2, answerText = "Мінімізація звітності", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання складних термінів у документації", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"експлікованість\" в контексті етики ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Здатність моделі генерувати швидкі відповіді", isCorrect = false),
                        Answer(answerId = 1, answerText = "Можливість зрозуміти і пояснити, як модель приймає рішення", isCorrect = true),
                        Answer(answerId = 2, answerText = "Розмір навчального набору даних", isCorrect = false),
                        Answer(answerId = 3, answerText = "Час, необхідний для навчання моделі", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яким чином етичний підхід до ЛМВ може впливати на довіру користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Підвищуючи прозорість та відповідальність розробників", isCorrect = true),
                        Answer(answerId = 1, answerText = "Зменшуючи точність відповідей моделі", isCorrect = false),
                        Answer(answerId = 2, answerText = "Збільшуючи складність використання моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Приховуючи недоліки моделі", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яке з наступних визначень найкраще описує \"алгоритмічну справедливість\"?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання алгоритмів для вирішення юридичних питань", isCorrect = false),
                        Answer(answerId = 1, answerText = "Забезпечення рівного ставлення алгоритмів до всіх користувачів", isCorrect = true),
                        Answer(answerId = 2, answerText = "Прискорення роботи алгоритмів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання алгоритмів у фінансових розрахунках", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"інформаційна безпека\" в контексті ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Здатність моделі розпізнавати мову", isCorrect = false),
                        Answer(answerId = 1, answerText = "Захист даних від несанкціонованого доступу та втрат", isCorrect = true),
                        Answer(answerId = 2, answerText = "Швидкість навчання моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Можливість моделі обробляти великі обсяги даних", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Чому важливо враховувати етичні аспекти при розробці ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Щоб зробити модель більш ефективною", isCorrect = false),
                        Answer(answerId = 1, answerText = "Щоб запобігти негативним соціальним наслідкам", isCorrect = true),
                        Answer(answerId = 2, answerText = "Щоб зменшити витрати на розробку", isCorrect = false),
                        Answer(answerId = 3, answerText = "Щоб прискорити процес навчання", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка практика допомагає забезпечити відповідальність у розробці ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання застарілих даних", isCorrect = false),
                        Answer(answerId = 1, answerText = "Відкриття вихідного коду моделі", isCorrect = true),
                        Answer(answerId = 2, answerText = "Обмеження доступу до моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Приховування алгоритмів", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"зовнішній аудит\" у контексті ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Процес швидкого тестування моделі", isCorrect = false),
                        Answer(answerId = 1, answerText = "Оцінка моделі незалежними експертами", isCorrect = true),
                        Answer(answerId = 2, answerText = "Використання моделі для розваг", isCorrect = false),
                        Answer(answerId = 3, answerText = "Навчання моделі на нових даних", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яким чином етичні норми можуть допомогти уникнути упереджень у ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Впровадження механізмів контролю за використанням моделі", isCorrect = true),
                        Answer(answerId = 1, answerText = "Збільшення кількості даних", isCorrect = false),
                        Answer(answerId = 2, answerText = "Прискорення обробки запитів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Обмеження обсягу навчальних даних", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"етичний дизайн\" у контексті ЛМВ?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання яскравих кольорів у інтерфейсі моделі", isCorrect = false),
                        Answer(answerId = 1, answerText = "Розробка моделей з урахуванням етичних норм та принципів", isCorrect = true),
                        Answer(answerId = 2, answerText = "Оптимізація швидкості моделі", isCorrect = false),
                        Answer(answerId = 3, answerText = "Зменшення витрат на розробку моделі", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 5,
            testName = "Тест на знання доступності (Accessibility)",
            testDescription = "Цей тест спрямований на перевірку знань стандартів і практик, що забезпечують доступність цифрових продуктів для людей з інвалідністю. Запитання охоплюють теми, пов'язані зі стандартами WCAG, методами забезпечення доступності для різних типів інвалідностей, та інструментами оцінки доступності.",
            questions = listOf(
                Question(
                    questionText = "Що таке WCAG?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Web Content Accessibility Guidelines", isCorrect = true),
                        Answer(answerId = 1, answerText = "World Code Accessibility Group", isCorrect = false),
                        Answer(answerId = 2, answerText = "Web Code and Graphics", isCorrect = false),
                        Answer(answerId = 3, answerText = "Worldwide Content Accessibility Guidelines", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який рівень відповідності WCAG є мінімально необхідним для більшості веб-сайтів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "A", isCorrect = false),
                        Answer(answerId = 1, answerText = "AA", isCorrect = true),
                        Answer(answerId = 2, answerText = "AAA", isCorrect = false),
                        Answer(answerId = 3, answerText = "A+", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке альтернативний текст (alt text) і яка його роль у доступності?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Опис зображення для користувачів з вадами зору", isCorrect = true),
                        Answer(answerId = 1, answerText = "Альтернативний формат тексту для мобільних пристроїв", isCorrect = false),
                        Answer(answerId = 2, answerText = "Код для додавання зображень на веб-сторінку", isCorrect = false),
                        Answer(answerId = 3, answerText = "Текст, що з'являється при наведенні курсора на зображення", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які з наступних методів можуть покращити доступність для користувачів з вадами слуху?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання яскравих кольорів", isCorrect = false),
                        Answer(answerId = 1, answerText = "Додавання підписів до відео", isCorrect = true),
                        Answer(answerId = 2, answerText = "Збільшення шрифтів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Оптимізація швидкості завантаження сторінок", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке ARIA (Accessible Rich Internet Applications) і для чого воно використовується?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Фреймворк для створення мобільних додатків", isCorrect = false),
                        Answer(answerId = 1, answerText = "Стандарт для поліпшення доступності веб-додатків", isCorrect = true),
                        Answer(answerId = 2, answerText = "Інструмент для тестування продуктивності веб-сайтів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Плагін для браузера", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яким чином можна покращити навігацію для користувачів з вадами зору?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання великого шрифту", isCorrect = false),
                        Answer(answerId = 1, answerText = "Додавання аудіо супроводу до всіх елементів", isCorrect = false),
                        Answer(answerId = 2, answerText = "Забезпечення підтримки клавіатурної навігації", isCorrect = true),
                        Answer(answerId = 3, answerText = "Використання яскравих кольорів", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"контраст кольорів\" і чому він важливий для доступності?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Різниця у відтінках між кольорами для полегшення читання тексту", isCorrect = true),
                        Answer(answerId = 1, answerText = "Використання різних кольорів для різних частин веб-сторінки", isCorrect = false),
                        Answer(answerId = 2, answerText = "Зміна кольору фону при наведенні курсора", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання кольорів для виділення важливих елементів", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Як можна забезпечити доступність форм на веб-сайті для користувачів з інвалідністю?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання великих полів вводу", isCorrect = false),
                        Answer(answerId = 1, answerText = "Додавання лейблів до всіх полів форми", isCorrect = true),
                        Answer(answerId = 2, answerText = "Оптимізація форми для мобільних пристроїв", isCorrect = false),
                        Answer(answerId = 3, answerText = "Зменшення кількості полів у формі", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"екранний читець\" і яка його роль у забезпеченні доступності?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Програма, що читає текст з екрану вголос для користувачів з вадами зору", isCorrect = true),
                        Answer(answerId = 1, answerText = "Інструмент для перевірки орфографії", isCorrect = false),
                        Answer(answerId = 2, answerText = "Додаток для збільшення зображень на екрані", isCorrect = false),
                        Answer(answerId = 3, answerText = "Плагін для перегляду відео", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які з наступних технологій можуть допомогти користувачам з моторними вадами?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Екранні читці", isCorrect = false),
                        Answer(answerId = 1, answerText = "Клавіатурні скорочення та голосове управління", isCorrect = true),
                        Answer(answerId = 2, answerText = "Підписи до відео", isCorrect = false),
                        Answer(answerId = 3, answerText = "Оптимізація контенту для мобільних пристроїв", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"респонсивний дизайн\" і як він впливає на доступність?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Дизайн, що автоматично адаптується до різних розмірів екрану", isCorrect = true),
                        Answer(answerId = 1, answerText = "Використання лише однієї кольорової гами на всіх сторінках", isCorrect = false),
                        Answer(answerId = 2, answerText = "Оптимізація завантаження сторінок", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання анімацій для покращення взаємодії", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Чому важливо тестувати веб-сайти на доступність?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Щоб покращити швидкість завантаження сторінок", isCorrect = false),
                        Answer(answerId = 1, answerText = "Щоб забезпечити рівний доступ для всіх користувачів", isCorrect = true),
                        Answer(answerId = 2, answerText = "Щоб збільшити кількість відвідувачів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Щоб відповідати модним тенденціям у веб-дизайні", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка з наступних технологій може допомогти користувачам з когнітивними вадами?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Простий і зрозумілий текст", isCorrect = true),
                        Answer(answerId = 1, answerText = "Яскраві кольори та складні анімації", isCorrect = false),
                        Answer(answerId = 2, answerText = "Використання великого обсягу інформації на одній сторінці", isCorrect = false),
                        Answer(answerId = 3, answerText = "Складна навігаційна структура", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"попередження про помилки\" і як воно може покращити доступність форм?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Інформація про те, що форму заповнено правильно", isCorrect = false),
                        Answer(answerId = 1, answerText = "Повідомлення, яке з’являється, коли користувач робить помилку", isCorrect = true),
                        Answer(answerId = 2, answerText = "Додавання зображень до полів форми", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання кольорових маркерів для позначення важливих полів", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Як можна перевірити доступність веб-сайту?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використовуючи автоматизовані інструменти перевірки доступності", isCorrect = true),
                        Answer(answerId = 1, answerText = "Змінюючи кольори на сторінці", isCorrect = false),
                        Answer(answerId = 2, answerText = "Тестуючи лише на одному браузері", isCorrect = false),
                        Answer(answerId = 3, answerText = "Видаляючи всі зображення", isCorrect = false),
                    )
                )
            )
        )
    )

    testViewModel.insertTest(
        Test(
            testId = 6,
            testName = "Тест на знання прототипування",
            testDescription = "Цей тест спрямований на перевірку знань методів і інструментів прототипування, що використовуються в процесі розробки інтерфейсів. Запитання охоплюють теми, пов'язані з різними типами прототипів, інструментами для їх створення, методами тестування і важливістю прототипування в розробці продуктів.",
            questions = listOf(
                Question(
                    questionText = "Що таке \"low-fidelity\" прототип?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Прототип з високим рівнем деталізації", isCorrect = false),
                        Answer(answerId = 1, answerText = "Простий і швидкий прототип, часто на папері", isCorrect = true),
                        Answer(answerId = 2, answerText = "Прототип з використанням складних анімацій", isCorrect = false),
                        Answer(answerId = 3, answerText = "Прототип, який містить лише текстові описи", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які інструменти найчастіше використовуються для створення інтерактивних прототипів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Microsoft Word і Excel", isCorrect = false),
                        Answer(answerId = 1, answerText = "Adobe Photoshop і Illustrator", isCorrect = false),
                        Answer(answerId = 2, answerText = "Figma, Sketch, Adobe XD", isCorrect = true),
                        Answer(answerId = 3, answerText = "PowerPoint і Keynote", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"clickable\" прототип?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Статичний макет веб-сторінки", isCorrect = false),
                        Answer(answerId = 1, answerText = "Прототип, в якому можна взаємодіяти з елементами інтерфейсу", isCorrect = true),
                        Answer(answerId = 2, answerText = "Прототип з високою роздільною здатністю", isCorrect = false),
                        Answer(answerId = 3, answerText = "Прототип, що містить лише текст", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка основна мета прототипування?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Створити остаточний дизайн продукту", isCorrect = false),
                        Answer(answerId = 1, answerText = "Перевірити ідеї та концепції на ранніх етапах розробки", isCorrect = true),
                        Answer(answerId = 2, answerText = "Підвищити вартість проекту", isCorrect = false),
                        Answer(answerId = 3, answerText = "Оптимізувати код", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які з наступних етапів проектування включають прототипування?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Збір вимог", isCorrect = true),
                        Answer(answerId = 1, answerText = "Розробка ідеї", isCorrect = true),
                        Answer(answerId = 2, answerText = "Тестування і валідація", isCorrect = true),
                        Answer(answerId = 3, answerText = "Всі вищезазначені", isCorrect = true),
                    )
                ),
                Question(
                    questionText = "Що таке \"rapid prototyping\"?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Процес створення повільних і детальних прототипів", isCorrect = false),
                        Answer(answerId = 1, answerText = "Швидке створення прототипів для швидкої перевірки ідей", isCorrect = true),
                        Answer(answerId = 2, answerText = "Метод тестування прототипів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання лише низькоякісних інструментів для прототипування", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка різниця між \"low-fidelity\" та \"high-fidelity\" прототипами?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "\"Low-fidelity\" прототипи використовують лише текст, а \"high-fidelity\" – лише графіку", isCorrect = false),
                        Answer(answerId = 1, answerText = "\"Low-fidelity\" прототипи менш деталізовані і часто не інтерактивні, а \"high-fidelity\" – більш деталізовані і інтерактивні", isCorrect = true),
                        Answer(answerId = 2, answerText = "\"Low-fidelity\" прототипи коштують більше, ніж \"high-fidelity\"", isCorrect = false),
                        Answer(answerId = 3, answerText = "\"High-fidelity\" прототипи створюються вручну, а \"low-fidelity\" – автоматично", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Який з наступних методів тестування найбільш підходить для прототипів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Юзабіліті тестування", isCorrect = true),
                        Answer(answerId = 1, answerText = "Регресійне тестування", isCorrect = false),
                        Answer(answerId = 2, answerText = "Стрес-тестування", isCorrect = false),
                        Answer(answerId = 3, answerText = "Тестування безпеки", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"wireframe\"?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Повністю функціональний прототип", isCorrect = false),
                        Answer(answerId = 1, answerText = "Скелетний макет, що показує структуру і розташування елементів інтерфейсу", isCorrect = true),
                        Answer(answerId = 2, answerText = "Документ з технічними вимогами", isCorrect = false),
                        Answer(answerId = 3, answerText = "Фінальний дизайн продукту", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Чому важливо використовувати прототипи на ранніх етапах розробки?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Щоб зменшити витрати на кінцевий продукт", isCorrect = true),
                        Answer(answerId = 1, answerText = "Щоб збільшити час розробки", isCorrect = false),
                        Answer(answerId = 2, answerText = "Щоб зменшити залучення користувачів", isCorrect = false),
                        Answer(answerId = 3, answerText = "Щоб уникнути тестування", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Які з наступних тверджень найкраще описує прототипування?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Створення остаточного продукту", isCorrect = false),
                        Answer(answerId = 1, answerText = "Випробування і перевірка ідей, перш ніж перейти до розробки фінального продукту", isCorrect = true),
                        Answer(answerId = 2, answerText = "Процес маркетингових досліджень", isCorrect = false),
                        Answer(answerId = 3, answerText = "Підготовка технічної документації", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"interactive prototype\"?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Прототип, який складається лише з текстових описів", isCorrect = false),
                        Answer(answerId = 1, answerText = "Прототип, який містить взаємодіючі елементи, що дозволяють користувачам натискати, вводити дані тощо", isCorrect = true),
                        Answer(answerId = 2, answerText = "Складний документ з описом функціональності продукту", isCorrect = false),
                        Answer(answerId = 3, answerText = "Прототип, який створюється лише для внутрішнього використання", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Яка з наступних практик допомагає покращити процес прототипування?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Використання лише одного інструменту прототипування", isCorrect = false),
                        Answer(answerId = 1, answerText = "Регулярне отримання зворотного зв'язку від користувачів", isCorrect = true),
                        Answer(answerId = 2, answerText = "Створення прототипів без будь-яких тестувань", isCorrect = false),
                        Answer(answerId = 3, answerText = "Уникання документації", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Що таке \"mockup\"?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Деталізований візуальний макет інтерфейсу, що не обов'язково інтерактивний", isCorrect = true),
                        Answer(answerId = 1, answerText = "Прототип з мінімальною кількістю деталей", isCorrect = false),
                        Answer(answerId = 2, answerText = "Текстовий опис функціональності інтерфейсу", isCorrect = false),
                        Answer(answerId = 3, answerText = "Остаточний дизайн продукту", isCorrect = false),
                    )
                ),
                Question(
                    questionText = "Як можна перевірити, чи прототип відповідає потребам користувачів?",
                    answers = listOf(
                        Answer(answerId = 0, answerText = "Проведення юзабіліті тестування з реальними користувачами", isCorrect = true),
                        Answer(answerId = 1, answerText = "Аналіз коду", isCorrect = false),
                        Answer(answerId = 2, answerText = "Оптимізація завантаження сторінок", isCorrect = false),
                        Answer(answerId = 3, answerText = "Використання складних анімацій", isCorrect = false),
                    )
                )
            )
        )
    )
}